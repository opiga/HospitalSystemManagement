<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ include file="include/begin-html.jsp" %>

<div class="p-3 text-center">
    <h1 class="form-signin-heading">Enter your login and password</h1>
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
                            path="username">Username:</form:label>
                <form:input type="username" path="username"
                            class="form-control"
                            placeholder="Login"></form:input>
                    <%--                <form:errors path="username" cssClass="error"/>--%>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="password">Password:</form:label>
                <form:input type="password" path="password"
                            class="form-control"
                            placeholder="Password"></form:input>
                    <%--                <form:errors path="password" cssClass="error"/>--%>
            </div>
            <div class="form-group col-md-6">
                <c:if test="${param.error != null}">
                    <i class="failed" style="color: red">Sorry! You entered invalid
                        username/password.</i>
                </c:if>
            </div>
        </div>
            <div class="form-row">
                <div class="form-group col-md-4">
                    <p class="small fw-bold ">Don't have an account?
                        <a href="/registration" class="link-danger">Register</a></p>
                </div>
            </div>

        <div class="form-row">
            <div class="form-group col-md-2">
                <button class="btn  btn-secondary btn-block" type="submit">
                    Log in
                </button>
            </div>
        </div>
    </form:form>
</div>

<%@ include file="include/end-html.jsp" %>

