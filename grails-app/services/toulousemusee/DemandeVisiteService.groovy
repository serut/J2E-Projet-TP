package toulousemusee

import grails.transaction.Transactional

@Transactional
class DemandeVisiteService {

    def search(ArrayList<Integer> demandeVisiteList) {
        List<DemandeVisite> result = new ArrayList<DemandeVisite>();
        List<DemandeVisite> query = DemandeVisite.getAll()
        System.out.println(query)
        query.each {
            System.out.println demandeVisiteList.contains(it.id)
            if (demandeVisiteList.contains(it.id))
                result.add(it)
        }
        result
    }
}
