<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Add Hospital Card</h1>
</div>

<div class="container">
    <%--@elvariable id="newHospitalCard" type=""--%>
    <form:form action="${pageContext.request.contextPath}/hospitalcards/addNewHospitalCard"
               method="post"
               modelAttribute="newHospitalCard">
        <div class="form-row">
            <div class="form-group col-md-12">
                <form:hidden path="hospitalCardId"/>
                <form:hidden path="patient"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12">
                <form:label class="text-center"
                            path="preliminaryDiagnosis">Preliminary Diagnosis:</form:label>
                <form:input class="form-control" path="preliminaryDiagnosis"/>
            </div>
            <div class="form-group col-md-12">
                <form:label class="text-center"
                            path="clinicalDiagnosis">Clinical Diagnosis:</form:label>
                <form:input class="form-control" path="clinicalDiagnosis"/>
            </div>
            <div class="form-group col-md-12">
                <form:label class="text-center"
                            path="finalDiagnosis">Final Diagnosis:</form:label>
                <form:input class="form-control" path="finalDiagnosis"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label class="text-center"
                            path="discharged">Discharged:</form:label>
                <form:select class="form-control" path="discharged">
                    <form:option value="false">false</form:option>
                    <form:option value="true">true</form:option>
                </form:select>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="doctor.id">Doctor:</form:label>
                <form:select class="form-control" path="doctor.id">
                    <form:option value="" label="Choose a doctor" disabled="false"/>
                    <form:options items="${doctors}" itemValue="id"
                                  itemLabel="firstNameAndLastName"/>
                </form:select>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="nurse.id">Nurse:</form:label>
                <form:select class="form-control" path="nurse.id">
                    <form:option value="" label="Choose a nurse" disabled="false"/>
                    <form:options items="${nurses}" itemValue="id"
                                  itemLabel="firstNameAndLastName"/>
                </form:select>
            </div>
        </div>

        <button type="submit" class="btn btn-secondary" value="Save Changes">Save
        </button>
    </form:form>

</div>

<%@ include file="include/end-html.jsp" %>