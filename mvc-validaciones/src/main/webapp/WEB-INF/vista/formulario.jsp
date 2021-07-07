<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="procesar2" method="get"> <!-- aca va el nombre de la url a redireccionar (el que puse en el RequestMapping!) o al cual se enviaran los datos de este formulario y en el method va si quiero que sea post o get.. post es para enviar de archivo a archivo y get es para enviar por url-->
		<input type="text" name="nombre"> <!-- input es para hacer cuadros a rellenar y son de tipo texto, el nombre es el indicativo para rescatar lo que se alla escrito -->
		<input type="submit">				<!-- input type submit es un jbutton para enviar -->
	</form>
</body>
</html>