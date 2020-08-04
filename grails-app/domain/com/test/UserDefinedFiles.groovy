package com.test

import liquibase.database.typeconversion.core.HsqlTypeConverter

class UserDefinedFiles {

    String fileName
    String allowedFileContentType
    Integer maxFileSize
    String allowedFileExtensions
    String minimunRequiredFiles
    String maximunRequiredFiles

    static hasMany = [moduleFiles: ModuleFiles, legalEntityFiles: LegalEntityFiles]

    static constraints = {
         fileName nullable: true
         allowedFileContentType nullable: true
         maxFileSize nullable: true
         allowedFileExtensions nullable: true
         minimunRequiredFiles nullable: true
         maximunRequiredFiles nullable: true
    }

    static mapping = {
        version false
        moduleFiles moduleFiles: true
        moduleFiles moduleFilesDependencies: true
        fileName column: 'fileName', type: 'text'
        legalEntityFiles lazy: true
        legalEntityFiles moduleFiles: true
    }

    @Override
    String toString() {
        return fileName
    }
}
