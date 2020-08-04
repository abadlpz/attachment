package com.test

class LegalEntityFiles {

    String createdBy
    Date createdOn
    String modifiedBy
    Date modifiedOn


    static belongsTo = [legalEntityFileStatus: LegalEntityFileStatus, file: Files, userDefinedFiles: UserDefinedFiles]

    static constraints = {
        createdBy nullable: true
        createdOn nullable: true
        userDefinedFiles nullable: true
    }

    static mapping = {
        version false
    }

    @Override
    String toString() {
        return super.toString()
    }
}
