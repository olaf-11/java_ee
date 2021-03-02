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
	<div class="top-nav logo">
 		<img src="css/logo.png" alt="Logo">
	</div>
	
	<div class="top-nav right-side-tn">
		<div class="localization">
			<ul class="local">
				<li>EN</li>
				<li>RU</li>
			</ul>
		</div>
	
		<div class="authorization">
			<a href="Controller?command=GoToSignInPage">Sign in</a>
			|
			<a href="Controller?command=Registration">Registration</a>
		</div>
	</div>
	
	<div class="main-nav">
 		<a href="${pageContext.request.contextPath}/">Home</a>
		|
		<a href="${pageContext.request.contextPath}/Menu1">Menu1</a>
   		|
		<a href="${pageContext.request.contextPath}/Menu2">Menu2</a>
   		|
		<a href="${pageContext.request.contextPath}/Menu3">Menu3</a>
	</div>
	
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

		<c:forEach var="n" items="${requestScope.news}">
			<hr class="big_line">
			<br />
			<h2 class="news_header">${n.title}</h2>
			<p class="news_texts">${n.brief}</p>
			<br />
		</c:forEach>
	
	</div>

</body>
</html>