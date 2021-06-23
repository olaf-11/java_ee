<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %> 
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
						<li><a href="${pageContext.request.contextPath}/login?lang=en">EN</a></li>
						<li><a href="${pageContext.request.contextPath}/login?lang=ru">RU</a></li>
					</ul>
				</nav>
			</div>
			
			<div class="authorization-div">
				<nav class="nav authorization-nav">
					<ul>
						<li><a href="${pageContext.request.contextPath}/login"><spring:message code="home.start.nav.signin" /></a></li>
						<li><a href="${pageContext.request.contextPath}/registration"><spring:message code="home.start.nav.registration" /></a></li>
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
		<div class="container">
			<div class="inside_sign">
				<form:form action="login" modelAttribute="loginForm">

					<table class="table_signin">
						<tr>
							<td>
								<div class="table_td"><spring:message code="signin.login" /></div>
							</td>
							<td>
								<div class="table_td"><form:input path="email" placeholder="peter.ivanov@gmail.com" /></div>
							</td>
						</tr>
						<tr>
							<td>
								<div class="table_td"><spring:message code="signin.pwd" /></div>
							</td>
							<td>
								<div class="table_td"><form:password path="pswd" placeholder="***********" /></div>
							</td>
						</tr>
						<tr>
							<td></td>
							<td>
								<div><input class="button" type="submit" value=<spring:message code="signin.signin" /> /></div>
							</td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>