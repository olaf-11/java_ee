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
					<li><a href="Controller?command=GoToHomeUserPage"> &lt;&lt;&lt; Back </a></li>
					<c:if test="${sessionScope.role eq \"admin\"}">
						<li><a href="Controller?command=GoToNewsEditPage&news_id=${news.id}"> Edit news >>> </a></li>
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