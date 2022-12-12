<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/user/myPage.css" >
    <link rel="stylesheet" href="/resources/css/main/header.css" >
    <link rel="stylesheet" href="/resources/css/main/login.css" >
    <link rel="stylesheet" href="/resources/css/footer.css" >
    <title>ADMIN</title>
</head>
<body>
<header>
    <jsp:include page="../main/header.jsp"/>
</header>
<div id="bg"></div>
<main>
    <h1>마이페이지</h1>
    <h2>${user.username} 님, 환영합니다!</h2>
    <form action="/user/mypage/change" method="post" >
        <input type="hidden" name="userId" value="${user.userId}" />
        <input id="idDuplicationChecking" type="hidden" value="0" name="idDuplicationCheck" /><br>

        이름<br>
        <input required type="text" name="username" value="${user.username}" /><br>
        주소<br>
        <input readonly required type="hidden" id="sample4_postcode" placeholder="우편번호">
        <input type="button" onclick="sample4_execDaumPostcode()" value="우편번호 변경"><br>
        <input readonly required type="text" id="sample4_roadAddress" value="${user.address}" name="address">
        <input readonly type="hidden" id="sample4_jibunAddress" placeholder="지번주소">
        <span id="guide" style="color:#999;display:none"></span>
        <input required type="text" id="sample4_detailAddress" value="${user.detailAddress}" name="detailAddress">
        <input type="hidden" id="sample4_extraAddress" placeholder="참고항목"><br>
        전화번호<br>
        <input maxlength="13" required id="phoneNum" type="text" name="phoneNumber" value="${user.phoneNumber}" /><br>
        <input id="changeSubmit" type="submit" value="변경하기" />
        <button id="goHome" onclick="goHome()">홈으로</button>
    </form>
</main>
<footer>
    <%@include file="../footer.jsp"%>
</footer>
<script src="/resources/js/autoHypenPhoneNumber.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="/resources/js/address.js"></script>
<script src="https://kit.fontawesome.com/32e5e610fe.js" crossorigin="anonymous"></script>
<script src="/resources/js/overlapCheck.js"></script>
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
<script>
    $(document).ready(function(){
        $('.joinForm i').on('click',function(){
            $('#password').toggleClass('active');
            if($('#password').hasClass('active')){
                $(this).attr('class',"fa-sharp fa-solid fa-eye-slash")
                    .prev('input').attr('type',"text");
            }else{
                $(this).attr('class',"fa-solid fa-eye")
                    .prev('input').attr('type','password');
            }
        });
    });

    function goHome() {
        if(confirm('페이지를 벗어나면 변경사항이 적용되지않습니다. 정말 나가시겠습니까?')){
            location.href='/'
        }
    }
</script>
</body>
</html>