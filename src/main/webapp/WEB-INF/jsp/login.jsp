<%@ include file="include/begin-html.jsp" %>

<div class="p-3 text-center">
    <h1 class="form-signin-heading"><spring:message code="label.login"/></h1>
</div>

<div class="container">
    <%--    <sec:authorize access="isAuthenticated()">--%>
    <%--        <% response.sendRedirect("/"); %>--%>
    <%--    </sec:authorize>--%>
    <%--@elvariable id="loginForm" type=""--%>
    <form:form method="POST" modelAttribute="loginForm">

        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="username"><spring:message code="label.username"/>:</form:label>
                <form:input type="username" path="username"
                            class="form-control"
                            placeholder="Login"></form:input>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="password"><spring:message code="label.password"/>:</form:label>
                <form:input type="password" path="password"
                            class="form-control"
                            placeholder="Password"></form:input>
            </div>
            <div class="form-group col-md-6">
                <c:if test="${param.error != null}">
                    <i class="failed" style="color: red"><spring:message
                            code="label.invalidLoginPassword"/>.</i>
                </c:if>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <p class="small fw-bold "><spring:message code="label.noAccount"/>
                    <a href="/registration" class="link-danger"><spring:message
                            code="label.registration"/></a></p>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-2">
                <button class="btn  btn-secondary btn-block" type="submit">
                    <spring:message code="label.signIn"/>
                </button>
            </div>
        </div>
    </form:form>
</div>

<%@ include file="include/end-html.jsp" %>

