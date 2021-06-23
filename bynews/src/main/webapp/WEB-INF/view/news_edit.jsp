<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"      uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec"    uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form"   uri="http://www.springframework.org/tags/form" %>
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
						<li><a href="${pageContext.request.contextPath}/news/edit/${news.id}?lang=en">EN</a></li>
						<li><a href="${pageContext.request.contextPath}/news/edit/${news.id}?lang=ru">RU</a></li>
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
	
	<section class="section body-section">
		<section class="section group">
	
			<form:form action="${pageContext.request.contextPath}/news/save" method="post" modelAttribute="news">
			<div class="div form-edit-news">

					<p><form:textarea class="news-editor" path="title" rows="4" cols="72" /></p>
					<p><form:textarea class="news-editor" path="brief" rows="6" cols="72" /></p>
					<p><form:textarea class="news-editor" path="text" rows="30" cols="72" /></p>
					<form:hidden path="id" />
					<form:hidden path="status" />
					
					<div class="news-editor button-div save-button-div">
						<input class="button" type="submit" value=<spring:message code="home.user.button.save" /> />
					</div>

			</div>
				
			<div class="div control-buttons-div">
				<nav class="nav contol-edit-news-nav">
					<ul>
						<li><a href="${pageContext.request.contextPath}/news/read/${news.id}"><spring:message code="home.user.cancel" /></a></li>
						<sec:authorize access="hasAuthority('NEWS_DELETE')">
							<li><a href="${pageContext.request.contextPath}/news/delete/${news.id}"><spring:message code="home.user.delete" /></a></li>
						</sec:authorize>
					</ul>
				</nav>
			</div>
			</form:form>
			
		</section>

	</section>
	<br />
	<br />
</body>
</html>