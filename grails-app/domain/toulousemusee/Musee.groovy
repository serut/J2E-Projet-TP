package toulousemusee

import java.sql.Timestamp

class Musee {
    Timestamp version

    String nom
    String horairesOuverture
    String telephone
    String accesMetro
    String accesBus
    Adresse adresse
    Gestionnaire gestionnaire

    static constraints = {
        nom nullable: false, blank: false
        horairesOuverture nullable: false, blank: false
        telephone nullable: false, blank: false
        accesMetro nullable: false, blank: true
        accesBus nullable: false, blank: true
        adresse nullable: false, unique:true
        gestionnaire nullable: false
    }

    static mapping = {
        adresse lazy: false
        gestionnaire lazy: false
    }


    @Override
    public String toString() {
        return "Musee{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", horairesOuverture='" + horairesOuverture + '\'' +
                ", telephone='" + telephone + '\'' +
                ", accesMetro='" + accesMetro + '\'' +
                ", accesBus='" + accesBus + '\'' +
                ", gestionnaire=" + gestionnaire +
                ", adresse=" + adresse +
                '}';
    }
}
