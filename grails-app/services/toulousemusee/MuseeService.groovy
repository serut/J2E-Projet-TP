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
    def public searchMusee(String inNameMusee, String codePostal, String inAdresseMusee) {
            def criteria = Musee.createCriteria()
            List<Musee> result = criteria.list {
                if (inNameMusee) {
                    like("name", "%${inNameMusee}%")
                }
                if (codePostal) {
                    adress {
                        eq("codePostal", "${codePostal}")
                    }
                }
                if (inAdresseMusee) {
                    adress {
                        like("rue", "%${inAdresseMusee}%")
                    }
                }
            }
            result
        }
    }
}
