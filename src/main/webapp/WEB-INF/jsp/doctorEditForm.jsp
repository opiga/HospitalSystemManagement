<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Edit Doctor</h1>
</div>
<style>.error {
    color: red;
}</style>
<div class="container">
    <%--@elvariable id="editedDoctor" type=""--%>
    <form:form action="${pageContext.request.contextPath}/doctors/editsave/${editedDoctor.id}"
               method="post"
               modelAttribute="editedDoctor">
        <div class="form-row">
            <div class="form-group col-md-12">
                <form:hidden path="id"/>
                <form:hidden path="role"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <form:label class="text-center"
                            path="firstName"><spring:message code="label.firstName"/>:</form:label>
                <form:input class="form-control" path="firstName"
                            value="${editedDoctor.firstName}"/>
                <form:errors path="firstName" cssClass="error"/>
            </div>
            <div class="form-group col-md-6">
                <form:label class="text-center" path="lastName"><spring:message code="label.lastName"/>:</form:label>
                <form:input class="form-control" path="lastName"
                            value="${editedDoctor.lastName}"/>
                <form:errors path="lastName" cssClass="error"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label class="text-center" path="email"><spring:message code="label.email"/>:</form:label>
                <form:input class="form-control" path="email"
                            value="${editedDoctor.email}"/>
                <form:errors path="email" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="dateOfBirth"><spring:message code="label.dateOfBirth"/>:</form:label>
                <form:input class="form-control" path="dateOfBirth"
                            value="${editedDoctor.dateOfBirth}" type="date"/>
                <form:errors path="dateOfBirth" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="phoneNumber"><spring:message code="label.phoneNumber"/>:</form:label>
                <form:input class="form-control" path="phoneNumber"
                            value="${editedDoctor.phoneNumber}"/>
                <form:errors path="phoneNumber" cssClass="error"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label class="text-center" path="address"><spring:message code="label.address"/>:</form:label>
                <form:input class="form-control" path="address"
                            value="${editedDoctor.address}"/>
                <form:errors path="address" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="password"><spring:message code="label.password"/>:</form:label>
                <form:input class="form-control" path="password"
                            value="${editedDoctor.password}"/>
                <form:errors path="password" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="category"><spring:message code="label.category"/>:</form:label>
                <form:select class="form-control" path="category.categoryId">
                    <form:options items="${categories}" itemValue="categoryId"
                                  itemLabel="nameCategory"/>
                </form:select>
                <form:errors path="category" cssClass="error"/>
            </div>
        </div>
        <button type="submit" class="btn btn-secondary" value="Save Changes"><spring:message code="label.save"/></button>
    </form:form>
</div>


<%@ include file="include/end-html.jsp" %>