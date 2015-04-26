<%@ page import="toulousemusee.DemandeVisite" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Cover Template for Bootstrap</title>
    <meta name="layout" content="main"/>
    <style>
    .form-control, #dateDeb_day, #dateDeb_month, #dateDeb_year, #dateFin_day, #dateFin_month, #dateFin_year {
        display: block;
        width: 100%;
        height: 34px;
        padding: 6px 12px;
        font-size: 14px;
        line-height: 1.42857143;
        color: #555;
        background-color: #fff;
        background-image: none;
        border: 1px solid #ccc;
        border-radius: 4px;
        -webkit-box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
        box-shadow: inset 0 1px 1px rgba(0,0,0,.075);
        -webkit-transition: border-color ease-in-out .15s,-webkit-box-shadow ease-in-out .15s;
        -o-transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
        transition: border-color ease-in-out .15s,box-shadow ease-in-out .15s;
    }
    </style>
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
                            <li><a href="${createLink(uri: '/')}">Acceuil</a></li>
                            <li><a href="${createLink(uri: '/demandeVisite/')}">Vos demandes de visite</a></li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <h1 class="cover-heading">Vos demandes de visite de musée</h1>
            </div>


            <div class="">
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
            </div>

            <div class="content">
                <table>
                    <thead>
                    <tr>

                        <g:sortableColumn property="dateDeb" title="${message(code: 'demandeVisite.dateDeb.label', default: 'Date Deb')}" />

                        <g:sortableColumn property="dateFin" title="${message(code: 'demandeVisite.dateFin.label', default: 'Date Fin')}" />

                        <g:sortableColumn property="statut" title="${message(code: 'demandeVisite.statut.label', default: 'Statut')}" />

                        <g:sortableColumn property="nbPersonnes" title="${message(code: 'demandeVisite.nbPersonnes.label', default: 'Nb Personnes')}" />
                        <th>Liste des muséees</th>
                    </tr>
                    </thead>
                    <tbody>
                    <g:each in="${demandeVisiteInstanceList}" status="i" var="demandeVisiteInstance">
                        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                            <td><g:formatDate date="${demandeVisiteInstance.dateDeb}" format="dd MM yyyy" /></td>

                            <td><g:formatDate date="${demandeVisiteInstance.dateFin}" format="dd MM yyyy" /></td>

                            <td>${fieldValue(bean: demandeVisiteInstance, field: "statut")}</td>

                            <td>${fieldValue(bean: demandeVisiteInstance, field: "nbPersonnes")}</td>

                            <td>
                                <ul>
                                    <g:each in="${demandeVisiteInstance.demandeVisiteMusees}" var="demandeVisiteMusees">

                                        <li>${fieldValue(bean: demandeVisiteMusees.musee, field: "nom")}</li>
                                    </g:each>
                                </ul>
                            </td>
                        </tr>
                    </g:each>
                    </tbody>
                </table>
            </div>
            <div style="margin-top:50px">
                <p>Et vous pouvez aussi récuperer les informations d'une autre demande de visite si vous avez le code</p>
                <g:form name="formulaireGetInfoDemandeVisite" method="get" url="[controller:'demandeVisite',action:'index']">
                    <label>Numéro de demande visite</label>
                    <g:field name="idDemandeVisite" type="number" class="form-control" required=""/>

                    <button type="submit" class="btn btn-primary" >
                        Rechercher
                    </button>
                </g:form>
            </div>


        </div>

    </div>

</div>
</body>
</html>
