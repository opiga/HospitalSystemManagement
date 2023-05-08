<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Add New Doctor</h1>
</div>
<div class="container">
    <%--@elvariable id="doctor" type=""--%>
    <form:form action="${pageContext.request.contextPath}/doctors/adddoctoru" method="post"
               modelAttribute="doctor">
        <div class="form-row">
            <div class="form-group col-md-12">
                <form:label class="text-center"
                            path="firstName">First Name:</form:label>
                <form:input path="firstName" class="form-control"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <form:label class="text-center" path="lastName">Last Name:</form:label>
                <form:input path="lastName" class="form-control"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="dateOfBirth">Date Of Birth:</form:label>
                <form:input path="dateOfBirth" class="form-control" type="date"/>
            </div>
            <div class="form-group col-md-8">
                <form:label class="text-center" path="email">Email:</form:label>
                <form:input path="email" class="form-control"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <form:label class="text-center"
                            path="phoneNumber">Phone Number:</form:label>
                <form:input path="phoneNumber" class="form-control"/>
            </div>

            <div class="form-group col-md-6">
                <form:label class="text-center" path="address">Address:</form:label>
                <form:input path="address" class="form-control"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <td><form:label class="text-center" path="password">Password:</form:label></td>
                <td><form:input path="password" class="form-control"/></td>
            </div>
            <div class="form-group col-md-6">
                <td><form:label class="text-center" path="category">Category:</form:label></td>
                <td><form:select class="form-control" path="category.categoryId">
                    <form:options items="${categories}" itemValue="categoryId"
                                  itemLabel="nameCategory"/>
                </form:select></td>
            </div>
        </div>
        <button type="submit" class="btn btn-secondary" value="Save">Save
        </button>
    </form:form>

</div>

<%@ include file="include/end-html.jsp" %>