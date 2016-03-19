<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Tp5</title>
    
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.2.0.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/bootstrap-theme.min.css">

    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath}/css/signin.css" rel="stylesheet">

  </head>

  <body>

    <div class="container">

      <form class="form-signin" action="${pageContext.request.contextPath}/signin" method="post">
        <h2 class="form-signin-heading">Authentification</h2>
        
        <label for="inputFirstname" class="sr-only">Pseudonyme</label>
        <input type="text" id="inputFirstname" name="inputFirstname" class="form-control" placeholder="Pseudonyme" required autofocus>
       
        <button class="btn btn-lg btn-primary btn-block" type="submit">Se connecter</button>
      </form>

    </div> <!-- /container -->
    
  </body>
</html>
