package com.test

import org.springframework.dao.DataIntegrityViolationException

class UserDefinedFilesController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        [userDefinedFilesInstanceList: UserDefinedFiles.list(params), userDefinedFilesInstanceTotal: UserDefinedFiles.count()]
    }

    def create() {
        [userDefinedFilesInstance: new UserDefinedFiles(params)]
    }

    def save() {
        def userDefinedFilesInstance = new UserDefinedFiles(params)
        if (!userDefinedFilesInstance.save(flush: true)) {
            render(view: "create", model: [userDefinedFilesInstance: userDefinedFilesInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'userDefinedFiles.label', default: 'UserDefinedFiles'), userDefinedFilesInstance.id])
        redirect(action: "show", id: userDefinedFilesInstance.id)
    }

    def show(Long id) {
        def userDefinedFilesInstance = UserDefinedFiles.get(id)
        if (!userDefinedFilesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'userDefinedFiles.label', default: 'UserDefinedFiles'), id])
            redirect(action: "list")
            return
        }

        [userDefinedFilesInstance: userDefinedFilesInstance]
    }

    def edit(Long id) {
        def userDefinedFilesInstance = UserDefinedFiles.get(id)
        if (!userDefinedFilesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'userDefinedFiles.label', default: 'UserDefinedFiles'), id])
            redirect(action: "list")
            return
        }

        [userDefinedFilesInstance: userDefinedFilesInstance]
    }

    def update(Long id, Long version) {
        def userDefinedFilesInstance = UserDefinedFiles.get(id)
        if (!userDefinedFilesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'userDefinedFiles.label', default: 'UserDefinedFiles'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (userDefinedFilesInstance.version > version) {
                userDefinedFilesInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'userDefinedFiles.label', default: 'UserDefinedFiles')] as Object[],
                          "Another user has updated this UserDefinedFiles while you were editing")
                render(view: "edit", model: [userDefinedFilesInstance: userDefinedFilesInstance])
                return
            }
        }

        userDefinedFilesInstance.properties = params

        if (!userDefinedFilesInstance.save(flush: true)) {
            render(view: "edit", model: [userDefinedFilesInstance: userDefinedFilesInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'userDefinedFiles.label', default: 'UserDefinedFiles'), userDefinedFilesInstance.id])
        redirect(action: "show", id: userDefinedFilesInstance.id)
    }

    def delete(Long id) {
        def userDefinedFilesInstance = UserDefinedFiles.get(id)
        if (!userDefinedFilesInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'userDefinedFiles.label', default: 'UserDefinedFiles'), id])
            redirect(action: "list")
            return
        }

        try {
            userDefinedFilesInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'userDefinedFiles.label', default: 'UserDefinedFiles'), id])
            redirect(action: "list")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'userDefinedFiles.label', default: 'UserDefinedFiles'), id])
            redirect(action: "show", id: id)
        }
    }
}
