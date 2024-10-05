<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/styles.css">
<!--     <link rel="stylesheet" href="../res/css/styles.css"/> -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bod-img" style="background-image:url('${pageContext.request.contextPath}/res/img/sharepoint-training-8112055_1920.jpg')" >
	<main class="mainlog">	
		<div class="row">
			<div class="col-1 d-md-block d-none"></div>
			<div class="col-8 p-2">
    			<div class="container-login">
        			<div class="row justify-content-left p-3" style="width: 71.5dvh;">
            			<div class="col-sm-6">
                		<div class="card mt-5" style="width: 45dvh;">
                    		<div class="card-header text-center">
                        		<h3 class="text-dark">Iniciar Sesión</h3>
                    		</div>
                    		<div class="card-body">
                        		<form action="${pageContext.request.contextPath}/perform_login" method="post">
                            		<div class="mb-3">
                                		<label for="username" class="form-label text-dark">Usuario</label>
                                		<input type="text" class="form-control" id="username" name="username" required placeholder="USERNAME">
                            		</div>
                            		<div class="mb-3">
                                		<label for="password" class="form-label text-dark">Contraseña</label>
                                		<input type="password" class="form-control" id="password" name="password" required placeholder="PASSWORD">
                            		</div>
                            		<div class="d-grid">
                                		<button type="submit" class="btn btn-secondary">Ingresar</button>
                            		</div>
                        		</form>
                    		</div>
                    		<div class="card-footer text-center text-dark">
                        		<small>© 2024 Capacita'o/OTEC</small>
                    		</div>
                		</div>
            			</div>
        			</div>
    			</div>			
			</div>
			<div class="col-"></div>
		</div>
		
		<!-- Modal para mensajes -->
        <div class="modal fade" id="messageModal" tabindex="-1" aria-labelledby="messageModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="messageModalLabel">Mensaje</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body" id="modalMessage">
                        <!-- El mensaje se insertará aquí -->
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                    </div>
                </div>
            </div>
        </div>
	</main>
   <footer>
        <%@ include file="footer.jsp"%>
    </footer>
	<!-- CDN de Bootstrap 5.1 -->
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"	integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"	integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13"
		crossorigin="anonymous"></script>
		
	<!-- Script para manejar mensajes -->
    <script>
        // Función para mostrar el modal con un mensaje
        function showMessage(message, isError) {
            var modalMessage = document.getElementById('modalMessage');
            modalMessage.textContent = message;
            modalMessage.className = isError ? 'text-danger' : 'text-success';
            var messageModal = new bootstrap.Modal(document.getElementById('messageModal'));
            messageModal.show();
        }

        // Verificar si hay un mensaje de error en la URL
        var urlParams = new URLSearchParams(window.location.search);
        if (urlParams.has('error')) {
            showMessage('Error en el inicio de sesión. Por favor, intente de nuevo.', true);
        }

        // Verificar si hay un mensaje de éxito en la URL (por si lo implementas en el futuro)
        if (urlParams.has('success')) {
            showMessage('Inicio de sesión exitoso.', false);
        }
    </script>
</body>
</html>