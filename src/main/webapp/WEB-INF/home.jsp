<%@ page import="org.eclipse.persistence.internal.oxm.schema.model.Include"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Include all the css and js file -->
		<%@include file="header.jsp" %>
		
		<title>The Best Burger</title>
	</head>
	
	<body>
		<!-- Include of the navBar -->
		<%@include file="masterPage.jsp" %>
		<div class="container">
			<h2>Nos Burgers :</h2>
			<div class="row">
				<c:forEach items="${burgers}" var="burger">
					<div class="col-sm-6 col-md-4">
						<div onclick="displayDetail('${burger.id}')" class="thumbnail">
							<div class="img-container">
								<img class="burger-img" src="${burger.picture}" alt="burger picture">
							</div>
							<div class="caption">
								<h3>${burger.name}</h3>
								<p>${burger.description}</p>
								<div class="gradeHome">
									<jsp:include page="averagePage.jsp">
										<jsp:param name="averageOriginality" value="${burger.averageOriginality}"/>
										<jsp:param name="averageQuality" value="${burger.averageQuality}"/>
										<jsp:param name="averagePresentation" value="${burger.averagePresentation}"/>
										<jsp:param name="averageTaste" value="${burger.averageTaste}"/>
									</jsp:include>
								</div>
								<a href="detailBurger?id=${burger.id}" class="btn btn-primary" role="button">Donner votre avis</a>
							</div>
						</div>
				  	</div>
				 </c:forEach>
			</div>
		</div>
	</body>
</html>