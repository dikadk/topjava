<%--
  Created by IntelliJ IDEA.
  User: dkiro
  Date: 3/28/17
  Time: 4:39 PM
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

    <title>Meal Form</title>
    <!--jQuery 3.2.1-->
    <script
            src="https://code.jquery.com/jquery-3.2.1.js"
            integrity="sha256-DZAnKJ/6XZ9si04Hgrsxu/8s717jcIzLy3oi35EouyE="
            crossorigin="anonymous"></script>
    <!--Font Awesome -->
    <script src="https://use.fontawesome.com/3977ae73b8.js"></script>
    <!-- Latest compiled and minified CSS -->
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
        <form method="post" action="mealForm" name="formAddMeal">
            <div class="form-group">
                <input class="form-control" name="id" type="hidden" value="${meal.id}"/>
            </div>
            <div class="form-group">
                <label>Дата и время</label>
                <input class="form-control"  name="dateTime" type="text" placeholder="yyyy/mm/dd HH:MM" value="${fn:replace(meal.dateTime,"T"," ")}" required />
            </div>
            <div class="form-group">
                <label>Описание</label>
                <input class="form-control" type="text" name="description" value="${meal.description}" required/>
            </div>
            <div class="form-group">
                <label>Калории</label>
                <input class="form-control" type="number" name="calories" value="${meal.calories}" required/>
            </div>
            <button type="submit" class="btn btn-default">Submit</button>
        </form>
    </section>
</div>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
        integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
        crossorigin="anonymous"></script>
</body>
</html>
