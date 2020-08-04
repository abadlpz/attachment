package com.test

import org.springframework.dao.DataIntegrityViolationException

class ModuleFilesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [moduleFilesInstanceList: ModuleFiles.list(params), moduleFilesInstanceTotal: ModuleFiles.count()]
    }

    def create() {
        [moduleFilesInstance: new ModuleFiles(params)]
    }

    def save() {
        def moduleFilesInstance = new ModuleFiles(params)
        if (!moduleFilesInstance.save(flush: true)) {
            render(view: "create", model: [moduleFilesInstance: moduleFilesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'moduleFiles.label', default: 'ModuleFiles'), moduleFilesInstance.id])
        redirect(action: "show", id: moduleFilesInstance.id)
    }

    def show(Long id) {
        def moduleFilesInstance = ModuleFiles.get(id)
        if (!moduleFilesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'moduleFiles.label', default: 'ModuleFiles'), id])
            redirect(action: "list")
            return
        }

        [moduleFilesInstance: moduleFilesInstance]
    }

    def edit(Long id) {
        def moduleFilesInstance = ModuleFiles.get(id)
        if (!moduleFilesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'moduleFiles.label', default: 'ModuleFiles'), id])
            redirect(action: "list")
            return
        }

        [moduleFilesInstance: moduleFilesInstance]
    }

    def update(Long id, Long version) {
        def moduleFilesInstance = ModuleFiles.get(id)
        if (!moduleFilesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'moduleFiles.label', default: 'ModuleFiles'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (moduleFilesInstance.version > version) {
                moduleFilesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'moduleFiles.label', default: 'ModuleFiles')] as Object[],
                          "Another user has updated this ModuleFiles while you were editing")
                render(view: "edit", model: [moduleFilesInstance: moduleFilesInstance])
                return
            }
        }

        moduleFilesInstance.properties = params

        if (!moduleFilesInstance.save(flush: true)) {
            render(view: "edit", model: [moduleFilesInstance: moduleFilesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'moduleFiles.label', default: 'ModuleFiles'), moduleFilesInstance.id])
        redirect(action: "show", id: moduleFilesInstance.id)
    }

    def delete(Long id) {
        def moduleFilesInstance = ModuleFiles.get(id)
        if (!moduleFilesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'moduleFiles.label', default: 'ModuleFiles'), id])
            redirect(action: "list")
            return
        }

        try {
            moduleFilesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'moduleFiles.label', default: 'ModuleFiles'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'moduleFiles.label', default: 'ModuleFiles'), id])
            redirect(action: "show", id: id)
        }
    }
}
