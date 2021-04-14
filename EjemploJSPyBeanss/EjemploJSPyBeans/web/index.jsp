<%-- 
    Document   : index
    Created on : 05-jun-2017, 19:47:43
    Author     : sistemas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ejemplo de JSP Y BEANS</title>
    </head>
    <body>
        <jsp:useBean id="producto" class="beans.Producto" scope="session">
              <jsp:setProperty name="producto" property="codigo" value="1"/>
              <jsp:setProperty name="producto" property="descripcion" value="Tablet Google Nexus"/>
              <jsp:setProperty name="producto" property="precio" value="300"/>
        </jsp:useBean>
        <h1>Ejemplo de JSP y Beans</h1>
        
        <h2>Producto Actual:</h2>
        
        <p>Codigo:  <jsp:getProperty name="producto" property="codigo" /></p>
        <p>Descripcion:  <jsp:getProperty name="producto" property="descripcion" /></p>
        <p>Precio:  <jsp:getProperty name="producto" property="precio"/></p>
        <h2>Cambiar Por:</h2>
        <form action="CambiarProducto.jsp" method="post" accept-charset="ISO-8859-1">
            <table>
                <tr>
                    <td>Código:</td><td><input type="text" name="codigo"/></td>  
                </tr>
                  <tr>
                    <td>Descripción:</td><td><input type="text" name="descripcion"/></td> 
                </tr>
                  <tr>
                    <td>Precio:</td><td><input type="text" name="precio"/></td>
                </tr>
                  <tr>
                    <td></td><td><input type="submit" name="accion" value="Cambiar Producto"/></td>
                </tr>
            </table>
        </form>
    </body>
</html>
