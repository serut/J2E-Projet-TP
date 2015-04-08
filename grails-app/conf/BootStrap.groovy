class BootStrap {
    def museeService

    def init = { servletContext ->
        museeService.importMuseeFromCsv("Musee.csv")
    }
    def destroy = {
    }
}
