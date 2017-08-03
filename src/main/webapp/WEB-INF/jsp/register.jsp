<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<html>
<head>
	<title> Tickets PRO | Register</title>
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
	
	</div>
<!-- banner -->
<!-- register -->
		<div class="sign-up-form">
			<div class="container">
				<h3>Register Here</h3>
				<c:url value="/user/register" var="register"/>
				<form:form modelAttribute="newUser" action="${register}"  method="post">

				<div class="sign-up">
					<form:errors path="*" cssClass="alert alert-danger" element="div"/>
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="c">Email Address :</h4>
						</div>
						<div class="sign-up2">
							<form:input id="email" path="email"  type="text" placeholder=" " required=" "/>
						</div>
						<form:errors path="email" cssClass="text-danger"/>
						<div class="clearfix"> </div>

					</div>
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">First Name :</h4>
						</div>
						<div class="sign-up2">
							<form:input id="firstName" path="firstName"  type="text" placeholder=" " required=" "/>
						</div>
						<form:errors path="firstName" cssClass="text-danger"/>
						<div class="clearfix"> </div>
					</div>

					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="a">Last Name :</h4>
						</div>
						<div class="sign-up2">
							<form:input id="lastName" path="lastName"  type="text" placeholder=" " required=" "/>
						</div>
						<form:errors path="lastName" cssClass="text-danger"/>
						<div class="clearfix"> </div>
					</div>

					<h6>Login Information</h6>
					<div class="sign-u">
						<div class="sign-up1">
							<h4 class="d">Password :</h4>
						</div>
						<div class="sign-up2">
							<form:input id="password" path="password"  type="password" placeholder=" " required=" "/>
						</div>
						<form:errors path="password" cssClass="text-danger"/>
						<div class="clearfix"> </div>
					</div>

					<div class="sign-u">
						<div class="sign-up1">
							<h4>Confirm Password :</h4>
						</div>
						<div class="sign-up2">
							<form:input id="matchingPassword" path="matchingPassword"  type="password" placeholder=" " required=" "/>
						</div>
						<form:errors path="matchingPassword" cssClass="text-danger"/>
						<div class="clearfix"> </div>
					</div>

						<input type="submit" value="Submit">

				</div>
				</form:form >
			</div>
		</div>
<!-- //register -->
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>