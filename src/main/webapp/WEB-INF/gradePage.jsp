<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div id="originality">
	<label class="gradeLabel">Originalité</label>
	<jsp:include page="rating.jsp">
		<jsp:param name="id" value="originality"/>
	</jsp:include>
</div>

<div id="quality">
	<label class="gradeLabel">Qualité des ingrèdients</label>
	<jsp:include page="rating.jsp">
		<jsp:param name="id" value="quality"/>
	</jsp:include>
</div>

<div id="presentation">
	<label class="gradeLabel">Présentation</label>
	<jsp:include page="rating.jsp">
		<jsp:param name="id" value="presentation"/>
	</jsp:include>
</div>

<div id="tasty">
	<label class="gradeLabel">Goût</label>
	<jsp:include page="rating.jsp">
		<jsp:param name="id" value="tasty"/>
	</jsp:include>
</div>