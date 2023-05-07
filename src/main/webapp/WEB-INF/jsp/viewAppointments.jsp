<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<link href=https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css
      rel=stylesheet>
<link href=https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.20/css/dataTables.bootstrap4.min.css
      rel=stylesheet>
<div class="p-3 text-center">
    <h1 class="mb-2">Appointments</h1>
</div>
<div class=container>
    <table class="table table-bordered table-hover table-inverse table-striped"
           id=example>
        <thead>
        <tr>
            <th class="text-center">Patient
            <th class="text-center">Procedures
            <th class="text-center">Medications
            <th class="text-center">Operations
            <th class="text-center">Date
            <th class="text-center">Status
            <th class="text-center">Nurse
            <th class="text-center">Doctor
                <%--            <th class="text-center">Opened Cards--%>
            <th class="text-center">Actions

        <tbody>
        <c:forEach var="appointment" items="${appointments}">
        <tr>
            <td>${appointment.patient.firstName} ${appointment.patient.lastName}, date of birth: ${appointment.patient.dateOfBirth}
            <td>${appointment.procedures}
            <td>${appointment.medications}
            <td>${appointment.operations}
            <td>${appointment.date}
            <td>${appointment.status}
            <td>${appointment.nurse.firstName} ${appointment.doctor.lastName}
            <td>${appointment.doctor.firstName} ${appointment.doctor.lastName}, ${appointment.doctor.category.nameCategory}
                    <%--            <td>${patient.number_Of_Hospital_Cards}--%>
            <td class="text-center">
            <a class="btn btn-light"
               href="${pageContext.request.contextPath}/appointments/editAppointment/${appointment.id}">Edit</a>

            <a class="btn btn-light"
               href="${pageContext.request.contextPath}/appointments/addAppointment/${appointment.hospitalCard.hospitalCardId}/${appointment.patient.id}/${appointment.doctor.id}">Make appointment</a>
<%--                <c:if test="${patient.number_Of_Hospital_Cards == 0}">--%>
<%--                <a class="btn btn-light"--%>
<%--                   href="${pageContext.request.contextPath}/hospitalcards/addhospitalcard/${patient.id}">--%>
<%--                    Add New Hospital Card</a>--%>
<%--                </c:if>--%>
<%--                <c:if test="${patient.number_Of_Hospital_Cards > 0}">--%>
<%--                <a class="btn btn-light"--%>
<%--                   href="${pageContext.request.contextPath}/hospitalcards/list/${patient.id}">--%>
<%--                    Open Cards--%>
<%--                </a>--%>
<%--                </c:if>--%>

                </c:forEach>
    </table>
    <br>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/appointments/list">Return to Hospital Cards</a>
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