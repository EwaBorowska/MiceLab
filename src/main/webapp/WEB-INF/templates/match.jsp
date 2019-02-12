<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Matching results</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<h2>Available female mice: </h2>

<c:forEach items="${femaleMice}" var="mouse">
    ${mouse.mousePassId}<br>
</c:forEach>
${noMiceWiththisParameterFemale}
<br>

<h2>Available male mice: </h2>
<c:forEach items="${maleMice}" var="mouse">
    ${mouse.mousePassId}<br>
</c:forEach>
${noMiceWiththisParameter}
<br>

<h2>Possible matching</h2>
${notEnoughMice}

${noMatches}

<br>
<table class="table">

    <th>Female MousePassID</th>
    <th>1A KO</th>
    <th>1B KO</th>
    <th>1D KO</th>
    <th>Male MousePassID</th>
    <th>1A KO</th>
    <th>1B KO</th>
    <th>1D KO</th>


    <c:forEach var="match" items="${matched}">
        <tr>
            <td>${match.key.mousePassId} </td>
            <td>${match.key.KO1A} </td>
            <td>${match.key.KO1B} </td>
            <td>${match.key.KO1D} </td>

            <td>${match.value.mousePassId}</td>
            <td>${match.value.KO1A}</td>
            <td>${match.value.KO1B}</td>
            <td>${match.value.KO1D}</td>

        </tr>
    </c:forEach>



</table>
<br>
<a href="/find">Change your search criteria</a>
<br>
<a href="/save">Save</a>
<br>
<a href="/">Back to menu</a>
</body>
</html>
