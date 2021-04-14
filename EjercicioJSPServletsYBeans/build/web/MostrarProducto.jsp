<%-- 
    Document   : MostrarProducto
    Created on : 17/11/2013, 04:46:55 PM
    Author     : Raúl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio de JSP, Servlets y Beans - Mostrar Producto</title>
    </head>
    <body>
        <jsp:useBean id="producto" class="beans.Producto" scope="request" />
        
        <h1>Ejercicio de JSP, Servlets y Beans</h1>
        <h2>Mostrar Producto</h2>
        
        <p><strong>Código:</strong> <jsp:getProperty name="producto" property="codigo" /></p>
        <p><strong>Descripción:</strong> <jsp:getProperty name="producto" property="descripcion" /></p>
        <p><strong>Costo:</strong> <jsp:getProperty name="producto" property="costo" /></p>
        <p><strong>Stock actual:</strong> <jsp:getProperty name="producto" property="stockActual" /></p>
        
        <br />
        
        <p><strong>Descripción:</strong> <%= producto.getDescripcion() %></p>
        
        <br />
        
        <p><strong>Descripción:</strong> ${producto.descripcion}</p>
    </body>
</html>
