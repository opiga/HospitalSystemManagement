
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="include/begin-html.jsp" %>
<link href=https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css
      rel=stylesheet>
<link href=https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.20/css/dataTables.bootstrap4.min.css
      rel=stylesheet>
<div class="p-3 text-center">
    <h1 class="mb-2">Doctors List</h1>
</div>
<div class=container>
    <table class="table table-bordered table-hover table-inverse table-striped"
           id=example >
        <thead>
        <tr>
            <th class="text-center">doctorId
            <th class="text-center">firstName
            <th class="text-center">lastName
            <th class="text-center">category
            <th class="text-center">number of Patients
            <th class="text-center">Actions
        <tfoot>
        <tr>
            <th class="text-center">doctorId
            <th class="text-center">firstName
            <th class="text-center">lastName
            <th class="text-center">category
            <th class="text-center">number of Patients
            <th class="text-center">Actions
        <tbody>
            <c:forEach var="doctor" items="${doctors}">
        <tr>
            <th scope="row">${doctor.doctorId}
            <td>${doctor.firstName}
            <td>${doctor.lastName}
            <td>${doctor.category.nameCategory}
            <td>${doctor.patients.size()}
            <td><a class="btn btn-secondary"
                   href="${pageContext.request.contextPath}/doctors/editdoctor/${doctor.doctorId}">Edit</a>
           <a class="btn btn-secondary"
                   href="${pageContext.request.contextPath}/doctors/delete/${doctor.doctorId}">Delete</a>
        </c:forEach>

    </table>
    <br>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/doctors/adddoctor">Add new
        doctor</a>
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