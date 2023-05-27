<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Add New Doctor</h1>
</div>
<style>.error {
    color: red;
}</style>
<div class="container">
    <%--@elvariable id="doctor" type=""--%>
    <form:form action="${pageContext.request.contextPath}/doctors/adddoctoru" method="post"
               modelAttribute="doctor">
        <div class="form-row">
            <div class="form-group col-md-12">
                <form:label class="text-center" path="firstName">
                    <spring:message code="label.firstName"/>:
                </form:label>
                <form:input path="firstName" class="form-control"/>
                <form:errors path="firstName" cssClass="error"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <form:label class="text-center" path="lastName">
                    <spring:message code="label.lastName"/>:
                </form:label>
                <form:input path="lastName" class="form-control"/>
                <form:errors path="lastName" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="dateOfBirth">
                    <spring:message code="label.dateOfBirth"/>:
                </form:label>
                <form:input path="dateOfBirth" class="form-control" type="date"/>
                <form:errors path="dateOfBirth" cssClass="error"/>
            </div>
            <div class="form-group col-md-8">
                <form:label class="text-center" path="email">
                    <spring:message code="label.email"/>:
                </form:label>
                <form:input path="email" class="form-control"/>
                <form:errors path="email" cssClass="error"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <form:label class="text-center" path="phoneNumber">
                    <spring:message code="label.phoneNumber"/>:
                </form:label>
                <form:input path="phoneNumber" class="form-control"/>
                <form:errors path="phoneNumber" cssClass="error"/>
            </div>

            <div class="form-group col-md-6">
                <form:label class="text-center" path="address">
                    <spring:message code="label.address"/>:
                </form:label>
                <form:input path="address" class="form-control"/>
                <form:errors path="address" cssClass="error"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label class="text-center" path="username">
                    <spring:message code="label.username"/>:
                </form:label>
                <form:input class="form-control" path="username"
                            value="${editedDoctor.username}"/>
                <form:errors path="username" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="password">
                    <spring:message code="label.password"/>:
                </form:label>
                <form:input path="password" class="form-control"/>
                <form:errors path="password" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="category">
                    <spring:message code="label.category"/>:
                </form:label>
                <form:select class="form-control" path="category.categoryId">
                    <form:options items="${categories}" itemValue="categoryId"
                                  itemLabel="nameCategory"/>
                </form:select>
                <form:errors path="category" cssClass="error"/>
            </div>
        </div>
        <button type="submit" class="btn btn-secondary" value="Save">
            <spring:message code="label.save"/>
        </button>
    </form:form>

</div>

<%@ include file="include/end-html.jsp" %>