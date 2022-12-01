<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon">
    <title>The Krusty Krab</title>
    <%@include file="main/csslink.jsp" %>
    <link rel="stylesheet" href="/resources/css/menu/store.css">
</head>
<body>
<header>
    <jsp:include page="main/header.jsp"/>
</header>
<div id="bg"></div>
<main style=" width:1440px; height: 900px; margin: 0 auto;">
    <div id="map" style="width:100%;height:100%; margin: 0 auto;"></div>
</main>
<footer>
    <jsp:include page="footer.jsp"/>
</footer>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=bb5a8f867f43c670b360f3bff1cf1359"></script>
<script src="/resources/js/store.js"></script>
</body>
</html>