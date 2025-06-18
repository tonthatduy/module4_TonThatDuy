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
    <script src="https://cdn.tailwindcss.com"></script>
</head>
<body class="bg-gray-100 min-h-screen flex items-center justify-center">
<div class="bg-white p-8 rounded-lg shadow-lg max-w-md w-full">
    <form action="/save" method="post">
        <fieldset>
            <legend class="text-2xl font-bold text-gray-800 mb-6 text-center">Sandwich Condiments</legend>
            <div class="space-y-4">
                <label class="flex items-center">
                    <input type="checkbox" name="condiment" value="lettuce" class="h-5 w-5 text-blue-500">
                    <span class="ml-2 text-gray-700">Lettuce</span>
                </label>
                <label class="flex items-center">
                    <input type="checkbox" name="condiment" value="tomato" class="h-5 w-5 text-blue-500">
                    <span class="ml-2 text-gray-700">Tomato</span>
                </label>
                <label class="flex items-center">
                    <input type="checkbox" name="condiment" value="mustard" class="h-5 w-5 text-blue-500">
                    <span class="ml-2 text-gray-700">Mustard</span>
                </label>
                <label class="flex items-center">
                    <input type="checkbox" name="condiment" value="sprouts" class="h-5 w-5 text-blue-500">
                    <span class="ml-2 text-gray-700">Sprouts</span>
                </label>
            </div>
            <div class="mt-6 text-center">
                <input type="submit" value="Save" class="bg-blue-500 text-white px-6 py-2 rounded-md hover:bg-blue-600 transition duration-200 cursor-pointer">
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>