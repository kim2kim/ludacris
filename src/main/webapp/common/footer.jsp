<%@ include file="/common/taglibs.jsp" %>

    <div id="divider"><div></div></div>
    <span class="left">
        &copy; <fmt:message key="copyright.year"/> <a href="<fmt:message key="company.url"/>"><fmt:message key="company.name"/></a>
        |
        <a href="/legal.jsp"><fmt:message key="legal"/></a>
        <c:if test="${pageContext.request.remoteUser != null}">
        | <fmt:message key="user.status"/> ${pageContext.request.remoteUser}
        </c:if>
    </span>
    <span class="right">
        <a href="/aboutus.jsp"><fmt:message key="aboutus"/></a>
        |
        <a href="/help.jsp"><fmt:message key="help"/></a>
    </span>
