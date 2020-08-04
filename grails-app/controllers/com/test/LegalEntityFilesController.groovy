package com.test

import org.springframework.dao.DataIntegrityViolationException

class LegalEntityFilesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [legalEntityFilesInstanceList: LegalEntityFiles.list(params), legalEntityFilesInstanceTotal: LegalEntityFiles.count()]
    }

    def create() {
        [legalEntityFilesInstance: new LegalEntityFiles(params)]
    }

    def save() {
        def legalEntityFilesInstance = new LegalEntityFiles(params)
        if (!legalEntityFilesInstance.save(flush: true)) {
            render(view: "create", model: [legalEntityFilesInstance: legalEntityFilesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'legalEntityFiles.label', default: 'LegalEntityFiles'), legalEntityFilesInstance.id])
        redirect(action: "show", id: legalEntityFilesInstance.id)
    }

    def show(Long id) {
        def legalEntityFilesInstance = LegalEntityFiles.get(id)
        if (!legalEntityFilesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'legalEntityFiles.label', default: 'LegalEntityFiles'), id])
            redirect(action: "list")
            return
        }

        [legalEntityFilesInstance: legalEntityFilesInstance]
    }

    def edit(Long id) {
        def legalEntityFilesInstance = LegalEntityFiles.get(id)
        if (!legalEntityFilesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'legalEntityFiles.label', default: 'LegalEntityFiles'), id])
            redirect(action: "list")
            return
        }

        [legalEntityFilesInstance: legalEntityFilesInstance]
    }

    def update(Long id, Long version) {
        def legalEntityFilesInstance = LegalEntityFiles.get(id)
        if (!legalEntityFilesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'legalEntityFiles.label', default: 'LegalEntityFiles'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (legalEntityFilesInstance.version > version) {
                legalEntityFilesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'legalEntityFiles.label', default: 'LegalEntityFiles')] as Object[],
                          "Another user has updated this LegalEntityFiles while you were editing")
                render(view: "edit", model: [legalEntityFilesInstance: legalEntityFilesInstance])
                return
            }
        }

        legalEntityFilesInstance.properties = params

        if (!legalEntityFilesInstance.save(flush: true)) {
            render(view: "edit", model: [legalEntityFilesInstance: legalEntityFilesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'legalEntityFiles.label', default: 'LegalEntityFiles'), legalEntityFilesInstance.id])
        redirect(action: "show", id: legalEntityFilesInstance.id)
    }

    def delete(Long id) {
        def legalEntityFilesInstance = LegalEntityFiles.get(id)
        if (!legalEntityFilesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'legalEntityFiles.label', default: 'LegalEntityFiles'), id])
            redirect(action: "list")
            return
        }

        try {
            legalEntityFilesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'legalEntityFiles.label', default: 'LegalEntityFiles'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'legalEntityFiles.label', default: 'LegalEntityFiles'), id])
            redirect(action: "show", id: id)
        }
    }
}
