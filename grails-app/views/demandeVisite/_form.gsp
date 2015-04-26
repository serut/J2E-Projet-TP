<%@ page import="toulousemusee.DemandeVisite" %>


<div class="form-group col-sm-4 ${hasErrors(bean: demandeVisiteInstance, field: 'dateDeb', 'error')} required">
    <label>Date début</label>
    <div class='input-group date' id='datetimepicker1'>
    <g:field name="dateDeb" class="form-control" value="${formatDate(format:'MM/dd/yyyy',demandeVisiteInstance?.dateDeb)}" type="text"/>
        <span class="input-group-addon">
            <span class="glyphicon glyphicon-calendar"></span>
        </span>
    </div>
</div>

<div class="form-group col-sm-4 ${hasErrors(bean: demandeVisiteInstance, field: 'dateFin', 'error')} required">
    <label>Date fin</label>
    <div class='input-group date' id='datetimepicker2'>
        <g:field name="dateFin" class="form-control" value="${formatDate(format:'MM/dd/yyyy', demandeVisiteInstance?.dateFin)}" type="text"/>
        <span class="input-group-addon">
            <span class="glyphicon glyphicon-calendar"></span>
        </span>
    </div>
</div>

<div class="form-group col-sm-4 ${hasErrors(bean: demandeVisiteInstance, field: 'nbPersonne', 'error')} required">
    <label>Nombre de personnes</label>
    <g:field name="nbPersonnes" type="number" class="form-control" min="1" max="6"
             value="${demandeVisiteInstance?.nbPersonnes ?: 1}" required=""/>
    <label>Max 6</label>
</div>