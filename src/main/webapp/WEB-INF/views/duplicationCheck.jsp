<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    Boolean isDuplicate = true;

    if (request.getAttribute("isDuplicate") != null && (boolean) request.getAttribute("isDuplicate") == false) {
        isDuplicate = false;
    }
%>

<h1>중복체크</h1>

<%
    if (isDuplicate) {
%>
<form action="idDuplicationCheck" method="post">
    <input type="text" name="id">
    <input type="submit" value="확인">
</form>
<%
    } else {
        out.print("중복이 아닙니다.");
        // 여기 닫기 버튼 추가하면 될 듯?
    }
%>