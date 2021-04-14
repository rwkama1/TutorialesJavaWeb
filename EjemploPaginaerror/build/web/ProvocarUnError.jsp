<%-- 
    Document   : ProvocarUnError
    Created on : 02-jun-2017, 19:55:08
    Author     : sistemas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <title>Ejemplo Pagina error- Provocar Un Error</title>
    </head>
    <body>
        <h1>Ejemplo de Pagina de Error- Provocar un Error</h1>
        <form>
            <p><input type="submit" name="accion" value="Provocar Error"/></p>
        </form>
    </body>
</html>
