package com.test

import org.springframework.dao.DataIntegrityViolationException

class FilesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [filesInstanceList: Files.list(params), filesInstanceTotal: Files.count()]
    }

    def create() {
        [filesInstance: new Files(params)]
    }

    def save() {
        def filesInstance = new Files(params)
        if (!filesInstance.save(flush: true)) {
            render(view: "create", model: [filesInstance: filesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'files.label', default: 'Files'), filesInstance.id])
        redirect(action: "show", id: filesInstance.id)
    }

    def show(Long id) {
        def filesInstance = Files.get(id)
        if (!filesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'files.label', default: 'Files'), id])
            redirect(action: "list")
            return
        }

        [filesInstance: filesInstance]
    }

    def edit(Long id) {
        def filesInstance = Files.get(id)
        if (!filesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'files.label', default: 'Files'), id])
            redirect(action: "list")
            return
        }

        [filesInstance: filesInstance]
    }

    def update(Long id, Long version) {
        def filesInstance = Files.get(id)
        if (!filesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'files.label', default: 'Files'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (filesInstance.version > version) {
                filesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'files.label', default: 'Files')] as Object[],
                          "Another user has updated this Files while you were editing")
                render(view: "edit", model: [filesInstance: filesInstance])
                return
            }
        }

        filesInstance.properties = params

        if (!filesInstance.save(flush: true)) {
            render(view: "edit", model: [filesInstance: filesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'files.label', default: 'Files'), filesInstance.id])
        redirect(action: "show", id: filesInstance.id)
    }

    def delete(Long id) {
        def filesInstance = Files.get(id)
        if (!filesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'files.label', default: 'Files'), id])
            redirect(action: "list")
            return
        }

        try {
            filesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'files.label', default: 'Files'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'files.label', default: 'Files'), id])
            redirect(action: "show", id: id)
        }
    }
}
