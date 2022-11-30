<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon">
    <title>The Krusty Krab</title>
</head>
<body>
<header>
    <h1>세일</h1>
    <form action="/" method="get">
        <input type="submit" value="홈으로">
    </form>
</header>
<main>
    <br>
    <table border="1">
        <c:forEach var="m" items="${menus}">
            <tr>
                <td>${m.menuName}</td>
                <td>${m.menuDescription}</td>
                <td>${m.price}</td>
                <td>${m.saleRate}</td>
            </tr>
        </c:forEach>
    </table>
</main>
<footer>
</footer>
</body>
</html>