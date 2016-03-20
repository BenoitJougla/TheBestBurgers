<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>The Best Burger</title>
	</head>
	
	<body>
	
		<c:choose>
			<c:when test="${empty user}">
				<a href="${pageContext.request.contextPath}/signin.jsp">Se connecter</a>
			</c:when>    
			<c:otherwise>
				${user.name}
				<a href="${pageContext.request.contextPath}/logout">Se déconnecter</a>
			</c:otherwise>
		</c:choose>
	
	</body>
</html>