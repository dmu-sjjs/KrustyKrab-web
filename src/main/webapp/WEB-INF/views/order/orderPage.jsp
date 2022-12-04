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
</main>
<div class="orderBtn">
    <button>주문하기</button>
</div>
<footer>
    <!-- footer -->
    <%@ include file="../footer.jsp"%>
    <!-- End footer -->
</footer>
</body>
<script>
    function selectMenuPage() {
        window.open('/order/select', 'window_name', 'width=800, height=600, scrollbars=yes');
    }
</script>
</html>


