<%@ page import="js.krustykrab.domain.handmadeBurger.BurgerIngredient" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/resources/css/order/handMadePage.css">
<div id="handMadePage">
    <div>
        <br>
        <h1><img width="100" height="100" src="/resources/img/burger/게살버거.png">수제버거 만들기</h1><br>
        <p>
            ※ 프리미엄 수제버거는 한 건의 주문당 한개의 제작만 가능하며
            기본 가격 4000원에 토핑에 따라 추가금이 붙습니다.
        </p>
    </div>
    <div>
        <form method="post" action="/order/handmade/orderSuccess">
            <div id="vegDiv">
                <label for="vegetable1">야채선택1</label>
                <select id="vegetable1" name="vegetable1">
                    <option value="NONE">선택안함</option>
                    <option value="TOMATO">토마토</option>
                    <option value="ONION">양파</option>
                    <option value="LETTUCE">양상추</option>
                </select>
                <label for="vegetable2">야채선택2</label>
                <select id="vegetable2" name="vegetable2">
                    <option value="NONE">선택안함</option>
                    <option value="TOMATO">토마토</option>
                    <option value="ONION">양파</option>
                    <option value="LETTUCE">양상추</option>
                </select>
                <label for="vegetable3">야채선택3</label>
                <select id="vegetable3" name="vegetable3">
                    <option value="NONE">선택안함</option>
                    <option value="TOMATO">토마토</option>
                    <option value="ONION">양파</option>
                    <option value="LETTUCE">양상추</option>
                </select>
                <br>
                <div>
                    <table id="vegtTable" class="h_table">
                    <c:forEach var="v" items="${vegetables}">
                        <td>
                            <img width="100" height="100" src="/resources/img/handmade/${v.name()}.png"><br>
                            <strong>${v.name()}</strong><br>
                            가격 : ${v.getPrice()} ￦
                        </td>
                    </c:forEach>
                    </table>
                </div>
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
                <div>
                    <table id="pattTable" class="h_table">
                    <c:forEach var="p" items="${pattys}">
                        <td>
                            <img width="100" height="100" src="/resources/img/handmade/${p.name()}.png"><br>
                            <strong>${p.name()}</strong><br>
                            가격 : ${p.getPrice()} ￦
                        </td>
                    </c:forEach>
                    </table>
                </div>
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
                <div>
                    <table id="toppTable" class="h_table">
                    <c:forEach var="t" items="${toppings}">
                            <td>
                                <img width="100" height="100" src="/resources/img/handmade/${t.name()}.png"><br>
                                <strong>${t.name()}</strong><br>
                                가격 : ${t.getPrice()} ￦
                            </td>
                    </c:forEach>
                    </table>
                </div>
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
                <table id="sourTable" class="h_table">
                <c:forEach var="s" items="${sources}">
                        <td>
                            <img width="100" height="100" src="/resources/img/handmade/${s.name()}.png"><br>
                            <strong>${s.name()}</strong><br>
                            가격 : ${s.getPrice()} ￦
                        </td>
                </c:forEach>
                </table>
            </div>
            <br><br>
            <input type="submit" id="handMadeComplete" value="선택완료">
        </form>
    </div>
</div>