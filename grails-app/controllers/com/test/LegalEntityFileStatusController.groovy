package com.test

import org.springframework.dao.DataIntegrityViolationException

class LegalEntityFileStatusController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [legalEntityFileStatusInstanceList: LegalEntityFileStatus.list(params), legalEntityFileStatusInstanceTotal: LegalEntityFileStatus.count()]
    }

    def create() {
        [legalEntityFileStatusInstance: new LegalEntityFileStatus(params)]
    }

    def save() {
        def legalEntityFileStatusInstance = new LegalEntityFileStatus(params)
        if (!legalEntityFileStatusInstance.save(flush: true)) {
            render(view: "create", model: [legalEntityFileStatusInstance: legalEntityFileStatusInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'legalEntityFileStatus.label', default: 'LegalEntityFileStatus'), legalEntityFileStatusInstance.id])
        redirect(action: "show", id: legalEntityFileStatusInstance.id)
    }

    def show(Long id) {
        def legalEntityFileStatusInstance = LegalEntityFileStatus.get(id)
        if (!legalEntityFileStatusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'legalEntityFileStatus.label', default: 'LegalEntityFileStatus'), id])
            redirect(action: "list")
            return
        }

        [legalEntityFileStatusInstance: legalEntityFileStatusInstance]
    }

    def edit(Long id) {
        def legalEntityFileStatusInstance = LegalEntityFileStatus.get(id)
        if (!legalEntityFileStatusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'legalEntityFileStatus.label', default: 'LegalEntityFileStatus'), id])
            redirect(action: "list")
            return
        }

        [legalEntityFileStatusInstance: legalEntityFileStatusInstance]
    }

    def update(Long id, Long version) {
        def legalEntityFileStatusInstance = LegalEntityFileStatus.get(id)
        if (!legalEntityFileStatusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'legalEntityFileStatus.label', default: 'LegalEntityFileStatus'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (legalEntityFileStatusInstance.version > version) {
                legalEntityFileStatusInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'legalEntityFileStatus.label', default: 'LegalEntityFileStatus')] as Object[],
                          "Another user has updated this LegalEntityFileStatus while you were editing")
                render(view: "edit", model: [legalEntityFileStatusInstance: legalEntityFileStatusInstance])
                return
            }
        }

        legalEntityFileStatusInstance.properties = params

        if (!legalEntityFileStatusInstance.save(flush: true)) {
            render(view: "edit", model: [legalEntityFileStatusInstance: legalEntityFileStatusInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'legalEntityFileStatus.label', default: 'LegalEntityFileStatus'), legalEntityFileStatusInstance.id])
        redirect(action: "show", id: legalEntityFileStatusInstance.id)
    }

    def delete(Long id) {
        def legalEntityFileStatusInstance = LegalEntityFileStatus.get(id)
        if (!legalEntityFileStatusInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'legalEntityFileStatus.label', default: 'LegalEntityFileStatus'), id])
            redirect(action: "list")
            return
        }

        try {
            legalEntityFileStatusInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'legalEntityFileStatus.label', default: 'LegalEntityFileStatus'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'legalEntityFileStatus.label', default: 'LegalEntityFileStatus'), id])
            redirect(action: "show", id: id)
        }
    }
}
