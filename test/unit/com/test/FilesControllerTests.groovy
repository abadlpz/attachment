package com.test



import org.junit.*
import grails.test.mixin.*

@TestFor(FilesController)
@Mock(Files)
class FilesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/files/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.filesInstanceList.size() == 0
        assert model.filesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.filesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.filesInstance != null
        assert view == '/files/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/files/show/1'
        assert controller.flash.message != null
        assert Files.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/files/list'

        populateValidParams(params)
        def files = new Files(params)

        assert files.save() != null

        params.id = files.id

        def model = controller.show()

        assert model.filesInstance == files
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/files/list'

        populateValidParams(params)
        def files = new Files(params)

        assert files.save() != null

        params.id = files.id

        def model = controller.edit()

        assert model.filesInstance == files
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/files/list'

        response.reset()

        populateValidParams(params)
        def files = new Files(params)

        assert files.save() != null

        // test invalid parameters in update
        params.id = files.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/files/edit"
        assert model.filesInstance != null

        files.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/files/show/$files.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        files.clearErrors()

        populateValidParams(params)
        params.id = files.id
        params.version = -1
        controller.update()

        assert view == "/files/edit"
        assert model.filesInstance != null
        assert model.filesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/files/list'

        response.reset()

        populateValidParams(params)
        def files = new Files(params)

        assert files.save() != null
        assert Files.count() == 1

        params.id = files.id

        controller.delete()

        assert Files.count() == 0
        assert Files.get(files.id) == null
        assert response.redirectedUrl == '/files/list'
    }
}
