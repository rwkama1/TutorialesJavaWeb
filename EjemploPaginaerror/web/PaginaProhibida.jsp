<%-- 
    Document   : PaginaProhibida
    Created on : 02-jun-2017, 20:04:10
    Author     : sistemas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String usuario=request.getParameter("usuario")!=null?request.getParameter("usuario") : "";
     String contrasena=request.getParameter("contrasena")!=null?request.getParameter("contrasena"):"";
     if(!(usuario.equals("admin")&&contrasena.equals("admin")))
     {
         response.sendError(403);
     }
    %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de Pagina de Error - Pagina Prohibida</title>
    </head>
    <body>
        <h1>Ejemplo de Pagina de Error - Pagina Prohibida</h1>
        
        <p>Esta es una pagina prohibida al publico.</p>
      
    </body>
</html>
