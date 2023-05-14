<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<link href=https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css
      rel=stylesheet>
<link href=https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.20/css/dataTables.bootstrap4.min.css
      rel=stylesheet>

<div class="p-3 text-center">

    <h1 class="mb-2"><spring:message code="label.hospitalCards"/>, <spring:message code="label.doctor"/> ${doctor.firstName} ${doctor.lastName}
        <%--        <td>${hospitalCard.doctor.firstName} ${hospitalCard.doctor.lastName}--%>
    </h1>
</div>
<div class=container>

    <table class="table table-bordered table-hover table-inverse table-striped"
           id=example>
        <thead>
        <tr>
            <%--            <th class="text-center">id--%>
            <th class="text-center"><spring:message code="label.patient"/>
            <th class="text-center"><spring:message code="label.pDiagnosis"/>
            <th class="text-center"><spring:message code="label.cDiagnosis"/>
            <th class="text-center"><spring:message code="label.fDiagnosis"/>
            <th class="text-center"><spring:message code="label.discharged"/>
            <th class="text-center"><spring:message code="label.actions"/>
        <tbody>
        <c:forEach var="hospitalCard" items="${hospitalCards}">
        <tr>
                <%--            <td>${hospitalCard.hospitalCardId}--%>
            <td>${hospitalCard.patient.firstName} ${hospitalCard.patient.lastName}, <spring:message code="label.dateOfBirth"/>: ${hospitalCard.patient.dateOfBirth}
            <td>${hospitalCard.preliminaryDiagnosis}
            <td>${hospitalCard.clinicalDiagnosis}
            <td>${hospitalCard.finalDiagnosis}
            <td>${hospitalCard.discharged}
            <td class="text-center">
                <a class="btn btn-light"
                   href="${pageContext.request.contextPath}/appointments/addAppointment/${hospitalCard.hospitalCardId}/${hospitalCard.patient.id}/${hospitalCard.doctor.id}"><spring:message code="label.makeAppointment"/></a>
                <a class="btn btn-light"
                   href="${pageContext.request.contextPath}/appointments/listAppointments/${hospitalCard.hospitalCardId}"><spring:message code="label.viewAppointment"/></a>
                </c:forEach>
    </table>
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