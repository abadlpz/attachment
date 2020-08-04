package com.initialize

import com.test.Chapters
import com.test.Files
import com.test.LegalEntityFileStatus
import com.test.LegalEntityFiles
import com.test.ModuleFiles

import com.test.Modules
import com.test.UserDefinedFiles

class ChaptersService {

    def initialize() {
        Chapters chapterInstance = new Chapters(name: "Individuos")
        chapterInstance.save(flush: true, failOnError: true)
        Modules moduleInstance = new Modules(moduleName: "Individuo residente inversionista", chapter: chapterInstance).save(flush: true)
        Modules moduleInstance2 = new Modules(moduleName: "Investigadores o Científicos (Investigación en Compañias Elegiles)", chapter: chapterInstance).save(flush: true)
        Modules moduleInstance3 = new Modules(moduleName: "Investigadores o Científicos (Investigación en Universidades)", chapter: chapterInstance).save(flush: true)
        Modules moduleInstance4 = new Modules(moduleName: "medicos cualificados", chapter: chapterInstance).save(flush: true)
        Modules moduleInstance5 = new Modules(moduleName: "personal de difícil reclutamiento", chapter: chapterInstance).save(flush: true)
        UserDefinedFiles userDefinedFiles1 = new UserDefinedFiles(fileName: "Certificado de Antecedentes Penales del Solicitante, emitido por la autoridad correspondiente del estado o país de su última residencia").save(flush: true)
        UserDefinedFiles userDefinedFiles2 = new UserDefinedFiles(fileName: "Copia del Número de Seguro Social o Identificación Nacional. Si el Solicitante no es Ciudadano Norteamericano, él o ella deberá, además, someter una declaración jurada a esos efectos, acompañada de copia del pasaporte, visa o tarjeta de residente permanente").save(flush: true)
        UserDefinedFiles userDefinedFiles3 = new UserDefinedFiles(fileName: "Copia del Pasaporte Norteamericano o de la Visa de Residente").save(flush: true)
        ModuleFiles moduleFiles1 = new ModuleFiles(modules: moduleInstance, userDefinedFiles: userDefinedFiles1, isFileRequired: new Boolean(true)).save(flush: true)
        ModuleFiles moduleFiles2 = new ModuleFiles(modules: moduleInstance, userDefinedFiles: userDefinedFiles2, isFileRequired: new Boolean(true)).save(flush: true)
        ModuleFiles moduleFiles3 = new ModuleFiles(modules: moduleInstance, userDefinedFiles: userDefinedFiles3, isFileRequired: new Boolean(true)).save(flush: true)
        ModuleFiles moduleFiles4 = new ModuleFiles(modules: moduleInstance2, userDefinedFiles: userDefinedFiles3, isFileRequired: new Boolean(true)).save(flush: true)
        LegalEntityFileStatus entityFileStatus1  = new LegalEntityFileStatus(legalEntityFileStatusName: "En progreso").save(flush: true)
        LegalEntityFileStatus entityFileStatus2  = new LegalEntityFileStatus(legalEntityFileStatusName: "Aprobado").save(flush: true)
        LegalEntityFileStatus entityFileStatus3  = new LegalEntityFileStatus(legalEntityFileStatusName: "Declinado").save(flush: true)
        LegalEntityFileStatus entityFileStatus4  = new LegalEntityFileStatus(legalEntityFileStatusName: "Por expirar").save(flush: true)
        LegalEntityFileStatus entityFileStatus5  = new LegalEntityFileStatus(legalEntityFileStatusName: "Expirado").save(flush: true)

        Files fileInstance = new Files()
        fileInstance.filePath = '/02020202/Individuo/doc'
        fileInstance.save(flush: true, failOnError: true)
        LegalEntityFiles legalEntityFiles = new LegalEntityFiles(file: fileInstance, userDefinedFiles: userDefinedFiles1, legalEntityFileStatus: entityFileStatus1).save(flush: true)

        Chapters chapterInstance2 = new Chapters(name: "Exportación de bienes y servicios")
        chapterInstance2.save(flush: true)
        Modules moduleInstance6 = new Modules(moduleName: "Comercio de Exportación", chapter: chapterInstance2).save(flush: true)
        Modules moduleInstance7 = new Modules(moduleName: "Promotor Cualificado", chapter: chapterInstance2).save(flush: true)
        Modules moduleInstance8 = new Modules(moduleName: "Finanzas, Inversiones y Seguros", chapter: chapterInstance2).save(flush: true)



        Chapters chapterInstance3 = new Chapters(name: "Finanzas, Inversiones y Seguros")
        chapterInstance3.save(flush: true)
        Chapters chapterInstance4 = new Chapters(name: "Economía del Visistante")
        chapterInstance4.save(flush: true)
        Chapters chapterInstance5 = new Chapters(name: "Manufactura")
        chapterInstance5.save(flush: true)
        Chapters chapterInstance6 = new Chapters(name: "Infraectrustura y Energía Verde")
        chapterInstance6.save(flush: true)
        Chapters chapterInstance7 = new Chapters(name: "Agroindrustrias")
        chapterInstance7.save(flush: true)
        Chapters chapterInstance8 = new Chapters(name: "Industrias Creativas")
        chapterInstance8.save(flush: true)
        Chapters chapterInstance9 = new Chapters(name: "otros")
        chapterInstance9.save(flush: true)
        Chapters chapterInstance10 = new Chapters(name: "Empresarios")
        chapterInstance10.save(flush: true)
        Modules moduleInstance9 = new Modules(moduleName: "Jóvenes empresarios", chapter: chapterInstance10).save(flush: true)
    }
}
