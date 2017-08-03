<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<html>
<head>
    <title>Allway Tickets PRO | Air</title>
    <link href="<spring:url value="/resources/css/bootstrap.css"/>" rel='stylesheet' type='text/css'/>
    <link href="<spring:url value="/resources/css/jquery-ui.min.css"/>" rel='stylesheet' type='text/css'/>
    <link href="<spring:url value="/resources/css/style.css"/>" rel='stylesheet' type='text/css'/>

</head>
<body>
<jsp:include page="fragments/headerBody.jsp"/>
<div class="pic">
    <p class="mockText">Page in development...</p>
    <img src="<spring:url value="/resources/images/949331151.gif"/>" width="100" height="142"/>

</div>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
