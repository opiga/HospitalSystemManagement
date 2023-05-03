<%--<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>--%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ include file="include/begin-html.jsp" %>

<br>
<br>
<section class="vh-100">
    <div class="container h-100">
        <div class="row d-flex justify-content-center align-items-center h-100">
            <div class="col-lg-12 col-xl-11">
                <%--                <div class="card text-black">--%>

                <div class="row justify-content-center">
                    <div class="col-md-10 col-lg-6 col-xl-5 order-2 order-lg-1">
                        <sec:authorize access="isAuthenticated()">
                            <% response.sendRedirect("/"); %>
                        </sec:authorize>
                        <h2 class="form-signin-heading">Please, enter your login and password</h2>
                        <br>
                        <form method="POST" action="/login">
                            <div class="form-group">
<%--                                <label for="login">Login</label>--%>
                                <input name="username" type="text" class="form-control" id="login"
                                       aria-describedby="logindescribe" autofocus="true"
                                       placeholder="Enter login">
                                <small id="logindescribe" class="form-text text-muted">We'll never
                                    share your login with anyone else.</small>
                            </div>
                            <div class="form-group">
<%--                                <label for="exampleInputPassword">Password</label>--%>
                                <input name="password" type="password" class="form-control"
                                       id="exampleInputPassword" placeholder="Password"
                                       autofocus="true">
                            </div>
                            <%--                     <div class="form-group form-check">--%>
                            <%--                       <input type="checkbox" class="form-check-input" id="exampleCheck1">--%>
                            <%--                       <label class="form-check-label" for="exampleCheck1">Check me out</label>--%>
                            <%--                     </div>--%>
                            <button class="btn btn-lg btn-secondary btn-block" type="submit">
                                Log in
                            </button>
                            <br>
                            <p class="small fw-bold ">Don't have an account?
                                <a href="/registration" class="link-danger">Register</a></p>

                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
</div>

<%@ include file="include/end-html.jsp" %>
