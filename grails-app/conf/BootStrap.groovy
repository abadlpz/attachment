class BootStrap {
    def chaptersService
    def init = { servletContext ->
        println("  * * * * * *   Inicializando datos de prueba * * * * * ")
        chaptersService.initialize()
        println("  * * * * * *   finalizando datos de prueba * * * * * ")

    }
    def destroy = {
    }
}
