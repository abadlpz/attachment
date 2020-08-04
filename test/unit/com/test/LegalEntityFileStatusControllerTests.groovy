package com.test



import org.junit.*
import grails.test.mixin.*

@TestFor(LegalEntityFileStatusController)
@Mock(LegalEntityFileStatus)
class LegalEntityFileStatusControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/legalEntityFileStatus/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.legalEntityFileStatusInstanceList.size() == 0
        assert model.legalEntityFileStatusInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.legalEntityFileStatusInstance != null
    }

    void testSave() {
        controller.save()

        assert model.legalEntityFileStatusInstance != null
        assert view == '/legalEntityFileStatus/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/legalEntityFileStatus/show/1'
        assert controller.flash.message != null
        assert LegalEntityFileStatus.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/legalEntityFileStatus/list'

        populateValidParams(params)
        def legalEntityFileStatus = new LegalEntityFileStatus(params)

        assert legalEntityFileStatus.save() != null

        params.id = legalEntityFileStatus.id

        def model = controller.show()

        assert model.legalEntityFileStatusInstance == legalEntityFileStatus
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/legalEntityFileStatus/list'

        populateValidParams(params)
        def legalEntityFileStatus = new LegalEntityFileStatus(params)

        assert legalEntityFileStatus.save() != null

        params.id = legalEntityFileStatus.id

        def model = controller.edit()

        assert model.legalEntityFileStatusInstance == legalEntityFileStatus
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/legalEntityFileStatus/list'

        response.reset()

        populateValidParams(params)
        def legalEntityFileStatus = new LegalEntityFileStatus(params)

        assert legalEntityFileStatus.save() != null

        // test invalid parameters in update
        params.id = legalEntityFileStatus.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/legalEntityFileStatus/edit"
        assert model.legalEntityFileStatusInstance != null

        legalEntityFileStatus.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/legalEntityFileStatus/show/$legalEntityFileStatus.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        legalEntityFileStatus.clearErrors()

        populateValidParams(params)
        params.id = legalEntityFileStatus.id
        params.version = -1
        controller.update()

        assert view == "/legalEntityFileStatus/edit"
        assert model.legalEntityFileStatusInstance != null
        assert model.legalEntityFileStatusInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/legalEntityFileStatus/list'

        response.reset()

        populateValidParams(params)
        def legalEntityFileStatus = new LegalEntityFileStatus(params)

        assert legalEntityFileStatus.save() != null
        assert LegalEntityFileStatus.count() == 1

        params.id = legalEntityFileStatus.id

        controller.delete()

        assert LegalEntityFileStatus.count() == 0
        assert LegalEntityFileStatus.get(legalEntityFileStatus.id) == null
        assert response.redirectedUrl == '/legalEntityFileStatus/list'
    }
}
