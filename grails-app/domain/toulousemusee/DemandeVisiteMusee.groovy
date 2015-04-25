package toulousemusee

class DemandeVisiteMusee {
    DemandeVisite demandeVisite
    Musee musee
    Date dateDemande

    static constraints = {
        demandeVisite nullable: false
        musee nullable: false
        dateDemande nullable: false
    }
}
