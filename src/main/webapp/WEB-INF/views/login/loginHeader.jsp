<%@ page import="js.krustykrab.dto.UserDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>



<%
    UserDto userDto = null;
    try{
        userDto = (UserDto)session.getAttribute("user");
    }catch(NullPointerException e){
        e.printStackTrace();
    }

    if (userDto == null) {
%>
<header class="loginTop">
    <div class="loginHeader">
        <a href="#"><strong>로그인</strong></a> |
    </div>
    <div class="loginLogo">
        <a href="/"><img class="loginLogoImg" width="80px" height="80px" src="/resources/img/logo.png" /><h1 class="loginLogoText" ><strong>The Krusty Krab</strong></h1></a>
    </div>
    <div class="signUp">
        <a href="/user/join"><strong>회원가입</strong></a>
    </div>
</header>
<%
}else {
    String name = userDto.getUsername();
%>
<header class="loginTop">
    <div class="loginHeader">
        <a href="#"><strong>로그아웃</strong></a> |
    </div>
    <div class="loginLogo">
        <a href="/"><img class="loginLogoImg" width="80px" height="80px" src="/resources/img/logo.png" /><h1 class="loginLogoText" ><strong>The Krusty Krab</strong></h1></a>
    </div>
</header>
<%
    }
%>