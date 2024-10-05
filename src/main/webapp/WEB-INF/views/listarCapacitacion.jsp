<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <!DOCTYPE html> 
<%@ page import="grupo4.sprint6.modelos.*"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>
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
    <body class="bod-img" style="background-image:url('${pageContext.request.contextPath}/res/img/cap7.jpg')" >
        <header class="sticky-top ">
        	<%@ include file="navbar.jsp"%>
        </header>
        <main class="container mt-8">
            <table class="table bg-lil mt-4">
                <thead>
                    <tr>
                        <th scope="col">Identificador</th>   
                        <th scope="col">Día</th>
                        <th scope="col">Hora</th>
                        <th scope="col">Lugar</th>
                        <th scope="col">Duración</th>
                        <th scope="col">Cantidad Asistentes</th>
                    </tr>
                </thead>
                <tbody>
                <!-- Codigo Java con for each para que la tabla se llene con los datos que ingresa el cliente en crearcapacitacion -->
                <%
                List<Capacitacion> capacitacion = (List<Capacitacion>)request.getAttribute("capacitaciones");
                    for(Capacitacion c : capacitacion){
                        %>
                    <tr>
                        <th scope="row"><%=c.getIdentificador()%></th>
                        <td><%=c.getDia()%></td>
                        <td><%=c.getHora()%></td>
                        <td><%=c.getLugar()%></td>
                        <td><%=c.getDuracion()%></td>
                        <td><%=c.getCantidadAsistentes()%></td>
                    </tr><%}%>
                </tbody>
            </table>
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