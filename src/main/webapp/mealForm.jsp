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
        <form>
            <div class="form-group row">
                <label class="col-2 col-form-label">Дата и время</label>
                <div class="col-10">
                    <input class="form-control" type="datetime-local" id="dateTime">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-2 col-form-label">Описание</label>
                <div class="col-10">
                    <input class="form-control" type="text" id="description">
                </div>
            </div>
            <div class="form-group row">
                <label class="col-2 col-form-label">Калории</label>
                <div class="col-10">
                    <input class="form-control" type="number" id="calories">
                </div>
            </div>
        </form>
    </section>
</div>
</body>
</html>
