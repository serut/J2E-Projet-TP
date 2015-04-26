package toulousemusee

import grails.test.spock.IntegrationSpec
import spock.lang.Unroll

class DemandeVisiteMuseeIntegrationSpec extends IntegrationSpec {

    @Unroll
    void "test ajout d'une demande visite musée valide"(Date uneDateDemande, Musee unMusee, DemandeVisite uneDemandeVisite) {

        given: "une demande visite musée bien initialisé"
        DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(
                dateDemande: uneDateDemande,
                musee: unMusee,
                demandeVisite: uneDemandeVisite)

        expect: "la demande de visite musée est valide"
        demandeVisiteMusee.validate() == true

        where:
        uneDateDemande | unMusee | uneDemandeVisite
        new Date() | Mock(Musee) | Mock(DemandeVisite)
    }
    @Unroll
    void "test ajout d'une demande visite musée invalide"(Date uneDateDemande, Musee unMusee, DemandeVisite uneDemandeVisite) {

        given: "une demande visite musée mal initialisé"
        DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(
                dateDemande: uneDateDemande,
                musee: unMusee,
                demandeVisite: uneDemandeVisite)

        expect: "la demande de visite musée est invalide"
        demandeVisiteMusee.validate() == false

        where:
        uneDateDemande | unMusee | uneDemandeVisite
        null | Mock(Musee) | Mock(DemandeVisite)
        new Date() | null | Mock(DemandeVisite)
        new Date() | Mock(Musee) | null
    }
}
