<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Edit Doctor</h1>
</div>
<div class="container">
    <div class="table-wrapper">
        <%--@elvariable id="editedDoctor" type=""--%>
        <form:form action="${pageContext.request.contextPath}/doctors/editsave/${editedDoctor.id}"
                   method="post"
                   modelAttribute="editedDoctor">
            <table>
                <tr>
                    <td><form:hidden path="id"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="firstName">First Name:</form:label></td>
                    <td><form:input class="form-control" path="firstName"
                                    value="${editedDoctor.firstName}"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="lastName">Last Name:</form:label></td>
                    <td><form:input class="form-control" path="lastName"
                                    value="${editedDoctor.lastName}"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="dateOfBirth">Date Of Birth:</form:label></td>
                    <td><form:input class="form-control" path="dateOfBirth"
                                    value="${editedDoctor.dateOfBirth}" type="date"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="email">Email:</form:label></td>
                    <td><form:input class="form-control" path="email"
                                    value="${editedDoctor.email}"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="phoneNumber">Phone Number:</form:label></td>
                    <td><form:input class="form-control" path="phoneNumber"
                                    value="${editedDoctor.phoneNumber}"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="address">Address:</form:label></td>
                    <td><form:input class="form-control" path="address"
                                    value="${editedDoctor.address}"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="username">Login:</form:label></td>
                    <td><form:input class="form-control" path="username"
                                    value="${editedDoctor.username}"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="password">Password:</form:label></td>
                    <td><form:input class="form-control" path="password"
                                    value="${editedDoctor.password}"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="category">Category:</form:label></td>
                    <td><form:select class="form-control" path="category.categoryId">
                        <form:options items="${categories}" itemValue="categoryId"
                                      itemLabel="nameCategory"/>
                    </form:select></td>
                </tr>
                <tr>
                    <td><form:hidden path="role"/></td>
                </tr>
            </table>
            <br><input class="btn btn-secondary" type="submit" value="Save Changes"/>
        </form:form>
    </div>
</div>

<%@ include file="include/end-html.jsp" %>