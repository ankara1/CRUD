<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib  prefix = "form" uri = "http://www.springframework.org/tags/form"%> <!-- taglib para utilizar las form mvc tags -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form:form action="procesar" modelAttribute="elalumno"> 															<!-- el form:form action hace referencia a la url que va a redireccionar, y el modelAttribute al id que le di al model de la clase alumno -->
		nombre: <form:input path="nombre"/><form:errors path="nombre" style="color:red"/> <br><br>						<!-- este form:input con su path hace referencia al setter y getter de la clase del modelAttribute.. en este caso la clase alumno.. si el get o el set es getNombre, el path es nombre, sin get y con la primer letra en minuscula --> <!-- y el form:errors lo que hace es especificar que tiene que tener un error en caso de haber error de validacion y el mensaje que tomara es el especificado en la annotation Size, message en la clase alumno -->
		
		apellido: <form:input path="apellido"/><form:errors path="apellido" style="color:red"/> <br><br>
		
		edad: <form:input path="edad"/><form:errors path="edad" style="color:red"/> <br><br>							<!-- por detras lo que esta pasando es que esta mvc tag lo que hace es que cuando se apreta el boton enviar hace un setNombre y un setApellido con los textos escritos y luego los pide con un get en la pagina de confirmacion final -->
		
		email: <form:input path="email"/><form:errors path="email" style="color:red"/> <br><br>
		
		codigo postal: <form:input path="codigopostal"/><form:errors path="codigopostal" style="color:red"/> <br><br>
		
		asignaturas: <br> 
		
		<form:select path="optativa" multiple="false"> 																	<!-- form:select es para hacer un menu y multiple es para poder seleccionar varios-->
			<form:option value="karate" label="karate"></form:option>													<!-- option es para hacer las diferentes opciones del menu -->
			<form:option value="kung fu" label="kung fu"></form:option> 												<!-- label es lo que va a aparecer visible en la pagina -->
			<form:option value="judo" label="judo"></form:option>														<!-- value va a ser el id para rescatar el valor seleccionado -->
		</form:select> <br><br>
		
		barcelona <form:radiobutton path="ciudad" value="barcelona"/> <br>											<!-- radiobuttons en las que el path debe ser el mismo para que solo se pueda seleccionar y sobreescribir una -->
		madrid <form:radiobutton path="ciudad" value="madrid"/>	<br>												<!-- value es lo que va a escupir en la pagina registrado.jsp -->
		bilbao <form:radiobutton path="ciudad" value="bilbao"/> <br><br>											<!-- los path siempre llaman al set de la clase, en este caso de la variable ciudad y su set, y luego el value es el get a obtener pedido por la pagina registrado -->
		
		ingles <form:checkbox path="idioma" value="ingles"/> <br>			<!-- sintaxis de checkbox, igual que radiobutton pero con multiples opciones -->
		frances <form:checkbox path="idioma" value="frances"/> <br>
		aleman <form:checkbox path="idioma" value="aleman"/> <br><br>
		
		<input type="submit" value="enviar">
	</form:form> 
	
</body>
</html>