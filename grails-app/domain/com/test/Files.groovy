package com.test

import java.sql.Blob

class Files {

    String fileName
    String filePath
    String fileSize
    String fileContentType
    Date fileExpirationDate
    String createdBy
    Date createdOn
    String lastModify
    Date lastModifyOn
   

    static hasMany = [legalEntityFiles: LegalEntityFiles]

    static constraints = {
         fileName nullable: true
         filePath nullable: true
         fileSize nullable: true
         fileContentType nullable: true
         fileExpirationDate nullable: true
         createdBy nullable: true
         createdOn nullable: true
         lastModify nullable: true
         lastModifyOn nullable: true
    }

    static mapping = {
        version false
        legalEntityFiles lazy: true
    }

    @Override
    String toString() {
        return filePath
    }
}
