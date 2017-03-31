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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
    <link rel="stylesheet" href="resources/css/mystyle.css"/>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="container">
    <section>
        <div class="row">
            <div class="col-lg-12">
                <div class="table-content">
                    <a href="meals?action=addMeal" role="button" class="btn btn-primary">Добавить Еду</a>
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
                            <jsp:useBean id="meal" scope="page" type="ru.javawebinar.topjava.model.MealWithExceed"/>
                            <tr style="color:${meal.exceed ? 'red' : 'green'}">
                                <th scope="row">${fn:replace(meal.dateTime,'T',' ')}</th>
                                <td>${meal.description}</td>
                                <td>${meal.calories}</td>
                                <td><a href="meals?action=edit&id=${meal.id}"><i class="fa fa-pencil fa-lg"></i></a>
                                </td>
                                <td><a href="meals?action=delete&id=${meal.id}"><i class="fa fa-trash fa-lg"></i></a>
                                </td>
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
<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
