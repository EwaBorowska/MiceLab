<%--
  Created by IntelliJ IDEA.
  User: ewa
  Date: 21.01.19
  Time: 18:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">


</head>
<body>


<h1> Needed for matching </h1>

<form action="" method="post" >


        How many matches do you need?
        <input type="number" required="required"  name="number">
        <br>
        Minimal age of mice (in days):
        <input type="number" required="required" name="minAge">
        <br>
        Maximal age of mice (in days):
        <input type="number" required="required" name="maxAge">
        <br>

        <br>

<h2> Female mice </h2>


    <br>
    1A KO:
    <br>
    p/p:	<input type="checkbox"	 name="KO1A"	value="p/p"/>
    +/p:	<input type="checkbox"	 name="KO1A"	value="+/p"/>
    p/+	     <input type="checkbox"	 name="KO1A"	value="p/+"/>
    +/+:	<input type="checkbox"	 name="KO1A"	value="+/+"/>
    <br>
    <br>
    1B KO:
    <br>
    p/p:	<input type="checkbox"	 name="KO1B"	value="p/p"/>
    +/p:	<input type="checkbox"	 name="KO1B"	value="+/p"/>
    p/+	     <input type="checkbox"	 name="KO1B"	value="p/+"/>
    +/+:	<input type="checkbox"	 name="KO1B"	value="+/+"/>
    <br>
    <br>
    1D KO:
    <br>
    p/p:	<input type="checkbox"	 name="KO1D"	value="p/p"/>
    +/p:	<input type="checkbox"	 name="KO1D"	value="+/p"/>
    p/+	     <input type="checkbox"	 name="KO1D"	value="p/+"/>
    +/+:	<input type="checkbox"	 name="KO1D"	value="+/+"/>
    <br>
    <br>
    <br>
    <h2> Male mice </h2>
    <br>


    1A KO:
    <br>
    p/p:	<input type="checkbox"  name="KO1Am"	value="p/p"/>
    +/p:	<input type="checkbox"	name="KO1Am"	value="+/p"/>
    p/+	     <input type="checkbox"	name="KO1Am"	value="p/+"/>
    +/+:	<input type="checkbox"	name="KO1Am"	value="+/+"/>
    <br>
    <br>
    1B KO:
    <br>
    p/p:	<input type="checkbox"	 name="KO1Bm"	value="p/p"/>
    +/p:	<input type="checkbox"	 name="KO1Bm"	value="+/p"/>
    p/+	     <input type="checkbox"	 name="KO1Bm"	value="p/+"/>
    +/+:	<input type="checkbox"	 name="KO1Bm"	value="+/+"/>
    <br>
    <br>
    1D KO:
    <br>
    p/p:	<input type="checkbox"	  name="KO1Dm"	value="p/p"/>
    +/p:	<input type="checkbox"	  name="KO1Dm"	value="+/p"/>
    p/+	     <input type="checkbox"	  name="KO1Dm"	value="p/+"/>
    +/+:	<input type="checkbox"	  name="KO1Dm"	value="+/+"/>
    <br>
    <input type="submit" value="save"><br>





    </form>


    </body>
</html>
