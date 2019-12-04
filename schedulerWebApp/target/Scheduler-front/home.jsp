<%--
  Created by IntelliJ IDEA.
  User: thomas
  Date: 02/12/2019
  Time: 12:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<button type="button"  class="btn btn-info pull-right" data-toggle="modal" data-target="#myTraining">
    My training
</button>
<div >
    <h1><font color="blue"><u>All training sessions</u></font></h1>


</div>
<div class="table-responsive">


    <div class="alert alert-info alert-dismissible" role="alert" style="display: ${visible}">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        Aucun résultat trouvé
    </div>
    <!-- test des balises jstl-->
    <div class="alert alert-${typeAl} alert-dismissible" role="alert" style="display: ${visible2}">
        <button type="button" class="close" data-dismiss="alert" aria-label="Close">
            <span aria-hidden="true">&times;</span>
        </button>
        <c:choose>
            <c:when test="${inscritOK}">
                Votre inscrition est faite

            </c:when>

            <c:otherwise>

                Vous êtes déjà inscrit


            </c:otherwise>
        </c:choose>

    </div>


    <table class="table table-striped table-hover">
        <thead>

        <tr>
            <th>Code</th>
            <th>Training sessions</th>
            <th>Location</th>
            <th>Start date</th>
            <th>End dates</th>
            <th></th>
        </tr>

        <tr>
            <form method="post" action="Filter">
                <th>
                </th>
                <th>
                    <input class="form-control" type="text" id="title" name="titleFilter" value="" size="20" maxlength="20" />

                </th>
                <th>
                    <select class="form-control" name="locFilter">
                        <option value = "vide"></option>
                        <c:forEach var="listloc" items="${listLocation}">
                            <option value ="${listloc.city}">${listloc.city}</option>
                        </c:forEach>
                    </select>
                </th>
                <th>

                    <input id="startFilter" name="dateFilter" type="text" class="form-control datepicker" onclick="datePickBug()" >


                </th>
                <th>

                </th>
                <th> <input type="submit" value="Search" class="btn btn-success" /></th>
            </form>
        </tr>


        </thead>

        <tbody>

        <c:forEach var="list" items="${result}">
            <tr>

                <td>

                        ${list.course.code}

                </td>
                <td id="title${list.idSession}">

                        ${list.course.title}

                </td>
                <td>

                        ${list.location.city}

                </td>
                <td>

                        ${list.startDate}

                </td>
                <td>

                        ${list.endDate}

                </td>

                <td>
                    <button type="button" value="${list.idSession}" class="btn btn-primary btn-sm" data-toggle="modal" data-target="#register" onclick="returnValue(this)">
                                <span class="glyphicon glyphicon-plus" >
                                </span>
                    </button>

                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

</div>
</br>

<button class="btn btn-primary"><span class="glyphicon glyphicon-chevron-left"></span> Previous </button>
<a href="RequestPdf"><button class="btn btn-success"><span class="glyphicon glyphicon-save-file"></span> Print PDF </button></a>
<button class="btn btn-primary"> Next <span class="glyphicon glyphicon-chevron-right"></span></button>

<!-- Modal -->
<div class="modal fade" id="register" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Subscribe</h4>
            </div>
            <form class="form-horizontal" method="post" action="Sub">
                <div  class="modal-body">
                    <input id ="idSess" type="hidden" name="idSess">


                    <div class="form-group">
                        <label class="control-label col-sm-2" for="fisrtN">Firstname:</label>
                        <div class="col-sm-10">
                            <input type="text"  name="firstName" class="form-control" id="fisrtN" placeholder="Enter firstname">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="lastN">Lastname:</label>
                        <div class="col-sm-10">
                            <input type="text"  name="lastName" class="form-control" id="lasrtN" placeholder="Enter lastname">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="addr">Address:</label>
                        <div class="col-sm-10">
                            <input type="text"  name="address" class="form-control" id="addr" placeholder="Enter address">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="phone">Phone:</label>
                        <div class="col-sm-10">
                            <input type="text"  name="phone" class="form-control" id="phone" placeholder="Enter phone">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="email">Email:</label>
                        <div class="col-sm-10">
                            <input type="email" name="email" class="form-control" id="email" placeholder="Enter email">
                        </div>
                    </div>
                </div>


                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Subcribe</button>
                </div>
            </form>
        </div>
    </div>
</div>

<!-- Modal -->
<div class="modal fade" id="myTraining" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title" id="myModalLabel">Modal title</h4>
            </div>
            <form class="form-horizontal" method="post" action="MyTraining">
                <div class="modal-body">
                    <div class="form-group">
                        <label class="control-label col-sm-2" for="emailT">Email:</label>
                        <div class="col-sm-10">
                            <input type="email" value="${emailSession}" name="emailT" class="form-control" id="emailT" placeholder="Enter email">
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                    <button type="submit" class="btn btn-primary">Done</button>
                </div>
            </form>
        </div>
    </div>
</div>
</html>
