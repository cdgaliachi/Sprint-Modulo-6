<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html> 
<%@ page import="grupo4.sprint6.modelos.*"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
    <html>
    <head>
        <meta charset="UTF-8">
		<title>Listado de Visitas</title>
		<link 	rel="icon" type="image/jpg" href="${pageContext.request.contextPath}/res/img/favicon.png"/>
		<!-- Enlace a Bootstrap CSS -->
		<link 	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"	rel="stylesheet">
		<!-- Enlace a la hoja de estilos personalizada -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/styles.css">
		<!--Link a googlefont-->
		<link 	rel="preconnect" 	href="https://fonts.googleapis.com">
		<link	rel="preconnect" 	href="https://fonts.gstatic.com" crossorigin>
		<link	href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet">
    </head>
    <body class="bod-img" style="background-image:url('${pageContext.request.contextPath}/res/img/cap5.jpg')" >
        <header>
        	<%@ include file="navbar.jsp"%>
        </header>
        <main class="container">
            <h3 class="my-md-3 text-dark p-md-2 visittbody">Listado de Visitas</h3>
        <div class="table-responsive">
        <table class="table table-striped table-hover">
            <thead class="table-dark">
                <tr>
                    <th scope="col">Id Visita</th>
                    <th scope="col">Rut Usuario</th>
                    <th scope="col">Fecha de Visita</th>
                </tr>
            </thead>
             <tbody class="visittbody">
                <%
                List<Visita> visitas = (List<Visita>)request.getAttribute("visitas");
                List<String> ruts = (List<String>)request.getAttribute("rut");
                    for(Visita v : visitas){
                    	int i = visitas.indexOf(v);
                        %>
                    <tr>
                        <th scope="row"><%=v.getIdV()%></th>
                        <td><%=ruts.get(i).toString()%></td>
                        <td><%=v.getFechaVisita()%></td>
                    </tr><%}%>
                </tbody>
        </table>
        	<div>
        		<button type="button" class="btn btn-dark col-12" data-bs-toggle="modal" data-bs-target="#visitaForm">Registrar Nueva Vista</button>
        	</div>
        </div>
        
        <div class="modal fade" id="visitaForm" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true" style="Color: #000000;">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
				<div class="modal-content">
					<div class="modal-header">
					<h2 class="mb-4 text-left">Registrar Visitas</h2>
						<form action="<c:url value='/visitas'/>" method="POST" id="crearVisita">
						<div class="row">
						<div class="col-12">
						<div class="mb-3">
							<label for="id" class="form-label">Rut Usuario</label> <select
								class="form-select" aria-label="Default select example"
								id="id" name="id" required>
								<option value="" selected disabled>Ingrese el RUT asociado a la visita</option>
								<% List<Usuario> listaUsuarios = (List<Usuario>)request.getAttribute("usuarios");
									for(Usuario u : listaUsuarios){
								%>
								<option value="<%=u.getId()%>"><%=u.getRut()%></option>
								<%} %>
							</select>
						</div>
						<div class="mb-3">
							<label for="fechaVisita" class="form-label">Fecha de Ingreso:</label>
							<input type="date" id="fechaVisita" name="fechaVisita" class="form-control" placeholder="DD/MM/AAAA" required>
							<br/>
							<button type="submit" class="btn btn-dark">Registrar</button>
						</div>
						</div>
						</div>
						</form>
					</div>
				</div>
			</div>
						<br>
					</div>
			
        </main>
        <footer>
            <%@ include file="footer.jsp" %>
        </footer>
        <!-- JQUERY -->
			<script src="https://code.jquery.com/jquery-3.7.1.slim.js"		integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc="		crossorigin="anonymous"></script>
		<!-- CDN de Bootstrap 5.0 -->
			<script 	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
			<script		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"		integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF"	crossorigin="anonymous"></script>
    </body>
    </html>