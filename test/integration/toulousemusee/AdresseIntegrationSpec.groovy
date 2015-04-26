package toulousemusee

import grails.test.spock.IntegrationSpec
import spock.lang.Unroll

class AdresseIntegrationSpec extends IntegrationSpec {
    @Unroll
    void "test ajout d'une adresse valide"(String unNumero, String uneRue, String unCodePostal, String uneVille) {

        given: "une adresse bien initialisé"
        Adresse adresse = new Adresse(
                numero : unNumero,
                rue : uneRue,
                codePostal : unCodePostal,
                ville : uneVille)

        expect: "l'adresse est valide"
        adresse.validate() == true
        adresse.toString().size() > 0

        where:
        unNumero | uneRue | unCodePostal |uneVille
        "01" | "Une route" | "31000" | "Ville"
    }
    @Unroll
    void "test ajout d'une adresse invalide"(String unNumero, String uneRue, String unCodePostal, String uneVille) {

        given: "une adresse mal initialisé"
        Adresse adresse = new Adresse(
                numero : unNumero,
                rue : uneRue,
                codePostal : unCodePostal,
                ville : uneVille)

        expect: "l'adresse est invalide"
        adresse.validate() == false

        where:
        unNumero | uneRue | unCodePostal |uneVille
        "" | "Une route" | "31000" | "Ville"
        "01" | "" | "31000" | "Ville"
        "01" | "Une route" | "" | "Ville"
        "01" | "Une route" | "31000" | ""
    }
}
