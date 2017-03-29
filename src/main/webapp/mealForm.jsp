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
        <form>
            <div clas="form-group">
                <input class="form-control" id="id" type="hidden"/>
            </div>
            <div clas="form-group">
                <label for="dateTime">Дата и время</label>
                <input class="form-control" id="dateTime" type="datetime-local"/>
            </div>
            <div clas="form-group">
                <label for="description">Описание</label>
                <input class="form-control" type="text" id="description"/>
            </div>
            <div clas="form-group">
                <label for="calories">Калории</label>
                <input class="form-control" type="number" id="calories"/>
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
