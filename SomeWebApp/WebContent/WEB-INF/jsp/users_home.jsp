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
			<h2 class="news_header">${n.title}</h2>
			<!-- <p class="news_date"><c:out value="${n.date}" /></p> -->
			<p class="news_texts">${n.brief}</p>
			<p class="news_ref"><a href="Controller?command=GoToNewsPage&id=${n.id}">more >>></a></p>
			<br />
		</c:forEach>
	
	</div>

</body>
</html>