<%-- 
    Document   : ProvocarOtroError
    Created on : 02-jun-2017, 20:01:21
    Author     : sistemas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" errorPage="OtroError.jsp"%>
<%
    if(request.getParameter("accion")!=null&&request.getParameter("accion").equals("Provocar Error"))
    {
        int resultado=1 / 0;
    }
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo Pagina error- Provocar Otro Error</title>
    </head>
    <body>
        <h1>Ejemplo de Pagina de Error- Provocar Otro Error</h1>
        <form>
            <p><input type="submit" name="accion" value="Provocar Error"/></p>
        </form>
    </body>
</html>
