<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Update teacher</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<div class="container" style="width: 40%; margin: 40px auto auto auto">
    <h2 style="margin-bottom: 20px">Update teacher</h2>
    <form:form method="post" action="${pageContext.request.contextPath}/updateteacher">

        <div class="form-group" hidden>
            <label for="userid">UserID:</label>
            <form:input path="userid" type="text" class="form-control" id="userid" required="required"/>
        </div>

        <div class="form-group" hidden>
            <label for="teacherid">TeacherID:</label>
            <form:input path="teacherid" type="text" class="form-control" id="teacherid" required="required"/>
        </div>

        <div class="form-group" hidden>
            <label for="userid_fk">userid_fk:</label>
            <form:input path="userid_fk" type="text" class="form-control" id="userid_fk" required="required"/>
        </div>

        <div class="form-group">
            <label for="title">Title:</label>
            <form:input path="title" type="text" class="form-control" id="title" required="required"/>
        </div>

        <div class="form-group">
            <label for="name">Name:</label>
            <form:input path="name" type="text" class="form-control" id="name" required="required"/>
        </div>

        <div class="form-group">
            <label for="enrollment">Enrollment:</label>
            <form:input path="enrollment" type="text" class="form-control" id="enrollment" required="required"/>
        </div>

        <div class="form-group">
            <label for="pwd">Password:</label>
            <form:input path="password" type="password" class="form-control" id="pwd" required="required"/>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <form:input path="email" type="email" class="form-control" id="email" required="required"/>
        </div>

        <div class="form-group">
            <label for="profile">Profile:</label>
            <form:select path="profileid_fk" id="profile" class="form-control">
                <form:options items="${profiles}" itemLabel="profilename" itemValue="profileid"/>
            </form:select>
        </div>

        <button type="submit" class="btn btn-primary">Update</button>

    </form:form>
    <c:if test="${not empty errors}">
        <c:forEach var="error" items="${errors}">
            <div class="alert alert-danger" role="alert">${error}</div>
        </c:forEach>
    </c:if>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>

