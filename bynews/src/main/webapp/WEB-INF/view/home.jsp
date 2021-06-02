<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Root Page</title>
<link rel="stylesheet" type="text/css" href="<c:url value='/resources/css/some_web_app_css.css'/>" />
</head>
<body>
	<header>
		<div class="header logo">
 			  <img src="<c:url value='/resources/img/bynews.png'/>" alt="Logo">
 			  <!-- <img src="${pageContext.request.contextPath}/resources/img/logo.png" alt="Logo" /> -->  
		</div>
	
		<div class="header service-nav">
			<div class="local-div">
				<nav class="nav local-nav">
					<ul>
						<li>EN</li>
						<li>RU</li>
						<!-- <li><a href="Controller?command=SetLang&lang=en&lastCommand=GoToHomeStartPage">EN</a></li>
						<li><a href="Controller?command=SetLang&lang=ru&lastCommand=GoToHomeStartPage">RU</a></li> -->
					</ul>
				</nav>
			</div>
			
			<div class="authorization-div">
				<nav class="nav authorization-nav">
					<ul>
						<li><a href="${pageContext.request.contextPath}/GoToSignInPage/showSignIn">Sign in</a></li>
						<li><a href="${pageContext.request.contextPath}/GoToRegisterPage/showRegForm">Registration</a></li>
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
			<c:if test="${not empty message}">
			<h1>
				<font color="red">${message}</font>
			</h1>
			</c:if>
	
		<br />
	</div>

	<div class="body-div">

		<c:if test="${not empty news}">
			<c:forEach var="news" items="${news}">
				<hr class="big_line">
				<br />
				<h2 class="news_title">${news.title}</h2>
				<p class="news_content">${news.brief}</p>
				<br />
			</c:forEach>
		</c:if>
	
	</div>

</body>
</html>