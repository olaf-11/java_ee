<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="by.htp.project.bean.News"%>
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
						<li>Hello, <c:out value="${sessionScope.user}" /> 
							<c:if test="${sessionScope.role eq \"admin\"}">
							(<c:out value="${sessionScope.role}" />)
							</c:if>
						</li>
						<li><a href="Controller?command=logout">Logout</a></li>
					</ul>
				</nav>
			</div>
		</div>
	
		<nav class="nav main-nav">
			<ul>
 				<li><a href="Controller?command=GoToHomeUserPage">Home</a></li>
				<li><a href="${pageContext.request.contextPath}/Menu1">Menu1</a></li>
				<li><a href="${pageContext.request.contextPath}/Menu2">Menu2</a></li>
				<li><a href="${pageContext.request.contextPath}/Menu3">Menu3</a></li>
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
						<input class="button" type="submit" value="Save">
					</div>
					

			</div>
				
			<div class="div control-buttons-div">
				<nav class="nav contol-edit-news-nav">
					<ul>
						<li><a href="Controller?command=GoToNewsReadPage&news_id=${news.id}">Cancel</a></li>
						<li><a href="Controller?command=DeleteNews&news_id=${news.id}">Delete</a></li>
					</ul>
				</nav>
			</div>
			</form>
			
		</section>

	</section>
</body>
</html>