package toulousemusee

import grails.transaction.Transactional

@Transactional
class MuseeService {

    def public searchMusee(String inNameMusee, int codePostal, String inAdresseMusee) {
            def criteria = Musee.createCriteria()
            List<Musee> result = criteria.list {
                if (inNameMusee) {
                    like("name", "%${inNameMusee}%")
                }
                if (codePostal) {
                    eq("codePostal", "%${codePostal}%")
                }
                if (inAdresseMusee) {
                    like("inAdresseMusee", "%${inAdresseMusee}%")
                }
            }
            result
        }
    }
}
