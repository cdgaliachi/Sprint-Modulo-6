<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
  	<meta charset="UTF-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1.0">
  	<!-- T�tulo de la p�gina -->
 	<title>Navbar</title>
  
  	<!-- Enlace a la hoja de estilos de Bootstrap desde un CDN -->
  	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
  
  	<!-- Enlace a la hoja de estilos personalizada -->
  	<link rel="stylesheet" href="<c:url value='/res/css/styles.css'/>">
 	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>	
	<link href="https://fonts.googleapis.com/css2?family=Raleway:ital@0;1&display=swap" rel="stylesheet">
</head>
<body>
  	<nav class="navbar navbar-expand-lg navbar-light bg-osc text-white">
    	<div class="container-fluid">
      	<!-- Marca de la barra de navegaci�n -->
      		<a class="navbar-brand text-white" href="inicio">CAPACITA'O/OTEC</a>
      
      		<!-- Bot�n para colapsar la barra de navegaci�n en pantallas peque�as -->
      		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavAltMarkup"	aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
        		<span class="navbar-toggler-icon"></span>
      		</button>
      
      		<!-- Contenido colapsable de la barra de navegaci�n -->
      		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
        		<div class="navbar-nav" >
          			<a class="nav-link active text-white" aria-current="page" href="<c:url value='/inicio'/>">Inicio</a>
          			
          			<%
          			String rol = (String)request.getAttribute("rol");
          			if (rol!=null&&rol.equals("[CLIENTE]")){%>
          				<a class="nav-link text-white" href="<c:url value='/contacto'/>">Contacto</a>
          				<a class="nav-link text-white" href="<c:url value='/capacitaciones/crear'/>">Crear Capacitacion</a> 
          				<a class="nav-link text-white" href="<c:url value='/capacitaciones/listar'/>">Listar Capacitacion</a>
          			<%}else if(rol!=null&&rol.equals("[PROFESIONAL]")){ %>
          				<a class="nav-link text-white" href="<c:url value='/checklist'/>">Responder Checklist</a>  
          				<a class="nav-link text-white" href="<c:url value='/visitas'/>">Listado Visitas</a>
          			<%}else if(rol!=null&&rol.equals("[ADMINISTRATIVO]")){ %>
          				<a class="nav-link text-white" href="<c:url value='/usuario/listar'/>">Listado de Usuarios</a> 
          				<a class="nav-link text-white" href="<c:url value='/usuario/crear'/>">Crear usuario</a> 
          				<a class="nav-link text-white" href="<c:url value='/pago/listar'/>">Listado Pago</a>
          				<a class="nav-link text-white" href="<c:url value='/pago/crear'/>">Crear Pago</a>
          			<%} %> 
        
        		</div>
      		</div>
		<!-- Enlace al log out -->
    	<div class="d-flex ms-auto px-2">
            <a href="${pageContext.request.contextPath}/logout" class="btn btn-outline-danger text-light fw-bold">Log out</a>
    	</div>
    	</div>
    
    	

  	</nav>
  
  	<!-- JQUERY -->
  	<script src="https://code.jquery.com/jquery-3.7.1.slim.js"	    integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc=" crossorigin="anonymous"></script>
  
  	<!-- CDN de Bootstrap 5.1 -->
 	<script 	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"	crossorigin="anonymous"></script>
	<script		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"	crossorigin="anonymous"></script>
</body>
</html>