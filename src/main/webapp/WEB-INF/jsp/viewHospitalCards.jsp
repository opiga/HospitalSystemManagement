<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>

<link href=https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css
      rel=stylesheet>
<link href=https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.20/css/dataTables.bootstrap4.min.css
      rel=stylesheet>

<div class="p-3 text-center">
    <h1 class="mb-2"><spring:message code="label.hospitalCards"/>
        <br>
        ${hospitalCardPatient.firstName} ${hospitalCardPatient.lastName}
        <spring:message code="label.age.start"/> ${age} <spring:message code="label.age.end"/>
    </h1>
</div>
<div class=container>
    <table class="table table-bordered table-hover table-inverse table-striped"
           id=example>
        <thead>
        <tr>
            <th class="text-center"><spring:message code="label.pDiagnosis"/></th>
            <th class="text-center"><spring:message code="label.cDiagnosis"/></th>
            <th class="text-center"><spring:message code="label.fDiagnosis"/></th>
            <th class="text-center"><spring:message code="label.discharged"/></th>
            <th class="text-center"><spring:message code="label.doctor"/></th>
            <th class="text-center"><spring:message code="label.category"/></th>
            <th class="text-center"><spring:message code="label.nurse"/></th>
            <th class="text-center"><spring:message code="label.actions"/></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="hospitalCard" items="${hospitalCards}">
            <tr>
                <td>${hospitalCard.preliminaryDiagnosis}
                <td>${hospitalCard.clinicalDiagnosis}
                <td>${hospitalCard.finalDiagnosis}
                <td>${hospitalCard.discharged}
                <td>${hospitalCard.doctor.firstName} ${hospitalCard.doctor.lastName}
                <td>${hospitalCard.doctor.category.nameCategory}
                <td>${hospitalCard.nurse.firstName} ${hospitalCard.nurse.lastName}
                <td class="text-center">
                    <a class="btn btn-light"
                       href="${pageContext.request.contextPath}/hospitalcards/edit/${hospitalCard.hospitalCardId}">
                        <spring:message code="label.edit"/>
                    </a>
                <td/>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <br>
    <a class="btn btn-secondary"
       href="${pageContext.request.contextPath}/hospitalcards/add/${hospitalCardPatient.id}">
        <spring:message code="label.addHospitalCard"/>
    </a>
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