<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<li>
    <c:choose>
        <c:when test="${menu.level == 1}">
            <a href="${menu.url}">
                <i class="fa fa-home"></i>
                <span class="nav-label">${menu.title}</span>
                <c:if test="${menu.menu_type == '0'}">
                    <span class="fa arrow"></span>
                </c:if>
            </a>
        </c:when>
        <c:otherwise>
            <a class="J_menuItem" href="${menu.url}">${menu.title}</a>
        </c:otherwise>
    </c:choose>
    <c:if test="${not empty menu.children}">
        <ul ${menu.level == 2 ? "class='nav nav-second-level'" : "class='nav nav-second-level'"}>
            <c:forEach var="menu" items="${menu.children}">
                <c:set var="menu" value="${menu}" scope="request"/>
                <jsp:include page="./include/treeMenu.jsp"/>
            </c:forEach>
        </ul>
    </c:if>
</li>