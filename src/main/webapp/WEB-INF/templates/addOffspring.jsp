<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Add an offspring </title>
    <style type="text/css">
        body {color: ${color}; background-color: ${backgroundColor}}
    </style>
</head>
<body>

<style>
    .errorClass {
        color: red;
        font-weight: bold
    }
</style>

<h1> Add an offspring </h1>

<form:form method="post" modelAttribute="offspring">

    Enter birthdate  <form:input path="birthDate" placeholder="dd/MM/yyyy" />

    <br>

    Enter quantity  <form:input path="quantity" />
    <br>


    Enter comments  <form:input path="comments" />


    <br>

    Enter offspring id   <form:input path="offspringId" />


    <br>


    <input type="submit" value="Save" />
</form:form>




</body>
</html>
