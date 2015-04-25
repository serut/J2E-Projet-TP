<%@ page import="toulousemusee.DemandeVisite" %>



<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'dateDeb', 'error')} required">
	<label for="dateDeb">
		<g:message code="demandeVisite.dateDeb.label" default="Date Deb" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateDeb" precision="day"  value="${demandeVisiteInstance?.dateDeb}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'dateFin', 'error')} required">
	<label for="dateFin">
		<g:message code="demandeVisite.dateFin.label" default="Date Fin" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="dateFin" precision="day"  value="${demandeVisiteInstance?.dateFin}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'statut', 'error')} required">
	<label for="statut">
		<g:message code="demandeVisite.statut.label" default="Statut" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="statut" required="" value="${demandeVisiteInstance?.statut}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: demandeVisiteInstance, field: 'nbPersonnes', 'error')} required">
	<label for="nbPersonnes">
		<g:message code="demandeVisite.nbPersonnes.label" default="Nb Personnes" />
		<span class="required-indicator">*</span>
	</label>
	<g:field name="nbPersonnes" type="number" value="${demandeVisiteInstance.nbPersonnes}" required=""/>

</div>

