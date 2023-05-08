<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Edit Doctor</h1>
</div>

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
                            path="firstName">First Name:</form:label>
                <form:input class="form-control" path="firstName"
                            value="${editedDoctor.firstName}"/>
            </div>
            <div class="form-group col-md-6">
                <form:label class="text-center" path="lastName">Last Name:</form:label>
                <form:input class="form-control" path="lastName"
                            value="${editedDoctor.lastName}"/>
            </div>
        </div>


        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label class="text-center" path="email">Email:</form:label>
                <form:input class="form-control" path="email"
                            value="${editedDoctor.email}"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="dateOfBirth">Date Of Birth:</form:label>
                <form:input class="form-control" path="dateOfBirth"
                            value="${editedDoctor.dateOfBirth}" type="date"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="phoneNumber">Phone Number:</form:label>
                <form:input class="form-control" path="phoneNumber"
                            value="${editedDoctor.phoneNumber}"/>
            </div>
        </div>

        <div class="form-row">

            <div class="form-group col-md-4">
                <form:label class="text-center" path="address">Address:</form:label>
                <form:input class="form-control" path="address"
                            value="${editedDoctor.address}"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="password">Password:</form:label>
                <form:input class="form-control" path="password"
                            value="${editedDoctor.password}"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="category">Category:</form:label>
                <form:select class="form-control" path="category.categoryId">
                    <form:options items="${categories}" itemValue="categoryId"
                                  itemLabel="nameCategory"/>
                </form:select>
            </div>
        </div>


        <button type="submit" class="btn btn-secondary" value="Save Changes">Save Changes</button>
    </form:form>
</div>


<%@ include file="include/end-html.jsp" %>