<%@ page import="js.krustykrab.domain.cart.Cart" %>
<%@ page import="js.krustykrab.domain.cart.CartItem" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<link rel="stylesheet" href="/resources/css/order/checkMenu.css">
<div id="menuList">
<h1>주문 목록</h1>
<table border id="listTable" >
    <thead>
    <tr align="center">
        <td>사진</td>
        <td>메뉴아이디</td>
        <td>개수</td>
        <td>메뉴 이름</td>
        <td>총 가격</td>
        <td>메뉴 삭제</td>
    </tr>
    </thead>
    <%
        Cart cart = (Cart) session.getAttribute("cart");
        List<CartItem> items = cart.getItems();

        for(CartItem item : items){
    %>
    <tr align="center">
        <td><img width="150" height="150" src="/resources/img/<%=item.getMenuType()%>/<%=item.getMenuName()%>.png"></td>
        <td><span><%=item.getMenuId()%></span></td>
        <td><span><%=item.getCount()%></span></td>
        <td><span><%=item.getMenuName()%></span></td>
        <td><span><%=item.getPrice()*item.getCount()%>원</span></td>
        <td>
                <span>
                <form method="post" action="/order/${storeId}/removeItem">
                    <input type="hidden" name="menuId" value="<%=item.getMenuId()%>">
                    <input type="submit" value="메뉴삭제">
                </form>
            </span>
        </td>
    </tr>

    <%
        }
    %>
</table>
</div>