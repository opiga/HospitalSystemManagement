<%@ include file="include/begin-html.jsp" %>

<br>
<div id="page-content">
    <div class="container text-center">
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
                    </div>
                </div>
            </div>
        </section>
    </div>
</div>


<%@ include file="include/end-html.jsp" %>

