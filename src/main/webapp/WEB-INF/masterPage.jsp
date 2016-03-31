<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        
        <nav class="navbar custom-navbar navbar-fixed-top">
            <div class="container shadow-nav-bar">
                <div class="navbar-header">
                  <a id="home-button" class="navbar-brand trans-100" href="${pageContext.request.contextPath}/">
                    <img id="home-logo" alt="home" src="${pageContext.request.contextPath}/img/logo.png">
                  </a>
                  <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse"> <span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span> <span class="icon-bar"></span> <span class="icon-bar"></span> </button>
                </div>
                <div id="collapse-text" class="navbar-collapse collapse">
                  <ul class="nav navbar-nav">
                    <li class="active"><a href="${pageContext.request.contextPath}/restaurants" class="trans-300">Restaurants</a></li>
                    <li><a href="#about" class="trans-300">Top</a></li>
                    <li><a href="#contact" class="trans-300">Localisation</a></li>
                  </ul>
                  <ul class="nav navbar-nav navbar-right">
                    <li>
						<div class="dropdown">
						  <button class="btn btn-custom dropdown-toggle" type="button" id="dropdownMenu" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
							<img id="admin" alt="admin" src="${pageContext.request.contextPath}/img/admin.png"/><span id="admin-link">Profil</span>
							<span class="caret"></span>
						  </button>
						  <ul class="dropdown-menu" aria-labelledby="dropdownMenu">
						  		<c:choose>
									<c:when test="${empty user}">
										<li><a href="${pageContext.request.contextPath}/signin.jsp">Connexion</a></li>
									</c:when>    
									<c:otherwise>
										<li><a href="#">Bonjour <strong>${user.name}</strong></a></li>
										<li><a href="${pageContext.request.contextPath}/burger">Ajouter un Burger</a></li>
										<li><a href="${pageContext.request.contextPath}/restaurant">Ajouter un Restaurant</a></li>
										<li><a href="#">Modifier un Burger</a></li>
										<li><a href="#">Modifier un Restaurant</a></li>
										<li role="separator" class="divider"></li>
										<li><a href="#">Mes commentaires</a></li>
										<li><a href="${pageContext.request.contextPath}/logout">Déconnexion</a></li>
									</c:otherwise>
								</c:choose>
						  </ul>
						</div>
					</li>
                    <li>
                        <div class="input-group">
                          <input type="text" class="form-control" placeholder="Rechercher un burger...">
                          <span class="input-group-btn">
                            <button class="btn btn-custom" type="button">Go!</button>
                          </span>
                        </div>
                    </li>
                  </ul>
                </div>
            </div>
        </nav>
        
        <!-- Start SubBan -->
        <div id="sub-ban"><p>Bienvenue sur The Best Burger</p></div>
        
        