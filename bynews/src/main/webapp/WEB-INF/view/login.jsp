<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="by.htp.project.localization.lang" var="loc"/> -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SignIn</title>
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
						<li>EN</li>
						<li>RU</li>
						<!-- <li><a href="Controller?command=SetLang&lang=en&lastCommand=GoToRegisterPage">EN</a></li>
						<li><a href="Controller?command=SetLang&lang=ru&lastCommand=GoToRegisterPage">RU</a></li> -->
					</ul>
				</nav>
			</div>
			
			<div class="authorization-div">
				<nav class="nav authorization-nav">
					<ul>
						<li><a href="${pageContext.request.contextPath}/login">Sign in</a></li>
						<li><a href="${pageContext.request.contextPath}/registration">Registration</a></li>
						<!-- <li><a href="Controller?command=GoToSignInPage"><fmt:message bundle="${loc}" key="home.start.nav.signin" /></a></li>
						<li><a href="Controller?command=GoToRegisterPage"><fmt:message bundle="${loc}" key="home.start.nav.registration" /></a></li> -->
					</ul>
				</nav>
			</div>
		</div>
	
		<nav class="nav main-nav">
			<ul>
				<li><a href="${pageContext.request.contextPath}/">Home</a></li>
				<li>Menu1</li>
				<li>Menu2</li>
				<li>Menu3</li>
 				<!-- <li><a href="${pageContext.request.contextPath}/"><fmt:message bundle="${loc}" key="home.start.mainnav.home" /></a></li>
				<li><a href="${pageContext.request.contextPath}/Menu1"><fmt:message bundle="${loc}" key="home.start.mainnav.menu1" /></a></li>
				<li><a href="${pageContext.request.contextPath}/Menu2"><fmt:message bundle="${loc}" key="home.start.mainnav.menu2" /></a></li>
				<li><a href="${pageContext.request.contextPath}/Menu3"><fmt:message bundle="${loc}" key="home.start.mainnav.menu3" /></a></li> -->
			</ul>
		</nav>
	</header>
	
	<div class="error-messages">
		<br>
		<%
			String error = (String)request.getParameter("error");
			if(error != null){
	    	
		%>
		<h2><font color="red">
		<%
			out.write("Wrong login or password.");
		    }
		%>
		</font></h2>
	
		<br />
	</div>

	<div class="body-div">
		<hr>
		<br>
		<form:form action="login" modelAttribute="loginForm">

			<table>
				<tr>
					<td class="body_form">Enter login:</td>
					<td><form:input path="email" placeholder="ivanov@mail.com" /></td>
				</tr>
				<tr>
					<td class="body_form">Enter password:</td>
					<td><form:password path="pswd" placeholder="***********" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input class="button" type="submit" value="Sign in" /></td>
				</tr>
			</table>
		</form:form>
	
	</div>

</body>
</html>