<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 19/06/2025
  Time: 2:16 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h1>Settings</h1>
<form:form action="/update" method="post" modelAttribute="email">
    <form:hidden path="id"/>

    <label>Language:</label>
    <form:select path="language">
        <form:options items="${languages}"/>
    </form:select> <br><br>

    <label>Page Size:</label>
    <form:select path="pageSize">
        <form:options items="${pageSizes}"/>
    </form:select> <br><br>

    <label>Spam Filter:</label>
    <form:checkbox path="spamFilter"/> <br><br>

    <label>Signature:</label>
    <form:input path="signature"/> <br><br>
    <input type="submit" value="Update">
</form:form>
</body>
</html>
