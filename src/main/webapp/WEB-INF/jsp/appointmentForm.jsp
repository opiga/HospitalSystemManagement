<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2">Add new appointment</h1>
</div>
<div class="container">
        <%--@elvariable id="appointment" type=""--%>
        <form:form action="${pageContext.request.contextPath}/appointments/addAppointment"
                   method="post"
                   modelAttribute="appointment">
        <div class="form-row">
            <div class="form-group col-md-12">
                <form:hidden path="patient"/>
               <form:hidden path="doctor"/>
                <form:hidden path="hospitalCard"/>
                <form:hidden path="status" value="appointed"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12">
                <form:label class="text-center"
                            path="procedures">Procedures:</form:label>
                <form:textarea path="procedures" class="form-control"/>
            </div>
            <div class="form-group col-md-12">
                <form:label class="text-center"
                            path="medications">Medications:</form:label>
                <form:textarea path="medications" class="form-control"/>
            </div>
            <div class="form-group col-md-12">
                <form:label class="text-center" path="operations">Operations:</form:label>
                <form:textarea path="operations" class="form-control"/>
            </div>
        </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <form:label class="text-center"
                                path="date">Appointment date:</form:label>
                    <form:input path="date" class="form-control" type="date"/>
                </div>

            <div class="form-group col-md-6">
                <form:label class="text-center" path="nurse">Nurse:</form:label>
                <form:select class="form-control" path="nurse">
                    <form:option value="" label="Choose a nurse" disabled="false"/>
                    <form:options items="${nurses}" itemValue="id"
                                  itemLabel="fullName"/>
                </form:select>
            </div>
            </div>

            <button type="submit" class="btn btn-secondary" value="Save Changes">Save Changes
            </button>
            </form:form>

    </div>
<%@ include file="include/end-html.jsp" %>