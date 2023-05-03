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
            <table>
                <tr>
                    <td><form:label class="text-center"
                                    path="firstName">First Name:</form:label></td>
                    <td><form:input class="form-control" path="firstName"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="lastName">Last Name:</form:label></td>
                    <td><form:input class="form-control" path="lastName"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="dateOfBirth">Date of Birth:</form:label></td>
                    <td><form:input class="form-control" path="dateOfBirth"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="email">email:</form:label></td>
                    <td><form:input class="form-control" path="email"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="phoneNumber">phoneNumber:</form:label></td>
                    <td><form:input class="form-control" path="phoneNumber"/></td>
                </tr>
            </table>

        </form:form>
        <br>
        <input class="btn btn-secondary" type="submit" value="Save Changes"/>

    </div>
</div>

<%@ include file="include/end-html.jsp" %>