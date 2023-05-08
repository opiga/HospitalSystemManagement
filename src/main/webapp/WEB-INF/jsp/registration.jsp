<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ include file="include/begin-html.jsp" %>

<div class="p-3 text-center">
    <h1 class="form-signin-heading">Create your account</h1>
</div>

<div class="container">

    <%--@elvariable id="userForm" type=""--%>
    <form:form method="POST" modelAttribute="userForm"
               class="form-signin">
        <div class="form-row">
            <div class="form-group col-md-6">
                <spring:bind path="firstName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label class="text-center"
                                    path="firstName">First name:</form:label>
                        <form:input type="text" path="firstName"
                                    class="form-control" placeholder="First name"
                                    autofocus="true"></form:input>
                        <form:errors path="firstName"></form:errors>
                    </div>
                </spring:bind>
            </div>

            <div class="form-group col-md-6">
                <spring:bind path="lastName">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label class="text-center"
                                    path="lastName">Last name:</form:label>
                        <form:input type="text" path="lastName"
                                    class="form-control" placeholder="Last name"
                                    autofocus="true"></form:input>
                        <form:errors path="lastName"></form:errors>
                    </div>
                </spring:bind>
            </div>

        </div>
        <div class="form-row">
            <div class="form-group col-md-2">
                <spring:bind path="dateOfBirth">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label class="text-center"
                                    path="dateOfBirth">Date of birth:</form:label>
                        <form:input type="date" path="dateOfBirth"
                                    class="form-control" placeholder="Date of birth"
                                    autofocus="true"></form:input>
                        <form:errors path="dateOfBirth"></form:errors>
                    </div>
                </spring:bind>
            </div>
            <div class="form-group col-md-4">
                <spring:bind path="phoneNumber">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label class="text-center"
                                    path="phoneNumber">Phone number:</form:label>
                        <form:input type="text" path="phoneNumber"
                                    class="form-control" placeholder="Phone number"
                                    autofocus="true"></form:input>
                        <form:errors path="phoneNumber"></form:errors>
                    </div>
                </spring:bind>
            </div>
            <div class="form-group col-md-6">
                <spring:bind path="address">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label class="text-center"
                                    path="address">Address:</form:label>
                        <form:input type="text" path="address"
                                    class="form-control" placeholder="Address"
                                    autofocus="true"></form:input>
                        <form:errors path="address"></form:errors>
                    </div>
                </spring:bind>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <spring:bind path="email">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label class="text-center"
                                    path="email">Email:</form:label>
                        <form:input type="text" path="email"
                                    class="form-control" placeholder="Email"
                                    autofocus="true"></form:input>
                        <form:errors path="email"></form:errors>
                    </div>
                </spring:bind>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <spring:bind path="username">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label class="text-center"
                                    path="username">Username:</form:label>
                        <form:input type="username" path="username"
                                    class="form-control"
                                    placeholder="Login"></form:input>
                        <form:errors path="username"></form:errors>
                    </div>
                </spring:bind>
            </div>
            <div class="form-group col-md-4">
                <spring:bind path="password">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label class="text-center"
                                    path="password">Password:</form:label>
                        <form:input type="password" path="password"
                                    class="form-control"
                                    placeholder="Password"></form:input>
                        <form:errors path="password"></form:errors>
                    </div>
                </spring:bind>
            </div>
            <div class="form-group col-md-4">
                <spring:bind path="passwordConfirm">
                    <div class="form-group ${status.error ? 'has-error' : ''}">
                        <form:label class="text-center"
                                    path="password">Password confirm:</form:label>
                        <form:input type="password" path="passwordConfirm"
                                    class="form-control"
                                    placeholder="Confirm your password"></form:input>
                        <form:errors path="passwordConfirm"></form:errors>
                    </div>
                </spring:bind>
            </div>
            <div class="form-group col-md-2">
                <button class="btn btn-lg btn-secondary btn-block" type="submit">
                    Register
                </button>
            </div>
        </div>
    </form:form>
</div>

<%--<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>--%>
<%--<script src="${contextPath}/resources/js/bootstrap.min.js"></script>--%>
<%@ include file="include/end-html.jsp" %>