<%@ page import="js.krustykrab.domain.cart.Cart" %>
<%@ page import="js.krustykrab.domain.cart.CartItem" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<%
    Cart cart = (Cart) session.getAttribute("cart");
    List<CartItem> items = cart.getItems();
    
    for(CartItem item : items) {
        out.print(item.getMenuId());
        out.print(item.getCount());
        out.print("<br>");
    }
%>