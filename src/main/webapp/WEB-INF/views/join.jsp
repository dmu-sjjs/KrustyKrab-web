<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">

    <%@include file="login/csslink.jsp"%>
    <title>The Krusty Krab</title>
</head>
<body>
<%@include file="login/loginHeader.jsp" %>
<div class="dummy"></div>
<div class="path">
    <a href="/">홈</a> >
    <a href="#"><strong>로그인</strong></a>
</div>
<main class="loginMain">
    <div class="maintext">
        <h1 id="firstline">YOUR WAY</h1>
        <h1 id="secondline">어서오세요 집게리아입니다!</h1>
    </div>
    <div class="mainInput">
        <div class="normal_login">
            <h2>일반 회원가입</h2>
            <form class="joinForm" action="/user/join" method="post" >
                아이디<br>
                <input required id="joinId" type="text" name="id" placeholder="ID" ><a id="overlap">중복확인</a><br>

                비밀번호<br>
                <input required type="text" name="pw" placeholder="Password" ><br>

                이름<br>
                <input required type="text" name="username" placeholder="홍길동"><br>

                주소<br>
                <input type="text" id="sample4_postcode" placeholder="우편번호">
                <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 찾기"><br>
                <input type="text" id="sample4_roadAddress" placeholder="도로명주소">
                <input type="text" id="sample4_jibunAddress" placeholder="지번주소">
                <span id="guide" style="color:#999;display:none"></span>
                <input type="text" id="sample4_detailAddress" placeholder="상세주소">
                <input type="text" id="sample4_extraAddress" placeholder="참고항목"><br>

                전화번호<br>
                <input maxlength="12" required id="phoneNum" type="text" name="phoneNumber" placeholder="010-0000-0000" >

                <input id="joinSubmit" type="submit" value="가입하기">
            </form>
        </div>
        <div class="social_login">
            <h2>간편 회원가입</h2>
            내용 넣어야 함.
        </div>
    </div>
</main>
<footer>
    <!-- footer -->
    <%@ include file="footer.jsp"%>
    <!-- End footer -->
</footer>
<script src="/resources/js/autoHypenPhoneNumber.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/address.js"></script>
<script src="https://kit.fontawesome.com/32e5e610fe.js" crossorigin="anonymous"></script>
<script src="/resources/js/overlapCheck.js"></script>
</body>

</html>


