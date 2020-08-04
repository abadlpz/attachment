package com.test



import org.junit.*
import grails.test.mixin.*

@TestFor(ModulesController)
@Mock(Modules)
class ModulesControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/modules/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.modulesInstanceList.size() == 0
        assert model.modulesInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.modulesInstance != null
    }

    void testSave() {
        controller.save()

        assert model.modulesInstance != null
        assert view == '/modules/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/modules/show/1'
        assert controller.flash.message != null
        assert Modules.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/modules/list'

        populateValidParams(params)
        def modules = new Modules(params)

        assert modules.save() != null

        params.id = modules.id

        def model = controller.show()

        assert model.modulesInstance == modules
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/modules/list'

        populateValidParams(params)
        def modules = new Modules(params)

        assert modules.save() != null

        params.id = modules.id

        def model = controller.edit()

        assert model.modulesInstance == modules
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/modules/list'

        response.reset()

        populateValidParams(params)
        def modules = new Modules(params)

        assert modules.save() != null

        // test invalid parameters in update
        params.id = modules.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/modules/edit"
        assert model.modulesInstance != null

        modules.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/modules/show/$modules.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        modules.clearErrors()

        populateValidParams(params)
        params.id = modules.id
        params.version = -1
        controller.update()

        assert view == "/modules/edit"
        assert model.modulesInstance != null
        assert model.modulesInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/modules/list'

        response.reset()

        populateValidParams(params)
        def modules = new Modules(params)

        assert modules.save() != null
        assert Modules.count() == 1

        params.id = modules.id

        controller.delete()

        assert Modules.count() == 0
        assert Modules.get(modules.id) == null
        assert response.redirectedUrl == '/modules/list'
    }
}
