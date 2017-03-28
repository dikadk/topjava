<%--
  Created by IntelliJ IDEA.
  User: dkiro
  Date: 3/27/17
  Time: 4:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions"
           prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Meals</title>
    <!--Font Awesome -->
    <script src="https://use.fontawesome.com/3977ae73b8.js"></script>
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/css/bootstrap.min.css"
          integrity="sha384-rwoIResjU2yc3z8GV/NPeZWAv56rSmLldC3R/AZzGRnGxQQKnKkoFVhFQhNUwEyJ" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/mystyle.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <section>
        <div class="row">
            <div class="col-lg-12">
                <div class="table-content">
                    <a href="mealForm" role="button" class="btn btn-primary">Primary</a>
                    <table class="table table-responsive">
                        <thead class="thead-inverse">
                        <tr>
                            <th>Дата и время</th>
                            <th>Описание</th>
                            <th>Калории</th>
                            <th></th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach var="meal" items="${mealsList}">
                            <tr style="color:${meal.exceed ? 'red' : 'green'}">
                                <th scope="row">${fn:replace(meal.dateTime,'T',' ')}</th>
                                <td>${meal.description}</td>
                                <td>${meal.calories}</td>
                                <td><a href="#"><i class="fa fa-pencil fa-lg"></i></a></td>
                                <td><a href="#"><i class="fa fa-trash fa-lg"></i></a></td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </section>
    <!-- /.container -->
</div>
<!-- jQuery first, then Tether, then Bootstrap JS. -->
<script src="https://code.jquery.com/jquery-3.1.1.slim.min.js"
        integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.4.0/js/tether.min.js"
        integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.6/js/bootstrap.min.js"
        integrity="sha384-vBWWzlZJ8ea9aCX4pEW3rVHjgjt7zpkNpZk+02D9phzyeVkE+jo0ieGizqPLForn"
        crossorigin="anonymous"></script>
</body>
</html>
