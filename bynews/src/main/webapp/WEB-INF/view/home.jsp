<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SomeNews</title>
</head>
<body>
	<h1> Welcome! </h1>
	<c:if test="${not empty message}">
	<h1>
		<font color="red">${message}</font>
	</h1>
	</c:if>

</body>
</html>