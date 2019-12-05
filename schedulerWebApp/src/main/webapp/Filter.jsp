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
<html>
<head>
    <title>Projet de LO54</title>
</head>
<body>
<h1>Liste des cours disponibles</h1>

<form action="Filter" method="post">
    Lieux:
    <select name="location">
        <option value="">Tous</option>
        <%
            ArrayList<LocationEntity> locations=(ArrayList<LocationEntity>) request.getAttribute("locationsList");
            LocationEntity currentLoc = (LocationEntity) request.getAttribute("currentLoc");
            for (LocationEntity loc: locations) {
        %>
        <option value="<%=loc.getId()%>"<% if ( currentLoc != null && currentLoc.getId() == loc.getId()) {%> selected <%}%>><%=loc.getCity()%></option>
        <%}%>
    </select>
    <input type="submit" value="Submit">
</form>

<table border="1">
    <tr>
        <th>Titre</th>
        <th>Date</th>
        <th>Début</th>
        <th>Fin</th>
        <th>lieu</th>
        <th>nombre de place</th>
    </tr>
    <%
        ArrayList<CourseSessionEntity> sessions=(ArrayList<CourseSessionEntity>) request.getAttribute("sessions");
        SimpleDateFormat hour=new SimpleDateFormat("HH:mm");
        String startDate, endDate;
        for (CourseSessionEntity courseSession: sessions) {
            startDate = hour.format(courseSession.getStartDate());
            endDate = hour.format(courseSession.getEndDate());
    %>
    <tr>
        <td><%=courseSession.getCourse_code().getTitle()%></td>
        <td><%=courseSession.getStartDate()%></td>
        <td><%=startDate%></td>
        <td><%=endDate%></td>
        <td><%=courseSession.getLocation_id().getCity()%></td>
        <td><%=courseSession.getMax()%></td>
    </tr>
    <%}%>
</table>
</body>
</html>
