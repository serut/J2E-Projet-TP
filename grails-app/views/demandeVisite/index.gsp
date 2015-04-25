
<%@ page import="toulousemusee.DemandeVisite" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'demandeVisite.label', default: 'DemandeVisite')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-demandeVisite" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-demandeVisite" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="dateDeb" title="${message(code: 'demandeVisite.dateDeb.label', default: 'Date Deb')}" />
					
						<g:sortableColumn property="dateFin" title="${message(code: 'demandeVisite.dateFin.label', default: 'Date Fin')}" />
					
						<g:sortableColumn property="statut" title="${message(code: 'demandeVisite.statut.label', default: 'Statut')}" />
					
						<g:sortableColumn property="nbPersonnes" title="${message(code: 'demandeVisite.nbPersonnes.label', default: 'Nb Personnes')}" />
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${demandeVisiteInstanceList}" status="i" var="demandeVisiteInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${demandeVisiteInstance.id}">${fieldValue(bean: demandeVisiteInstance, field: "dateDeb")}</g:link></td>
					
						<td><g:formatDate date="${demandeVisiteInstance.dateFin}" /></td>
					
						<td>${fieldValue(bean: demandeVisiteInstance, field: "statut")}</td>
					
						<td>${fieldValue(bean: demandeVisiteInstance, field: "nbPersonnes")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${demandeVisiteInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
