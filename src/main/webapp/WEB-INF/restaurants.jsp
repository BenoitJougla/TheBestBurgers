<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- Include all the css and js file -->
	<%@include file="header.jsp" %>
	<title>Insert title here</title>
</head>
<body>

	<!-- Include of the navBar -->
	<%@include file="masterPage.jsp" %>
	
	<h2>Nos Restaurants :</h2>
	
	<div class="container">
		<c:forEach items="${restaurants}" var="restaurant">
 			<div class="list-group">
			  <a href="#" class="list-group-item">
			    <h4 class="list-group-item-heading">${restaurant.name }</h4>
			    <p class="list-group-item-text">Localisation :<br/>
			    	- ${restaurant.latitude }
			    	- ${restaurant.longitude }
			    </p>
			  </a>
			</div>
 		</c:forEach>
	</div>

</body>
</html>