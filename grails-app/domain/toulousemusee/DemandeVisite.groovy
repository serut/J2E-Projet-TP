package toulousemusee

class DemandeVisite {
    Date dateDeb
    Date dateFin
    int nbPersonnes
    String statut

    static constraints = {
        dateDeb nullable: false
        dateFin nullable: false
        statut nullable: false, blank: false
    }
}
