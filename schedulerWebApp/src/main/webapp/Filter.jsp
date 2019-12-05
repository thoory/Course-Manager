<%@ page import="fr.utbm.lo54.tp.scheduler.entity.CourseEntity" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: thomas
  Date: 24/11/2019
  Time: 10:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Course list</title>
</head>
<body>
<h1>Liste des cours disponibles</h1>
<table>
<%
    ArrayList<CourseEntity> courses=(ArrayList<CourseEntity>) request.getAttribute("courses");
    for (CourseEntity course: courses) {
%>
<tr>
    <td><%=course.getCode()%></td>
    <td><%=course.getTitle()%></td>
</tr>
<%}%>
</table>
</body>
</html>
