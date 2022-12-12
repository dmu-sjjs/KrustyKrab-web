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
        <div id="mem">
            <div class="lg">
                <a class="taga" href="/user/login">로그인</a>
            </div>
        </div>
    </div>
<%
    }else {
        String name = userDto.getUsername();
        %>
        <div id=member>
            <div id="mem">
                <div class="lg">
                    <a class="taga" href="/user/logout">로그아웃</a>
                    <%
                        if(userDto.getAuthority().equals("ADMIN")){
                    %>
                </div>
                <div class="lg">
                            <a class="taga" href="/admin/main">관리자 페이지</a>
                    <%
                    } else if(userDto.getAuthority().equals("USER")) {
                    %>
                </div>
                <div class="lg">
                        <a class="taga" href="/user/mypage">마이페이지</a>
                    <%
                        }
                    %>
                </div>
            </div>
        </div>
        <%
    }
%>
<ul id="menu">
    <a href="/"><img id="logoimg" width="80px" height="80px" src="/resources/img/logo.png" /></a>
    <div id="menubars">
        <li class="menutitle">메뉴소개▾
            <ul class="submenu">
                <li><a class="taga" href="/menu/sale">세트</a></li>
                <li><a class="taga" href="/menu/BURGER">버거</a></li>
                <li><a class="taga" href="/menu/SIDE">사이드</a></li>
                <li><a class="taga" href="/menu/DRINK">음료</a></li>
                <li><a class="taga" href="/menu/DESSERT">디저트</a></li>
            </ul>
        </li>

        <li class="menutitle">매장소개▾
            <ul class="submenu">
                <li><a class="taga" href="/store/all">매장 찾기</a></li>
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
    <button id="deliverybtn" onclick="location.href='/store/all';"><strong>딜리버리 주문</strong></button>
</ul>