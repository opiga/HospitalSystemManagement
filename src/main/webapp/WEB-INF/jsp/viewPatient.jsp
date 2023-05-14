<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<link href=https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css
      rel=stylesheet>
<link href=https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.20/css/dataTables.bootstrap4.min.css
      rel=stylesheet>
<div class="p-3 text-center">
    <h1 class="mb-2"><spring:message code="label.viewPatients"/></h1>
</div>
<div class=container>
    <table class="table table-bordered table-hover table-inverse table-striped"
           id=example>
        <thead>
        <tr>
            <th class="text-center"><spring:message code="label.firstName"/>
            <th class="text-center"><spring:message code="label.lastName"/>
            <th class="text-center"><spring:message code="label.dateOfBirth"/>
            <th class="text-center"><spring:message code="label.email"/>
            <th class="text-center"><spring:message code="label.phoneNumber"/>
            <th class="text-center"><spring:message code="label.address"/>
                <%--            <th class="text-center">Opened Cards--%>
            <th class="text-center"><spring:message code="label.actions"/>

        <tbody>
        <c:forEach var="patient" items="${patients}">
        <tr>
            <td>${patient.first_Name}
            <td>${patient.last_Name}
            <td>${patient.date_Of_Birth}
            <td>${patient.email}
            <td>${patient.phone_Number}
            <td>${patient.address}
                    <%--            <td>${patient.number_Of_Hospital_Cards}--%>
            <td class="text-center"><a class="btn btn-light"
                                       href="${pageContext.request.contextPath}/patients/editpatient/${patient.id}"><spring:message code="label.edit"/></a>

                <c:if test="${patient.number_Of_Hospital_Cards == 0}">
                <a class="btn btn-light"
                   href="${pageContext.request.contextPath}/hospitalcards/addhospitalcard/${patient.id}">
                    <spring:message code="label.addHospitalCard"/></a>
                </c:if>
                <c:if test="${patient.number_Of_Hospital_Cards > 0}">
                <a class="btn btn-light"
                   href="${pageContext.request.contextPath}/hospitalcards/list/${patient.id}">
                    <spring:message code="label.openCards"/>
                </a>
                </c:if>

                </c:forEach>
    </table>
    <br>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/patients/addpatient"> <spring:message code="label.addPatient"/></a>
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