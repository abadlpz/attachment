package com.test

class ModuleFiles {

    Boolean isFileRequired

    static belongsTo = [modules: Modules, userDefinedFiles: UserDefinedFiles]


    static constraints = {
        isFileRequired nullable: true
    }

    static mapping = {
        version false

    }

    @Override
    String toString() {
        return super.toString()
    }
}
