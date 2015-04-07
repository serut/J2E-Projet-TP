package toulousemusee

import grails.transaction.Transactional

@Transactional
class MuseeService {
    public Musee insertOrUpdateMusee(Musee musee, Gestionnaire gestionnaire, Adresse adresse) {
        gestionnaire.addToMusees(musee)
        adresse.musee = musee

        gestionnaire.save(flush: true)
        adresse.save(flush: true)
        musee.save(flush: true)
        musee
    }

    def deleteMusee(Musee musee) {
        musee.gestionnaire.removeFromMusees(musee)
        musee.adresse.delete(flush : true)
        musee.delete(flush : true)
    }

    def public searchMusee(String inNomMusee, String codePostal, String inAdresseMusee) {
        def criteria = Musee.createCriteria()
        List<Musee> result = criteria.list {
            if (inNomMusee) {
                like("nom", "%${inNomMusee}%")
            }
            if (codePostal) {
                adresse {
                    eq("codePostal", "${codePostal}")
                }
            }
            if (inAdresseMusee) {
                adresse {
                    like("rue", "%${inAdresseMusee}%")
                }
            }
        }
        result
    }

    def importMuseeFromCsv(String csvPath) {
        File csvFile = new File(csvPath)

        // Lecture du fichier CSV en ignorant la première ligne (titres des colonnes)
        csvFile.toCsvReader(['skipLines':1, 'charset':'UTF-8']).eachLine { tokens ->
            // Attributs pour le musée
            def nomMusee = tokens[0].trim()
            def horairesMusee = tokens[2].trim()
            def telephoneMusee = tokens[4].trim()
            def accesMetroMusee = tokens[5].trim()
            def accesBusMusee = tokens[6].trim()

            // Attributs pour le gestionnaire
            def nomGestionnaire = tokens[1].trim()

            // Attributs pour l'adresse
            def numAdresse = tokens[7].trim()
            def rueAdresse = tokens[8].trim()
            def codePostalAdresse = tokens[9].trim()
            def villeAdresse = tokens[10].trim()


            // Création des objets
            Gestionnaire gestionnaire = Gestionnaire.findByNom(nomGestionnaire) ?: new Gestionnaire(nom: nomGestionnaire)
            Adresse adresse = new Adresse(numero: numAdresse, rue: rueAdresse, codePostal: codePostalAdresse, ville: villeAdresse)
            Musee musee = new Musee(nom: nomMusee, horairesOuverture: horairesMusee, telephone: telephoneMusee, accesMetro: accesMetroMusee, accesBus: accesBusMusee)
            musee.adresse = adresse
            musee.gestionnaire = gestionnaire

            insertOrUpdateMusee(musee, gestionnaire, adresse)
        }
    }
}
