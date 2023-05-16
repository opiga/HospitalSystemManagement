<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<div class="p-3 text-center">
    <h1 class="mb-2"><spring:message code="label.addAppointment"/></h1>
</div>
<style>.error {
    color: red;
}</style>
<div class="container">
        <%--@elvariable id="appointment" type=""--%>
        <form:form action="${pageContext.request.contextPath}/appointments/addAppointment"
                   method="post"
                   modelAttribute="appointment">
        <div class="form-row">
            <div class="form-group col-md-12">
                <form:hidden path="patient"/>
                <form:hidden path="nurse"/>
                <form:hidden path="hospitalCard"/>
                <form:hidden path="status" value="appointed"/>
            </div>
        </div>

        <div class="form-row">
            <div class="form-group col-md-12">
                <form:label class="text-center"
                            path="procedures"><spring:message code="label.procedures"/>:</form:label>
                <form:textarea path="procedures" class="form-control"/>
                <form:errors path="procedures" cssClass="error"/>
            </div>
            <div class="form-group col-md-12">
                <form:label class="text-center"
                            path="medications"><spring:message code="label.medications"/>:</form:label>
                <form:textarea path="medications" class="form-control"/>
                <form:errors path="medications" cssClass="error"/>
            </div>
        </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <form:label class="text-center"
                                path="date"><spring:message code="label.appointmentDate"/>:</form:label>
                    <form:input path="date" class="form-control" type="date"/>
                    <form:errors path="date" cssClass="error"/>
                </div>
            </div>

            <button type="submit" class="btn btn-secondary" value="Save Changes"><spring:message code="label.save"/>
            </button>
            </form:form>

    </div>
<%@ include file="include/end-html.jsp" %>