<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Pagina de Inicio</title>
	<!-- Enlace a Bootstrap CSS -->
	<link 	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"	rel="stylesheet">
	<!-- Enlace a la hoja de estilos personalizada -->
	<link rel="stylesheet" href="<c:url value='/res/css/styles.css' />">
	<!--Link a googlefont-->
	<link 	rel="preconnect" 	href="https://fonts.googleapis.com">
	<link	rel="preconnect" 	href="https://fonts.gstatic.com" crossorigin>
	<link	href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet">
</head>

<body>
    <%@ include file="navbar.jsp"%>
	<header class="headline" style="background-color: #02102a; color: #ffffff;">
    	<div class="container">
        	<h1>No tienes permiso para ingresar a esta pagina</h1>
        	
    	</div>
	</header>

	<footer>
		<%@ include file="footer.jsp"%>
	</footer>
	<!-- JQUERY -->
	<script src="https://code.jquery.com/jquery-3.7.1.slim.js"	integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc="	crossorigin="anonymous"></script>
	<!-- CDN de Bootstrap 5.1 -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
</body>
</html>