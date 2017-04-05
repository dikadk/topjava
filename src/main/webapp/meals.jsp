<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://topjava.javawebinar.ru/functions" %>
<html>
<head>
    <title>Meal list</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        .normal {
            color: green;
        }

        .exceeded {
            color: red;
        }

        .container .jumbotron {
            padding: 0 !important;
        }

        .form-horizontal .control-label {
            text-align: left;
        }
        .control-label.col-sm-2{
            margin-right: -70px;
        }
    </style>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <navbar class="navbar-header">
            <h2><a href="index.html">Home</a></h2>
        </navbar>
    </div>
</nav>
<section>
    <div class="container">
        <h2>Meal list</h2>
        <div class="col-sm-12">
            <div class="jumbotron">
                <div class="form-group">
                    <div class="panel-body">
                        <form id="filter" class="form-horizontal" action="meals" method="get">
                            <div class="form-group">
                                <label class="control-label col-sm-1" for="startDate" >От даты:</label>
                                <div class="col-sm-2">
                                    <input class="form-control" name="startDate" id="startDate" type="date"/>
                                </div>
                                <label class="control-label col-sm-2" for="startTime">От времени:</label>
                                <div class="col-sm-2">
                                    <input class="form-control" name="startTime" id="startTime" type="time"/>
                                </div>
                            </div>
                            <div class="form-group">
                                <label class="control-label col-sm-1" for="endDate">До даты:</label>
                                <div class="col-sm-2">
                                    <input class="form-control" name="endDate" id="endDate" type="date"/>
                                </div>
                                <label class="control-label col-sm-2" for="endTime">До времени:</label>
                                <div class="col-sm-2">
                                    <input class="form-control" name="endTime" id="endTime" type="time"/>
                                </div>

                            </div>
                            <div class="col-sm-2">
                                <button type="submit" class="btn btn-primary">Filter</button>
                                <button type="reset" class="btn btn-danger" value="Reset">Reset</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <hr>
    <div class="container">
        <div>
            <a href="meals?action=create" class="btn btn-primary">Add Meal</a>
        </div>
        <div class="table-responsive">
            <table class="table">
                <thead>
                <tr>
                    <th>Date</th>
                    <th>Description</th>
                    <th>Calories</th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>
                <c:forEach items="${meals}" var="meal">
                    <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.to.MealWithExceed"/>
                    <tr class="${meal.exceed ? 'exceeded' : 'normal'}">
                        <td>
                                <%--${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}--%>
                                <%--<%=TimeUtil.toString(meal.getDateTime())%>--%>
                                ${fn:formatDateTime(meal.dateTime)}
                        </td>
                        <td>${meal.description}</td>
                        <td>${meal.calories}</td>
                        <td><a href="meals?action=update&id=${meal.id}">Update</a></td>
                        <td><a href="meals?action=delete&id=${meal.id}">Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</section>
</body>
</html>