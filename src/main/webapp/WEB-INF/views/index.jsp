<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon">
    <title>The Krusty Krab</title>
    <%@include file="main/csslink.jsp" %>
</head>
<body>

    <header>
    <jsp:include page="main/header.jsp"/>
    </header>
    <div id="bg"></div>
    <jsp:include page="main/main.jsp"/>
    <footer>
    <jsp:include page="footer.jsp"/>
    </footer>
    <audio autoplay loop>
        <source src="/resources/audio/opening.mp3" type="audio/mp3">
    </audio>
</body>
</html>