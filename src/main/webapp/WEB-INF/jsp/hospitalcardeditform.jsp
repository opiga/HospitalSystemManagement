<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Edit Hospital Card</h1>
</div>
<div class="container">
    <div class="table-wrapper">
        <%--@elvariable id="editedHospitalCard" type=""--%>
        <form:form
                action="${pageContext.request.contextPath}/hospitalcards/editsave"
                method="post"
                modelAttribute="editedHospitalCard">
            <table>
                <tr>
                    <td><form:hidden path="hospitalCardId"/></td>
                    <td><form:hidden path="patient"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="diagnosis">Diagnosis:</form:label></td>
                    <td><form:input class="form-control" path="diagnosis"
                                    value="${editedHospitalCard.diagnosis}"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="discharged">Discharged:</form:label></td>
                    <td><form:select class="form-control" path="discharged">
                        <form:option value="true">true</form:option>
                        <form:option value="false">false</form:option>
                    </form:select></td>
                </tr>
<%--                <td><form:label class="text-center" path="Doctor">Doctor:</form:label></td>--%>
<%--                <td><form:select class="form-control" path="doctor.firstName">--%>
<%--                    <form:options items="${doctors}" itemValue="id"--%>
<%--                                  itemLabel="firstNameAndLastName"/>--%>
<%--                </form:select></td>--%>

                <td><form:label class="text-center" path="doctor.id">Doctor:</form:label></td>
                <td>
                    <form:select class="form-control" path="doctor.id">
                        <form:option value="" label="Choose a doctor" disabled="${editedHospitalCard.doctor == null}"/>
                        <form:options items="${doctors}" itemValue="id" itemLabel="firstNameAndLastName" />
                    </form:select>
                </td>
            </table>
            <br><input class="btn btn-secondary" type="submit" value="Save Changes"/>
        </form:form>
    </div>
</div>

<%@ include file="include/end-html.jsp" %>