<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<%@ page import="grupo4.sprint6.modelos.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>

<html>
<head>
	<meta charset="UTF-8">
	<title>Listado de Usuarios</title>
	<link rel="icon" type="image/jpg"	href="${pageContext.request.contextPath}/res/img/favicon.png" />
	<!-- Enlace a Bootstrap CSS -->
	<link	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"	rel="stylesheet">
	<!-- Enlace a la hoja de estilos personalizada -->
<link rel="stylesheet"	href="${pageContext.request.contextPath}/res/css/styles.css">
</head>
<body class="bod-img" style="background-image:url('${pageContext.request.contextPath}/res/img/cap5.jpg')">
	<header>
		<%@ include file="navbar.jsp"%>
	</header>
	<main class="container mt-md-4">
		<h3 class="mb-md-3 text-left text-dark visittbody ps-2">Lista de Usuarios</h3>
		<div class="table-responsive subtable">
			<table class="table table-striped table-hover" id="tablaUsuario">
				<thead class="table-dark">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nombre</th>
						<th scope="col">Rut</th>
						<th scope="col">Tipo</th>
					</tr>
				</thead>
				<tbody class="visittbody">
					<tr>


						<!-- Codigo Java con for each para que la tabla se llene con los datos que ingresa el cliente en crearcapacitacion -->
						<%
							List<Usuario> usuario = (List<Usuario>) request.getAttribute("usuarios");
							for (Usuario u : usuario) {
						%>
					
					<tr>
						<th scope="row"><%=u.getId()%></th>
						<td><%=u.getNombre()%></td>
						<td><%=u.getRut()%></td>
						<td><%=u.getTipo()%></td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
				<table class="table table-striped table-hover" id="tablaCliente" style="Display: none;">

					<thead class="table-dark">
						<tr>
							<th scope="col">Id</th>
							<th scope="col">Nombre</th>
							<th scope="col">Rut</th>
							<th scope="col">Tipo</th>
							<th scope="col">Teléfono</th>
							<th scope="col">Comuna</th>
							<th scope="col">Editar</th>
							<th scope="col">Borrar</th>
						</tr>
					</thead>
					<tbody class="visittbody">
						<tr>


							<!-- Codigo Java con for each para que la tabla se llene con los datos que ingresa el cliente en crearcapacitacion -->
							<%
						List<Cliente> cliente = (List<Cliente>) request.getAttribute("clientes");
						for (Cliente cl : cliente) {
						%>
					
					<tr>
						<th scope="row"><%=cl.getId()%></th>
						<td><%=cl.getNombre()%></td>
						<td><%=cl.getRut()%></td>
						<td><%=cl.getTipo()%></td>
						<td><%=cl.getTelefono()%></td>
						<td><%=cl.getComuna()%></td>
						<td>
							<button type="button" class="btn btn-warning"
								onClick="editCL(<%=cl.getId()%>, '<%=cl.getNombre()%>', '<%=cl.getRut()%>', '<%=cl.getTipo()%>', '<%=cl.getTelefono()%>', '<%=cl.getComuna()%>')" data-bs-toggle="modal"
								data-bs-target="#editarCliente">Editar</button>
						</td>
						<td>
							<button type="button" class="btn btn-danger"
								onclick="deleteUser(<%=cl.getId()%>, '<%=cl.getTipo()%>')">Borrar</button>
						</td>
					</tr>
					<%
					}
					%>

					</tbody>
				</table>
			<table class="table table-striped table-hover"
				id="tablaAdministrativo" style="Display: none;">

				<thead class="table-dark">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nombre</th>
						<th scope="col">Rut</th>
						<th scope="col">Tipo</th>
						<th scope="col">Área</th>
						<th scope="col">Experiencia Previa</th>
						<th scope="col">Editar</th>
						<th scope="col">Borrar</th>
					</tr>
				</thead>
				<tbody class="visittbody">
					<tr>


						<!-- Codigo Java con for each para que la tabla se llene con los datos que ingresa el cliente en crearcapacitacion -->
						<%
						Administrativo editAD = new Administrativo();
						List<Administrativo> administrativo = (List<Administrativo>) request.getAttribute("administrativos");
						for (Administrativo a : administrativo) {
						%>
					
					<tr>
						<th scope="row"><%=a.getId()%></th>
						<td><%=a.getNombre()%></td>
						<td><%=a.getRut()%></td>
						<td><%=a.getTipo()%></td>
						<td><%=a.getArea()%></td>
						<td><%=a.getExperienciaPrevia()%></td>
						<td>
							<button type="button" class="btn btn-warning" data-bs-toggle="modal"
								data-bs-target="#editarAdministrativo"
								onclick="editAD(<%=a.getId()%>, '<%=a.getNombre()%>', '<%=a.getRut()%>', '<%=a.getTipo()%>', '<%=a.getArea()%>', '<%=a.getExperienciaPrevia()%>')">Editar</button>
						</td>
						<td>
							<button type="button" class="btn btn-danger"
								onclick="deleteUser(<%=a.getId()%>, '<%=a.getTipo()%>')">Borrar</button>
						</td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>
			<table class="table table-striped table-hover" id="tablaProfesional"
				style="Display: none;">

				<thead class="table-dark">
					<tr>
						<th scope="col">Id</th>
						<th scope="col">Nombre</th>
						<th scope="col">Rut</th>
						<th scope="col">Tipo</th>
						<th scope="col">Título</th>
						<th scope="col">Fecha de Ingreso</th>
						<th scope="col">Editar</th>
						<th scope="col">Borrar</th>
					</tr>
				</thead>
				<tbody class="visittbody">
					<tr>


						<!-- Codigo Java con for each para que la tabla se llene con los datos que ingresa el cliente en crearcapacitacion -->
						<%
						Profesional editPF = new Profesional();
						List<Profesional> profesional = (List<Profesional>) request.getAttribute("profesionales");
						for (Profesional p : profesional) {
						%>
					
					<tr>
						<th scope="row"><%=p.getId()%></th>
						<td><%=p.getNombre()%></td>
						<td><%=p.getRut()%></td>
						<td><%=p.getTipo()%></td>
						<td><%=p.getTitulo()%></td>
						<td><%=p.getFechaDeIngreso()%></td>
						<td>
							<button type="button" class="btn btn-warning"
								data-bs-toggle="modal" data-bs-target="#editarProfesional"
								onclick="editPF(<%=p.getId()%>, '<%=p.getNombre()%>', '<%=p.getRut()%>' ,'<%=p.getTipo()%>', '<%=p.getTitulo()%>', '<%=p.getFechaDeIngreso()%>')">Editar</button>
						</td>
						<td>
							<button type="button" class="btn btn-danger"
								onclick="deleteUser(<%=p.getId()%>, '<%=p.getTipo()%>')">Borrar</button>
						</td>
					</tr>
					<%
					}
					%>

				</tbody>
			</table>

			<div class="container selector mt-md-5">
				<div class="d-flex justify-content-center">
					<h3 class="d-md-block d-none">Selecciona lista según tipo de usuario</h3>
				</div>
				<div class="d-flex justify-content-center mt-md-3">
					<div class="btn-group" role="group"
						aria-label="Botones de selección">
						<button type="button" class="btn btn-warning" id="buttonCliente">Cliente</button>
						<button type="button" class="btn btn-secondary"
							id="buttonProfesional">Profesional</button>
						<button type="button" class="btn btn-warning"
							id="buttonAdministrativo">Administrativo</button>
					</div>
				</div>
			</div>
		</div>

		<!-- Formularios ocultos que editan -->

		<div class="modal fade" id="editarCliente" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Editar
							Cliente</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<!-- Aqui empieza el form de cliente -->
					<form action="<c:url value='/usuario/actualizar'/>" method="POST">
						<div class="mb-3">
							<label for="nombre" class="form-label">Nombre de usuario</label>
							<input type="text" class="form-control" id="nombreClienteEdit" name="nombre"
								required value="">
						</div>
						<div class="mb-3">
							<label for="rut" class="form-label">RUT</label> <input
								type="text" class="form-control" id="rutClienteEdit" name="rut" required
								value="">
						</div>
						<div class="mb-3">
							<label for="telefono" class="form-label">Teléfono</label> <input
								type="text" id="telefonoClienteEdit" name="telefono" class="form-control"
								value="" required><br> <label
								for="comuna" class="form-label">Comuna</label> <input
								type="text" id="comunaClienteEdit" name="comuna" class="form-control"
								value="" required><br> <br>
						</div>
						<div class="mb-3">
							<label for="id" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="idClienteEdit" name="id"
								required value="">
						</div>
						<div class="mb-3">
							<label for="tipo" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="tipoClienteEdit" name="tipo"
								required value="">
						</div>
						<div class="mb-3">
							<label for="action" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="action"
								name="action" required value="actualizar">
						</div>
						<button type="submit" class="btn btn-dark">Guardar
							Cambios</button>
					</form>
				</div>
			</div>
		</div>

		<div class="modal fade" id="editarAdministrativo" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Editar
							Administrativo</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<!-- Aqui empieza el form de administrativo-->
					<form action="<c:url value='/usuario/actualizar'/>" method="POST">
						<div class="mb-3">
							<label for="nombre" class="form-label">Nombre de usuario</label>
							<input type="text" class="form-control" id="nombreAdministrativoEdit" name="nombre"
								required value="">
						</div>
						<div class="mb-3">
							<label for="rut" class="form-label">RUT</label> <input
								type="text" class="form-control" id="rutAdministrativoEdit" name="rut" required
								value="">
						</div>
						<div class="mb-3">
							<label for="area" class="form-label">Área</label> <input
								type="text" id="areaAdministrativoEdit" name="area" class="form-control"
								value="" required><br> <label
								for="feexperienciaPrevia" class="form-label">Experiencia
								Previa</label> <input type="text" id="experienciaPreviaAdministrativoEdit"
								name="experienciaPrevia" class="form-control"
								value="" required><br>
							<br>
						</div>
						<div class="mb-3">
							<label for="id" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="idAdministrativoEdit" name="id"
								required value="">
						</div>
						<div class="mb-3">
							<label for="tipo" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="tipoAdministrativoEdit" name="tipo"
								required value="">
						</div>
						<div class="mb-3">
							<label for="action" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="action"
								name="action" required value="actualizar">
						</div>
						<button type="submit" class="btn btn-dark">Guardar
							Cambios</button>
					</form>
				</div>
			</div>
		</div>

		<div class="modal fade" id="editarProfesional" tabindex="-1"
			aria-labelledby="exampleModalLabel" aria-hidden="true">
			<div
				class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
				<div class="modal-content">
					<div class="modal-header">
						<h1 class="modal-title fs-5" id="exampleModalLabel">Editar
							Profesional</h1>
						<button type="button" class="btn-close" data-bs-dismiss="modal"
							aria-label="Close"></button>
					</div>
					<!-- Aqui empieza el form de profesional -->
					<form action="<c:url value='/usuario/actualizar'/>" method="POST">
						<div class="mb-3">
							<label for="nombre" class="form-label">Nombre de usuario</label>
							<input type="text" class="form-control" id="nombreProfesionalEdit" name="nombre"
								required value="">
						</div>
						<div class="mb-3">
							<label for="rut" class="form-label">RUT</label> <input
								type="text" class="form-control" id="rutProfesionalEdit" name="rut" required
								value="">
						</div>
						<div class="mb-3">
							<label for="titulo" class="form-label">Título</label> <input
								type="text" id="tituloProfesionalEdit" name="titulo" class="form-control"
								value="" required><br> <label
								for="fechaIngreso" class="form-label">Fecha de Ingreso</label> <input
								type="date" id="fechaIngresoProfesionalEdit" name="fechaIngreso"
								class="form-control" value=""
								required><br> <br>
						</div>
						<div class="mb-3">
							<label for="id" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="idProfesionalEdit" name="id"
								required value="">
						</div>
						<div class="mb-3">
							<label for="tipo" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="tipoProfesionalEdit" name="tipo"
								required value="">
						</div>
						<div class="mb-3">
							<label for="action" class="form-label d-none"></label> <input
								type="text" class="form-control d-none" id="action"
								name="action" required value="actualizar">
						</div>
						<button type="submit" class="btn btn-dark">Guardar
							Cambios</button>
					</form>
				</div>
			</div>
		</div>
	</main>

	<footer>
		<%@ include file="footer.jsp"%>
	</footer>
	<!-- JQUERY -->
	<script src="https://code.jquery.com/jquery-3.7.1.slim.js"
		integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc="
		crossorigin="anonymous"></script>
	<!-- CDN de Bootstrap 5.1 -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"
		integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"
		integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>

	<script>
        function navigateTo(page) {
            window.location.href = page;
        }
    </script>
	<script>
    function editCL(id, nombre, rut, tipo, telefono, comuna){
    	document.getElementById('idClienteEdit').value = id;
        document.getElementById('nombreClienteEdit').value = nombre;
        document.getElementById('rutClienteEdit').value = rut;
        document.getElementById('tipoClienteEdit').value = tipo;
        document.getElementById('telefonoClienteEdit').value = telefono;
        document.getElementById('comunaClienteEdit').value = comuna;
        
    }
    
    function editPF(id, nombre, rut, tipo, titulo, fechaIngreso){
    	document.getElementById('idProfesionalEdit').value = id;
        document.getElementById('nombreProfesionalEdit').value = nombre;
        document.getElementById('rutProfesionalEdit').value = rut;
        document.getElementById('tipoProfesionalEdit').value = tipo;
        document.getElementById('tituloProfesionalEdit').value = titulo;
        document.getElementById('fechaIngresoProfesionalEdit').value = fechaIngreso;
    }
    
    function editAD(id, nombre, rut, tipo, area, experienciaPrevia){
    	document.getElementById('idAdministrativoEdit').value = id;
        document.getElementById('nombreAdministrativoEdit').value = nombre;
        document.getElementById('rutAdministrativoEdit').value = rut;
        document.getElementById('tipoAdministrativoEdit').value = tipo;
        document.getElementById('areaAdministrativoEdit').value = area;
        document.getElementById('experienciaPreviaAdministrativoEdit').value = experienciaPrevia;
    }

    function deleteUser(id, tipo, action) {
        // Lógica para borrar usuario
        if (confirm('¿Estás seguro de que deseas borrar este '+tipo+'?')) {
        	var form = document.createElement('form');
            form.method = 'POST';
            form.action = '<c:url value='/usuario/borrar'/>'; // El destino donde se manejará el POST

            // Crear un campo oculto para el ID del usuario
            var inputId = document.createElement('input');
            inputId.type = 'hidden';
            inputId.name = 'id';
            inputId.value = id;
            
         	// Crear un campo oculto para el tipo del usuario
            var inputTipo = document.createElement('input');
            inputTipo.type = 'hidden';
            inputTipo.name = 'tipo';
            inputTipo.value = tipo;
            
         	// Crear un campo oculto para el tipo del usuario
            var inputAction = document.createElement('input');
            inputAction.type = 'hidden';
            inputAction.name = 'action';
            inputAction.value = 'borrar';
            
            // Añadir el campo al formulario
            form.appendChild(inputId);
            form.appendChild(inputTipo);
            form.appendChild(inputAction);

            // Añadir el formulario al body y enviarlo
            document.body.appendChild(form);
            form.submit();
        }
    }
    
  //Funciones para cambio de tabla on click
    document.addEventListener('DOMContentLoaded', function() {
    document.getElementById('buttonCliente').addEventListener('click', function() {
    	document.getElementById('tablaUsuario').style.display = 'none';
    	document.getElementById('tablaProfesional').style.display = 'none';
    	document.getElementById('tablaAdministrativo').style.display = 'none';
    	document.getElementById('tablaCliente').style.display = 'block';
    });

    document.getElementById('buttonProfesional').addEventListener('click', function() {
    	document.getElementById('tablaUsuario').style.display = 'none';
    	document.getElementById('tablaProfesional').style.display = 'block';
    	document.getElementById('tablaAdministrativo').style.display = 'none';
    	document.getElementById('tablaCliente').style.display = 'none';
    });

    document.getElementById('buttonAdministrativo').addEventListener('click', function() {
    	document.getElementById('tablaUsuario').style.display = 'none';
    	document.getElementById('tablaProfesional').style.display = 'none';
    	document.getElementById('tablaAdministrativo').style.display = 'block';
    	document.getElementById('tablaCliente').style.display = 'none';
    });
    });
</script>

</body>
</html>
