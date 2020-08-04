package com.test

class Modules {

    String moduleName
    String modelePath
    String iconName
    Integer menuOrderNumber
    String entityTypeOrder

    static belongsTo = [chapter: Chapters]
    static hasMany = [moduleFiles: ModuleFiles]

    static constraints = {
         moduleName nullable: true
         modelePath nullable: true
         iconName nullable: true
         menuOrderNumber nullable: true
         entityTypeOrder nullable: true
    }

    static mapping = {
        version false
        moduleFiles lazy: true
        moduleFiles moduleFilesDependencies: true
    }

    @Override
    String toString() {
        return moduleName
    }
}
