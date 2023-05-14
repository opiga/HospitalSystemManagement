<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ include file="include/begin-html.jsp" %>
<style>.error {
    color: red;
}</style>
<div class="p-3 text-center">
    <h1 class="form-signin-heading"><spring:message code="label.newAccount"/></h1>
</div>

<div class="container">

    <%--@elvariable id="userForm" type=""--%>
    <form:form method="POST" modelAttribute="userForm"
               class="form-signin">
        <div class="form-row">
            <div class="form-group col-md-6">
                <form:label class="text-center"
                            path="firstName"><spring:message code="label.firstName"/>:</form:label>
                <form:input type="text" path="firstName"
                            class="form-control" placeholder="First name"
                            autofocus="true"></form:input>
                <form:errors path="firstName" cssClass="error"></form:errors>
            </div>
            <div class="form-group col-md-6">
                <form:label class="text-center"
                            path="lastName"><spring:message code="label.lastName"/>:</form:label>
                <form:input type="text" path="lastName"
                            class="form-control" placeholder="Last name"
                            autofocus="true"></form:input>
                <form:errors path="lastName" cssClass="error"></form:errors>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-2">
                <form:label class="text-center"
                            path="dateOfBirth"><spring:message code="label.dateOfBirth"/>:</form:label>
                <form:input type="date" path="dateOfBirth"
                            class="form-control" placeholder="Date of birth"
                            autofocus="true"></form:input>
                <form:errors path="dateOfBirth" cssClass="error"></form:errors>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="phoneNumber"><spring:message code="label.phoneNumber"/>:</form:label>
                <form:input type="text" path="phoneNumber"
                            class="form-control" placeholder="Phone number"
                            autofocus="true"></form:input>
                <form:errors path="phoneNumber" cssClass="error"></form:errors>
            </div>
            <div class="form-group col-md-6">
                <form:label class="text-center"
                            path="address"><spring:message code="label.address"/>:</form:label>
                <form:input type="text" path="address"
                            class="form-control" placeholder="Address"
                            autofocus="true"></form:input>
                <form:errors path="address" cssClass="error"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <form:label class="text-center"
                            path="email"><spring:message code="label.email"/>:</form:label>
                <form:input type="text" path="email"
                            class="form-control" placeholder="Email"
                            autofocus="true"></form:input>
                <form:errors path="email" cssClass="error"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="username"><spring:message code="label.username"/>:</form:label>
                <form:input type="username" path="username"
                            class="form-control"
                            placeholder="Login"></form:input>
                <form:errors path="username" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="password"><spring:message code="label.password"/>:</form:label>
                <form:input type="password" path="password"
                            class="form-control"
                            placeholder="Password"></form:input>
                <form:errors path="password" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="password"><spring:message code="label.passwordConfirm"/>:</form:label>
                <form:input type="password" path="passwordConfirm"
                            class="form-control"
                            placeholder="Confirm your password"></form:input>
                <form:errors path="password" cssClass="error"/>
            </div>
            <div class="form-group col-md-2">
                <button class="btn btn-lg btn-secondary btn-block" type="submit">
                    <spring:message code="label.registration"/>
                </button>
            </div>
        </div>
    </form:form>
</div>

<%@ include file="include/end-html.jsp" %>