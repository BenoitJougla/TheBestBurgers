<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="originality">
	<label class="gradeLabel">Originalité</label>
	<jsp:include page="rating.jsp">
		<jsp:param name="id" value="originality"/>
		<jsp:param name="value" value="${param.originality}"/>
	</jsp:include>
</div>

<div id="quality">
	<label class="gradeLabel">Qualité des ingrédients</label>
	<jsp:include page="rating.jsp">
		<jsp:param name="id" value="quality"/>
		<jsp:param name="value" value="${param.quality}"/>
	</jsp:include>
</div>

<div id="presentation">
	<label class="gradeLabel">Présentation</label>
	<jsp:include page="rating.jsp">
		<jsp:param name="id" value="presentation"/>
		<jsp:param name="value" value="${param.presentation}"/>
	</jsp:include>
</div>

<div id="tasty">
	<label class="gradeLabel">Goût</label>
	<jsp:include page="rating.jsp">
		<jsp:param name="id" value="tasty"/>
		<jsp:param name="value" value="${param.taste}"/>
	</jsp:include>
</div>