<%-- 
    Document   : CambiarProducto
    Created on : 17/11/2013, 12:33:30 PM
    Author     : Raúl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cambiar Producto</title>
    </head>
    <body>
        <jsp:useBean id="producto" class="beans.Producto" scope="session" />
        
        <jsp:setProperty name="producto" property="codigo" />
        <jsp:setProperty name="producto" property="descripcion" />
        <jsp:setProperty name="producto" property="precio" />
        
        <jsp:forward page="index.jsp" />
    </body>
</html>
