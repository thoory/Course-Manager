<%@ page import="fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity" %>
<%@ page import="fr.utbm.lo54.tp.scheduler.entity.ClientEntity" %>
<%@ page import="java.text.SimpleDateFormat" %><%--
  Created by IntelliJ IDEA.
  User: thomas
  Date: 24/11/2019
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Projet LO54</title>
    <meta http-equiv="X-UA-Compatible" content="IE=Edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="keywords" content="">
    <meta name="description" content="">
    <!-- stylesheet css -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/font-awesome.min.css">
    <link rel="stylesheet" href="css/templatemo-blue.css">
</head>
<body data-spy="scroll" data-target=".navbar-collapse">

<!-- preloader section -->
<div class="preloader">
    <div class="sk-spinner sk-spinner-wordpress">
        <span class="sk-inner-circle"></span>
    </div>
</div>

<!-- header section -->
<header>
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12">
                <h1 class="tm-title bold shadow">Projet de LO54</h1>
                <h1 class="white bold shadow">Par Mathieu Puget et Thomas Ory</h1>
                <hr>
            </div>
        </div>
    </div>
</header>

<!-- education and languages -->
<section class="container">
    <div class="row">
        <div class="col-md-5 col-sm-12">
            <div class="education">
                <h2 class="white">Cours</h2>
                <div class="education-content">
                    <div class="education-school">
                        <%
                            CourseSessionEntity cSession = (CourseSessionEntity) request.getAttribute("cSession");
                            SimpleDateFormat dateFormat=new SimpleDateFormat("dd/MM/YYYY");
                            SimpleDateFormat hourFormat=new SimpleDateFormat("HH:mm");

                            String date = dateFormat.format(cSession.getStartDate());
                            String start = hourFormat.format(cSession.getStartDate());
                            String end = hourFormat.format(cSession.getEndDate());
                        %>
                        <div>
                            Titre: <%=cSession.getCourse().getTitle()%>
                        </div>
                        <div>
                            Date: <%=date%>
                        </div>
                        <div>
                            Horaire: <%=start%> à <%=end%>
                        </div>
                        <div>
                            Localisation: <%=cSession.getLocation().getCity()%>
                        </div>
                        <div>
                            Nombre de place restantes: <%=cSession.getMax()-cSession.getClientList().size()%>/<%=cSession.getMax()%>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-7 col-sm-12">
            <div class="languages">
                <% if (request.getAttribute("client") != null) {
                    ClientEntity client = (ClientEntity) request.getAttribute("client");
                %>
                <h2>Inscription validé !</h2>
                Le cours de <%=cSession.getCourse().getTitle()%> du <%=date%> compte maintenant <%=client.getFirstname()%> <%=client.getLastname()%> dans ses participants.
                <div>
                    <br>
                    <a href="Filter" class="btn btn-default">Liste des cours</a>
                </div>
                <%} else {%>
                <h2>Informations clients</h2>
                <form class="form-horizontal" action="Inscription?id=<%=cSession.getId()%>" method="POST">
                    <div class="form-group">
                        <label class="control-label col-sm-2">Prénom:</label>
                        <div class="col-sm-10">
                            <input type="input" class="form-control" name="firstname" placeholder="Votre prénom" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Nom:</label>
                        <div class="col-sm-10">
                            <input type="input" class="form-control" name="lastname" placeholder="Votre Nom" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Adresse:</label>
                        <div class="col-sm-10">
                            <input type="input" class="form-control" name="address" placeholder="Votre adresse">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Telephone:</label>
                        <div class="col-sm-10">
                            <input type="tel" class="form-control" name="phone" placeholder="Votre numéro">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-sm-2">Email:</label>
                        <div class="col-sm-10">
                            <input type="email" class="form-control" name="email" placeholder="Enter email">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <a href="Filter" class="btn btn-default">Retour</a>
                            <button type="submit" class="btn btn-default">S'inscrire</button>
                        </div>
                    </div>
                </form>
                <%}%>
            </div>
        </div>
    </div>
</section>

<!-- footer section -->
<footer>
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12">
                <p>Copyright &copy; 2018</p>
                <ul class="social-icons">
                    <li><a href="https://github.com/thoory" class="fa fa-github"></a></li>
                </ul>
            </div>
        </div>
    </div>
</footer>

<!-- javascript js -->
<script src="js/jquery.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/jquery.backstretch.min.js"></script>
<script src="js/custom.js"></script>

</body>
</html>