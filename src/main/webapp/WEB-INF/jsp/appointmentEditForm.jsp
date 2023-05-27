<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Edit Appointment</h1>
</div>
<style>.error {
    color: red;
}</style>
<div class="container">
    <%--<jsp:useBean id="editedDoctor" scope="request" type="com.sun.org.apache.xml.internal.security.signature.SignatureProperty"/>--%>
    <%--@elvariable id="editedAppointment" type=""--%>
    <form:form action="${pageContext.request.contextPath}/appointments/editsave"
               method="post"
               modelAttribute="editedAppointment">
        <div class="form-row">
            <div class="form-group col-md-12">
                <form:hidden path="id"/>
                <form:hidden path="patient"/>
                <form:hidden path="doctor"/>
                <form:hidden path="hospitalCard"/>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-12">
                <label for="procedures"><spring:message code="label.procedures"/></label>
                <form:textarea class="form-control " path="procedures"
                               value="${editedAppointment.procedures}"/>
                <form:errors path="procedures" cssClass="error"/>
            </div>
        </div>
        <div class="form-group">
            <label for="medications"><spring:message code="label.medications"/></label>
            <form:textarea class="form-control" path="medications"
                           value="${editedAppointment.medications}"/>
            <form:errors path="medications" cssClass="error"/>
        </div>
        <div class="form-group">
            <label for="operations"><spring:message code="label.operations"/></label>
            <form:textarea class="form-control" path="operations"
                           value="${editedAppointment.operations}"/>
            <form:errors path="operations" cssClass="error"/>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="date"><spring:message code="label.date"/></label>
                <form:input class="form-control" path="date"
                            value="${editedAppointment.date}" type="date"/>
                <form:errors path="date" cssClass="error"/>
            </div>

            <div class="form-group col-md-4">
                <form:label class="text-center" path="nurse"><spring:message
                        code="label.nurse"/>:</form:label>
                <form:select class="form-control" path="nurse.id">
                    <form:option value="" label="Choose a nurse" disabled="false"/>
                    <form:options items="${nurses}" itemValue="id"
                                  itemLabel="fullName"/>
                </form:select>
                <form:errors path="nurse" cssClass="error"/>
            </div>

            <div class="form-group col-md-2">
                <form:label class="text-center" path="status"><spring:message code="label.status"/>:</form:label>
                <form:select class="form-control" path="status">
                    <form:option value="" label="Choose a status" disabled="false"/>
                    <form:option value="appointed"><spring:message
                            code="label.appointed"/></form:option>
                    <form:option value="completed"><spring:message
                            code="label.completed"/></form:option>
                    <form:option value="canceled"><spring:message
                            code="label.canceled"/></form:option>
                </form:select>
            </div>
        </div>
        <button type="submit" class="btn btn-secondary" value="Save Changes"><spring:message
                code="label.save"/></button>
    </form:form>
</div>

<%@ include file="include/end-html.jsp" %>