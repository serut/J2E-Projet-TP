<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}" />
		<title><g:message code="default.create.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#create-musee" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="create-musee" class="content scaffold-create" role="main">
			<h1><g:message code="default.create.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
            <ul class="nav nav-pills nav-stacked">
                <g:each in="${museesFavSorted}" status="i" var="museeFavoris">
                    <li role="presentation">
                        ${museeFavoris.value}
                        <g:form name="formulaireRechercher" method="get" url="[controller:'musee',action:'removeMuseeFav']">
                            <input type="hidden" name="codePostal" value="${params.codePostal}">
                            <input type="hidden" name="inNomMusee" value="${params.inNomMusee}">
                            <input type="hidden" name="inAdresseMusee" value="${params.inAdresseMusee}">
                            <input type="hidden" name="offset" value="${params.offset}">
                            <input type="hidden" name="max" value="${params.max}">
                            <input type="hidden" name="idMuseeFav" value="${museeFavoris.key}">
                            <button type="submit" class="btn btn-primary" >
                                <span class="glyphicon glyphicon-trash"></span> Supprimer
                            </button>
                        </g:form>
                    </li>
                </g:each>
            </ul>
			<g:hasErrors bean="${museeInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${museeInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form url="[resource:museeInstance, action:'save']" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton name="create" class="save" value="${message(code: 'default.button.create.label', default: 'Create')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
