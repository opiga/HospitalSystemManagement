<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Add New Doctor</h1>
</div>
<div class="container">
    <div class="table-wrapper ">
        <%--@elvariable id="doctor" type=""--%>
        <form:form action="${pageContext.request.contextPath}/doctors/adddoctoru" method="post"
                   modelAttribute="doctor">
            <table>
                <tr>
                    <td><form:label class="text-center"
                                    path="firstName">First Name:</form:label></td>
                    <td><form:input path="firstName" class="form-control"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="lastName">Last Name:</form:label></td>
                    <td><form:input path="lastName" class="form-control"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="dateOfBirth">Date Of Birth:</form:label></td>
                    <td><form:input path="dateOfBirth" class="form-control" type="date"/></td>

                </tr>
                <tr>
                    <td><form:label class="text-center" path="email">Email:</form:label></td>
                    <td><form:input path="email" class="form-control"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="phoneNumber">Phone Number:</form:label></td>
                    <td><form:input path="phoneNumber" class="form-control"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="address">Address:</form:label></td>
                    <td><form:input path="address" class="form-control"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="username">Login:</form:label></td>
                    <td><form:input path="username" class="form-control"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="password">Password:</form:label></td>
                    <td><form:input path="password" class="form-control"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="category">Category:</form:label></td>
                    <td><form:select class="form-control" path="category.categoryId">
                        <form:options items="${categories}" itemValue="categoryId"
                                      itemLabel="nameCategory"/>
                    </form:select></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input class="btn btn-secondary" type="submit" value="Save"/></td>
                </tr>
            </table>
        </form:form>
    </div>
</div>
<%@ include file="include/end-html.jsp" %>