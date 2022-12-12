<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon">
    <title>ADMIN</title>
</head>
<body>
<header>
    <h1>마이페이지</h1>
    <form action="/" method="get">
        <input type="submit" value="홈으로">
    </form>
</header>
<main>
    <br>
    <input value="${u.id}" readonly>
    <form action="/user/mypage/change/username" method="post">
        <input type="text" value="${u.username}">
        <input type="submit" value="변경">
    </form>
    <form action="/user/mypage/change/address" method="post">
        <input type="text" value="${u.address}">
        <input type="submit" value="변경">
    </form>
    <form action="/user/mypage/change/detailAddress" method="post">
        <input type="text" value="${u.detailAddress}">
        <input type="submit" value="변경">
    </form>
</main>
<footer>
</footer>
</body>
</html>