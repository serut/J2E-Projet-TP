package toulousemusee

import grails.test.spock.IntegrationSpec

class MuseeServiceIntegrationSpec extends IntegrationSpec {

    def uneAdresse
    def unGestionnaire
    def museeService

    def setup() {
        uneAdresse = new Adresse(
            numero : "01",
            rue : "une rue",
            codePostal: "12345",
            ville : "Toulouse"
        ).save()
        unGestionnaire = new Gestionnaire(
            nom: "Dupond"
        ).save()
    }


    void "test ajout d'un musee"() {
        given: "un musee"
        def unMusee = new Musee(
                nom: "Musee 1",
                horairesOuverture: "8H - 16h",
                telephone: "05 61 93 93 57",
                accesMetro: "Esquirol, Capitole (A)",
                accesBus: "2, 10, 12, 14, 38, 78",
                adresse: uneAdresse,
                gestionnaire: unGestionnaire)


        when: "on insert ou met à jour le musee"
        def resAjoutMusee = museeService.insertOrUpdateMusee(unMusee)

        then: "le musee insérée est bien celui retournée"
        unMusee == resAjoutMusee

        and: "le musee a bien un id"
        unMusee.id != null

        and: "elle est valide"
        unMusee.validate()

        and: "elle est bien stockée en base"
        Musee.findById(unMusee.id) != null
    }
}