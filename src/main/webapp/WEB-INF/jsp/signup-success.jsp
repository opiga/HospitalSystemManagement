<%@ page language="java" pageEncoding="UTF-8" %>
<%@ include file="include/begin-html.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<br>

<div id="page-content">
    <div class="container text-center">
        <h1><spring:message code="label.signUpSuccessfull"/></h1>
        <section class="vh-60">
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100">
                    <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                        <sec:authorize access="!isAuthenticated()">
                            <h5>
                                <a href="/login" class="text-secondary">
                                    <spring:message code="label.signIn"/>
                                </a>
                            </h5>
                            <h5>
                                <a href="/registration" class="text-secondary">
                                    <spring:message code="label.registration"/>
                                </a>
                            </h5>
                        </sec:authorize>

                        <sec:authorize access="isAuthenticated()">
                            <h5>
                                <a href="/logout" class="text-secondary">
                                    <spring:message code="label.logOut"/>
                                </a>
                            </h5>
                        </sec:authorize>
                        <h5>
                            <a href="${pageContext.request.contextPath}/patients/list"
                               class="text-secondary">
                                <spring:message code="label.viewPatients"/>
                            </a>
                        </h5>
                        <h5>
                            <a href="${pageContext.request.contextPath}/doctors/list"
                               class="text-secondary">
                                <spring:message code="label.viewDoctors"/>
                            </a>
                        </h5>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<%@ include file="include/end-html.jsp" %>
<html>
