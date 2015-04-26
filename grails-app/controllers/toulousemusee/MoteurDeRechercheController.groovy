package toulousemusee

class MoteurDeRechercheController {
    def index() {
        AdresseService adresseService = new AdresseService();

        List<String> listeCodePostal = adresseService.getCodePostal()

        def museesFavSorted = new LinkedHashMap<Integer, String>();
        if (session.museesFav) {
            museesFavSorted = sortByValue(session.museesFav);
        }

        render view: 'search', model: [listeCodePostal: listeCodePostal, museesFavSorted: museesFavSorted]
    }

    def removeMuseeFav() {
        Integer id = Integer.parseInt(params.idMuseeFav)

        if (session.museesFav) {
            session.museesFav.remove(id)
        }

        params.remove("idMuseeFav")

        redirect(controller: "moteurDeRecherche", action: "index", params: params)
    }

    private static <Integer, String> Map<Integer, String> sortByValue( Map<Integer, String> map )
    {
        List<Map.Entry<Integer, String>> list =
                new LinkedList<Map.Entry<Integer, String>>( map.entrySet() );
        Collections.sort( list, new Comparator<Map.Entry<Integer, String>>()
        {
            public int compare( Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2 )
            {
                return (o1.getValue()).compareTo( o2.getValue() );
            }
        } );

        Map<Integer, String> result = new LinkedHashMap<Integer, String>();
        for (Map.Entry<Integer, String> entry : list)
        {
            result.put( entry.getKey(), entry.getValue() );
        }
        return result;
    }
}
