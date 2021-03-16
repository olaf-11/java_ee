<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.lang}" />
<fmt:setBundle basename="by.htp.project.localization.lang" var="loc"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/some_web_app_css.css">
</head>
<body>
	<header>
		<div class="header logo">
 			<img src="css/logo.png" alt="Logo">
		</div>
	
		<div class="header service-nav">
			<div class="local-div">
				<nav class="nav local-nav">
					<ul>
						<li><a href="Controller?command=SetLang&lang=en&lastCommand=GoToRegisterPage">EN</a></li>
						<li><a href="Controller?command=SetLang&lang=ru&lastCommand=GoToRegisterPage">RU</a></li>
					</ul>
				</nav>
			</div>
			
			<div class="authorization-div">
				<nav class="nav authorization-nav">
					<ul>
						<li><a href="Controller?command=GoToSignInPage"><fmt:message bundle="${loc}" key="home.start.nav.signin" /></a></li>
						<li><a href="Controller?command=GoToRegisterPage"><fmt:message bundle="${loc}" key="home.start.nav.registration" /></a></li>
					</ul>
				</nav>
			</div>
		</div>
	
		<nav class="nav main-nav">
			<ul>
 				<li><a href="${pageContext.request.contextPath}/"><fmt:message bundle="${loc}" key="home.start.mainnav.home" /></a></li>
				<li><a href="${pageContext.request.contextPath}/Menu1"><fmt:message bundle="${loc}" key="home.start.mainnav.menu1" /></a></li>
				<li><a href="${pageContext.request.contextPath}/Menu2"><fmt:message bundle="${loc}" key="home.start.mainnav.menu2" /></a></li>
				<li><a href="${pageContext.request.contextPath}/Menu3"><fmt:message bundle="${loc}" key="home.start.mainnav.menu3" /></a></li>
			</ul>
		</nav>
	</header>
	
	<div class="error-messages">
		<br>
		<%
			String message = (String)request.getParameter("message");
	
	 	   if(message != null){
	    	
		%>
		<h1><font color="red">
		<%
		     out.write(message);
		    }
		%>
		</font></h1>
	
		<br />
	</div>
	
	<div class="body-div">
		<hr>
		<br>
		<form action="Controller" method="post">
			<input type="hidden" name="command" value="SaveNewUser" />
			<table>
				<tr>
					<td class="body_form"><fmt:message bundle="${loc}" key="register.email" />:</td>
					<td><input type="text" name="login" value="" placeholder="alexanderIII@email.com" /></td>
				</tr>
				<tr>
					<td class="body_form"><fmt:message bundle="${loc}" key="register.pwd" />:</td>
					<td><input type="password" name="password" value="" placeholder="***********" /></td>
				</tr>
				<tr>
					<td class="body_form"><fmt:message bundle="${loc}" key="register.name" />:</td>
					<td><input type="text" name="name" value="" placeholder="Alexander III" /></td>
				</tr>
				<tr>
					<td class="body_form"><fmt:message bundle="${loc}" key="register.surname" />:</td>
					<td><input type="text" name="surname" value="" placeholder="the Great" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="isRobot"><fmt:message bundle="${loc}" key="register.checkbox.norobot" />.</td>
				</tr>
				<tr>
					<td></td>
					<td><input class="button" type="submit" value=<fmt:message bundle="${loc}" key="register.button.register" />></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>