package toulousemusee

class MoteurDeRechercheController {
    def index() {
        AdresseService adresseService = new AdresseService();

        List<String> listeCodePostal = adresseService.getCodePostal()

        render view: 'search', model: [listeCodePostal: listeCodePostal]
    }
}
