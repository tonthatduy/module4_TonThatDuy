<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Kết quả</title></head>
<body>
<h2>Gia vị bạn đã chọn:</h2>
<ul>
    <c:forEach items="${selectedCondiments}" var="c">
        <li>${c}</li>
    </c:forEach>
</ul>
<a href="/condiment">Quay lại</a>
</body>
</html>
