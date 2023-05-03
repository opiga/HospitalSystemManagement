<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Add Hospital Card</h1>
</div>
<div class="container">
    <div class="table-wrapper ">
  
        <%--@elvariable id="newHospitalCard" type=""--%>
        <form:form action="${pageContext.request.contextPath}/hospitalcards/addNewHospitalCard"
                   method="post"
                   modelAttribute="newHospitalCard">
            <table>
                <tr>
                    <td><form:hidden path="hospitalCardId"/></td>
                    <td><form:hidden path="patient"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="preliminaryDiagnosis">Preliminary Diagnosis:</form:label></td>
                    <td><form:input class="form-control" path="preliminaryDiagnosis"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="clinicalDiagnosis">Clinical Diagnosis:</form:label></td>
                    <td><form:input class="form-control" path="clinicalDiagnosis"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="finalDiagnosis">Final Diagnosis:</form:label></td>
                    <td><form:input class="form-control" path="finalDiagnosis"/></td>
                </tr>
                <tr>
                    <td><form:label class="text-center"
                                    path="discharged">Discharged:</form:label></td>
                    <td><form:select class="form-control" path="discharged">
                        <form:option value="false">false</form:option>
                        <form:option value="true">true</form:option>
                    </form:select></td>
                </tr>
                <tr>
                    <td><form:label class="text-center" path="doctor.id">Doctor:</form:label></td>
                    <td>
                        <form:select class="form-control" path="doctor.id">
                            <form:option value="" label="Choose a doctor" disabled="false"/>
                            <form:options items="${doctors}" itemValue="id"
                                          itemLabel="firstNameAndLastName"/>
                        </form:select>
                    </td>
                </tr>
            </table>
            <input class="btn btn-secondary" type="submit" value="Save changes"/>
        </form:form>

    </div>
</div>
<%@ include file="include/end-html.jsp" %>