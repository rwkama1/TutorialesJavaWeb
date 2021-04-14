<%-- 
    Document   : Error
    Created on : 17/11/2013, 04:45:05 PM
    Author     : Raúl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejercicio de JSP, Servlets y Beans - Error</title>
    </head>
    <body>
        <h1>Ejercicio de JSP, Servlets y Beans</h1>
        <h2>¡ERROR!</h2>
        
        <p>Se ha producido el siguiente error:</p>
        
        <p>${pageContext.exception.message}</p>
    </body>
</html>
