<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<html>
<head>
    <title>Add a mouse</title>
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

<h1> Add a mouse </h1>

<form:form method="post" modelAttribute="mouse">
    Enter mousePassId  <form:input path="mousePassId" />
    <br>
    <br>

    Enter mother mousePassId  <form:input path="motherMousePassId" />
    <br>
    <br>
    Enter father mousePassId  <form:input path="fatherMousePassId" />
    <br>
    <br>
    Enter offspringId  <form:input path="offspringId" />
    <br>
    <br>
    Enter date of birth  <form:input path="birthDate" placeholder="dd/MM/yyyy" />
    <br>
    <br>

    Gender:<br>
    Male:	<form:radiobutton path="sex" value=" MALE" />
    Female:	<form:radiobutton path="sex" value=" FEMALE" />
    <br>
    <br>
    Availability:<br>
    Yes:	<form:radiobutton path="available" value="1" />
    No:	<form:radiobutton path="available" value="0" />

    <br>
    <br>
    Gene 1A KO:<br>
    p/p:	<form:radiobutton path="KO1A" value="p/p" />
    +/p:	<form:radiobutton path="KO1A" value="+/p" />
    p/+:	<form:radiobutton path="KO1A" value="p/+" />
    +/+:	<form:radiobutton path="KO1A" value="+/+" />
    undefined: <form:radiobutton path="KO1A" value="undefined" />
    <br>
    <br>
    Gene 1B KO:<br>
    p/p:	<form:radiobutton path="KO1B" value="p/p" />
    +/p:	<form:radiobutton path="KO1B" value="+/p" />
    p/+:	<form:radiobutton path="KO1B" value="p/+" />
    +/+:	<form:radiobutton path="KO1B" value="+/+" />
    undefined: <form:radiobutton path="KO1B" value="undefined" />
    <br>
    <br>
    Gene 1D KO:<br>
    p/p:	<form:radiobutton path="KO1D" value="p/p" />
    +/p:	<form:radiobutton path="KO1D" value="+/p" />
    p/+:	<form:radiobutton path="KO1D" value="p/+" />
    +/+:	<form:radiobutton path="KO1D" value="+/+" />
    undefined: <form:radiobutton path="KO1D" value="undefined" />
    <br>
    <br>
    Enter comments  <form:input path="comments" />
    <br>
    <br>



    <input type="submit" value="Save" />
</form:form>




</body>
</html>
