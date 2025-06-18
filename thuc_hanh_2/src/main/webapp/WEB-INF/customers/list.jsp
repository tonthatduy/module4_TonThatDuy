<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Danh sách khách hàng</title>
    <style>
        table {
            width: 500px;
            border: 2px solid;
        }

        tr, td, th {
            border: 1px dotted;
        }
    </style>
</head>
<body>
<h2>Danh sách khách hàng</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Address</th>
    </tr>
    <c:forEach var="c" items="${customers}">
        <tr>
            <td>${c.id}</td>
            <td><a href="/customers/${c.id}">${c.name}</a></td>
            <td>${c.email}</td>
            <td>${c.address}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
