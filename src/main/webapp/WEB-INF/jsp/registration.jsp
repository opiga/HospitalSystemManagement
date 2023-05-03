<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<%@ include file="include/begin-html.jsp" %>

<br>
<br>

<section class="vh-100">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                        <div class="row justify-content-center">
                            <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                                <%--@elvariable id="userForm" type=""--%>
                                <form:form method="POST" modelAttribute="userForm"
                                           class="form-signin">
                                    <h2 class="form-signin-heading">Create your account</h2>
                                    <br>
                                    <spring:bind path="username">
                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                            <form:input type="text" path="username"
                                                        class="form-control" placeholder="Username"
                                                        autofocus="true"></form:input>
                                            <form:errors path="username"></form:errors>
                                        </div>
                                    </spring:bind>

                                    <spring:bind path="password">
                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                            <form:input type="password" path="password"
                                                        class="form-control"
                                                        placeholder="Password"></form:input>
                                            <form:errors path="password"></form:errors>
                                        </div>
                                    </spring:bind>

                                    <spring:bind path="passwordConfirm">
                                        <div class="form-group ${status.error ? 'has-error' : ''}">
                                            <form:input type="password" path="passwordConfirm"
                                                        class="form-control"
                                                        placeholder="Confirm your password"></form:input>
                                            <form:errors path="passwordConfirm"></form:errors>
                                        </div>
                                    </spring:bind>

                                    <button class="btn btn-lg btn-secondary btn-block" type="submit">
                                        Register
                                    </button>
                                </form:form>

                            </div>
                        </div>
                </div>

        </div>
    </div>
</section>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<%@ include file="include/end-html.jsp" %>