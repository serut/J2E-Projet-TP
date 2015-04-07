package toulousemusee

import grails.test.spock.IntegrationSpec

class AdresseServiceIntegrationSpec extends IntegrationSpec {

    def adresseService

    def setup() {
    }


    void "test ajout d'une adresse"() {
        given: "une adresse"
        def uneAdresse = new Adresse(
                todo
        )
        when: "on insert ou met à jour l'adresse"
        def resAjoutAdresse = adresseService.insertOrUpdateAdresse(uneAdresse)

        then: "l'adresse insérée est bien celle retournée"
        uneAdresse == resAjoutAdresse

        and: "l'adresse a bien un id"
        uneAdresse.id != null

        and: "elle est valide"
        uneAdresse.validate()

        and: "elle est bien stockée en base"
        Adresse.findById(uneAdresse.id) != null
    }

    void "test de la suppression d'une adresse"() {
        given:"une adresse existe en base"
        def uneAdresse = new Adresse(
                todo
        )
        adresseService.insertOrUpdateMusee(uneAdresse)

        when:"on déclenche la suppression d'une adresse"
        adresseService.deleteGestionnaire(uneAdresse)

        then:"l'adresse est supprimée de la base"
        Adresse.findById(uneAdresse.id) == null
    }
}
