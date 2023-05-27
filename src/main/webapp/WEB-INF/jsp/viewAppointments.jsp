<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>

<link href=https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css
      rel=stylesheet>
<link href=https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.20/css/dataTables.bootstrap4.min.css
      rel=stylesheet>
<div class="p-3 text-center">
    <h1 class="mb-2"><spring:message code="label.appointments"/></h1>
</div>
<div class="container">
    <table class="table table-responsive table-bordered table-hover table-inverse table-striped"
           id=example>
        <thead>
        <tr>
            <th class="text-center"><spring:message code="label.patient"/></th>
            <th class="text-center"><spring:message code="label.procedures"/></th>
            <th class="text-center"><spring:message code="label.medications"/></th>
            <th class="text-center"><spring:message code="label.operations"/></th>
            <th class="text-center"><spring:message code="label.date"/></th>
            <th class="text-center"><spring:message code="label.status"/></th>
            <th class="text-center"><spring:message code="label.nurse"/></th>
            <th class="text-center"><spring:message code="label.doctor"/></th>
            <th class="text-center"><spring:message code="label.actions"/></th>
        <tbody>
        <c:forEach var="appointment" items="${appointments}">
            <tr>
                <td>${appointment.patient.firstName} ${appointment.patient.lastName},
                        <spring:message
                                code="label.dateOfBirth"/>: ${appointment.patient.dateOfBirth}
                <td>${appointment.procedures}
                <td>${appointment.medications}
                <td>${appointment.operations}
                <td>${appointment.date}
                <td>${appointment.status}
                <td>${appointment.nurse.firstName} ${appointment.nurse.lastName}
                <td>${appointment.doctor.firstName} ${appointment.doctor.lastName}, ${appointment.doctor.category.nameCategory}
                <td class="text-center">
                    <a class="btn btn-light"
                       href="${pageContext.request.contextPath}/appointments/editAppointment/${appointment.id}">Edit</a>

                    <a class="btn btn-light"
                       href="${pageContext.request.contextPath}/appointments/addAppointment/${appointment.hospitalCard.hospitalCardId}/${appointment.patient.id}/${appointment.doctor.id}/${appointment.nurse.id}"><spring:message
                            code="label.makeAppointment"/></a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <br>
    <a class="btn btn-secondary"
       href="${pageContext.request.contextPath}/appointments/list">
        <spring:message code="label.returnToHospitalCards"/></a>
</div>
<br>
<br>
<br>
<script src=https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.min.js></script>
<script src=https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.20/js/jquery.dataTables.min.js></script>
<script src=https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.20/js/dataTables.bootstrap4.min.js></script>
<script>$(document).ready(function () {
    $('#example').DataTable();
});</script>

<%@ include file="include/end-html.jsp" %>