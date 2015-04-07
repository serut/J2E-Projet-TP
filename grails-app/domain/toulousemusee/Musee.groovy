package toulousemusee

class Musee {
    String name
    String horairesOuverture
    String telephone
    String accesMetro
    String accesBus

    static constraints = {
        name nullable: false, blank: false
        horairesOuverture nullable: false, blank: false
        telephone nullable: false, blank: false
        accesMetro nullable: false, blank: false
        accesBus nullable: false, blank: false
    }
}
