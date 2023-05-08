<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Edit Hospital Card</h1>
</div>

<div class="container">

        <%--@elvariable id="editedHospitalCard" type=""--%>
        <form:form
                action="${pageContext.request.contextPath}/hospitalcards/editsave"
                method="post"
                modelAttribute="editedHospitalCard">
        <div class="form-row">
            <div class="form-group col-md-12">
               <form:hidden path="hospitalCardId"/>
               <form:hidden path="patient"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
               <form:label class="text-center"
                                path="preliminaryDiagnosis">Preliminary diagnosis:</form:label>
               <form:input class="form-control" path="preliminaryDiagnosis"
                                value="${editedHospitalCard.preliminaryDiagnosis}"/>
            </div>
        </div>
        <div class="form-group">
            <form:label class="text-center"
                            path="clinicalDiagnosis">Clinical diagnosis:</form:label>
            <form:input class="form-control" path="clinicalDiagnosis"
                            value="${editedHospitalCard.clinicalDiagnosis}"/>
        </div>
        <div class="form-group">
           <form:label class="text-center"
                            path="finalDiagnosis">Final diagnosis:</form:label>
            <form:input class="form-control" path="finalDiagnosis"
                            value="${editedHospitalCard.finalDiagnosis}"/>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label class="text-center" path="discharged">Discharged:</form:label>
                <form:select class="form-control" path="discharged">
                    <form:option value="true">true</form:option>
                    <form:option value="false">false</form:option>
                </form:select>
            </div>

            <div class="form-group col-md-4">
               <form:label class="text-center" path="doctor.id">Doctor:</form:label>
                    <form:select class="form-control" path="doctor.id">
                        <form:option value="" label="Choose a doctor" disabled="${editedHospitalCard.doctor == null}"/>
                        <form:options items="${doctors}" itemValue="id" itemLabel="firstNameAndLastName" />
                    </form:select>
            </div>

            <div class="form-group col-md-4">
                <form:label class="text-center" path="nurse.id">Nurse:</form:label>
                <form:select class="form-control" path="nurse.id">
                    <form:option value="" label="Choose a nurse" disabled="${editedHospitalCard.nurse == null}"/>
                    <form:options items="${nurses}" itemValue="id" itemLabel="firstNameAndLastName" />
                </form:select>
            </div>
        </div>
        <button type="submit" class="btn btn-secondary" value="Save Changes">Save Changes</button>
    </form:form>
</div>

<%@ include file="include/end-html.jsp" %>