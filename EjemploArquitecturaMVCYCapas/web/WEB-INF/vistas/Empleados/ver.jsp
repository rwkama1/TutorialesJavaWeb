<%-- 
    Document   : Ver
    Created on : 04/12/2015, 12:16:13 AM
    Author     : Raúl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:paginaMaestra titulo="Ver Empleado">
    <jsp:body>
        <c:if test="${!empty empleado}">
            <jsp:useBean id="empleado" type="compartidos.beans.datatypes.DTEmpleado" scope="request" />
            
            <h3><jsp:getProperty name="empleado" property="nombre" /></h3>
            
            <ul>
                <li><strong>Cédula:</strong> <jsp:getProperty name="empleado" property="cedula" /></li>
                <li><strong>Nombre:</strong> <jsp:getProperty name="empleado" property="nombre" /></li>
                <li><strong>Sueldo:</strong> <jsp:getProperty name="empleado" property="sueldo" /></li>
            </ul>
        </c:if>
        
        <p><a href="empleados">Volver...</a></p>
        
        <t:mensaje />
    </jsp:body>
</t:paginaMaestra>
