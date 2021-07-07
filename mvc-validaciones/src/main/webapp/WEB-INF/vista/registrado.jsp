<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form"%> <!-- taglib para utilizar las form mvc tags -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>confirmacion de registro</title>
</head>
<body>

el alumno con nombre <strong>${elalumno.nombre}</strong>, apellido <strong>${elalumno.apellido}</strong> y edad <strong>${elalumno.edad}</strong> se ha registrado con exito
<br><br>
el email del alumno es: <strong>${elalumno.email}</strong> &nbsp; y su codigo postal es: <strong>${elalumno.codigopostal}</strong>
<br><br>
la asignatura escogida es: <strong>${elalumno.optativa}</strong>
<br><br>
la ciudad escogida para estudiar la asignatura es: <strong>${elalumno.ciudad}</strong>
<br><br>
el/los idiomas escogidos son: <strong>${elalumno.idioma}</strong>

</body>
</html>