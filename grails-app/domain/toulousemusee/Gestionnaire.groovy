package toulousemusee

class Gestionnaire {
    String nom

    static hasMany = [musees:Musee]

    static mapping = {
        musees cascade: 'all-delete-orphan'
    }

    static constraints = {
        nom nullable: false, blank: false
    }


    @Override
    public String toString() {
        return nom;
    }
}
