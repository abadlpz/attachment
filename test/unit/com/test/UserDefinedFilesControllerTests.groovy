package com.test



import org.junit.*
import grails.test.mixin.*

@TestFor(UserDefinedFilesController)
@Mock(UserDefinedFiles)
class UserDefinedFilesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/userDefinedFiles/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.userDefinedFilesInstanceList.size() == 0
        assert model.userDefinedFilesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.userDefinedFilesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.userDefinedFilesInstance != null
        assert view == '/userDefinedFiles/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/userDefinedFiles/show/1'
        assert controller.flash.message != null
        assert UserDefinedFiles.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/userDefinedFiles/list'

        populateValidParams(params)
        def userDefinedFiles = new UserDefinedFiles(params)

        assert userDefinedFiles.save() != null

        params.id = userDefinedFiles.id

        def model = controller.show()

        assert model.userDefinedFilesInstance == userDefinedFiles
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/userDefinedFiles/list'

        populateValidParams(params)
        def userDefinedFiles = new UserDefinedFiles(params)

        assert userDefinedFiles.save() != null

        params.id = userDefinedFiles.id

        def model = controller.edit()

        assert model.userDefinedFilesInstance == userDefinedFiles
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/userDefinedFiles/list'

        response.reset()

        populateValidParams(params)
        def userDefinedFiles = new UserDefinedFiles(params)

        assert userDefinedFiles.save() != null

        // test invalid parameters in update
        params.id = userDefinedFiles.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/userDefinedFiles/edit"
        assert model.userDefinedFilesInstance != null

        userDefinedFiles.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/userDefinedFiles/show/$userDefinedFiles.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        userDefinedFiles.clearErrors()

        populateValidParams(params)
        params.id = userDefinedFiles.id
        params.version = -1
        controller.update()

        assert view == "/userDefinedFiles/edit"
        assert model.userDefinedFilesInstance != null
        assert model.userDefinedFilesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/userDefinedFiles/list'

        response.reset()

        populateValidParams(params)
        def userDefinedFiles = new UserDefinedFiles(params)

        assert userDefinedFiles.save() != null
        assert UserDefinedFiles.count() == 1

        params.id = userDefinedFiles.id

        controller.delete()

        assert UserDefinedFiles.count() == 0
        assert UserDefinedFiles.get(userDefinedFiles.id) == null
        assert response.redirectedUrl == '/userDefinedFiles/list'
    }
}
