<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div id="page-content">
    <div class="container text-center">
        <div class="row justify-content-center">
            <div class="col-md-7">
                <h1 class="fw-light mt-4 text-white">${pageContext.request.userPrincipal.name}</h1>
                <sec:authorize access="!isAuthenticated()">
                   <a href="/login" >sign in</a>
                    <br>
                    <a href="/registration">registration</a>
                    <br>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <a href="/logout">log out</a>
                    <br>
                </sec:authorize>
                <a href="/news" >news (for user role)</a>
                <br>
                <a href="${pageContext.request.contextPath}/patients/list" >View Patients(for admin role)</a>
            </div>
        </div>
    </div>
</div>





<%@ include file="include/end-html.jsp" %>

