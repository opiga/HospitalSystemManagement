<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2"><spring:message code="label.addHospitalCard"/></h1>
</div>
<style>.error {
    color: red;
}</style>
<div class="container">
    <%--@elvariable id="newHospitalCard" type=""--%>
    <form:form action="${pageContext.request.contextPath}/hospitalcards/add"
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
                <form:label class="text-center" path="preliminaryDiagnosis">
                    <spring:message code="label.pDiagnosis"/>:
                </form:label>
                <form:input class="form-control" path="preliminaryDiagnosis"/>
                <form:errors path="preliminaryDiagnosis" cssClass="error"/>
            </div>
            <div class="form-group col-md-12">
                <form:label class="text-center" path="clinicalDiagnosis">
                    <spring:message code="label.cDiagnosis"/>:
                </form:label>
                <form:input class="form-control" path="clinicalDiagnosis"/>
            </div>
            <div class="form-group col-md-12">
                <form:label class="text-center" path="finalDiagnosis">
                    <spring:message code="label.fDiagnosis"/>:
                </form:label>
                <form:input class="form-control" path="finalDiagnosis"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-4">
                <form:label class="text-center" path="discharged">
                    <spring:message code="label.discharged"/>:
                </form:label>
                <form:select class="form-control" path="discharged">
                    <form:option value="false">false</form:option>
                    <form:option value="true">true</form:option>
                </form:select>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="doctor.id">
                    <spring:message code="label.doctor"/>:
                </form:label>
                <form:select class="form-control" path="doctor.id">
                    <form:option value="" label="Choose a doctor" disabled="false"/>
                    <form:options items="${doctors}" itemValue="id"
                                  itemLabel="firstNameAndLastName"/>
                </form:select>
                <form:errors path="doctor" cssClass="error"/>
            </div>
            <div class="form-group col-md-4">
                <form:label class="text-center" path="nurse.id">
                    <spring:message code="label.nurse"/>:
                </form:label>
                <form:select class="form-control" path="nurse.id">
                    <form:option value="" label="Choose a nurse" disabled="false"/>
                    <form:options items="${nurses}" itemValue="id"
                                  itemLabel="firstNameAndLastName"/>
                </form:select>
                <form:errors path="nurse" cssClass="error"/>
            </div>
        </div>

        <button type="submit" class="btn btn-secondary" value="Save Changes">
            <spring:message code="label.save"/>
        </button>
    </form:form>

</div>

<%@ include file="include/end-html.jsp" %>