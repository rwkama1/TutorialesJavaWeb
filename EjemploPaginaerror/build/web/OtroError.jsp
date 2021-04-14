<%-- 
    Document   : OtroError
    Created on : 02-jun-2017, 19:49:16
    Author     : sistemas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
   <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de Pagina de Error - Error</title>
    </head>
    <body style="background-color: red;color:white;">
        <h1>!OTRO ERROR!</h1>
        
        <p>Se ha producido el siguiente error:</p>
        <p>${pageContext.errorData.throwable}</p>
    </body>
</html>
