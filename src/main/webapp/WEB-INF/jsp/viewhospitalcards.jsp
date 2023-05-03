<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="include/begin-html.jsp" %>
<link href=https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.0/css/bootstrap.min.css
      rel=stylesheet>
<link href=https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.20/css/dataTables.bootstrap4.min.css
      rel=stylesheet>

<div class="p-3 text-center">

    <h1 class="mb-2">Hospital cards
        <br>
        ${hospitalCardPatient.firstName} ${hospitalCardPatient.lastName}
       is ${age} years old
    </h1>
</div>
<div class=container>

    <table class="table table-bordered table-hover table-inverse table-striped"
           id=example>
        <thead>
        <tr>
            <th class="text-center">id
            <th class="text-center">diagnosis
            <th class="text-center">discharged
            <th class="text-center">doctor
            <th class="text-center">doctor category
            <th class="text-center">Actions
                <%--        <tfoot>--%>
                <%--        <tr>--%>
                <%--            <th class="text-center">id--%>
                <%--            <th class="text-center">diagnosis--%>
                <%--            <th class="text-center">discharged--%>
                <%--            <th class="text-center">doctor--%>
                <%--            <th class="text-center">Actions--%>
        <tbody>
        <c:forEach var="hospitalCard" items="${hospitalCards}">
        <tr>
            <td>${hospitalCard.hospitalCardId}
            <td>${hospitalCard.diagnosis}
            <td>${hospitalCard.discharged}
            <td>${hospitalCard.doctor.firstName} ${hospitalCard.doctor.lastName}
            <td>${hospitalCard.doctor.category.nameCategory}
            <td class="text-center">
            <a class="btn btn-secondary"
                                       href="${pageContext.request.contextPath}/hospitalcards/edit/${hospitalCard.hospitalCardId}">Edit</a>
            </c:forEach>
    </table>

    <br>
    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/patients/addpatient">Add
        new
        patient</a>
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