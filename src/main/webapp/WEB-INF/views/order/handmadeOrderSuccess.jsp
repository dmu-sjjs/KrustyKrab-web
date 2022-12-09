<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/resources/css/order/handmadeSuccess.css"/>
<c:set var="orderSum" value="4000"/>

<style>
    img {
        display: none;
    }
</style>
<script src="//code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
    $( document ).ready( function() {
        $( 'img' ).fadeIn( 2000 );
    } );
</script>
<div id="handmadeTitle" >
    <br><h1 id="handmadeText">주문 완료! <strong>감사합니다!</strong></h1><br>
    <h2>당신의 버거를 맛있게 조리중입니다!</h2>
</div>
<div id="handmadeSuccessPage">

    <div id="burgerImg">
        <img width="400" height="100" src="/resources/img/handmade/BUNTOP.png"><br>
        <img width="400" height="100" src="/resources/img/handmade/BEEF.png"><br>

        <c:forEach var="i" items="${ingredients}" varStatus="vs">
            <td>
                <img id="img${vs.index}" width="400" height="100" src="/resources/img/handmade/${i.name()}.png"><br>
                <c:set var="orderSum" value="${orderSum + i.price}" />
            </td>
        </c:forEach>
        <img width="400" height="100" src="/resources/img/handmade/BUNBOTTOM.png"><br>
    </div>
    <h2>결제금액: <c:out value="${orderSum}" /> ￦</h2>
    <button id="exitPageBtn" onclick="window.close()">나가기</button>
</div>

