<%-- 
    Document   : index
    Created on : 17/11/2013, 12:43:54 PM
    Author     : Raúl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio de JSP y Beans</title>
    </head>
    <body>
        <jsp:useBean id="rotadorMensajes" class="beans.RotadorMensajes" scope="session" />
        
        <h1>Ejemplo de JSP y Beans</h1>
        
        <p><jsp:getProperty name="rotadorMensajes" property="mensaje" /></p>
    </body>
</html>
