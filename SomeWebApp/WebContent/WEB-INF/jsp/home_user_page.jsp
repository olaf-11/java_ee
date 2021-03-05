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
			<h2 class="news_title">${n.title}</h2>
			<!-- <p class="news_date"><c:out value="${n.date}" /></p> -->
			<p class="news_content">${n.brief}</p>
			<p class="news_ref"><a href="Controller?command=GoToNewsReadPage&news_id=${n.id}">more >>></a></p>
			<br />
		</c:forEach>
	
	</div>

</body>
</html>