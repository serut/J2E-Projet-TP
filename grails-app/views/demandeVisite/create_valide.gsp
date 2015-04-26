<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Demande de visite</title>
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
                <h1 class="cover-heading">Demande de visite de musée</h1>
            </div>
            <div class="">
                <g:if test="${flash.message}">
                    <div class="message" role="status">${flash.message}</div>
                </g:if>
            </div>
            <a href="${createLink(uri: '/demandeVisite')}">
                <button type="submit" class="btn btn-warning">Voir vos demandes de visite</button>
            </a>


        </div>

    </div>

</div>
</body>
</html>
