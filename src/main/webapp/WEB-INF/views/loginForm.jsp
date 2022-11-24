<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="resources/img/favicon.png" type="image/x-icon">

    <%@include file="login/csslink.jsp"%>
    <title>The Krusty Krab</title>
</head>
<body>
<header class="loginTop">
    <div class="loginHeader">
        <a href="#"><strong>브랜드홈</strong></a> |
        <a href="#"><strong>로그인</strong></a> |
        <a href="#"><strong>고객센터</strong></a>
    </div>
    <div class="loginLogo">
        <a href="#"><img id="loginLogoImg" width="80px" height="80px" src="resources/img/logo.png" /><h1 id="loginLogoText" ><strong>The Krusty Krab</strong></h1></a>
    </div>
    <div class="signUp">
        <a href="#"><strong>회원가입</strong></a>
    </div>
</header>
<div class="dummy"></div>
<div class="path">
    <a href="#">홈</a> >
    <a href="#"><strong>로그인</strong></a>
</div>
<main class="loginMain">
    <div class="maintext">
        <h1 id="firstline">YOUR WAY</h1>
        <h1 id="secondline">어서오세요 집게리아입니다!</h1>
    </div>
    <div class="loginform">
        <div class="normal_login">
            <h2>일반 로그인</h2>
            <form>
                <input id="id" type="text" placeholder="아이디" /><br>
                <input id="pw" type="password" placeholder="비밀번호" /><br>
                <input id="adminlogin" type="checkbox" /> 관리자 로그인
                <input id="saveid" type="checkbox" /> 아이디 저장
                <input id="autologin" type="checkbox" /> 자동 로그인 <br>
                <input id="loginbtn" type="submit" value="로그인" />
            </form>
            <a href="#">회원가입</a>
        </div>
        <div class="social_login">
            <h2>간편 로그인</h2>
            내용 넣어야 함.
        </div>
    </div>
</main>
<footer>
    <!-- footer -->
    <%@ include file="footer.jsp"%>
    <!-- End footer -->
</footer>
</body>
</html>