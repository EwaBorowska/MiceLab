<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Save match</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>
<body>

<br>
<h1> Please confirm: </h1>
<br>




<form action="" method=post>
    <INPUT TYPE="radio" name="opt" value="yes"/>Yes, save!
    <br>
    <INPUT TYPE="radio" name="opt" value="no"/>No, don't save!
    <br>
    <INPUT TYPE="submit" value="submit" />
</form>

<br>

</body>
</html>
