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
	
		<br />
		<h2 class="news_header">${news.title}</h2>
		<h4 class="news_brief">${news.brief}</h4>
		
		${news.content}
		
		<hr class="thin_line">
		<br />

		<div class="button_div_block">
			<c:if test="${sessionScope.role eq \"admin\"}">
			<div class="div_button_ref">
				<p class="news_ref_edit"><a href="Controller?command=GoToNewsEditor&id=${news.id}"> Edit news >>> </a></p>
			</div>
			</c:if>
			<div class="div_button_ref">
				<p class="news_ref_back"><a href="Controller?command=GoToUsersHomePage"> &lt;&lt;&lt; Back </a></p>
			</div>
		</div>

	</div>
	
	
			<!-- <div class="button_div_block">
				<div class="div_button_ref">
					<form action="Controller">
						<input type="hidden" name="command" value="GoToNewsEditor" />
						<input type="hidden" name="id" value="${news.id}" />
						<input class="button_secondary" type="submit" value="Edit news">
					</form>
				</div>
				
				<div class="div_button_ref">
					<form action="Controller">
						<input type="hidden" name="command" value="GoToMainPage" />
						<input class="button" id="align_left" type="submit" value="Back">
					</form>
				</div>
			</div> -->

</body>
</html>