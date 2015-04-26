package toulousemusee

import grails.test.spock.IntegrationSpec
import spock.lang.Unroll

class DemandeVisiteIntegrationSpec extends IntegrationSpec {
    @Unroll
    void "test ajout d'une demande visite valide"(Date uneDateDeb, Date uneDateFin, int nbPersonnes, String unStatut) {

        given: "une demande visite bien initialisé"
        DemandeVisite demandeVisite = new DemandeVisite(
                dateDeb: uneDateDeb,
                dateFin: uneDateFin,
                nbPersonnes: nbPersonnes,
                statut: unStatut)

        expect: "la demande de visite est valide"
        demandeVisite.validate() == true

        where:
        uneDateDeb | uneDateFin | nbPersonnes | unStatut
        new Date() | new Date() | 1 | "En cours"
    }
    @Unroll
    void "test ajout d'une demande visite invalide"(Date uneDateDeb, Date uneDateFin, int nbPersonnes, String unStatut) {

        given: "une demande visite mal initialisé"
        DemandeVisite demandeVisite = new DemandeVisite(
                dateDeb: uneDateDeb,
                dateFin: uneDateFin,
                nbPersonnes: nbPersonnes,
                statut: unStatut)

        expect: "la demande de visite est invalide"
        demandeVisite.validate() == false

        where:
        uneDateDeb | uneDateFin | nbPersonnes | unStatut
        null | new Date() | 1 | "En cours"
        new Date() | null | 1 | "En cours"
        new Date() | new Date() | 10 | "En cours"
        new Date() | new Date() | 1 | ""
    }
}
