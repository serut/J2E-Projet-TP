package toulousemusee

import java.sql.Timestamp

class DemandeVisiteMusee {

    Timestamp version
    Date dateDemande
    DemandeVisite demandeVisite
    Musee musee

    static mapping = {
        musee lazy: false
        demandeVisite lazy: false
    }

    static constraints = {
        demandeVisite nullable: false
        musee nullable: false
        dateDemande nullable: false
    }
}
