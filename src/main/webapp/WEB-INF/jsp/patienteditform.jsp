<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>

<div class="p-3 text-center">
    <h1 class="mb-2">Edit Patient</h1>
</div>
<div class="container">
    <div class="table-wrapper">
        <%--@elvariable id="patient" type=""--%>
        <form:form action="${pageContext.request.contextPath}/patients/editsave" method="post"
                   modelAttribute="patient">
            <form:hidden path="id"/>
            <form:hidden path="role"/>
            <table>
                <tr>
                    <td><form:label class="text-center"
                                    path="firstName">First Name:</form:label></td>
                    <td><form:input class="form-control" path="firstName"
                                    value="${patient.firstName}"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="lastName">Last Name:</form:label></td>
                    <td><form:input class="form-control" path="lastName"
                                    value="${patient.lastName}"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="dateOfBirth">Date of Birth:</form:label></td>
                    <td><form:input class="form-control" path="dateOfBirth" type="date"
                                    value="${patient.dateOfBirth}"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="email">email:</form:label></td>
                    <td><form:input class="form-control" path="email"
                                    value="${patient.email}"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="phoneNumber">PhoneNumber:</form:label></td>
                    <td><form:input class="form-control" path="phoneNumber"
                                    value="${patient.phoneNumber}"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="address">Address:</form:label></td>
                    <td><form:input class="form-control" path="address"
                                    value="${patient.address}"/></td>
                </tr>
            </table>
            <input class="btn btn-secondary" type="submit" value="Save Changes"/>
        </form:form>
        <br>


    </div>
</div>

<%@ include file="include/end-html.jsp" %>