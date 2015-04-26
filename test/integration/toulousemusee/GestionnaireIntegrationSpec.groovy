package toulousemusee

import grails.test.spock.IntegrationSpec
import spock.lang.Unroll

class GestionnaireIntegrationSpec extends IntegrationSpec {

    @Unroll
    void "test ajout d'un gestionnaire valide"(String unNom) {

        given: "un gestionnaire bien initialisé"
        Gestionnaire gestionnaire = new Gestionnaire(nom: unNom)

        expect: "le gestionnaire est valide"
        gestionnaire.validate() == true
        gestionnaire.toString().size() > 0

        where:
        unNom = "Un nom "
    }
    @Unroll
    void "test ajout d'un gestionnaire invalide"(String unNom) {

        given: "un gestionnaire mal initialisé"
        Gestionnaire gestionnaire = new Gestionnaire(nom: unNom)

        expect: "le gestionnaire est invalide"
        gestionnaire.validate() == false

        where:
        unNom = ""
    }

}
