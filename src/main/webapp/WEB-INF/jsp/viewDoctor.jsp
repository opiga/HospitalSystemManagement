<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<link href=https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css
      rel=stylesheet>
<link href=https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.20/css/dataTables.bootstrap4.min.css
      rel=stylesheet>
<div class="p-3 text-center">
    <h1 class="mb-2"><spring:message code="label.viewDoctors"/></h1>
</div>
<div class=container>
    <table class="table table-bordered table-hover table-inverse table-striped"
           id=example>
        <thead>
        <tr>

<%--            <th class="text-center">id--%>
            <th class="text-center"><spring:message code="label.firstName"/>
            <th class="text-center"><spring:message code="label.lastName"/>
            <th class="text-center"><spring:message code="label.email"/>
            <th class="text-center"><spring:message code="label.phoneNumber"/>
            <th class="text-center"><spring:message code="label.category"/>
            <th class="text-center"><spring:message code="label.numberOfPatients"/>
            <th class="text-center"><spring:message code="label.actions"/>
        <tbody>
        <c:forEach var="doctor" items="${doctors}">
        <tr>
<%--            <td>${doctor.id}</td>--%>
            <td>${doctor.first_Name}</td>
            <td>${doctor.last_Name}</td>
            <td>${doctor.email}</td>
            <td>${doctor.phone_Number}</td>
            <td>${doctor.name_Category}</td>
            <td>${doctor.number_Of_Patients}</td>

        <td><a class="btn btn-light"
               href="${pageContext.request.contextPath}/doctors/editdoctor/${doctor.id}"><spring:message code="label.edit"/></a>
            <a class="btn btn-light"
               href="${pageContext.request.contextPath}/doctors/delete/${doctor.id}"><spring:message code="label.delete"/></a>
            </c:forEach>

    </table>
    <br>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/doctors/adddoctor"><spring:message code="label.addDoctor"/></a>
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