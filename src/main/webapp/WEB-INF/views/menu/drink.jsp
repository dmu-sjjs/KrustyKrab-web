<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon">
    <%@include file="../main/csslink.jsp" %>
    <link rel="stylesheet" href="/resources/css/menu/burger.css">
    <title>The Krusty Krab</title>
</head>
<body>
<header>
    <jsp:include page="../main/header.jsp"/>
</header>
<div id="bg"></div>
<main class="menu_main">
    <h1>DRINK</h1>
    <table class="menu_table">
        <tr>
            <c:forEach var="m" items="${menus}" varStatus="status" >
            <c:if test="${status.index%5==0}">
        </tr><tr>
        </c:if>
        <td><img width="150" height="150" src="/resources/img/${m.menuType}/${m.menuName}.png">
            <br> ${m.menuName} <br>${m.price}<br>${m.menuDescription}</td>
        </c:forEach>
    </tr>
    </table>
</main>
<footer>
    <jsp:include page="../footer.jsp"/>
</footer>
<header>
    <%@include file="../main/header.jsp"%>
</header>
</body>
</html>