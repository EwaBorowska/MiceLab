<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>
<table class="table">
    <th>Date</th>
    <th>Female ID</th>
    <th>1A KO</th>
    <th>1B KO</th>
    <th>1D KO</th>
    <th>Male ID</th>
    <th>1A KO</th>
    <th>1B KO</th>
    <th>1D KO</th>


    <c:forEach var="match" items="${matches}">
        <tr>
            <td>${match.date} </td>
            <td>${match.motherMousePassId.mousePassId} </td>
            <td>${match.motherMousePassId.KO1A} </td>
            <td>${match.motherMousePassId.KO1B} </td>
            <td>${match.motherMousePassId.KO1D} </td>

            <td>${match.fatherMousePassId.mousePassId}</td>
            <td>${match.fatherMousePassId.KO1A}</td>
            <td>${match.fatherMousePassId.KO1B}</td>
            <td>${match.fatherMousePassId.KO1D}</td>

        </tr>
    </c:forEach>



</table>

<br>
<a href="/">Back to menu</a><br>
</body>
</html>
