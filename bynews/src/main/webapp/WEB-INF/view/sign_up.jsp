<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/bynews_css.css'/>" />
</head>
<body>
	<header>
		<div class="header logo">
 			<img src="<c:url value='/resources/img/bynews.png'/>" alt="Logo">
		</div>
	
		<div class="header service-nav">
			<div class="local-div">
				<nav class="nav local-nav">
					<ul>
						<li><a href="${pageContext.request.contextPath}/signup?lang=en">EN</a></li>
						<li><a href="${pageContext.request.contextPath}/signup?lang=ru">RU</a></li>
					</ul>
				</nav>
			</div>
			
			<div class="authorization-div">
				<nav class="nav authorization-nav">
					<ul>
						<li><a href="${pageContext.request.contextPath}/login"><spring:message code="home.start.nav.signin" /></a></li>
						<li><a href="${pageContext.request.contextPath}/signup"><spring:message code="home.start.nav.registration" /></a></li>
					</ul>
				</nav>
			</div>
		</div>
	
		<nav class="nav main-nav">
			<ul>
				<li><a href="${pageContext.request.contextPath}/"><spring:message code="home.start.mainnav.home" /></a></li>
				<li><spring:message code="home.start.mainnav.menu1" /></li>
				<li><spring:message code="home.start.mainnav.menu2" /></li>
				<li><spring:message code="home.start.mainnav.menu3" /></li>
			</ul>
		</nav>
	</header>
	
	<br />
	<hr />
	<br />
	<br />

	<div class="body-div">
		<div class="container">
			<div class="inside_sign">

				<form:form action="${pageContext.request.contextPath}/signup" modelAttribute="appUser">
					<table class="table_register table_form">
						<tr>
							<td><div class="table_td"><spring:message code="register.email" />:</div></td>
							<td>
								<div class="table_td"><form:input path="email" placeholder="Alexander_III@gmail.com" /></div>
							</td>
						</tr>
						<tr>
							<td><div class="table_td"><spring:message code="register.pwd" />:</div></td>
							<td>
								<div class="table_td"><form:password path="password" placeholder="***********" /></div>
							</td>
						</tr>
						<tr>
							<td><div class="table_td"><spring:message code="register.pwdConfirm" />:</div></td>
							<td>
								<div class="table_td"><form:password path="pwdConfirm" placeholder="***********" /></div>
							</td>
						</tr>
						<tr>
							<td><div class="table_td"><spring:message code="register.name" />:</div></td>
							<td>
								<div class="table_td"><form:input path="name" placeholder="Alexander_III" /></div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<div><input class="button" type="submit" value=<spring:message code="register.button.register" /> /></div>
							</td>
						</tr>
					</table>
				</form:form>
				
			</div>
		</div>
	</div>
	
	<div class="error_messages">
		<br />
		<c:if test="${not empty message}">
			<br />
			<h4 class="centered_error-msg">${message}</h4>
		</c:if>
	</div>
	
	<div class="hints_signup">
		<c:if test="${not empty hints}">
			<c:forEach var="hint" items="${hints}">
				<br />
				<p class="hint_text">(!) ${hint}</p>
			</c:forEach>
		</c:if>
	</div>

</body>
</html>