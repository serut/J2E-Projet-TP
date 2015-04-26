package toulousemusee

import grails.test.spock.IntegrationSpec
import spock.lang.Unroll

class MuseeIntegrationSpec extends IntegrationSpec {

    def setup() {
    }

    @Unroll
    void "test ajout d'un musee valide"(String unNom, String unHorairesOuverture, String unTel, String unAccesMetro, String unAccesBus, Adresse uneAdresse, Gestionnaire unGestionnaire) {

        given: "un musee bien initialise"
        Musee musee = new Musee(
                nom: unNom,
                horairesOuverture: unHorairesOuverture,
                telephone: unTel,
                accesMetro: unAccesMetro,
                accesBus: unAccesBus,
                adresse: uneAdresse,
                gestionnaire: unGestionnaire)

        expect: "le musée est valide"
        musee.validate() == true
        musee.toString().size() > 0

        where:
        unNom     | unHorairesOuverture | unTel            | unAccesMetro             | unAccesBus              | uneAdresse    | unGestionnaire
        "Un nom " | "8H - 16h"          | "05 61 93 93 57" | "Esquirol, Capitole (A)" | "2, 10, 12, 14, 38, 78" | Mock(Adresse) | Mock(Gestionnaire)
    }
    @Unroll
    void "test ajout d'un musee invalide"(String unNom, String unHorairesOuverture, String unTel, String unAccesMetro, String unAccesBus, Adresse uneAdresse, Gestionnaire unGestionnaire) {

        given: "un musee mal initialise"
        Musee musee = new Musee(
                nom: unNom,
                horairesOuverture: unHorairesOuverture,
                telephone: unTel,
                accesMetro: unAccesMetro,
                accesBus: unAccesBus,
                adresse: uneAdresse,
                gestionnaire: unGestionnaire)

        expect: "Le musée est invalide"
        musee.validate() == false

        where:
        unNom     | unHorairesOuverture | unTel            | unAccesMetro             | unAccesBus              | uneAdresse    | unGestionnaire
        null | "8H - 16h"          | "05 61 93 93 57" | "Esquirol, Capitole (A)" | "2, 10, 12, 14, 38, 78" | Mock(Adresse) | Mock(Gestionnaire)
        "Un nom " | null          | "05 61 93 93 57" | "Esquirol, Capitole (A)" | "2, 10, 12, 14, 38, 78" | Mock(Adresse) | Mock(Gestionnaire)
        "Un nom " | "8H - 16h"          | null | "Esquirol, Capitole (A)" | "2, 10, 12, 14, 38, 78" | Mock(Adresse) | Mock(Gestionnaire)
        "Un nom " | "8H - 16h"          | "05 61 93 93 57" | null | "2, 10, 12, 14, 38, 78" | Mock(Adresse) | Mock(Gestionnaire)
        "Un nom " | "8H - 16h"          | "05 61 93 93 57" | "Esquirol, Capitole (A)" | null | Mock(Adresse) | Mock(Gestionnaire)
        "Un nom " | "8H - 16h"          | "05 61 93 93 57" | "Esquirol, Capitole (A)" | "2, 10, 12, 14, 38, 78" | null | Mock(Gestionnaire)
        "Un nom " | "8H - 16h"          | "05 61 93 93 57" | "Esquirol, Capitole (A)" | "2, 10, 12, 14, 38, 78" | Mock(Adresse) | null
    }
}