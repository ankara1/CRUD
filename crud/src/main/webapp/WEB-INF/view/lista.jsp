<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilo.css"/>

</head>
<body>

<h1>esta es la lista de la BBDD</h1>

<table border="1">

	<tr>
		<th>nombre</th>
		<th>apellido</th>
		<th>email</th>
		<th>modificar</th>
		<th>borrar</th>
	</tr>
	
	<c:forEach var="cltemp" items="${losclientes}"> <!-- losclientes es el nombre id que estableci dentro del model del controlador -->
	
	<!-- link para actualizar -->
		<c:url var="actualiza" value="/proyecto/actualizar"> <!-- la variable debe llamarse igual al href del input type button de debajo enserrado en la jsptag y el value es la url a la que va a redirigir desde el controlador -->
			<c:param name="elID" value="${cltemp.ID}"></c:param> <!-- a cada vuelta de bucle se almacenara en el boton actualizar la id de cada cliente-->	
		</c:url>
		
	<!-- link para borrar -->	
		<c:url var="borra" value="/proyecto/borrar"> <!-- la variable debe llamarse igual al href del input type button de debajo enserrado en la jsptag y el value es la url a la que va a redirigir desde el controlador -->
			<c:param name="elID" value="${cltemp.ID}"></c:param> <!-- a cada vuelta de bucle se almacenara en el boton actualizar la id de cada cliente-->	
		</c:url> 
			
		<tr>
			<td>${cltemp.NOMBRE}</td> <!-- recorro con este bucle forEach todos los registros del CRUD previamente almacenados en el metodo lista del Controlador para meterlos dentro de los td -->
			<td>${cltemp.APELLIDO}</td> <!-- recorro con este bucle forEach todos los registros del CRUD previamente almacenados en el metodo lista del Controlador para meterlos dentro de los td -->
			<td>${cltemp.EMAIL}</td> <!-- recorro con este bucle forEach todos los registros del CRUD previamente almacenados en el metodo lista del Controlador para meterlos dentro de los td -->
			<td><a href="${actualiza}"><input type="button" value="actualizar"></a></td>
			<td><a href="${borra}"><input type="button" value="borrar" onclick="if(!(confirm('estas a punto de eliminar el registro, estas seguro?'))) return false"></a></td>
		</tr>
	
	</c:forEach>
	
</table><br>

<input type="button" value="agregar clientes" onclick="window.location.href='agregar'; return false;"> <!-- onclick = codigo javascript para ActionListener la clase es window.location y a donde va a redireccionar es a una url de nombre agregar que estare creando, el return false es para que no haga nada mas que redireccionar-->

</body>
</html>


