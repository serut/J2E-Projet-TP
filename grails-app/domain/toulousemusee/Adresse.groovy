package toulousemusee

class Adresse {
    String numero
    String rue
    String codePostal
    String ville

    static constraints = {
        numero nullable: false, blank: false
        rue nullable: false, blank: false
        codePostal nullable: false, blank: false
        ville nullable: false, blank: false
    }


    @Override
    public String toString() {
        return "n°" + numero +
                ", " + rue +
                ", " + codePostal +
                " '" + ville;
    }
}
