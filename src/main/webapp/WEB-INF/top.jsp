<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Include all the css and js file -->
	<%@include file="header.jsp" %>
	<title>Le classement !!!</title>
</head>
	<body>
			<!-- Include of the navBar -->
			<%@include file="masterPage.jsp" %>
			
			<div class="container">
				<c:forEach items="${sortedList}" var="burger">
		 			<div class="list-group">
					  <a href="detailBurger?id=${burger.id}" class="list-group-item">
					    <h4 class="list-group-item-heading">${burger.name }</h4>
						<div>
							<h2>Moyenne : </h2>
							<div class="gradeHome">
								<jsp:include page="averagePage.jsp">
									<jsp:param name="averageOriginality" value="${burger.averageOriginality}"/>
									<jsp:param name="averageQuality" value="${burger.averageQuality}"/>
									<jsp:param name="averagePresentation" value="${burger.averagePresentation}"/>
									<jsp:param name="averageTaste" value="${burger.averageTaste}"/>
								</jsp:include>
							</div>
						</div>
					  </a>
					</div>
		 		</c:forEach>
			</div>
	</body>
</html>