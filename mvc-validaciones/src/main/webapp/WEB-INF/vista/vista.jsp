<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>primer ejemplo de mvc en spring</h1>

<a href="principal/formulario">ir al formulario</a>	<!-- en href hago referencia al nombre de url que le di al formulario desde el RequestMapping del controlador, las palabritas de al lado son las que van a aparecer en azul-->
<!-- <a href="secundario/formulario">ir al formulario</a> -->
<br><br><br>

<a href="alumno/formulario">ir al formulario de registro de alumnos</a> <!-- el href apunta al requestmapping del controlador para mandar a llamar a la pagina que retorne el metodo, en este caso al poner alumno/formulario llamo al controlador alumno y al metodo que contiene el requestmapping formulario que en su return devuelve registro.jsp -->

</body>
</html>