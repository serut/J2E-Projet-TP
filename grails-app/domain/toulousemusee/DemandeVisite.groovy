package toulousemusee

class DemandeVisite {
    Date dateDeb
    Date dateFin
    int nbPersonnes
    String statut = 'Pending';

    static constraints = {
        dateDeb nullable: false
        dateFin nullable: false
        statut nullable: false, blank: false
        nbPersonnes max: 6
    }

    static mapping = {
        statut defaultValue: "'Pending'"
    }

    static hasMany = [demandeVisiteMusees: DemandeVisiteMusee]
}
