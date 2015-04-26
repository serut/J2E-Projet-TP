<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../favicon.ico">

    <title>Cover Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="./../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./../css/cover.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="./../js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="./../js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
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
                <h1 class="cover-heading">Formulaire de demande de visite de musée</h1>
            </div>
            <div class="">

                <div style="margin:50px 0">
                    Vous avez ajouté à vos favoris la liste de musées suivante :
                    <g:each in="${session.museesFav}" status="i" var="museeFavoris">
                        <li role="presentation">
                            ${museeFavoris.value}
                        </li>
                    </g:each>
                </div>
                <p>Remplissez le formulaire ci dessous pour enregistrer votre demande :</p>
                <g:hasErrors bean="${demandeVisiteInstance}">
                    <ul class="label-danger" role="alert">
                        <g:eachError bean="${demandeVisiteInstance}" var="error">
                            <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                        </g:eachError>
                    </ul>
                </g:hasErrors>
                <div class="row text-right">
                    <g:form url="[resource: demandeVisiteInstance, action: 'save']">
                            <g:render template="form"/>
                            <button type="submit" class="btn btn-lg btn-success">Envoyer</button>
                    </g:form>
                </div>
            </div>


        </div>

    </div>

</div>

<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="../../dist/js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="../../assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
