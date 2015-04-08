package toulousemusee

class Musee {
    String nom
    String horairesOuverture
    String telephone
    String accesMetro
    String accesBus
    Adresse adresse
    Gestionnaire gestionnaire

    static mapping = {
        adresse cascade: 'all-delete-orphan'
    }

    static constraints = {
        nom nullable: false, blank: false
        horairesOuverture nullable: false, blank: false
        telephone nullable: false, blank: false
        accesMetro nullable: false, blank: false
        accesBus nullable: false, blank: false
        adresse nullable: false
        gestionnaire nullable: false
    }
}
