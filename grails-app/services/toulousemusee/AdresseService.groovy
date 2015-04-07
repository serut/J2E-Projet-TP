package toulousemusee

import grails.transaction.Transactional

@Transactional
class AdresseService {
    public Adresse insertOrUpdateAdresse(Adresse adresse) {
        adresse.save(flush: true)
        adresse
    }
    def deleteAdresse(Adresse adresse) {
        adresse.delete(flush : true)
    }
}
