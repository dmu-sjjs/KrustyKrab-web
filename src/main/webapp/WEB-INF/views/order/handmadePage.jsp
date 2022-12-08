<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/resources/css/order/handMadePage.css">
<div id="handMadePage">
    <div>
        <br>
        <h1><img width="100" height="100" src="/resources/img/burger/게살버거.png">수제버거 만들기</h1><br>
    </div>
    <div>
        <form method="post">
            <div id="vegDiv">
                <label for="vegetable1">야채선택1</label>
                <select id="vegetable1" name="vegetable1">
                    <option value="NONE">선택안함</option>
                    <option value="TOMATO">토마토</option>
                    <option value="ONION">양파</option>
                    <option value="LETTUCE">상추</option>
                </select>
                <label for="vegetable2">야채선택2</label>
                <select id="vegetable2" name="vegetable2">
                    <option value="NONE">선택안함</option>
                    <option value="TOMATO">토마토</option>
                    <option value="ONION">양파</option>
                    <option value="LETTUCE">상추</option>
                </select>
                <label for="vegetable3">야채선택3</label>
                <select id="vegetable3" name="vegetable3">
                    <option value="NONE">선택안함</option>
                    <option value="TOMATO">토마토</option>
                    <option value="ONION">양파</option>
                    <option value="LETTUCE">상추</option>
                </select>
                <br>
                <table>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                </table>
            </div>
            <br><br>
            <div id="patDiv">
                <label for="patty1">패티선택1</label>
                <select id="patty1" name="patty1">
                    <option value="NONE">선택안함</option>
                    <option value="HAM">햄</option>
                    <option value="CHICKEN">치킨</option>
                    <option value="BEEF">소고기</option>
                </select>
                <label for="patty2">패티선택2</label>
                <select id="patty2" name="patty2">
                    <option value="NONE">선택안함</option>
                    <option value="HAM">햄</option>
                    <option value="CHICKEN">치킨</option>
                    <option value="BEEF">소고기</option>
                </select>
                <br>
                <table>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                </table>
            </div>
            <br><br>
            <div id="toppDiv">
                <label for="topping1">토핑선택1</label>
                <select id="topping1" name="topping1">
                    <option value="NONE">선택안함</option>
                    <option value="PICKLE">피클</option>
                    <option value="GARLIC">갈릭</option>
                    <option value="EGGFRY">계란후라이</option>
                </select>
                <label for="topping2">토핑선택2</label>
                <select id="topping2" name="topping2">
                    <option value="NONE">선택안함</option>
                    <option value="PICKLE">피클</option>
                    <option value="GARLIC">갈릭</option>
                    <option value="EGGFRY">계란후라이</option>
                </select>
                <label for="topping3">토핑선택3</label>
                <select id="topping3" name="topping3">
                    <option value="NONE">선택안함</option>
                    <option value="PICKLE">피클</option>
                    <option value="GARLIC">갈릭</option>
                    <option value="EGGFRY">계란후라이</option>
                </select>
                <br>
                <table>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                </table>
            </div>
            <br><br>
            <div id="sourceDiv">
                <label for="source1">소스선택1</label>
                <select id="source1" name="source1">
                    <option value="NONE">선택안함</option>
                    <option value="BBQ">BBQ 소스</option>
                    <option value="CHILI">칠리 소스</option>
                    <option value="RANCH">랜치 소스</option>
                </select>
                <label for="source2">소스선택2</label>
                <select id="source2" name="source2">
                    <option value="NONE">선택안함</option>
                    <option value="BBQ">BBQ 소스</option>
                    <option value="CHILI">칠리 소스</option>
                    <option value="RANCH">랜치 소스</option>
                </select>
                <br>
                <table>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                    <tr><img src="/resources/img/handmade/TOMATO.png"></tr>
                </table>
            </div>
            <br><br>
            <input type="submit" id="handMadeComplete" value="선택완료">
        </form>
    </div>
</div>
model에 storeId 들어있음

재료 삽입하는곳 <br>
주문버튼 (요청: post방식 , order/handmade/{storeId} / 데이터 : HandmadeBurgerDto 에 있는 애들 다 )
안쓰는 재료는 value=None 으로