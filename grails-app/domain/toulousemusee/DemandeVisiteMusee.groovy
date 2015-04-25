package toulousemusee

class DemandeVisiteMusee {

    Date dateDemande

    static belongsTo = [
            musee: Musee,
            demandeVisite: DemandeVisite
    ]

    static constraints = {
        demandeVisite nullable: false
        musee nullable: false
        dateDemande nullable: false
    }
}
