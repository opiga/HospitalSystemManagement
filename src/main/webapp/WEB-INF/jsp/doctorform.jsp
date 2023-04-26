<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Add New Doctor</h1>
</div>
<div class="container">
    <div class = "table-wrapper ">
<%--@elvariable id="doctor" type=""--%>
<form:form action="${pageContext.request.contextPath}/doctors/adddoctoru" method="post" modelAttribute="doctor">
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
            <td> <form:label class="text-center"  path="category">Category:</form:label></td>
            <td> <form:select class="form-control" path="category.categoryId">
                <form:options items="${categories}" itemValue="categoryId" itemLabel="nameCategory"/>
            </form:select></td>
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