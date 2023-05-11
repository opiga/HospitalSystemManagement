<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<fmt:setBundle basename="messages"/>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" pageEncoding="UTF-8" %>
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
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">Home</a>
        <div class="collapse navbar-collapse" id="exCollapsingNavbar">
            <ul class="nav navbar-nav">
                <li class="nav-item"><a href="${pageContext.request.contextPath}/patients/list"
                                        class="nav-link">Patients</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/doctors/list"
                                        class="nav-link">Doctors</a></li>
                <li class="nav-item"><a href="${pageContext.request.contextPath}/appointments/list"
                                        class="nav-link">Hospital Cards</a></li>
                <li class="nav-item"><a href="#" class="nav-link">Contacts</a></li>

            </ul>

            <%--            <ul class="nav navbar-nav flex-row justify-content-between ml-auto">--%>
            <%--                <li class="nav-item order-2 order-md-1"><a href="#" class="nav-link"--%>
            <%--                                                           title="settings"><i--%>
            <%--                        class="fa fa-cog fa-fw fa-lg"></i></a></li>--%>

            <%-- Если пользователь залогирован, то показываем его имя и кнопку "Logout" --%>
            <%-- Если пользователь не залогирован, то показываем кнопку "Login" --%>
            <ul class="nav navbar-nav flex-row justify-content-between ml-auto">
                <%--                    <div class="dropdown">--%>
                <%--                        <button class="btn btn-default dropdown-toggle" type="button" data-toggle="dropdown">--%>
                <%--                            <span th:text="#{lang.change}"></span>--%>
                <%--                            <span class="caret"></span>--%>
                <%--                        </button>--%>
                <%--                        <ul class="dropdown-menu">--%>
                <%--                            <li><a href="#" th:href="@{/changeLocale('en')}"><spring:message code="lang.eng"/></a></li>--%>
                <%--                            <li><a href="#" th:href="@{/changeLocale('ru')}"><spring:message code="lang.ru"/></a></li>--%>
                <%--                        </ul>--%>
                <%--                    </div>--%>


                <% if (request.getUserPrincipal() != null) { %>
                <li class="nav-item order-2 order-md-1">
                        <span class="navbar-text text-white mx-3">
                            Welcome, <%= request.getUserPrincipal().getName() %> !
                        </span>
                </li>

                <li class="nav-item order-2">
                    <form method="POST" action="/logout" class="form-inline">
                        <%--                            <button type="submit" class="btn btn-outline-dark my-2 my-sm-0">Logout</button>--%>
                        <button type="submit" class="btn btn-dark">Logout</button>
                    </form>
                </li>
                <% }
                else { %>
                    <li class="nav-item"><a href="?lang=en" class="nav-link">English </a></li>
                    <li class="nav-item"><a href="?lang=ru" class="nav-link">Russian </a></li>
                    <li class="nav-item"><a href="${pageContext.request.contextPath}/login"
                                            class="nav-link"><spring:message
                            code="label.signIn"/></a></li>

                <%--                <li class="dropdown order-2">--%>

                <%--                    <button type="button"--%>
                <%--                            class="btn btn-dark dropdown-toggle">Login--%>
                <%--                    </button>--%>
                <%--                    <sec:authorize access="isAuthenticated()">--%>
                <%--                        <% response.sendRedirect("/"); %>--%>
                <%--                    </sec:authorize>--%>
                <%--                    <form class="dropdown-menu p-4" method="POST" action="/login">--%>
                <%--                        <div class="form-group">--%>
                <%--                            <label for="exampleDropdownFormLogin2">Login</label>--%>
                <%--                            <input name="username" type="text" class="form-control"--%>
                <%--                                   id="exampleDropdownFormLogin2" placeholder="Enter login">--%>
                <%--                        </div>--%>
                <%--                        <div class="form-group">--%>
                <%--                            <label for="exampleDropdownFormPassword2">Password</label>--%>
                <%--                            <input name="password" type="password" class="form-control"--%>
                <%--                                   id="exampleDropdownFormPassword2" placeholder="Password">--%>
                <%--                        </div>--%>
                <%--                <button type="submit" class="btn btn-dark">Log in</button>--%>

                </form>
                <%--                </li>--%>
                <% } %>
            </ul>
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