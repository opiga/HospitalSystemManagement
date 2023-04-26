<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/begin-html.jsp" %>

<div class="p-3 text-center">
    <h1 class="mb-2">Edit Doctor</h1>
</div>
<div class="container">
    <div class = "table-wrapper">
<%--@elvariable id="patient" type=""--%>
<form:form action="${pageContext.request.contextPath}/doctors/editsave" method="post" modelAttribute="doctor">
    <form:hidden path="doctorId"/>
    <table>
        <tr>
            <td><form:label class="text-center" path="firstName">First Name:</form:label></td>
            <td><form:input class="form-control" path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label class="text-center" path="lastName">Last Name:</form:label></td>
            <td><form:input  class="form-control" path="lastName"/></td>
        </tr>
        <tr>
            <td> <form:label class="text-center"  path="category">Category:</form:label></td>
            <td> <form:select class="form-control" path="category.categoryId">
                <form:options items="${categories}" itemValue="categoryId" itemLabel="nameCategory"/>
            </form:select></td>
        </tr>
    </table>
</form:form>
        <br><input class="btn btn-secondary"  type="submit" value="Save Changes"/>
    </div>
    </div>

<%@ include file="include/end-html.jsp" %>