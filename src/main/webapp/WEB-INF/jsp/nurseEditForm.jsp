<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<style>.error {
    color: red;
}</style>
<div class="p-3 text-center">
    <h1 class="mb-2"><spring:message code="label.editNurse"/></h1>
</div>

<div class="container">
    <%--@elvariable id="editedNurse" type=""--%>
    <form:form action="${pageContext.request.contextPath}/nurses/edit/${editedNurse.id}"
               method="post"
               modelAttribute="editedNurse">
        <form:hidden path="id"/>
        <form:hidden path="role"/>
        <div class="form-row">
            <div class="form-group col-md-6">
                <form:label class="text-center" path="firstName">
                    <spring:message code="label.firstName"/>:
                </form:label>
                <form:input class="form-control" path="firstName"
                            value="${editedNurse.firstName}"/>
                <form:errors path="firstName" cssClass="error"/>
            </div>
            <div class="form-group col-md-6">
                <form:label class="text-center" path="lastName">
                    <spring:message code="label.lastName"/>:
                </form:label>
                <form:input class="form-control" path="lastName"
                            value="${editedNurse.lastName}"/>
                <form:errors path="lastName" cssClass="error"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="dateOfBirth">
                    <spring:message code="label.dateOfBirth"/>:
                </form:label>
                <form:input class="form-control" path="dateOfBirth" type="date"
                            value="${editedNurse.dateOfBirth}"/>
                <form:errors path="dateOfBirth" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="email">
                    <spring:message code="label.email"/>:
                </form:label>
                <form:input class="form-control" path="email"
                            value="${editedNurse.email}"/>
                <form:errors path="email" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="phoneNumber">
                    <spring:message code="label.phoneNumber"/>:
                </form:label>
                <form:input class="form-control" path="phoneNumber"
                            value="${editedNurse.phoneNumber}"/>
                <form:errors path="phoneNumber" cssClass="error"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label class="text-center" path="address">
                    <spring:message code="label.address"/>:
                </form:label>
                <form:input class="form-control" path="address"
                            value="${editedNurse.address}"/>
                <form:errors path="address" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="username">
                    <spring:message code="label.username"/>:
                </form:label>
                <form:input class="form-control" path="username"
                            value="${editedNurse.username}"/>
                <form:errors path="username" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="password">
                    <spring:message code="label.password"/>:
                </form:label>
                <form:input class="form-control" path="password"
                            value="${editedNurse.password}"/>
                <form:errors path="password" cssClass="error"/>
            </div>
        </div>
        <a class="btn btn-secondary"
           href="${pageContext.request.contextPath}/nurses/list">
            <spring:message code="label.cancel"/>
        </a>
        <button type="submit" class="btn btn-secondary" value="Save Changes">
            <spring:message code="label.save"/>
        </button>
    </form:form>
</div>

<%@ include file="include/end-html.jsp" %>