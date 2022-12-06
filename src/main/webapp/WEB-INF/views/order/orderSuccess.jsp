<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="js.krustykrab.domain.cart.Cart" %>
<%@ page import="js.krustykrab.domain.cart.CartItem" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<script>
    alert('주문되었습니다!');
</script>

<table border="1">
    <thead>
    <tr>
        <th><h1>메뉴목록</h1></th>
        <th>메뉴이름</th>
        <th>주문수량</th>
        <th>가격</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="i" items="${cartItems}">
        <tr>
            <td><img width="150px" height="150px" src="/resources/img/${i.menuType}/${i.menuName}.png" ></td>
            <td>${i.menuName}</td>
            <td>${i.count}</td>
            <td>${i.price * i.count}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<button>홈으로</button>
