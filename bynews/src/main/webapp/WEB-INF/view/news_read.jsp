<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Root Page</title>
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
						<li><a href="${pageContext.request.contextPath}/news/read/${news.id}?lang=en">EN</a></li>
						<li><a href="${pageContext.request.contextPath}/news/read/${news.id}?lang=ru">RU</a></li>
					</ul>
				</nav>
			</div>
			
			<div class="authorization-div">
				<nav class="nav authorization-nav">
					<ul>
						<li><sec:authentication property="name"/></li>
						<li><a href="${pageContext.request.contextPath}/logout"><spring:message code="home.user.logout" /></a></li>
					</ul>
				</nav>
			</div>
		</div>
	
		<nav class="nav main-nav">
			<ul>
				<li><a href="${pageContext.request.contextPath}/home"><spring:message code="home.start.mainnav.home" /></a></li>
				<li><spring:message code="home.start.mainnav.menu1" /></li>
				<li><spring:message code="home.start.mainnav.menu2" /></li>
				<li><spring:message code="home.start.mainnav.menu3" /></li>
				<sec:authorize access="hasAuthority('NEWS_ADD')">
					<li><a href="${pageContext.request.contextPath}/news/add"><spring:message code="home.user.add" /></a></li>
				</sec:authorize>
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

		<br />
		<h2 class="news_title">${news.title}</h2>
		<h4 class="news_brief">${news.brief}</h4>
		
		${news.text}
		
		<hr class="thin_line">
		<br />

		<div class="button_div_block">
			<nav class="nav backward-forward-nav">
				<ul>
					<li><a href="${pageContext.request.contextPath}/home"> &lt;&lt;&lt; <spring:message code="home.user.back" /> </a></li>
					
					<sec:authorize access="hasAuthority('NEWS_EDIT')">
						<li><a href="${pageContext.request.contextPath}/news/edit/${news.id}"> <spring:message code="home.user.editnews" /> >>> </a></li>
					</sec:authorize>

				</ul>
			</nav>
		</div>
	
	</div>
	<br />
	<br />
</body>
</html>