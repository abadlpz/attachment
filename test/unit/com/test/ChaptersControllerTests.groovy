package com.test



import org.junit.*
import grails.test.mixin.*

@TestFor(ChaptersController)
@Mock(Chapters)
class ChaptersControllerTests {

    def populateValidParams(params) {
        assert params != null
        // TODO: Populate valid properties like...
        //params["name"] = 'someValidName'
    }

    void testIndex() {
        controller.index()
        assert "/chapters/list" == response.redirectedUrl
    }

    void testList() {

        def model = controller.list()

        assert model.chaptersInstanceList.size() == 0
        assert model.chaptersInstanceTotal == 0
    }

    void testCreate() {
        def model = controller.create()

        assert model.chaptersInstance != null
    }

    void testSave() {
        controller.save()

        assert model.chaptersInstance != null
        assert view == '/chapters/create'

        response.reset()

        populateValidParams(params)
        controller.save()

        assert response.redirectedUrl == '/chapters/show/1'
        assert controller.flash.message != null
        assert Chapters.count() == 1
    }

    void testShow() {
        controller.show()

        assert flash.message != null
        assert response.redirectedUrl == '/chapters/list'

        populateValidParams(params)
        def chapters = new Chapters(params)

        assert chapters.save() != null

        params.id = chapters.id

        def model = controller.show()

        assert model.chaptersInstance == chapters
    }

    void testEdit() {
        controller.edit()

        assert flash.message != null
        assert response.redirectedUrl == '/chapters/list'

        populateValidParams(params)
        def chapters = new Chapters(params)

        assert chapters.save() != null

        params.id = chapters.id

        def model = controller.edit()

        assert model.chaptersInstance == chapters
    }

    void testUpdate() {
        controller.update()

        assert flash.message != null
        assert response.redirectedUrl == '/chapters/list'

        response.reset()

        populateValidParams(params)
        def chapters = new Chapters(params)

        assert chapters.save() != null

        // test invalid parameters in update
        params.id = chapters.id
        //TODO: add invalid values to params object

        controller.update()

        assert view == "/chapters/edit"
        assert model.chaptersInstance != null

        chapters.clearErrors()

        populateValidParams(params)
        controller.update()

        assert response.redirectedUrl == "/chapters/show/$chapters.id"
        assert flash.message != null

        //test outdated version number
        response.reset()
        chapters.clearErrors()

        populateValidParams(params)
        params.id = chapters.id
        params.version = -1
        controller.update()

        assert view == "/chapters/edit"
        assert model.chaptersInstance != null
        assert model.chaptersInstance.errors.getFieldError('version')
        assert flash.message != null
    }

    void testDelete() {
        controller.delete()
        assert flash.message != null
        assert response.redirectedUrl == '/chapters/list'

        response.reset()

        populateValidParams(params)
        def chapters = new Chapters(params)

        assert chapters.save() != null
        assert Chapters.count() == 1

        params.id = chapters.id

        controller.delete()

        assert Chapters.count() == 0
        assert Chapters.get(chapters.id) == null
        assert response.redirectedUrl == '/chapters/list'
    }
}
