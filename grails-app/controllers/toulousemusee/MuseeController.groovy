package toulousemusee



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class MuseeController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def museeService

    def index(Integer max) {
        params.max = Math.min(max ?: 5, 100)

        def listeMusee = museeService.searchMusee(params.inNomMusee, params.codePostal, params.inAdresseMusee)
        def museesFavSorted = new LinkedHashMap<Integer, String>();
        if (session.museesFav) {
            museesFavSorted = sortByValue(session.museesFav);
        }
        respond listeMusee.drop(params.int('offset') ?: 0).take(params.int('max')), model: [params: params, museeInstanceCount: listeMusee.size(), museesFavSorted: museesFavSorted]
    }
    
    def addMuseeFav() {
        Integer id = Integer.parseInt(params.idMuseeFav)
        session.museesFav = session.museesFav ?: new HashMap<Integer, String>()
        session.museesFav.put(id, Musee.findById(id).nom)
        params.remove("idMuseeFav")

        redirect(controller:'musee',action:'index', params: params)
    }

    def removeMuseeFav() {
        Integer id = Integer.parseInt(params.idMuseeFav)

        if (session.museesFav) {
            session.museesFav.remove(id)
        }

        params.remove("idMuseeFav")

        redirect(controller:'musee',action:'index', params: params)
    }
    /**
     * Sort a map by value
     * @see http://stackoverflow.com/a/2581754/2294168
     * @param map
     * @return
     */
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
