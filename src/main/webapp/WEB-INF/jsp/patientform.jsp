<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Add New Patient</h1>
</div>
<div class="container">
    <div class = "table-wrapper">
<%--@elvariable id="patient" type=""--%>
<form:form action="${pageContext.request.contextPath}/patients/addpatientu" method="post" modelAttribute="patient">
    <table >
        <tr>
            <td><form:label class="text-center" path="firstName">First Name:</form:label></td>
            <td><form:input path="firstName" class="form-control"/></td>
        </tr>
        <tr>
            <td><form:label class="text-center" path="lastName">Last Name:</form:label></td>
            <td><form:input path="lastName" class="form-control"/></td>
        </tr>
        <tr>

            <td><form:label class="text-center" path="dateOfBirth">Date of Birth:</form:label></td>
            <td><form:input path="dateOfBirth" type="date" class="form-control"/></td>
        </tr>
        <tr>

            <td><form:label class="text-center" path="email">Email:</form:label></td>
            <td><form:input path="email" class="form-control"/></td>
        </tr>
        <tr>

            <td><form:label class="text-center" path="phoneNumber">phoneNumber:</form:label></td>
            <td><form:input path="phoneNumber" class="form-control"/></td>
        </tr>
        <tr>
            <td> </td>
            <td><input class="btn btn-secondary" type="submit" value="Save" /></td>
        </tr>
    </table>
</form:form>
    </div>
    </div>
<%@ include file="include/end-html.jsp" %>