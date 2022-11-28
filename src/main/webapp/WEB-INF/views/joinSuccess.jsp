<%@ page import="js.krustykrab.dto.user.UserDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="../../../resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="../../../resources/img/favicon.png" type="image/x-icon">
    <title>The Krusty Krab</title>
</head>
<body>
<header>
    <%
        UserDto user = (UserDto) session.getAttribute("joinedUser");
        out.println(user.getUsername() + "님, 가입을 환영합니다!");
        session.removeAttribute("joinedUser");
    %>
</header>
<main>

</main>
<footer>
</footer>
</body>
</html>