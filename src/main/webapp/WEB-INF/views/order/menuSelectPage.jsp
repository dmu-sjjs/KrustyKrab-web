<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<span>BURGER</span> | <span>BURGER</span> | <span>BURGER</span> |<span>BURGER</span> |<span>BURGER</span>
<table class="menu_table">
    <tr>
        <c:forEach var="m" items="${menus}" varStatus="status" >
        <c:if test="${status.index%5==0}">
    </tr><tr>
    </c:if>
    <td><img width="150" height="150" src="/resources/img/${m.menuType}/${m.menuName}.png">
        <br> ${m.menuName} <br>${m.price}<br>${m.menuDescription}</td>
    </c:forEach>
</tr>
</table>