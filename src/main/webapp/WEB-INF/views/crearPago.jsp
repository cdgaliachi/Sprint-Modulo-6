<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="grupo4.sprint6.modelos.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
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
<body class="bod-img" style="background-image:url('${pageContext.request.contextPath}/res/img/cap6.jpg')" >
	<header class="sticky-top ">
		<%@ include file="navbar.jsp"%>
	</header>
	<main class="P-4">
	<div class="row">
	<div class="col-1"></div>
			<div class="col-md-4 col-12">
		<div class="container mt-5 bg-osc rounded" style="padding: 1.5rem 3rem">
            <h2>Registro de Pago</h2>
            <form action="<c:url value='/pago/crear'/>" method="POST">
                <div class="col-md-8">
                    <div class="mb-3">
                    <label for="id" class="form-label">Rut Usuario</label> <select
								class="form-select" aria-label="Default select example"
								id="id" name="id" required>
								<option value="" selected disabled>Ingrese el RUT asociado al pago</option>
								<% List<Usuario> listaUsuarios = (List<Usuario>)request.getAttribute("usuarios");
									for(Usuario u : listaUsuarios){
								%>
								<option value="<%=u.getId()%>"><%=u.getRut()%></option>
								<%} %>
							</select>
                    </div>

                    <div class="mb-3">
                        <label for="fechaPago" class="form-label">Fecha del pago:</label>
                        <input type="date" class="form-control" id="fechaPago"
                            name="fechaPago">
                    </div>

                    <div class="mb-3">
                        <label for="monto" class="form-label">Monto</label> <input
                            type="number" class="form-control" id="monto" name="monto"
                            placeholder="Ingrese el monto a pagar" required>

        			</div>
        		</div>
        		<button type="submit" class="btn btn-dark">Crear Pago</button>
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