<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html> 
<%@ page import="grupo4.sprint6.modelos.*"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
    <html>
    <head>
        <meta charset="UTF-8">
		<title>Listado de Capacitaciones</title>
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
    <body class="bod-img" style="background-image:url('${pageContext.request.contextPath}/res/img/cap7.jpg')" >
        <header>
        	<%@ include file="navbar.jsp"%>
        </header>
        <main class="container">
        <h3 class="my-3">Checklist</h3>
        <div class="table-responsive">
            <table class="table bg-osc2 rounded">
                <thead>
                    <tr>
                        <th class="textdl" scope="col">Marca</th>   
                        <th class="textdl" scope="col">Revision</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>
                        	<div class="form-check">
						  		<input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
							</div>
						</td>
                        <td class="textdl" >Uso adecuado de equipo de protección personal (EPP).</td>
                    </tr>
                    <tr>
                        <td>
                        	<div class="form-check">
						  		<input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
							</div>
						</td>
                        <td class="textdl">Zonas de trabajo limpias y sin obstáculos.</td>
                    </tr>
                    <tr>
                        <td>
                        	<div class="form-check">
						  		<input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
							</div>
						</td>
                        <td class="textdl">Maquinaria y herramientas en buen estado y con mantenimiento al día.</td>
                    </tr>
                    <tr>
                        <td>
                        	<div class="form-check">
						  		<input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
							</div>
						</td>
                        <td class="textdl">Salidas de emergencia señalizadas y accesibles.</td>
                    </tr>
                    <tr>
                        <td><div class="form-check">
						  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
						</div>
						</td>
                        <td class="textdl">Extintores disponibles y operativos.</td>
                    </tr>
                    <tr>
                        <td><div class="form-check">
						  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
						</div>
						</td>
                        <td class="textdl">Medidas de prevención de caídas en trabajos en altura implementadas.</td>
                    </tr>
                    <tr>
                        <td><div class="form-check">
						  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
						</div>
						</td>
                        <td class="textdl">Protocolos de seguridad en áreas de riesgo respetados.</td>
                    </tr>
                    <tr>
                        <td><div class="form-check">
						  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
						</div>
						</td>
                        <td class="textdl">Trabajadores capacitados en primeros auxilios y evacuación.</td>
                    </tr>
                    <tr>
                        <td><div class="form-check">
						  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
						</div>
						</td>
                        <td class="textdl">Rutas de evacuación señalizadas y libres de obstrucciones.</td>
                    </tr>
                    <tr>
                        <td><div class="form-check">
						  <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault">
						</div>
						</td>
                        <td class="textdl">Kit de primeros auxilios disponible en la zona de trabajo.</td>
                    </tr>
                </tbody>
            </table>
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