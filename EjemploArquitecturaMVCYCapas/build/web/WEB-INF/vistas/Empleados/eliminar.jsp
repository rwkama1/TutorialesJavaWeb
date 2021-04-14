<%-- 
    Document   : Eliminar
    Created on : 05/12/2015, 10:08:26 PM
    Author     : Raúl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:paginaMaestra titulo="Eliminar Empleado">
    <jsp:body>
        <c:if test="${!empty empleado}">
            <p>¿Está segur@ que desea eliminar el empleado con cédula <strong>${empleado.cedula}</strong> (${empleado.nombre})?</p>
            
            <form method="post" accept-charset="ISO-8859-1">
                <input type="hidden" name="cedula" value="${empleado.cedula}" />
                <input type="submit" name="accion" value="Eliminar" />
            </form>
        </c:if>
        
        <p><a href="empleados">Volver...</a></p>
        
        <t:mensaje />
    </jsp:body>
</t:paginaMaestra>
