<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String id = (String) session.getAttribute("id");
    String pw = (String) session.getAttribute("pw");
    String saveIdPw = (String) session.getAttribute("saveIdPw");
    if(id == null & pw == null) {
        id = "";
        pw = "";
    }
    if(saveIdPw == null) {
        saveIdPw = "";
    }
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon">

    <%@include file="login/csslink.jsp"%>
    <title>The Krusty Krab</title>
</head>
<body>
<%@include file="login/loginHeader.jsp"%>
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
            <h2>일반 로그인</h2>
            <form id="loginForm" action="login" method="post">
                <input id="id" type="text" placeholder="아이디" name="id" value="<%= id %>"/><br>
                <input id="pw" type="password" placeholder="비밀번호" name="pw" value="<%= pw %>"/><br>
                <input id="saveid" type="checkbox" name="saveIdPw" <%= saveIdPw%>/> ID/PW 저장
                <input id="loginbtn" type="submit" value="로그인" />
            </form>
            <a href="/user/join">회원가입</a>
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