<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
model에 storeId 들어있음

재료 삽입하는곳 <br>
주문버튼 (요청: post방식 , order/handmade/{storeId} / 데이터 : HandmadeBurgerDto 에 있는 애들 다 )
안쓰는 재료는 value=None 으로