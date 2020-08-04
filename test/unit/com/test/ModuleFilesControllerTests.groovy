package com.test



import org.junit.*
import grails.test.mixin.*

@TestFor(ModuleFilesController)
@Mock(ModuleFiles)
class ModuleFilesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/moduleFiles/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.moduleFilesInstanceList.size() == 0
        assert model.moduleFilesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.moduleFilesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.moduleFilesInstance != null
        assert view == '/moduleFiles/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/moduleFiles/show/1'
        assert controller.flash.message != null
        assert ModuleFiles.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/moduleFiles/list'

        populateValidParams(params)
        def moduleFiles = new ModuleFiles(params)

        assert moduleFiles.save() != null

        params.id = moduleFiles.id

        def model = controller.show()

        assert model.moduleFilesInstance == moduleFiles
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/moduleFiles/list'

        populateValidParams(params)
        def moduleFiles = new ModuleFiles(params)

        assert moduleFiles.save() != null

        params.id = moduleFiles.id

        def model = controller.edit()

        assert model.moduleFilesInstance == moduleFiles
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/moduleFiles/list'

        response.reset()

        populateValidParams(params)
        def moduleFiles = new ModuleFiles(params)

        assert moduleFiles.save() != null

        // test invalid parameters in update
        params.id = moduleFiles.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/moduleFiles/edit"
        assert model.moduleFilesInstance != null

        moduleFiles.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/moduleFiles/show/$moduleFiles.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        moduleFiles.clearErrors()

        populateValidParams(params)
        params.id = moduleFiles.id
        params.version = -1
        controller.update()

        assert view == "/moduleFiles/edit"
        assert model.moduleFilesInstance != null
        assert model.moduleFilesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/moduleFiles/list'

        response.reset()

        populateValidParams(params)
        def moduleFiles = new ModuleFiles(params)

        assert moduleFiles.save() != null
        assert ModuleFiles.count() == 1

        params.id = moduleFiles.id

        controller.delete()

        assert ModuleFiles.count() == 0
        assert ModuleFiles.get(moduleFiles.id) == null
        assert response.redirectedUrl == '/moduleFiles/list'
    }
}
