<%@ page import="fr.utbm.lo54.tp.scheduler.entity.CourseEntity" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="fr.utbm.lo54.tp.scheduler.entity.CourseSessionEntity" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="fr.utbm.lo54.tp.scheduler.entity.LocationEntity" %><%--
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
                <h2 class="white">Critères</h2>
                <div class="education-content">
                    <div class="education-school">
                        <form action="Filter" method="post">
                            Mots clés:
                            <input type="text" class="black-input" name="search" <% if ( request.getAttribute("strRequested") != null ) {%> placeholder="<%=request.getAttribute("strRequested")%>"<%}%>>
                            <input type="submit" class="btn btn-default" value="Appliquer">
                        </form>
                        <br>
                        <form action="Filter" method="post">
                            Localisation:
                            <select name="location">
                                <option value="">Tous</option>
                                <%
                                    ArrayList<LocationEntity> locations=(ArrayList<LocationEntity>) request.getAttribute("locationsList");
                                    LocationEntity currentLoc = (LocationEntity) request.getAttribute("currentLoc");
                                    for (LocationEntity loc: locations) {
                                %>
                                <option class="black-input" value="<%=loc.getId()%>"<% if ( currentLoc != null && currentLoc.getId() == loc.getId()) {%> selected <%}%>><%=loc.getCity()%></option>
                                <%}%>
                            </select>
                            <input type="submit" class="btn btn-default" value="Appliquer">
                        </form>
                        <br>
                        <form action="Filter" method="post">
                            Date: <input type="date" class="black-input" name="date" <% if ( request.getAttribute("currentDate") != null ) {%> value="<%=request.getAttribute("currentDate")%>" <%}%>>
                            <input type="submit" class="btn btn-default" value="Appliquer">
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <div class="col-md-7 col-sm-12">
            <div class="languages">
                <h2>Liste des cours</h2>
                <table class="table table-striped">
                    <tr>
                        <th>Titre</th>
                        <th>Date</th>
                        <th>Début</th>
                        <th>Fin</th>
                        <th>Localisations</th>
                        <th>Places réservées</th>
                        <th>Inscription</th>
                    </tr>
                    <%
                        ArrayList<CourseSessionEntity> sessions=(ArrayList<CourseSessionEntity>) request.getAttribute("sessions");
                        SimpleDateFormat hour=new SimpleDateFormat("HH:mm");
                        String startDate, endDate;
                        float inscrits = 0;
                        for (CourseSessionEntity courseSession: sessions) {
                            startDate = hour.format(courseSession.getStartDate());
                            endDate = hour.format(courseSession.getEndDate());
                            inscrits = courseSession.getClientList().size();
                            inscrits = (inscrits/courseSession.getMax())*100;
                    %>
                    <tr>
                        <td><%=courseSession.getCourse().getTitle()%></td>
                        <td><%=courseSession.getStartDate()%></td>
                        <td><%=startDate%></td>
                        <td><%=endDate%></td>
                        <td><%=courseSession.getLocation().getCity()%></td>
                        <td>
                            <div class="progress">
                                <div class="progress-bar" role="progressbar" aria-valuemin="0" aria-valuemax="<%=courseSession.getMax()%>" style="width:<%=inscrits%>%">
                                </div>
                                <%=Math.round(inscrits)%>%
                            </div>
                        </td>
                        <td>
                            <a href="Inscription?id=<%=courseSession.getId()%>" class="btn btn-primary" role="button">+</a>
                        </td>
                    </tr>
                    <%}%>
                </table>
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