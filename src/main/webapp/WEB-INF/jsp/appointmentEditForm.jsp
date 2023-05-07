<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Edit Appointment</h1>
</div>

<div class="container">
    <%--<jsp:useBean id="editedDoctor" scope="request" type="com.sun.org.apache.xml.internal.security.signature.SignatureProperty"/>--%>
    <%--@elvariable id="editedAppointment" type=""--%>
    <form:form action="${pageContext.request.contextPath}/appointments/editsave/${editedDoctor.id}"
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
                <label for="procedures">Procedures</label>
                <form:textarea class="form-control " path="procedures"
                               value="${editedAppointment.procedures}"/>
            </div>
        </div>
        <div class="form-group">
            <label for="medications">Medications</label>
            <form:textarea class="form-control" path="medications"
                           value="${editedAppointment.medications}"/>
        </div>
        <div class="form-group">
            <label for="operations">Operations</label>
            <form:textarea class="form-control" path="operations"
                           value="${editedAppointment.operations}"/>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="date">Date</label>
                <form:input class="form-control" path="date"
                            value="${editedAppointment.date}" type="date"/>
            </div>

            <div class="form-group col-md-4">
                <form:label class="text-center" path="nurse">Nurse:</form:label>
                <form:select class="form-control" path="nurse.id">
                    <form:option value="" label="Choose a nurse" disabled="false"/>
                    <form:options items="${nurses}" itemValue="id"
                                  itemLabel="fullName"/>
                </form:select>
            </div>

            <div class="form-group col-md-2">

                <form:label class="text-center" path="status">Status:</form:label>
                <form:select class="form-control" path="status">
                    <form:option value="" label="Choose a status" disabled="false"/>
                    <form:option value="appointed">appointed</form:option>
                    <form:option value="completed">completed</form:option>
                    <form:option value="canceled">canceled</form:option>
                </form:select>
            </div>
        </div>
        <button type="submit" class="btn btn-secondary" value="Save Changes">Save Changes</button>
    </form:form>
</div>

<%@ include file="include/end-html.jsp" %>