package toulousemusee

import static org.springframework.http.HttpStatus.CREATED

class DemandeVisiteController {

    def index() {
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

        //TODO


        // Fonctionne pas encore :
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'demandeVisiteInstance.label', default: 'Musee'), demandeVisiteInstance.id])
                redirect view:'create_valide'
            }
        }
    }
}
