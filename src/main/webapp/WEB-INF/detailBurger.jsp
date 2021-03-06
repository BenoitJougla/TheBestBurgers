<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<!-- Include all the css and js file -->
		<%@include file="header.jsp" %>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/addGrade.js"></script>
		
		<title>The Best Burger</title>
	</head>
	<body>
		<%@include file="masterPage.jsp" %>
		
		<div class="container">
			<div class="jumbotron">
				<h1>${burger.name}</h1>
				<div class="img-container">
					<img class="burger-img" src="${burger.picture}" alt="burger picture">
				</div>
				<h2>${burger.description}</h2>
				
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
				
				<div>
					<h2>Ingrédients :</h2>
					<c:forEach items="${burger.ingredients}" var="ingredient">
						<label>${ingredient.name}</label>
					</c:forEach>
				</div>
				
				<div>
					<h2>Restaurant :</h2>
					<label>${burger.restaurant.name}</label>
				</div>
				
				<c:choose>
					<c:when test="${empty user}">
						<a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/signin?from=/detailBurger?id=${burger.id}">Donner votre avis</a>
					</c:when>    
					<c:otherwise>
						<div id="gradeBurger">
							<h2>Noter le burger</h2>
							
							<jsp:include page="gradePage.jsp">
								<jsp:param name="idOriginality" value="originality"/>
								<jsp:param name="idQuality" value="quality"/>
								<jsp:param name="idPresentation" value="presentation"/>
								<jsp:param name="idTasty" value="tasty"/>
							</jsp:include>
							
							<textarea id="gradeDescription" type="text"  class="input" placeholder="Observation"></textarea>
							<button class="btn btn-primary btn-lg" role="button" onclick = "addGrade(${burger.id})">Commenter</button>
						</div>
					</c:otherwise>
				</c:choose>
				
				<div>
					<h2>Commentaires :</h2>
					<label>${burger.nbGrades} avis</label>
					<c:forEach items="${burger.grades}" var="grade">
						<div class="comment">
							<div>
								<label class="comment-author-name">${grade.user.name}</label>
								<label>${grade.observation}</label>
							</div>
							<div class="readonly">
								<jsp:include page="gradePage.jsp">
									<jsp:param name="originality" value="${grade.originality}"/>
									<jsp:param name="idOriginality" value="${grade.id}_originality"/>
									
									<jsp:param name="quality" value="${grade.quality}"/>
									<jsp:param name="idQuality" value="${grade.id}_quality"/>
									
									<jsp:param name="presentation" value="${grade.presentation}"/>
									<jsp:param name="idPresentation" value="${grade.id}_presentation"/>
									
									<jsp:param name="taste" value="${grade.taste}"/>
									<jsp:param name="idTasty" value="${grade.id}_tasty"/>
								</jsp:include> 
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
	</body>
</html>