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

<script type="text/javascript">
    $(function () {
        $('#datetimepicker1').datetimepicker({
            format: 'L'
        });
        $('#datetimepicker2').datetimepicker({
            format: 'L'
        });
        $("#datetimepicker1").on("dp.change", function (e) {
            $("#datetimepicker2").data("DateTimePicker").minDate(e.date);
        });

        $("#datetimepicker2").on("dp.change", function (e) {
            $("#datetimepicker1").data("DateTimePicker").maxDate(e.date);
        });
    });
</script>
</body>
</html>
