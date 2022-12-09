<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="/resources/css/order/menuSelect.css">

<div id="selectPage">
    <h1 id="selectTitle">Choose Your Menus!</h1>
    <form id="addForm" action="/order/${storeId}/addItem" method="post">
        <input readonly type="hidden" id="menuId" name="menuId">
        <span class="menuText">메뉴명: </span> <input placeholder="원하는 메뉴를 클릭하세요!" required readonly type="text"
                                                   id="menuName" name="menuName">
        <span class="menuText">개수: </span> <input placeholder="수량을 입력하세요" required type="number" id="count"
                                                  name="count">
        <input id="addCart" type="submit" onclick="closeMenu()" value="장바구니 추가">
    </form>
    <table class="menu_table">
        <tr>
            <c:forEach var="m" items="${menus}" varStatus="status">
            <c:if test="${status.index%5==0}">
        </tr>
        <tr>
            </c:if>
            <td align="center" class="menuList" id="${m.menuId}"><a href="javascript:void(0)"
                                                                    onclick="chooseMenu(${m.menuId}, '${m.menuName}')">
                <img width="150" height="150" src="/resources/img/${m.menuType}/${m.menuName}.png">
                <br><strong>${m.menuName}</strong><br>${m.price} ￦<br>${m.menuDescription}</a></td>
            </c:forEach>
        </tr>
    </table>
</div>
<script>
    const idInput = document.querySelector('#menuId');
    const menuName = document.querySelector('#menuName');
    const count = document.querySelector('#count');

    function chooseMenu(id, name) {
        idInput.value = id;
        menuName.value = name;
    }

    function closeMenu() {
        if (menuName.value === "") {
            alert('메뉴를 선택해주세요!');
        } else {
            if (count.value === "") {
                alert('개수를 입력해주세요!');
            } else {
                alert('장바구니에 추가되었습니다!');
            }
        }

        console.log('메뉴창 닫힘');
    }
</script>