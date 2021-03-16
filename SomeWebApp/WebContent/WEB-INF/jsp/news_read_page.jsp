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
						<li><a href="Controller?command=SetLang&lang=en&lastCommand=GoToNewsReadPage&news_id=${news.id}">EN</a></li>
						<li><a href="Controller?command=SetLang&lang=ru&lastCommand=GoToNewsReadPage&news_id=${news.id}">RU</a></li>
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

	<div class="body-div">
	
		<br />
		<h2 class="news_title">${news.title}</h2>
		<h4 class="news_brief">${news.brief}</h4>
		
		${news.content}
		
		<hr class="thin_line">
		<br />

		<div class="button_div_block">
			<nav class="nav backward-forward-nav">
				<ul>
					<li><a href="Controller?command=GoToHomeUserPage"> &lt;&lt;&lt; <fmt:message bundle="${loc}" key="home.user.back" /> </a></li>
					<c:if test="${sessionScope.role eq \"admin\"}">
						<li><a href="Controller?command=GoToNewsEditPage&news_id=${news.id}"> <fmt:message bundle="${loc}" key="home.user.editnews" /> >>> </a></li>
					</c:if>
				</ul>
			</nav>
		</div>

	</div>
	
	
			<!-- <div class="button_div_block">
				<div class="div_button_ref">
					<form action="Controller">
						<input type="hidden" name="command" value="GoToNewsEditPage" />
						<input type="hidden" name="news_id" value="${news.id}" />
						<input class="button_secondary" type="submit" value="Edit news">
					</form>
				</div>
				
				<div class="div_button_ref">
					<form action="Controller">
						<input type="hidden" name="command" value="GoToHomeUserPage" />
						<input class="button" id="align_left" type="submit" value="Back">
					</form>
				</div>
			</div> -->

</body>
</html>