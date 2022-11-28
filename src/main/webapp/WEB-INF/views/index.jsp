<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="resources/css/main/header.css">
    <link rel="stylesheet" href="resources/css/main/sns.css">
    <link rel="stylesheet" href="resources/css/main/header.css">
    <link rel="stylesheet" href="resources/css/main/youtube.css">
    <link rel="stylesheet" href="resources/css/footer.css">
    <link rel="shortcut icon" href="resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="resources/img/favicon.png" type="image/x-icon">
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
</body>
</html>