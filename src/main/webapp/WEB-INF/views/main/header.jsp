<%@ page import="js.krustykrab.dto.UserDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
    UserDto userDto = null;
    try{
        userDto = (UserDto)session.getAttribute("user");
    }catch(NullPointerException e){
        e.printStackTrace();
    }

    if (userDto == null) {
%>
<div id="member">
    <a class="taga" href="/user/login"><strong>로그인</strong></a>
</div>
<%
    }else {
        String name = userDto.getUsername();
        %>
        <div id=member>
            <a class="taga" href="/user/logout"><strong>로그아웃</strong></a>
        </div>
        <%
    }
%>
<ul id="menu">
    <a href="#"><img id="logoimg" width="80px" height="80px" src="/resources/img/logo.png" /></a>
    <div id="menubars">
        <li class="menutitle">메뉴소개▾
            <ul class="submenu">
                <li><a class="taga" href="#">할인</a></li>
                <li><a class="taga" href="#">신제품</a></li>
                <li><a class="taga" href="#">버거</a></li>
                <li><a class="taga" href="#">사이드</a></li>
                <li><a class="taga" href="#">음료&디저트</a></li>
            </ul>
        </li>

        <li class="menutitle">매장소개▾
            <ul class="submenu">
                <li><a class="taga" href="#">매장 찾기</a></li>
            </ul>
        </li>

        <li class="menutitle">이벤트▾
            <ul class="submenu">
                <li><a class="taga" href="#">이벤트</a></li>
            </ul>
        </li>

        <li class="menutitle">브랜드 스토리▾
            <ul class="submenu">
                <li><a class="taga" href="#">THE KRUSTY KRAB</a></li>
                <li><a class="taga" href="#">게살버거</a></li>
            </ul>
        </li>
    </div>
    <button id="deliverybtn"><strong>딜리버리 주문</strong></button>
</ul>