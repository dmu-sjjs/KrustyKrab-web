<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.3/css/font-awesome.min.css">

    <%@include file="../login/csslink.jsp" %>
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
    <span>주문</span>
    <button id="checkOrder" onclick="menuList()">주문목록 확인</button>
    <br>
    <button class="orderPageBtn" onclick="selectMenuPage()">메뉴 선택</button>
    <button class="orderPageBtn" onclick="goHandMadePage()" >수제버거 선택</button>
    <table class="menu_table">
        <tr>
            <c:forEach var="m" items="${menus}" varStatus="status">
            <c:if test="${status.index%5==0}">
        </tr>
        <tr>
            </c:if>
            <td align="center" class="menuList" id="${m.menuId}">
                <img width="150" height="150" src="/resources/img/${m.menuType}/${m.menuName}.png">
                <br>${m.menuName} <br>${m.price} ￦<br>${m.menuDescription}</td>
            </c:forEach>
        </tr>
    </table>
</main>
<%--주문하기 버튼 폼태그 input<name=storeId>로 받아와야함 주문하기: submit--%>
<div class="lastOrderBtn">
    <form method="post" action="/order">
        <input type="hidden" name="storeId" value="${storeId}">
        <input type="submit" value="주문하기">
    </form>
</div>
<footer>
    <!-- footer -->
    <%@ include file="../footer.jsp" %>
    <!-- End footer -->
</footer>
</body>
<script>
    let storeNum = window.location.href.split('/');
    storeNum = storeNum[storeNum.length - 1];

    function selectMenuPage() {
        window.open('/order/select/' + storeNum, 'window_name', 'width=800, height=600, scrollbars=yes');
        console.log('메뉴창 열림');
    }

    function menuList() {
        window.open('/order/' + storeNum + '/checkMenu', 'window_name', 'width=700, height=600, scrollbars=yes');
    }

    function goHandMadePage() {
        window.open('/order/handmade/' + storeNum, 'window_name', 'width=800, height=600, scrollbars=yes');

    }


</script>
</html>


