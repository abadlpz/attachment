package com.test

import org.springframework.dao.DataIntegrityViolationException

class ChaptersController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [chaptersInstanceList: Chapters.list(params), chaptersInstanceTotal: Chapters.count()]
    }

    def create() {
        [chaptersInstance: new Chapters(params)]
    }

    def save() {
        def chaptersInstance = new Chapters(params)
        if (!chaptersInstance.save(flush: true)) {
            render(view: "create", model: [chaptersInstance: chaptersInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'chapters.label', default: 'Chapters'), chaptersInstance.id])
        redirect(action: "show", id: chaptersInstance.id)
    }

    def show(Long id) {
        def chaptersInstance = Chapters.get(id)
        if (!chaptersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'chapters.label', default: 'Chapters'), id])
            redirect(action: "list")
            return
        }

        [chaptersInstance: chaptersInstance]
    }

    def edit(Long id) {
        def chaptersInstance = Chapters.get(id)
        if (!chaptersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'chapters.label', default: 'Chapters'), id])
            redirect(action: "list")
            return
        }

        [chaptersInstance: chaptersInstance]
    }

    def update(Long id, Long version) {
        def chaptersInstance = Chapters.get(id)
        if (!chaptersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'chapters.label', default: 'Chapters'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (chaptersInstance.version > version) {
                chaptersInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'chapters.label', default: 'Chapters')] as Object[],
                          "Another user has updated this Chapters while you were editing")
                render(view: "edit", model: [chaptersInstance: chaptersInstance])
                return
            }
        }

        chaptersInstance.properties = params

        if (!chaptersInstance.save(flush: true)) {
            render(view: "edit", model: [chaptersInstance: chaptersInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'chapters.label', default: 'Chapters'), chaptersInstance.id])
        redirect(action: "show", id: chaptersInstance.id)
    }

    def delete(Long id) {
        def chaptersInstance = Chapters.get(id)
        if (!chaptersInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'chapters.label', default: 'Chapters'), id])
            redirect(action: "list")
            return
        }

        try {
            chaptersInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'chapters.label', default: 'Chapters'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'chapters.label', default: 'Chapters'), id])
            redirect(action: "show", id: id)
        }
    }
}
