<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!DOCTYPE html> 
    <html>
    <head>
        <meta charset="UTF-8">
		<title>Listado de Capacitaciones</title>
		<link rel="icon" type="image/jpg" href="${pageContext.request.contextPath}/res/img/favicon.png"/>
		<!-- Enlace a Bootstrap CSS -->
		<link 	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"	rel="stylesheet">
		<!-- Enlace a la hoja de estilos personalizada -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/styles.css">
		<!--Link a googlefont-->
		<link 	rel="preconnect" 	href="https://fonts.googleapis.com">
		<link	rel="preconnect" 	href="https://fonts.gstatic.com" crossorigin>
		<link	href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet">
    </head>
<body class="bod-img" style="background-image:url('${pageContext.request.contextPath}/res/img/cap1.jpeg')" >
	<header class="sticky-top ">
		<%@ include file="navbar.jsp"%>
	</header>
	<main class="P-4">
		<div class="row">
			<div class="col-1"></div>
			<div class="col-md-4 col-12">
		
		<div class="container mt-md-5 bg-osc rounded py-4 px-5">
			<h2 class="mb-4">Registro de Capacitación</h2>
			<form action="<c:url value='/capacitaciones/crear'/>" method="POST">
				<div class="col-md-9">
					<div class="mb-2">
					<label for="identificador" class="form-label">Identifique su capacitación</label>
						<select class="form-select" aria-label="Default select example" id="identificador" name="identificador" required>
							<option selected disabled>Seleccione la Capacitación</option>
							<option value="1">1 .Prevención de Riesgos en el Trabajo</option>
							<option value="2">2 .Uso y Manejo de Extintores</option>
							<option value="3">3 .Primeros Auxilios</option>
							<option value="4">4 .Trabajos en Altura</option>
							<option value="5">5 .Manejo de Sustancias Peligrosas</option>
							<option value="6">6 .Espacios Confinados</option>
							<option value="7">7 .Ergonomía y Prevención de Lesiones
								Musculoesqueléticas</option>
							<option value="8">8 .Seguridad Eléctrica</option>
							<option value="9">9 .Control de Emergencias y Planes de
								Evacuación</option>
							<option value="10">10 .Uso de Equipos de Protección Personal
								(EPP)</option>
							<option value="11">11 .Seguridad Vial y Manejo Defensivo</option>
							<option value="12">12 .Manipulación Manual de Cargas</option>
							<option value="13">13 .Prevención de Riesgos Psicosociales</option>
							<option value="14">14 .Seguridad en el Uso de Maquinaria y
								Herramientas</option>
							<option value="15">15 .Normativa Legal y Reglamentación en
								Prevención de Riesgos</option>
						</select>
					</div>
					<div class="mb-2">
						<label for="dia" class="form-label">Día</label> 
						<select	class="form-select" aria-label="Dia de Semana" id="dia" name="dia" required>
							<option selected disabled>Seleccione el día de la capacitación</option>
							<option value="Lunes">Lunes</option>
							<option value="Martes">Martes</option>
							<option value="Miercoles">Miércoles</option>
							<option value="Jueves">Jueves</option>
							<option value="Viernes">Viernes</option>
						</select>
					</div>
					<div class="mb-2">
						<label for="hora" class="form-label">Hora</label>						
						<input type="text" class="form-control" id="hora" name="hora" placeholder="Ingrese la hora de la capacitación" required>						 
					</div>
					<div class="mb-2">
						<label 	for="lugar" class="form-label">Lugar</label>
						<input	type="text" class="form-control" id="lugar" name="lugar"	placeholder="Ingrese el lugar de la capacitación" required>
					</div>
					<div class="mb-2">
						<label 	for="duracion" class="form-label">Duración</label> 
						<input 	type="text" class="form-control" id="duracion" name="duracion"	placeholder="Ingrese la duración en horas y minutos" required>
					</div>
					<div class="mb-2">
						<label 	for="cantidadAsistentes" class="form-label">Cantidad de asistentes</label>
						<input 	type="number" class="form-control"	id="cantidadAsistentes" name="cantidadAsistentes"	placeholder="Ingrese la cantidad de asistentes" required>
					</div>
					<!-- Mensaje de registro exitoso al recibir confirmacion del Servlet -->
					<%	String message = (String)request.getAttribute("message");
						if(message != null){ %>
			
						<div class="alert alert-success alert-dismissible fade show" role="alert">
                            <%= message %>
               				<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
            			</div>
					<%} %>
			
					<button type="submit" class="mt-4  btn btn-dark">Registrar</button>
				</div>
			</form>

		</div>
		</div>
		</div>
	</main>
	<footer>
		<%@ include file="footer.jsp"%>
	</footer>
	<!-- JQUERY -->
	<script src="https://code.jquery.com/jquery-3.7.1.slim.js"></script>
	<!-- CDN de Bootstrap 5.0 -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
</body>
</html>