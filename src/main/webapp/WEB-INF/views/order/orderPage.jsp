<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">

    <%@include file="../login/csslink.jsp"%>
    <title>The Krusty Krab</title>
</head>
<body>
<%@include file="../login/loginHeader.jsp" %>
<div class="dummy"></div>
<div class="path">
    <a href="/">홈</a> >
    <a href="#"><strong>로그인</strong></a>
</div>
<main class="loginMain">

</main>
<footer>
    <!-- footer -->
    <%@ include file="../footer.jsp"%>
    <!-- End footer -->
</footer>
<script src="/resources/js/autoHypenPhoneNumber.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/address.js"></script>
<script src="https://kit.fontawesome.com/32e5e610fe.js" crossorigin="anonymous"></script>
<script src="/resources/js/overlapCheck.js"></script>

</body>

</html>


