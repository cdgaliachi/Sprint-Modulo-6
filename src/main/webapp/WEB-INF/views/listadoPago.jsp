<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="grupo4.sprint6.modelos.*"%>
<%@ page import ="java.util.ArrayList"%>
<%@ page import ="java.util.List"%>

    <!DOCTYPE html> 

    <html lang="es" >
        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
       
            <title>Listado de Pagos</title>
            <link 	rel="icon" type="image/jpg" href="${pageContext.request.contextPath}/res/img/favicon.png"/>
            <link rel="stylesheet" href="${pageContext.request.contextPath}/res/css/styles.css">
       
            <link 	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"	rel="stylesheet">
            <!-- Enlace a la hoja de estilos personalizada -->
            <!--Link a googlefont-->
            <link 	rel="preconnect" 	href="https://fonts.googleapis.com">
            <link	rel="preconnect" 	href="https://fonts.gstatic.com" crossorigin>
            <link	href="https://fonts.googleapis.com/css2?family=Raleway:wght@400;700&display=swap" rel="stylesheet">
            
        </head>
        <body class="bod-img" style="background-image:url('${pageContext.request.contextPath}/res/img/lpago.jpg')">
        	<header>
        		<%@ include file="navbar.jsp"%>
        	</header>
           <main class="container mt-5">
               <h3 class="mb-3">Listado de Pagos</h3>
               <div class="table-responsive">
                   <table class="table table-striped table-hover">
                       <thead class="table-dark">
                           <tr>
                               <th scope="col">Id Pago</th>
                               <th scope="col">Rut Cliente</th>
                               <th scope="col">Monto</th>
                               <th scope="col">Fecha de Pago</th>
                           </tr>
                       </thead>
                       <tbody class="bg-lil">
                           <%
                           List<Pago> pagos = (List<Pago>)request.getAttribute("pagos");
                           List<String> ruts = (List<String>)request.getAttribute("rut");
                           for(Pago p : pagos){
                               int i = pagos.indexOf(p);
                           %>
                           <tr>
                               <th scope="row"><%=p.getId()%></th>
                               <td><%=ruts.get(i).toString()%></td>
                               <td><%=p.getMonto()%></td>
                               <td><%=p.getFechaPago()%></td>
                           </tr>
                           <% } %>
                       </tbody>
                   </table>
               </div>
           </main>
           <footer>
               <%@ include file="footer.jsp" %>
           </footer>
           <script src="https://code.jquery.com/jquery-3.7.1.slim.js" integrity="sha256-UgvvN8vBkgO0luPSUl2s8TIlOSYRoGFAX4jlCIm9Adc=" crossorigin="anonymous"></script>
           <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
           <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
       </body>
       </html>