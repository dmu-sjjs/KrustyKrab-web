<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

주문완료 페이지 <br>
명세서 <br>
홈으로 버튼<br>
<h1>당신의 버거가 맛있게 조리중입니다!</h1>
<img width="400" height="100" src="/resources/img/handmade/BUNTOP.png"><br>
<c:forEach var="v" items="${ingredients}">
    <td>
        <img width="400" height="100" src="/resources/img/handmade/${v.name()}.png"><br>
    </td>
</c:forEach>
<img width="400" height="100" src="/resources/img/handmade/BUNBOTTOM.png"><br>