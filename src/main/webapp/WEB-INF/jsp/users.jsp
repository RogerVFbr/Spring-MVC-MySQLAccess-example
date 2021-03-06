<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Users</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet" integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">
</head>
<body>

<%@ include file="common/navbar.jspf" %>

<div class="container">

    <h2 style="margin-bottom: 20px">Students</h2>

    <table class="table table-striped">
        <tr><th>Name</th><th>E-mail</th><th>Enrollment</th><th>Birthdate</th><th>Actions</th></tr>
        <c:forEach var="su" items="${studentUser}">
            <tr>
                <td>${su.name}</td>
                <td>${su.email}</td>
                <td>${su.enrollment}</td>
                <td>${su.birthdate}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/updatestudent/${su.studentid}"><i class="fa fa-fw fa-edit"></i></a>
                    <a href="${pageContext.request.contextPath}/deleteuser/${su.userid_fk}"><i class="fa fa-fw fa-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
    </table>

    <h2 style="margin-bottom: 20px">Teachers</h2>

    <table class="table table-striped">
        <tr><th>Enrollment</th><th>Title</th><th>Name</th><th>E-mail</th><th>Actions</th></tr>
        <c:forEach var="tu" items="${teacherUser}">
            <tr>
                <td>${tu.enrollment}</td>
                <td>${tu.title}</td>
                <td>${tu.name}</td>
                <td>${tu.email}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/updateteacher/${tu.teacherid}"><i class="fa fa-fw fa-edit"></i></a>
                    <a href="${pageContext.request.contextPath}/deleteuser/${tu.userid_fk}"><i class="fa fa-fw fa-trash"></i></a>
                </td>
            </tr>
        </c:forEach>
    </table>

    </br></br></br>

</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>




