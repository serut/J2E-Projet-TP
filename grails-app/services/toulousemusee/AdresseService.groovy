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
        List<Adresse> query = Adresse.getAll()
        List<String> result = new ArrayList<String>();
        query.each {
            if (! result.contains(it.codePostal))
                result.add(it.codePostal)
        }
        result
    }
}
