<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new Ingredient</title>
</head>
<body>
	<h1>Add ingredient</h1>
		<form  method="post" action="${pageContext.request.contextPath}/ingredient">
			<input id="name" name="name" type="text" placeholder="Name">
			<p><input id="picture" name="picture" type="text" placeholder="Picture"> (facultatif)</p>
			<input type="submit" value="Valider">
		</form>
</body>
</html>