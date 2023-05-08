<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Add New Patient</h1>
</div>
<div class="container">

        <%--@elvariable id="patient" type=""--%>
        <form:form action="${pageContext.request.contextPath}/patients/addpatientu" method="post" modelAttribute="patient">
        <div class="form-row">
            <div class="form-group col-md-12">
                <form:label class="text-center" path="firstName">First Name:</form:label>
                <form:input path="firstName" class="form-control"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12">
                <form:label class="text-center" path="lastName">Last Name:</form:label>
                <form:input path="lastName" class="form-control"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="dateOfBirth">Date of Birth:</form:label>
                    <form:input path="dateOfBirth" type="date" class="form-control"/>
            </div>
            <div class="form-group col-md-8">
                <form:label class="text-center" path="email">Email:</form:label>
                <form:input path="email" class="form-control"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <form:label class="text-center" path="phoneNumber">phoneNumber:</form:label>
                <form:input path="phoneNumber" class="form-control"/>
            </div>

            <div class="form-group col-md-6">
               <form:label class="text-center" path="address">Address:</form:label>
                <form:input path="address" class="form-control"/>
            </div>
        </div>

        <button type="submit" class="btn btn-secondary" value="Save">Save
        </button>
    </form:form>

</div>

<%@ include file="include/end-html.jsp" %>