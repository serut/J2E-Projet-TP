package toulousemusee

import grails.transaction.Transactional

@Transactional
class AdresseService {
    public Adresse insertOrUpdateAdresse(Adresse adresse) {
        adresse.save(flush: true)
        adresse
    }
    def deleteAdresse(Adresse adresse) {
        adresse.delete(flush: true)
    }
    public List<String> getCodePostal() {
        def criteria = Adresse.createCriteria()
        List<Adresse> query = criteria.list {
            distinct("codePostal")
        }
        List<String> result = new ArrayList<String>();
        query.each {
            result.add(it.codePostal)
        }
        result
    }
}
