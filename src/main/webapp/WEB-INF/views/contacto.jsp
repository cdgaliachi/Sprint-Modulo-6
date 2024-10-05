<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link 	rel="icon" type="image/jpg" href="${pageContext.request.contextPath}/res/img/favicon.png"/>
	<link	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"	rel="stylesheet">
	<!-- Enlace a la hoja de estilos personalizada -->
	<link 	rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css">
	<!--Link a googlefont-->
	<link 	rel="preconnect" href="https://fonts.googleapis.com">
    <link 	rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link 	href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet">
</head>
<body class="bod-img" style="background-image:url('${pageContext.request.contextPath}/res/img/cap4.jpg')" >
	<header class="sticky-top ">
		<%@ include file="navbar.jsp"%>
	</header>
	<main class="container">
    	<div class="container" id="contcard">
        	<div class="row justify-content-center">
        		<div class="col-md-3 col-12 d-md-block d-none"></div>
            	<div class="col-md-6 col-12 bg-lil">
                	<div class="card shadow-lg p-4 bg-lil col-12">
                    	<h2 class="text-center mb-4 text-dark">Formulario de Contacto</h2>
                    	<form action="contacto" method="POST">
                        	<div class="mb-3">
                            	<label for="email" class="form-label text-dark">Correo electrónico</label>
                            	<input type="email" class="form-control" id="email" name="email" placeholder="correo@mail.com" required>
                        	</div>
                        	<div class="mb-3">
                            	<label for="mensaje" class="form-label text-dark">Mensaje</label>
                            	<textarea class="form-control" id="mensaje" name="mensaje" rows="3" required></textarea>
                        	</div>
                        	<button type="submit" class="btn btn-dark w-100 mt-3 text-light">Enviar</button>
                    	</form>
                	</div>
            	</div>
        	</div>
    	</div>
     	<!-- Mensaje de registro exitoso -->
     	<div class="container mt-5">   
        	<%
            	String message = (String) request.getAttribute("message");
            	String messageType = (String) request.getAttribute("messageType");
            	if (message != null) {
        	%>
        	<div class="alert alert-<%= messageType %> alert-dismissible fade show" role="alert">
            	<%= message %>
            	<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        	</div>
        	<% } %>
        </div>    
	</main>
	
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>
	<!-- JQUERY -->
	<script src="https://code.jquery.com/jquery-3.7.1.slim.js" integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc=" crossorigin="anonymous"></script>
	<!-- CDN de Bootstrap 5.1 -->
	<script	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
</body>
</html>