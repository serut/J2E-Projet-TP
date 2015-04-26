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
    <title>ToulouseMusee - Accueil</title>
    <meta name="layout" content="main"/>
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
                            <li><a href="${createLink(uri: '/')}">Accueil</a></li>
                            <li><a href="${createLink(uri: '/demandeVisite/')}">Vos demandes de visite</a></li>
                        </ul>
                    </nav>
                </div>
            </div>

            <div class="inner cover">
                <h1 class="cover-heading">Rechercher un musée</h1>
                <span>A partir d'un des critères de recherche suivants :</span>
            </div>
            <div class="">
                <g:form name="formulaireRechercher" method="get" url="[controller:'musee',action:'index']">

                    <div class="row text-left">
                        <div class="form-group col-sm-4">
                            <label>Nom</label>
                            <input type="text" name="inNomMusee" class="form-control" placeholder="Archives municipales...">
                        </div>
                        <div class="form-group col-sm-4">
                            <label for="exampleInputPassword1">Code postal</label>
                            <select class="form-control" name="codePostal">
                                <option value="" default></option>
                                <g:each in="${listeCodePostal}" var="codePostal">
                                    <option value="${codePostal}">${codePostal}</option>
                                </g:each>
                            </select>
                        </div>
                        <div class="form-group col-sm-4">
                            <label>Adresse</label>
                            <input type="text" name="inAdresseMusee" class="form-control" placeholder="Rue du may...">
                        </div>
                    </div>
                    <button type="submit" class="btn btn-lg btn-default">Rechercher</button>
                </g:form>
            </div>
        </div>
    </div>
</div>
</body>
</html>
