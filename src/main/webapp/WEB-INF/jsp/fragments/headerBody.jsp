<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="banner">
       <div class="header">
        <div class="header-top">
            <div class="container">
                <div class="logo">

                    <h1><a href="<spring:url value="/"/>">Allway Tickets PRO</a></h1>
                </div>
                <security:authorize access="!isAnonymous()">
                    <div class="logout">
                        <security:authentication property="principal.username"/>
                        <c:url value="/spring_security_logout" var="logoutUrl" />
                        <form:form class="navbar-form navbar-right" action="${logoutUrl}" method="post">
                        <input type="submit" class="btn btn-danger btn-mini pull-right" value="logout">
                        </form:form>
                        <%--<a href="${logoutUrl}" class="btn btn-danger btn-mini pull-right">logout</a>--%>
                    </div>
                </security:authorize>
                <div class="reserv">
                    <security:authorize access="isAnonymous()">
                        <a href="<spring:url value="/login"/>">Sign Up</a>
                    </security:authorize>
                </div>
                <div class="clearfix"></div>

            </div>

        </div>
        <div class="container">
            <div class="header-bottom">
                <nav class="navbar navbar-default" role="navigation">
                    <div class="navbar-header">
                        <button type="button" class="navbar-toggle" data-toggle="collapse"
                                data-target="#bs-example-navbar-collapse-1">
                            <span class="sr-only">Toggle navigation</span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                            <span class="icon-bar"></span>
                        </button>
                    </div>
                    <!--/.navbar-header-->
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav">
                            <li ><a href="<c:url value="/"/>">Home</a></li>
                            <li ><a href="<c:url value="/trains"/>">Trains</a></li>
                            <li><a href="<c:url value="/bus"/>">Bus</a></li>
                            <li><a href="<c:url value="/air"/>">Airplane</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</div>