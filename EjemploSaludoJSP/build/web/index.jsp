<%-- 
    Document   : index
    Created on : 31-may-2017, 19:34:16
    Author     : sistemas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%!
    private String accion, nombre;
 %>
 <%
 accion=request.getParameter("accion");
 nombre=request.getParameter("nombre");
 nombre=nombre != null && nombre.length() > 0 ? nombre:null;
 if(session.getAttribute("primerMensaje")==null)
 {
     session.setAttribute("primerMensaje","Bienvenid@ a Java Web.");
     session.setAttribute("segundoMensaje","Esperamos que lo disfrutes.");
 }
 %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Saludo en JSP</title>
    </head>
    <body>
        <jsp:include page="Titulo">
            <jsp:param name="subtitulo" value="S"/>
        </jsp:include>
        <form>
            <table>
                <tr>
                    <td>Escribe tu nombre: </td>
                    <td>
                        <input type="text" name="nombre"/>
                    </td>
                </tr>
                <tr>
                    <td colspan="2" style="text-align: right;">
                        <input type="submit" name="accion" value="Saludar"/>
                    </td>
                </tr>
            </table>
        </form>
        <% if((accion != null)&& accion.equals("Saludar")&&(nombre!=null)){%>
        <p>!Hola <%=nombre %>!</p>
        <p>!Chau ${param.nombre})!</p>
        <% } %>
        <p><%=session.getAttribute("primerMensaje")%></p>
        <p>${segundoMensaje}</p>
        
    </body>
</html>
