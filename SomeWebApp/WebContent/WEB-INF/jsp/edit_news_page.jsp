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
			<span>Hello, <c:out value="${sessionScope.user}" /> 
			<c:if test="${sessionScope.role eq \"admin\"}">
			(<c:out value="${sessionScope.role}" />)
			</c:if>
			</span>
			|
			<a href="Controller?command=logout">Logout</a>
		</div>
	</div>
	
	<div class="main-nav">
 		<a href="Controller?command=GoToUsersHomePage">Home</a>
		|
		<a href="${pageContext.request.contextPath}/Menu1">Menu1</a>
   		|
		<a href="${pageContext.request.contextPath}/Menu2">Menu2</a>
   		|
		<a href="${pageContext.request.contextPath}/Menu3">Menu3</a>
	</div>

	<div class="body-div">
	
		<div class="section">

				<form action="Controller" method="post">
					<p>
						<textarea class="news-editor" rows="4" cols="72" name="news_header">${news.title}</textarea>
					</p>
					<p>
						<textarea class="news-editor" rows="6" cols="72" name="news_brief">${news.brief}</textarea>
					</p>
					<p>
						<textarea class="news-editor" rows="30" cols="72" name="news_texts">${news.content}</textarea>
					</p>

					<input type="hidden" name="command" value="SaveEditedNews" />
					<input type="hidden" name="id" value="${news.id}" />
					<div class="centered_button">
						<input class="button" type="submit" value="Save">
					</div>
				</form>
				
				<form action="Controller">
					<input type="hidden" name="command" value="GoToNewsPage" />
					<input type="hidden" name="id" value="${news.id}" />
					<div class="centered_secondary_button">
						<input class="button_secondary" type="submit" value="Cancel">
					</div>
				</form>
	
			</div>

	</div>
</body>
</html>