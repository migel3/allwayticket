<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
    <title> Allway Tickets PRO | Login</title>
    <link href="<spring:url value="/resources/css/bootstrap.css"/>" rel='stylesheet' type='text/css'/>
    <link href="<spring:url value="/resources/css/style.css"/>" rel='stylesheet' type='text/css'/>

    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.8/angular.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.2.8/angular-route.js"></script>


    <script src="<spring:url value="/resources/js/util/bootstrap.js"/>"></script>
    <script src="<spring:url value="/resources/js/app.js"/>"></script>
</head>
<body>
<!-- banner -->
<jsp:include page="fragments/headerBody.jsp"/>
<!-- banner -->
<!-- login-page -->
<div class="login">
    <div class="container">
        <div class="login-grids">
            <div class="col-md-6 log">
                <h3>Login</h3>
                <p>Welcome, please enter the following to continue.</p>
                <p>User login: <b>vasya@yandex.by / 12345678</b></p>

                <p>Admin login: <b>alex@mail.by /  123456</b></p>

                <c:if test="${not empty error}">
                    <div class="alert alert-danger">
                        The username or password you entered is incorrect.<br/>
                    </div>
                </c:if>

                <form:form action="spring_security_check"  method="post">
                    <h5>Email:</h5>
                    <input type="text" name='email' value=""/>
                    <h5>Password:</h5>
                    <input type="password" name='pass' value=""/><br/>

                    <input type="submit" value="Login">

                </form:form >
                <a href="#">Forgot Password ?</a>
            </div>
            <div class="col-md-6 login-right">
                <h3>New Registration</h3>
                <p>By creating an account with our store, you will be able to move through the checkout process faster,
                    store multiple shipping addresses, view and track your orders in your account and more. Bla - bla- bla)</p>
                <a href="<c:url value="user/register" />" class="hvr-bounce-to-bottom button">Create An Account</a>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!-- //login-page -->
<jsp:include page="fragments/footer.jsp"/>

</body>
</html>