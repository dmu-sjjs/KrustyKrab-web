<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="shortcut icon" href="/resources/img/favicon.png" type="image/x-icon">
    <link rel="icon" href="/resources/img/favicon.png" type="image/x-icon">
    <title>ADMIN</title>
</head>
<body>
<header>
    <h1>관리자 페이지</h1>
    <form action="/" method="get">
        <input type="submit" value="홈으로">
    </form>
</header>
<main>
    <br>
    <h2>유저 목록</h2>
    <table border="1">
        <thead>
            <tr>
                <th>userId</th>
                <th>ID</th>
                <th>PW</th>
                <th>AUTHORITY</th>
                <th>USERNAME</th>
                <th>ADDRESS</th>
                <th>DETAIL_ADDRESS</th>
                <th>PHONE_NUMBER</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach var="u" items="${users}">
            <tr>
                <td>${u.userId}</td>
                <td>${u.id}</td>
                <td>${u.pw}</td>
                <td>${u.authority}</td>
                <td>${u.username}</td>
                <td>${u.address}</td>
                <td>${u.detailAddress}</td>
                <td>${u.phoneNumber}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <h2>주문 정보</h2>
    <table border="1">
        <thead>
        <tr>
            <th>orderId</th>
            <th>주문자ID</th>
            <th>매장번호</th>
            <th>주소</th>
            <th>상세주소</th>
            <th>주문일시</th>
            <th>배달완료여부</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="o" items="${orders}">
            <tr>
                <td>${o.orderId}</td>
                <td>${o.userId}</td>
                <td>${o.storeId}</td>
                <td>${o.address}</td>
                <td>${o.detailAddress}</td>
                <td>${o.orderDate}</td>
                <td>${o.isCompleted}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</main>
<footer>
</footer>
</body>
</html>