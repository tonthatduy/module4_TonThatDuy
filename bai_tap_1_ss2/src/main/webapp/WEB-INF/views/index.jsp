<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 18/06/2025
  Time: 1:54 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sandwich</title>
</head>
<body>
<form action="/save" method="post">
    <fieldset>
        <legend>
            Sandwich Condiments
        </legend>
        <label><input type="checkbox" name="condiment" value="lettuce">Lettuce</label>
        <label><input type="checkbox" name="condiment" value="tomato">Tomato</label>
        <label><input type="checkbox" name="condiment" value="mustard">Mustard</label>
        <label><input type="checkbox" name="condiment" value="sprouts">Sprouts</label>
        <br>
        <input type="submit" value="save"></fieldset>

</form>
</body>
</html>
