<%@ page import="org.eclipse.persistence.internal.oxm.schema.model.Include"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<!-- Include all the css and js file -->
		<%@include file="WEB-INF/header.jsp" %>
		
		<title>The Best Burger</title>
	</head>
	
	<body>
		<!-- Include of the navBar -->
		<%@include file="WEB-INF/masterPage.jsp" %>
		<div class="container">
			<h2>Nos Burgers :</h2>
			<div class="row">
				<c:forEach items="${burgers}" var="burger">
					<div class="col-sm-6 col-md-4">
						<div onclick="displayDetail('${burger.id}')" class="thumbnail">
						<div class="img-container"><img class="burger-img" src="${burger.picture}" alt="burger picture"></div>
							<div class="caption">
								<h3>${burger.name}</h3>
								<p>${burger.description}</p>
								<p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
							</div>
						</div>
				  	</div>
				 </c:forEach>
			</div>
		</div>
	</body>
</html>