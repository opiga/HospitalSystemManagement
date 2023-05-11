
<%@ include file="include/begin-html.jsp" %>

<br>


<%--<fmt:message key="label.title" />--%>
<%--<spring:message code="label.title" text="Default text"/>--%>


<div id="page-content">
    <div class="container text-center">
        <section class="vh-60">
            <div class="container-fluid h-custom">
                <div class="row d-flex justify-content-center align-items-center h-100">

                    <div class="col-md-8 col-lg-6 col-xl-4 offset-xl-1">
                        <sec:authorize access="!isAuthenticated()">
                            <h5><a href="/login" class="text-secondary"><spring:message code="label.signIn"/></a></h5>
                            <h5><a href="/registration" class="text-secondary"><spring:message code="label.registration"/></a></h5>
                        </sec:authorize>

                        <sec:authorize access="isAuthenticated()">
                            <h5><a href="/logout" class="text-secondary"><spring:message code="label.logOut"/></a></h5>
                        </sec:authorize>
                        <h5><a href="${pageContext.request.contextPath}/patients/list"
                               class="text-secondary"><spring:message code="label.viewPatients"/></a></h5>
                        <h5><a href="${pageContext.request.contextPath}/doctors/list"
                               class="text-secondary"><spring:message code="label.viewDoctors"/></a></h5>
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
</div>
</div>
</div>


<%@ include file="include/end-html.jsp" %>

