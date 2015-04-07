package toulousemusee

import grails.transaction.Transactional

@Transactional
class MuseeService {
    public Musee insertOrUpdateMusee(Musee musee) {
        musee.save(flush: true)
        musee
    }
    def deleteMusee(Musee musee) {
        musee.delete(flush : true)
    }
    def public searchMusee(String inNomMusee, String codePostal, String inAdresseMusee) {
        def criteria = Musee.createCriteria()
        List<Musee> result = criteria.list {
            if (inNameMusee) {
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
}
