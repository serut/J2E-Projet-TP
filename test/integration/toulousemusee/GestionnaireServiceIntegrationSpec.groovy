package toulousemusee

import grails.test.spock.IntegrationSpec

class GestionnaireServiceIntegrationSpec extends IntegrationSpec {

    def gestionnaireService

    def setup() {
    }


    void "test ajout d'un gestionnaire"() {
        given: "un gestionnaire"
        def unGestionnaire = new Gestionnaire(
                nom: "Dupond"
        )
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
        gestionnaireService.insertOrUpdateMusee(unGestionnaire)

        when:"on déclenche la suppression du musee"
        gestionnaireService.deleteGestionnaire(unGestionnaire)

        then:"le musee est supprimée de la base"
        Gestionnaire.findById(unGestionnaire.id) == null
    }
}
