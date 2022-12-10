<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<title>ORDER SUCCESS</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/resources/css/order/orderSuccess.css">
<script>
    alert('주문되었습니다!');
</script>
<c:set var="orderSum" value="0"/>
<br><h1>주문 목록</h1><br>
<table width="1000px" align="center">
    <thead align="center">
    <tr>
        <th>메뉴목록</th>
        <th>메뉴이름</th>
        <th>주문수량</th>
        <th>가격</th>
    </tr>
    </thead>
    <tbody align="center">
    <c:forEach var="i" items="${cartItems}">
        <tr>
            <td><img width="150px" height="150px" src="/resources/img/${i.menuType}/${i.menuName}.png"></td>
            <td>${i.menuName}</td>
            <td>${i.count}</td>
            <td>${i.price * i.count}</td>
            <c:set var="orderSum" value="${orderSum + (i.price * i.count)}" />
        </tr>

    </c:forEach>
    </tbody>
</table>

<br><br><h1>결제금액: <c:out value="${orderSum}" /> ￦</h1>
<button id="goHome" onclick="location.href='/'" >돌아가기</button><br><br>
