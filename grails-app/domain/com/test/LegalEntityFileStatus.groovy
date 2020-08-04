package com.test

class LegalEntityFileStatus {

    String legalEntityFileStatusName

    static hasMany = [legalEntityFiles: LegalEntityFiles]

    static constraints = {
        legalEntityFileStatusName nullable: true
    }

    static mapping = {
        version false
    }

    @Override
    String toString() {
        return legalEntityFileStatusName
    }
}
