<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 19/06/2025
  Time: 3:26 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>List</title>
</head>
<body>
<table border="1">
    <tr>
        <th>STT</th>
        <th>Ngôn Ngữ</th>
        <th>Trang</th>
        <th>Lọc Spam</th>
        <th>Chữ Ký</th>
        <th>Chỉnh Sửa</th>
    </tr>
    <c:forEach items="${emailList}" var="email" varStatus="idx">
        <tr>
            <td>${idx.count}</td>
            <td>${email.id}</td>
            <td>${email.language}</td>
            <td>${email.pageSize}</td>
            <td>${email.spamFiler}</td>
            <td>${email.signature}</td>
            <td><a href="/edit?id=${email.id}">Edit</a></td>        </tr>
    </c:forEach>

</table>
</body>
</html>
