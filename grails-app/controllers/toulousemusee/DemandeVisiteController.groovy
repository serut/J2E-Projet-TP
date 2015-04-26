package toulousemusee

class DemandeVisiteController {

    def demandeVisiteService;

    def index() {
        session.demandeVisite = session.demandeVisite ?: new ArrayList<Integer>()

        // Ajoute à la session de l'utilisateur une demande visite s'il connait son identifiant
        if (params.idDemandeVisite) {
            Integer idDemandeVisite = Integer.parseInt(params.idDemandeVisite)
            // Verifie si il a déjà l'idenfiant dans sa liste
            if (session.demandeVisite.contains(idDemandeVisite)) {
                flash.message = 'Vous avez déjà ajouté cette demande de visite.'
            } else {
                // Vérifie que la demandeVisite existe
                def demandeVisite = DemandeVisite.get(idDemandeVisite)
                if (demandeVisite) {
                    flash.message = "La demande de visite n°${idDemandeVisite} a bien été ajouté à votre liste de demande de visite."
                    session.demandeVisite.add(demandeVisite.id);
                } else {
                    flash.message = "La demande de visite n°${idDemandeVisite} n'existe pas"
                }
            }
        }

        def demandeVisiteList = demandeVisiteService.search(session.demandeVisite);

        respond demandeVisiteList
    }
    def create() {
        render view: 'create'
    }
    def save(DemandeVisite demandeVisiteInstance) {
        if (demandeVisiteInstance == null) {
            notFound()
            return
        }

        if (demandeVisiteInstance.hasErrors()) {
            respond demandeVisiteInstance.errors, view:'create'
            return
        }

        //Sauvegarde en db la demande
        demandeVisiteInstance.save flush: true

        //Attache cette demandeVisite au client grâce à la session
        session.demandeVisite = session.demandeVisite ?: new ArrayList<Integer>()
        session.demandeVisite.add(demandeVisiteInstance.id);

        System.out.println(demandeVisiteInstance.id);
        // Sauvegarde en db les demandeVisiteMusee (1 par museesFav de la session)
        session.museesFav = session.museesFav ?: new HashMap<Integer, String>()
        for (Integer i : session.museesFav.keySet()) {
            System.out.println(i);
            DemandeVisiteMusee demandeVisiteMusee = new DemandeVisiteMusee(dateDemande: new Date(), musee: Musee.get(i), demandeVisite : demandeVisiteInstance)
            demandeVisiteMusee.save flush: true
            System.out.println(demandeVisiteMusee.hasErrors());
        }

        // Affiche à l'utilisateur
        flash.message = 'La demande de visite n°' + demandeVisiteInstance.id + ' a bien été crée.'
        render view:'create_valide'
    }
}
