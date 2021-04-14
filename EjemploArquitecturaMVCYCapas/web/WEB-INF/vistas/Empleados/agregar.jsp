<%-- 
    Document   : Crear
    Created on : 05/12/2015, 08:17:45 PM
    Author     : Raúl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:paginaMaestra titulo="Agregar Empleado">
    <jsp:body>
        <t:editorEmpleados idFoco="cedula" textoBoton="Agregar" />
        
        <p><a href="empleados">Volver...</a></p>
        
        <t:mensaje />
    </jsp:body>
</t:paginaMaestra>
