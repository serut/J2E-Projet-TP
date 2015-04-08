package toulousemusee

import grails.transaction.Transactional

@Transactional
class GestionnaireService {
    public Gestionnaire insertOrUpdateGestionnaire(Gestionnaire gestionnaire) {
        gestionnaire.save(flush: true)
        gestionnaire
    }

    def deleteGestionnaire(Gestionnaire gestionnaire) {
        gestionnaire.delete(flush : true)
    }
}
