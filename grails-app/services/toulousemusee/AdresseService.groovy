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

    // Todo : le distinct n'est pas fonctionnel, d'ou le test result.has() avant insertion
    public List<String> getCodePostal() {
        def criteria = Adresse.createCriteria()
        List<Adresse> query = criteria.list {
            distinct("codePostal")
        }
        List<String> result = new ArrayList<String>();
        query.each {
            if (! result.contains(it.codePostal))
                result.add(it.codePostal)
        }
        result
    }
}
