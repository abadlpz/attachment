package com.test



import org.junit.*
import grails.test.mixin.*

@TestFor(LegalEntityFilesController)
@Mock(LegalEntityFiles)
class LegalEntityFilesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/legalEntityFiles/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.legalEntityFilesInstanceList.size() == 0
        assert model.legalEntityFilesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.legalEntityFilesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.legalEntityFilesInstance != null
        assert view == '/legalEntityFiles/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/legalEntityFiles/show/1'
        assert controller.flash.message != null
        assert LegalEntityFiles.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/legalEntityFiles/list'

        populateValidParams(params)
        def legalEntityFiles = new LegalEntityFiles(params)

        assert legalEntityFiles.save() != null

        params.id = legalEntityFiles.id

        def model = controller.show()

        assert model.legalEntityFilesInstance == legalEntityFiles
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/legalEntityFiles/list'

        populateValidParams(params)
        def legalEntityFiles = new LegalEntityFiles(params)

        assert legalEntityFiles.save() != null

        params.id = legalEntityFiles.id

        def model = controller.edit()

        assert model.legalEntityFilesInstance == legalEntityFiles
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/legalEntityFiles/list'

        response.reset()

        populateValidParams(params)
        def legalEntityFiles = new LegalEntityFiles(params)

        assert legalEntityFiles.save() != null

        // test invalid parameters in update
        params.id = legalEntityFiles.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/legalEntityFiles/edit"
        assert model.legalEntityFilesInstance != null

        legalEntityFiles.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/legalEntityFiles/show/$legalEntityFiles.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        legalEntityFiles.clearErrors()

        populateValidParams(params)
        params.id = legalEntityFiles.id
        params.version = -1
        controller.update()

        assert view == "/legalEntityFiles/edit"
        assert model.legalEntityFilesInstance != null
        assert model.legalEntityFilesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/legalEntityFiles/list'

        response.reset()

        populateValidParams(params)
        def legalEntityFiles = new LegalEntityFiles(params)

        assert legalEntityFiles.save() != null
        assert LegalEntityFiles.count() == 1

        params.id = legalEntityFiles.id

        controller.delete()

        assert LegalEntityFiles.count() == 0
        assert LegalEntityFiles.get(legalEntityFiles.id) == null
        assert response.redirectedUrl == '/legalEntityFiles/list'
    }
}
