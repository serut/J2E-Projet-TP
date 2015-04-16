<%@ page import="toulousemusee.DemandeVisite" %>



<div class="form-group col-sm-4 ${hasErrors(bean: demandeVisiteInstance, field: 'dateDeb', 'error')} required">
    <label>Date début</label>
    <g:datePicker name="dateDeb" precision="day" class="form-control"
                  value="${demandeVisiteInstance?.dateDeb}"/>

</div>

<div class="form-group col-sm-4 ${hasErrors(bean: demandeVisiteInstance, field: 'dateFin', 'error')} required">
    <label>Date fin</label>
    <g:datePicker name="dateFin" precision="day" class="form-control"
                  value="${demandeVisiteInstance?.dateFin}"/>

</div>

<div class="form-group col-sm-4 ${hasErrors(bean: demandeVisiteInstance, field: 'nbPersonne', 'error')} required">
    <label>Nombre de personnes</label>
    <g:field name="nbPersonne" type="number" class="form-control"
             value="${demandeVisiteInstance?.nbPersonne}" required=""/>
    <label>Max 6</label>
</div>
