<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="cssHorizontalMenu.vm" permissions="rolesAdapter">
<ul id="primary-nav" class="menuList">
    <li class="pad">&nbsp;</li>
    <c:if test="${empty pageContext.request.remoteUser}"><li><a href="<c:url value="/login.jsp"/>" class="current"><fmt:message key="login.title"/></a></li></c:if>
    <menu:displayMenu name="HomeMenu"/>
    <menu:displayMenu name="MusicMenu"/>
    <menu:displayMenu name="GamesMenu"/>
    <menu:displayMenu name="ParentsTeachersMenu"/>
    <menu:displayMenu name="GiftMenu"/>
    <menu:displayMenu name="UserMenu"/>
    <menu:displayMenu name="ParentMenu"/>
    <menu:displayMenu name="AdminMenu"/>
    <menu:displayMenu name="MainMenu"/>
    <menu:displayMenu name="Logout"/>
</ul>
</menu:useMenuDisplayer>