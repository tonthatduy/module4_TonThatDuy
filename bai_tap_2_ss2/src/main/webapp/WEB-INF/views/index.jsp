<%--
  Created by IntelliJ IDEA.
  User: ACER
  Date: 18/06/2025
  Time: 2:41 CH
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Calculator</title>
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">
<div class="bg-white p-8 rounded-lg shadow-lg max-w-md w-full">
    <h1 class="text-2xl font-bold text-gray-800 mb-6 text-center">Calculator</h1>
    <form action="calculator" method="post">
        <fieldset>
            <legend class="text-lg font-semibold text-gray-700 mb-4 text-center">Máy Tính</legend>
            <div class="flex space-x-4 mb-4">
                <input type="number" name="num1" class="w-full p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="Số thứ nhất" required>
                <input type="number" name="num2" class="w-full p-2 border border-gray-300 rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500" placeholder="Số thứ hai" required>
            </div>
            <div class="grid grid-cols-2 gap-4">
                <input type="submit" name="cal" value="Addition(+)" class="bg-blue-500 text-white p-2 rounded-md hover:bg-blue-600 transition duration-200 cursor-pointer">
                <input type="submit" name="cal" value="Subtraction(-)" class="bg-blue-500 text-white p-2 rounded-md hover:bg-blue-600 transition duration-200 cursor-pointer">
                <input type="submit" name="cal" value="Multiplication(x)" class="bg-blue-500 text-white p-2 rounded-md hover:bg-blue-600 transition duration-200 cursor-pointer">
                <input type="submit" name="cal" value="Division(/)" class="bg-blue-500 text-white p-2 rounded-md hover:bg-blue-600 transition duration-200 cursor-pointer">
            </div>
        </fieldset>
    </form>
    <c:if test="${result != null || mess != null}">
        <div class="mt-6 text-center">
            <h1 class="text-xl font-semibold text-red-600">${result}</h1>
            <h1 class="text-xl font-semibold text-red-600">${mess}</h1>
        </div>
    </c:if>
</div>
</body>
</html>