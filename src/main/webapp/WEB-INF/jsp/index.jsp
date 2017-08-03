
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Allway Tickets PRO | Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <link href="<spring:url value="/resources/bower_components/bootstrap/dist/css/bootstrap.css"/>" rel='stylesheet' type='text/css'/>
    <link href="<spring:url value="/resources/css/style.css"/>" rel='stylesheet' type='text/css'/>


    <script src="<spring:url value="/resources/js/util/bootstrap.js"/>"></script>


</head>
<body>
<jsp:include page="fragments/headerBody.jsp"/>


<div class="jumbotron">
    <div class="col-md-12 ">
    <div class="container ">


        <p>Technology stack: <a href="http://projects.spring.io/spring-security/">Spring Security</a>,
            <a href="http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html">Spring MVC</a>,
            <a href="http://projects.spring.io/spring-data-jpa/">Spring Data JPA</a>,
            <a href="http://spring.io/blog/2014/05/07/preview-spring-security-test-method-security">Spring MVC
                Test</a>,
            <a href="http://hibernate.org/orm/">Hibernate ORM</a>,
            <a href="http://hibernate.org/validator/">Hibernate Validator</a>,
            <a href="http://www.slf4j.org/">SLF4J</a>,
            <a href="https://github.com/FasterXML/jackson">Json Jackson</a>,
            <a href="http://ru.wikipedia.org/wiki/JSP">JSP</a>,
            <a href="http://en.wikipedia.org/wiki/JavaServer_Pages_Standard_Tag_Library">JSTL</a>,
            <a href="http://tomcat.apache.org/">Apache Tomcat</a>,
            <a href="http://www.postgresql.org/">PostgreSQL</a>,
            <a href="http://junit.org/">JUnit</a>,
            <a href="http://hamcrest.org/JavaHamcrest/">Hamcrest</a>,
            <a href="https://angularjs.org/">AngularJS</a>,
            <a href="http://getbootstrap.com/">Bootstrap</a>.</p>
    </div>
</div>
<div class="container">
    <div class="lead">

        &nbsp;&nbsp;&nbsp;Приложение с регистрацией/авторизацией пользователя и интерфейсом на основе ролей (ROLE_USER, ROLE_ADMIN).
        Приложение позволяет искать расписание поездов по маршруту и по станции, используя запросы по AJAX и AngularJS.
        Фильтрация данных по дате и времени отправления поездов. Просмотр расписания поезда по станциям.
        REST интерфейс покрывается JUnit тестами, используя Spring MVC Test

    </div>
</div>
</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
