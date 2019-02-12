<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<h1> Mice: </h1>
<body>


<table class="table">
    <th>Mousepass ID</th>
    <th>Sex</th>
    <th>1A KO</th>
    <th>1B KO</th>
    <th>1D KO</th>
    <th>Mother mousepass ID</th>
    <th>Father mousepass ID</th>
    <th>Date of birth</th>
    <th>Availability</th>
    <th>Death date</th>


    <th>Opcje</th>
    <c:forEach var="mouse" items="${mice}">
        <tr>
            <td>${mouse.mousePassId}</td>
            <td>${mouse.sex}</td>

            <td>${mouse.KO1A}</td>
            <td>${mouse.KO1B}</td>
            <td>${mouse.KO1D}</td>
            <td>${mouse.motherMousePassId}</td>
            <td>${mouse.fatherMousePassId}</td>
            <td>${mouse.birthDate}</td>
            <td>${mouse.available}</td>
            <td>${mouse.deathDate}</td>

            <td>
                <a href="/mouse/edit/${mouse.id}">Update</a>
                <a href="/mouse/delete/${mouse.id}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br><br>
<a href="/mouse">Add a new mouse</a><br>
<br>
<a href="/">Back to menu</a><br>
</body>
</html>
