<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<li>EN</li>
						<li>RU</li>
					</ul>
				</nav>
			</div>
			
			<div class="authorization-div">
				<nav class="nav authorization-nav">
					<ul>
						<li><a href="Controller?command=GoToSignInPage">Sign in</a></li>
						<li><a href="Controller?command=GoToRegisterPage">Registration</a></li>
					</ul>
				</nav>
			</div>
		</div>
	
		<nav class="nav main-nav">
			<ul>
 				<li><a href="${pageContext.request.contextPath}/">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/Menu1">Menu1</a></li>
				<li><a href="${pageContext.request.contextPath}/Menu2">Menu2</a></li>
				<li><a href="${pageContext.request.contextPath}/Menu3">Menu3</a></li>
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
					<td class="body_form">Enter your e-mail (login):</td>
					<td><input type="text" name="login" value="" placeholder="alexanderIII@email.com" /></td>
				</tr>
				<tr>
					<td class="body_form">Enter your password:</td>
					<td><input type="password" name="password" value="" placeholder="***********" /></td>
				</tr>
				<tr>
					<td class="body_form">Enter your name:</td>
					<td><input type="text" name="name" value="" placeholder="Alexander III" /></td>
				</tr>
				<tr>
					<td class="body_form">Enter your surname:</td>
					<td><input type="text" name="surname" value="" placeholder="the Great" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="checkbox" name="isRobot">Press checkbox if you are not a robocop.</td>
				</tr>
				<tr>
					<td></td>
					<td><input class="button" type="submit" value="Register"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>