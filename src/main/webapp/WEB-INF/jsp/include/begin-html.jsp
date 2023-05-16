<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">

</head>
<body class="d-flex flex-column">
<nav class="navbar navbar-expand-sm bg-dark navbar-dark" role="navigation">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">
            <spring:message code="label.homePage"/>
        </a>
        <div class="collapse navbar-collapse" id="mainNavbar">

            <div class="collapse navbar-collapse" id="exCollapsingNavbar">
                <ul class="nav navbar-nav">
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/patients/list" class="nav-link">
                            <spring:message code="label.patients"/>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/doctors/list" class="nav-link">
                            <spring:message code="label.doctors"/>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/nurses/list" class="nav-link">
                            <spring:message code="label.nurses"/>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/appointments/list"
                           class="nav-link">
                            <spring:message code="label.hospitalCards"/>
                        </a>
                    </li>
                </ul>


                <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
                    <% if (request.getUserPrincipal() != null) { %>
                    <li class=" nav-item order-2 order-md-1 ">
                            <span class="navbar-text text-white mx-3"><spring:message code="label.welcome"/>, <%= request.getUserPrincipal().getName()%> !</span>
                    </li>
                    <li class="nav-item order-2">
                        <form method="POST" action="/logout" class="form-inline">
                            <button type="submit" class="btn btn-dark"><spring:message code="label.logOut"/></button>
                        </form>
                    </li>
                    <% }
                    else { %>
                    <li class="nav-item">
                        <a href="${pageContext.request.contextPath}/login" class="nav-link">
                            <spring:message code="label.signIn"/>
                        </a>
                    </li>
                    </form>
                    <% } %>
                </ul>


            </div>
            <div class="dropdown">
                <button class="btn btn-dark dropdown-toggle" type="button"
                        id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true"
                        aria-expanded="false">
                    <c:if test="${not empty pageContext.request.getAttribute('lang')}">
                        <spring:message
                                code="label.${pageContext.request.getAttribute('lang')}"/>
                    </c:if>
                    <c:if test="${empty pageContext.request.getAttribute('lang') and not empty cookie['localeInfo']}">
                        <spring:message code="label.${cookie.get('localeInfo').value}"/>
                    </c:if>
                    <c:if test="${empty pageContext.request.getAttribute('lang') and empty cookie['localeInfo']}">
                        <spring:message code="label.en"/>
                    </c:if>
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <li>
                        <a class="dropdown-item" href="/lang?lang=en">
                            <spring:message code="label.en"/>
                        </a>
                    </li>
                    <li>
                        <a class="dropdown-item" href="/lang?lang=ru">
                            <spring:message code="label.ru"/>
                        </a>
                    </li>
                </div>
            </div>
        </div>
    </div>
</nav>
<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous">
</script>

<!-- Popper -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous">
</script>

<!-- Latest compiled and minified Bootstrap JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous">
</script>