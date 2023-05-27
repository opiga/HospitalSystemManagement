<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>

<br>
<br>
<div class="d-flex align-items-center justify-content-center vh-100">
    <div class="text-center">
        <h1 class="display-1 fw-bold">403</h1>
        <p class="fs-3"><span class="text-danger">Forbidden!</span>
            <spring:message code="label.pageForbidden"/></p>
        <a href="${pageContext.request.contextPath}/" class="btn btn-secondary"><spring:message
                code="label.homePage"/></a>
    </div>
</div>
<%@ include file="include/end-html.jsp" %>
