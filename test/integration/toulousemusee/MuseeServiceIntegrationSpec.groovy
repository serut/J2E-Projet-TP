package toulousemusee

import grails.test.spock.IntegrationSpec

class MuseeServiceIntegrationSpec extends IntegrationSpec {

    def uneAdresse
    def unGestionnaire
    def museeService

    def setup() {
        uneAdresse = new Adresse(
            numero : "01",
            rue : "Route de Narbonne",
            codePostal : "31400",
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

    void "test de la suppression d'un musee"() {
        given:"un musee existe en base"
        Musee unMusee = new Musee(
                nom: "Musee 1",
                horairesOuverture: "8H - 16h",
                telephone: "05 61 93 93 57",
                accesMetro: "Esquirol, Capitole (A)",
                accesBus: "2, 10, 12, 14, 38, 78",
                adresse: uneAdresse,
                gestionnaire: unGestionnaire)
        museeService.insertOrUpdateMusee(unMusee)

        when:"on déclenche la suppression du musee"
        museeService.deleteMusee(unMusee)

        then:"le musee est supprimée de la base"
        Musee.findById(unMusee.id) == null

        and:"ni l'adresse, ni le gestionnaire ne sont supprimés"
        Adresse.findById(uneAdresse.id) != null
        Gestionnaire.findById(unGestionnaire.id) != null
    }

//    void "test du moteur de recherche sur les musees"() {
//
//        given:"les activités, les utilisateurs et les inscriptions fournis par le jeu de test "
//        jeuTestMusee
//
//        when:"on cherche les inscriptions dont le titre de l'activité contient 'ct' "
//        List<Inscription> res = inscriptionService.searchInscriptions("ct1",null,null)
//
//        then:"on récupère uniquement les 2 inscriptions sur activité 1"
//        res.size() == 2
//        res*.id.contains(jeuTestService.jeanneOnAct1.id)
//        res*.id.contains(jeuTestService.jacquesOnAct1.id)
//
//        when:"on cherche les inscriptions dont les activités sont gérées par le responsable dont le nom ou le prenom contient 'Val'"
//        res = inscriptionService.searchInscriptions(null,'Val',null)
//
//        then:"on récupère uniquement l'inscription jacquesOnAct3"
//        res.size() == 1
//        res*.id.contains(jeuTestService.jacquesOnAct3.id)
//
//        when:"on cherche les inscriptions sur lesquelles une personne dont le nom ou me prénom contient 'Jack' "
//        res = inscriptionService.searchInscriptions(null,null,'Jacq')
//
//        then:"on recupère les 2 inscriptions de Jacques"
//        res.size() == 2
//        res*.id.contains(jeuTestService.jacquesOnAct3.id)
//        res*.id.contains(jeuTestService.jacquesOnAct1.id)
//
//        and:"elle sont ordonnées suivant le titre de l'activité"
//        res*.activite*.titre == [jeuTestService.activite1.titre, jeuTestService.activite3.titre]
//
//        when:"on cherche les inscriptions sur lesquelles une personne dont le nom ou me prénom contient 'Jack'et dont les activités sont gérées par le responsable dont le nom ou le prenom contient 'Isa'  "
//        res = inscriptionService.searchInscriptions(null,'Isa','Jacq')
//
//        then:"on récupère uniquement l'inscription jacquesOnAct1"
//        res.size() == 1
//        res*.id.contains(jeuTestService.jacquesOnAct1.id)
//
//        when:"on cherche les inscriptions dont le titre de l'activité contient 'Isa'"
//        res = inscriptionService.searchInscriptions("Isa",null,null)
//
//        then: "on ne récupère aucune inscription"
//        res.size() == 0
//
//        when:"on positionne tous les critères à null"
//        res = inscriptionService.searchInscriptions(null, null, null)
//
//        then: "on récupère toutes les inscriptions"
//        res.size() == 3
//
//        and:"elle sont ordonnées suivant le titre de l'activité"
//        res*.activite*.titre == [jeuTestService.activite1.titre, jeuTestService.activite1.titre, jeuTestService.activite3.titre]
//    }
}