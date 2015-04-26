
<%@ page import="toulousemusee.Musee" %>
<%--
  Created by IntelliJ IDEA.
  User: Leo
  Date: 08/04/15
  Time: 15:23
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>

    <g:set var="entityName" value="${message(code: 'musee.label', default: 'Musee')}" />
    <title><g:message code="default.list.label" args="[entityName]" /></title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">


    <asset:stylesheet src="application.css"/>
    <!-- Custom styles for this template -->
    <link href="/J2E-Projet-TP/css/cover.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="site-wrapper">

    <div class="site-wrapper-inner">

        <div class="cover-container">

            <div class="masthead clearfix">
                <div class="inner">
                    <h3 class="masthead-brand">Projet TP J2E</h3>
                    <nav>
                        <ul class="nav masthead-nav">
                            <li><a class="home" href="${createLink(uri: '/')}">Accueil</a></li>
                            <li><a href="${createLink(uri: '/demandeVisite/')}">Demande de visite</a></li>
                        </ul>
                    </nav>
                </div>
            </div>

        </div>
        <div class="content">
            <div class="row">
                <div class="col-sm-7 col-sm-offset-1">
                    <h1><g:message code="default.list.label" args="[entityName]" /></h1>
                    <g:if test="${flash.message}">
                        <div class="message" role="status">${flash.message}</div>
                    </g:if>
                    <table class="table table-condensed">
                        <thead>
                        <tr>

                            <g:sortableColumn property="nom" title="${message(code: 'musee.nom.label', default: 'Nom')}" />

                            <g:sortableColumn property="horairesOuverture" title="${message(code: 'musee.horairesOuverture.label', default: 'Horaires Ouverture')}" />

                            <g:sortableColumn property="telephone" title="${message(code: 'musee.telephone.label', default: 'Telephone')}" />

                            <g:sortableColumn property="accesMetro" title="${message(code: 'musee.accesMetro.label', default: 'Acces Metro')}" />

                            <g:sortableColumn property="accesBus" title="${message(code: 'musee.accesBus.label', default: 'Acces Bus')}" />

                            <g:sortableColumn property="gestionnaire" title="${message(code: 'musee.gestionnaire.nom.label', default: 'Nom gestionnaire')}" />

                            <th><g:message code="musee.adresse.label" default="Adresse" /></th>

                            <th>Ajouter aux favoris</th>
                        </tr>
                        </thead>
                        <tbody>
                        <g:each in="${museeInstanceList}" status="i" var="museeInstance">
                            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                                <td><g:link action="show" id="${museeInstance.id}">${fieldValue(bean: museeInstance, field: "nom")}</g:link></td>

                                <td>${fieldValue(bean: museeInstance, field: "horairesOuverture")}</td>

                                <td>${fieldValue(bean: museeInstance, field: "telephone")}</td>

                                <td>${fieldValue(bean: museeInstance, field: "accesMetro")}</td>

                                <td>${fieldValue(bean: museeInstance, field: "accesBus")}</td>

                                <td>${fieldValue(bean: museeInstance, field: "gestionnaire")}</td>

                                <td>${fieldValue(bean: museeInstance, field: "adresse")}</td>

                                <td>
                                    <g:if test="${session.museesFav?.containsKey((int)museeInstance.id)}">
                                        <button type="submit" class="btn btn-primary" disabled>
                                            <span class="glyphicon-plus"></span> Ajouter
                                        </button>
                                    </g:if>
                                    <g:else>
                                        <g:form name="formulaireRechercher" method="get" url="[controller:'musee',action:'addMuseeFav']">
                                            <input type="hidden" name="codePostal" value="${params.codePostal}">
                                            <input type="hidden" name="inNomMusee" value="${params.inNomMusee}">
                                            <input type="hidden" name="inAdresseMusee" value="${params.inAdresseMusee}">
                                            <input type="hidden" name="offset" value="${params.offset}">
                                            <input type="hidden" name="max" value="${params.max}">
                                            <input type="hidden" name="idMuseeFav" value="${museeInstance.id}">
                                            <button type="submit" class="btn btn-primary" >
                                                <span class="glyphicon-plus"></span> Ajouter
                                            </button>
                                        </g:form>
                                    </g:else>
                                </td>
                            </tr>
                        </g:each>
                        </tbody>
                    </table>
                    <div class="pagination">
                        <g:paginate params="${params}" total="${museeInstanceCount ?: 0}" />
                    </div>
                </div>
                <div class="col-sm-2 col-sm-offset-1">
                    <div>
                        <div class="row">
                            <h3 class="masthead-brand">Musées favoris</h3>
                        </div>
                        <div class="row">
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
                        </div>
                        <g:if test="${museesFavSorted.size() > 0}">
                            <div class="row">
                                <br/>
                                <a href="${createLink(uri: '/demandeVisite/')}">
                                    <button type="submit" class="btn btn-warning">Faire une demande de visite</button>
                                </a>
                            </div>
                        </g:if>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>