package com.test

class Chapters {
    String name
    String description

    static hasMany = [modules: Modules]
    static constraints = {
        name nullable: true
        description nullable: true
    }

    static mapping = {
        version false
        modules lazy: true
    }

    @Override
    String toString() {
        return name
    }
}
