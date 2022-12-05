<%@ page import="js.krustykrab.domain.cart.Cart"%>
<%@ page import="js.krustykrab.domain.cart.CartItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">

    <%@include file="../login/csslink.jsp"%>
    <link rel="stylesheet" href="/resources/css/order/order.css">
    <title>The Krusty Krab</title>
</head>
<body>
<%@include file="../login/loginHeader.jsp" %>
<div class="dummy"></div>
<div class="path">
    <a href="/">홈</a> >
    <a href="#"><strong>딜리버리</strong></a>
</div>
<main class="orderMain">
    <h1>주문</h1>
    <button onclick="selectMenuPage()" >메뉴 선택</button>
    <button>수제버거 선택</button>
    <button onclick="menuList()" >주문목록</button>
</main>
<%--주문하기 버튼 폼태그 input<name=storeId>로 받아와야함 주문하기: submit--%>
<div class="orderBtn">
    <form method="post" action="/order" >
        <input type="hidden" name="storeId" value="${storeId}">
        <input type="submit" value="주문하기">
    </form>
</div>
<footer>
    <!-- footer -->
    <%@ include file="../footer.jsp"%>
    <!-- End footer -->
</footer>
</body>
<script>
    let storeNum = window.location.href.split('/');
    storeNum = storeNum[storeNum.length-1];

    function selectMenuPage() {
        window.open('/order/select/'+ storeNum , 'window_name', 'width=800, height=600, scrollbars=yes');
        console.log('메뉴창 열림');
    }
    function menuList() {
        window.open('/order/'+ storeNum +'/checkMenu' , 'window_name', 'width=800, height=600, scrollbars=yes');
    }


</script>
</html>


