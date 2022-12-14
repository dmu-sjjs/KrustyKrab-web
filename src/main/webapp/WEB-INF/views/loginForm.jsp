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
    <script src="https://kit.fontawesome.com/32e5e610fe.js" crossorigin="anonymous"></script>

    <%@include file="login/csslink.jsp"%>
    <title>LOGIN</title>
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
                <input id="pw" type="password" placeholder="비밀번호" name="pw" value="<%= pw %>"/> <i class="fa-solid fa-eye"></i><br>
                <input id="saveid" type="checkbox" name="saveIdPw" <%= saveIdPw%>/> ID/PW 저장<br>
                <input id="loginbtn" type="submit" value="로그인" />
            </form>
            <a href="/user/join">회원가입</a>
        </div>
        <div class="social_login">
            <h2>간편 로그인</h2>
            <%--//내용 넣어야 함.--%>
        </div>
    </div>
</main>
<footer>
    <!-- footer -->
    <%@ include file="footer.jsp"%>
    <!-- End footer -->
</footer>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
    $(document).ready(function(){
        $('#loginForm i').on('click',function(){
            $('#pw').toggleClass('active');
            if($('#pw').hasClass('active')){
                $(this).attr('class',"fa-sharp fa-solid fa-eye-slash")
                    .prev('input').attr('type',"text");
            }else{
                $(this).attr('class',"fa-solid fa-eye")
                    .prev('input').attr('type','password');
            }
        });
    });
</script>
</body>
</html>