<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Kết quả</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">
<div class="bg-white p-8 rounded-lg shadow-lg max-w-md w-full">
    <h2 class="text-2xl font-bold text-gray-800 mb-6 text-center">Gia vị bạn đã chọn:</h2>
    <ul class="space-y-2">
        <c:forEach items="${selectedCondiments}" var="c">
            <li class="text-gray-700 bg-gray-50 p-3 rounded-md">${c}</li>
        </c:forEach>
    </ul>
    <div class="mt-6 text-center">
        <a href="/condiment" class="inline-block bg-blue-500 text-white px-6 py-2 rounded-md hover:bg-blue-600 transition duration-200">Quay lại</a>
    </div>
</div>
</body>
</html>