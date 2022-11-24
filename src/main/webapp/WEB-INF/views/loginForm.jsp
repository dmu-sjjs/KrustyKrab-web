<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="resources/img/favicon.png" type="image/x-icon">

    <link rel="stylesheet" href="resources/css/footer.css" />
    <link rel="stylesheet" href="resources/css/login/loginHeader.css" />
    <link rel="stylesheet" href="resources/css/login/loginMain.css"/>
    <title>The Krusty Krab</title>
</head>
<body>
<header class="loginTop">
    <div class="loginHeader">
        <a href="#"><strong>브랜드홈</strong></a> |
        <a href="#"><strong>로그인</strong></a> |
        <a href="#"><srong>고객센터</srong></a>
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
    <a href="#"><strong>홈</strong></a> >
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
                <input id="saveid" type="checkbox"> 아이디 저장
                <input id="autologin" type="checkbox"> 자동 로그인 <br>
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
    <div id="ftop">
        <a class="ftaga" href="#">이용약관</a> |
        <a class="ftaga" href="#">개인정보처리방침</a> |
        <a class="ftaga" href="#">법적고지</a>
    </div>
    <div id="fmain">
        <h1>Krusty Krab</h1><br>
        <h6>서울특별시 고척동 경인로445</h6>
        <h6><a class="ftaga" href="#">http://wwww.dongyang.ac.kr/</a></h6>
        <h6>사업자 등록번호 02-2610-1700 | (주) 승준재석</h6>
    </div>
    <div id="service">
        <button id="servicecenterbtn">고객센터</button>
    </div>
    <!-- End footer -->
</footer>
</body>
</html>