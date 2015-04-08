package toulousemusee

import grails.test.spock.IntegrationSpec

class GestionnaireServiceIntegrationSpec extends IntegrationSpec {

    def gestionnaireService
    def museeService
    def uneAdresse

    def setup() {
        uneAdresse = new Adresse(
                numero : "01",
                rue : "Route de Narbonne",
                codePostal : "31400",
                ville : "Toulouse"
        )

    }


    void "test ajout d'un gestionnaire"() {
        given: "un gestionnaire"
        def unGestionnaire = new Gestionnaire(
                nom: "Dupond"
        )
        Musee unMusee = new Musee(
                nom: "Musee 1",
                horairesOuverture: "8H - 16h",
                telephone: "05 61 93 93 57",
                accesMetro: "Esquirol, Capitole (A)",
                accesBus: "2, 10, 12, 14, 38, 78",
                adresse: uneAdresse,
                gestionnaire: unGestionnaire)
        museeService.insertOrUpdateMusee(unMusee)


        when: "on insert ou met à jour le gestionnaire"
        def resAjoutGestionnaire = gestionnaireService.insertOrUpdateGestionnaire(unGestionnaire)

        then: "le musee insérée est bien celui retournée"
        unGestionnaire == resAjoutGestionnaire

        and: "le musee a bien un id"
        unGestionnaire.id != null

        and: "elle est valide"
        unGestionnaire.validate()

        and: "elle est bien stockée en base"
        Gestionnaire.findById(unGestionnaire.id) != null
    }

    void "test de la suppression d'un musee"() {
        given:"un musee existe en base"
        def unGestionnaire = new Gestionnaire(
                nom: "Dupond"
        )
        def unMusee = new Musee(
                nom: "Musee 1",
                horairesOuverture: "8H - 16h",
                telephone: "05 61 93 93 57",
                accesMetro: "Esquirol, Capitole (A)",
                accesBus: "2, 10, 12, 14, 38, 78",
                adresse: uneAdresse,
                gestionnaire: unGestionnaire)
        museeService.insertOrUpdateMusee(unMusee)

        gestionnaireService.insertOrUpdateGestionnaire(unGestionnaire)

        when:"on déclenche la suppression du musee"
        gestionnaireService.deleteGestionnaire(unGestionnaire)

        then:"le musee est supprimée de la base"
        Gestionnaire.findById(unGestionnaire.id) == null
    }
}
