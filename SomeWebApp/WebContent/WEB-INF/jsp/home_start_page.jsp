<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<c:if test="${not empty news}">
			<c:forEach var="n" items="${requestScope.news}">
				<hr class="big_line">
				<br />
				<h2 class="news_title">${n.title}</h2>
				<p class="news_content">${n.brief}</p>
				<br />
			</c:forEach>
		</c:if>
	
	</div>

</body>
</html>