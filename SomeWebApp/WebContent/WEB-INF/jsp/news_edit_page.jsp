<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="by.htp.project.bean.News"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
						<li><a href="Controller?command=SetLang&lang=en&lastCommand=GoToNewsEditPage&news_id=${news.id}">EN</a></li>
						<li><a href="Controller?command=SetLang&lang=ru&lastCommand=GoToNewsEditPage&news_id=${news.id}">RU</a></li>
					</ul>
				</nav>
			</div>
	
			<div class="authorization-div">
				<nav class="nav authorization-nav">
					<ul>
						<li><fmt:message bundle="${loc}" key="home.user.hello" />, <c:out value="${sessionScope.user}" /> 
							<c:if test="${sessionScope.role eq \"admin\"}">
							(<fmt:message bundle="${loc}" key="home.user.admin" />)
							</c:if>
						</li>
						<li><a href="Controller?command=logout"><fmt:message bundle="${loc}" key="home.user.logout" /></a></li>
					</ul>
				</nav>
			</div>
		</div>
	
		<nav class="nav main-nav">
			<ul>
 				<li><a href="Controller?command=GoToHomeUserPage"><fmt:message bundle="${loc}" key="home.start.mainnav.home" /></a></li>
				<li><a href="${pageContext.request.contextPath}/Menu1"><fmt:message bundle="${loc}" key="home.start.mainnav.menu1" /></a></li>
				<li><a href="${pageContext.request.contextPath}/Menu2"><fmt:message bundle="${loc}" key="home.start.mainnav.menu2" /></a></li>
				<li><a href="${pageContext.request.contextPath}/Menu3"><fmt:message bundle="${loc}" key="home.start.mainnav.menu3" /></a></li>
			</ul>
		</nav>
	</header>

	<section class="section body-section">
		<section class="section group">
	
			<form action="Controller" method="post">
			<div class="div form-edit-news">

					<p><textarea class="news-editor" rows="4" cols="72" name="news_title">${news.title}</textarea></p>
					<p><textarea class="news-editor" rows="6" cols="72" name="news_brief">${news.brief}</textarea></p>
					<p><textarea class="news-editor" rows="30" cols="72" name="news_content">${news.content}</textarea></p>

					<div class="news-editor button-div save-button-div">
						<input type="hidden" name="command" value="SaveEditedNews" />
						<input type="hidden" name="news_id" value="${news.id}" />
						<input class="button" type="submit" value=<fmt:message bundle="${loc}" key="home.user.button.save" />>
					</div>
					

			</div>
				
			<div class="div control-buttons-div">
				<nav class="nav contol-edit-news-nav">
					<ul>
						<li><a href="Controller?command=GoToNewsReadPage&news_id=${news.id}"><fmt:message bundle="${loc}" key="home.user.cancel" /></a></li>
						<li><a href="Controller?command=DeleteNews&news_id=${news.id}"><fmt:message bundle="${loc}" key="home.user.delete" /></a></li>
					</ul>
				</nav>
			</div>
			</form>
			
		</section>

	</section>
</body>
</html>