<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form" %>	<!-- para usar etiquetas form -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilo.css"/>

</head>
<body>

<h2>aca va a estar el formulario para agregar clientes al CRUD</h2>

<!-- el action debe llamarse igual a lo que se ponga en el GetMapping y tambien igual al metodo a desarrollar en la interfaz y clase que implementa dicha interfaz -->

<form:form action="insertado" modelAttribute="addcliente" method="POST"> <!-- dentro del form:form se indica a donde queres que se envie la informacion del formulario, se le debe especificar url, lo del modelAttribute es para recopidar el model attribute creado en el controlador en el medoro agregar que contiene un objeto de tipo CRUD para meter los datos ahi para ser llamado por el controlador con una anotation @PostMapping y el metodo que contenga dentro de los argumentos el @ModelAttribute con el id entre parentesis y comillas de este id y a continuacion un objeto en el cual guardar este "Bean", que en este caso tiene que ser un objeto de tipo CRUD ya que lo que se quiere es agregar un cliente en la tabla CRUD de la bbdd y el metodo post es para que la informacion se envie pero no por la url sino por la clase -->
	
	<form:hidden path="iD"/>
	
	<table>
	
		<tr>
			<td>Nombre: </td>
			<td><form:input path="nOMBRE"/></td>
		</tr>
		
		<tr>
			<td>Apellido: </td>
			<td><form:input path="aPELLIDO"/></td>
		</tr>
		
		<tr>
			<td>Email: </td>
			<td><form:input path="eMAIL"/></td> <!-- el path es el setter de los campos de clase del objeto CRUD -->
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="insertar/actualizar"></td>
		</tr>
		
	</table>
</form:form>

</body>
</html>