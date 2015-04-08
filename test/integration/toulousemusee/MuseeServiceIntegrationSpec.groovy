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

    void "test du moteur de recherche sur les musees"() {

        given:"les activités, les utilisateurs et les inscriptions fournis par le jeu de test "

        Musee unMusee = new Musee(
                nom: "Votre Musee 1",
                horairesOuverture: "8H - 16h",
                telephone: "05 61 93 93 57",
                accesMetro: "Esquirol, Capitole (A)",
                accesBus: "2, 10, 12, 14, 38, 78",
                adresse: uneAdresse,
                gestionnaire: unGestionnaire)
        museeService.insertOrUpdateMusee(unMusee)


        def secAdresse = new Adresse(
                numero : "01",
                rue : "Avenue de Ponsan",
                codePostal : "31500",
                ville : "Toulouse"
        ).save()
        Musee secMusee = new Musee(
                nom: "Votre Musae 2",
                horairesOuverture: "8H - 16h",
                telephone: "05 61 93 93 57",
                accesMetro: "Esquirol, Capitole (A)",
                accesBus: "2, 10, 12, 14, 38, 78",
                adresse: secAdresse,
                gestionnaire: unGestionnaire)
        museeService.insertOrUpdateMusee(secMusee)

        when:"on cherche les musées dont le nom du musee contient 'Musee' "
        List<Musee> res = museeService.searchMusee("Musee",null,null)

        then:"on récupère uniquement 1 musée"
        res.size() == 1

        when:"on cherche les musées situés dans le code postal '31500' "
        res = museeService.searchMusee(null,"31500",null)

        then:"on récupère uniquement 1 musée"
        res.size() == 1


        when:"on cherche les musées situés dans à l'adresse contenant 'Ponsan' "
        res = museeService.searchMusee(null,null,"Ponsan")

        then:"on récupère uniquement 1 musée"
        res.size() == 1
    }
}