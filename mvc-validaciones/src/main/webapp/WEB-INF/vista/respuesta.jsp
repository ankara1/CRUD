<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- la hoja de estilo css -->
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/recursos/estilos/miestilo.css">

<title>Insert title here</title>

</head>
<body>

<h1>Hola ${param.nombre}. bienvenido al curso de spring</h1>							<!-- en la jsp tag llamo con el param al nombre id del input type text del formulario.jsp -->
<p><br>																					<!-- parrafo y salto de linea con el br -->
<h3>atencion a todos</h3>																<!-- textito a partir de h3 -->
${elmensaje} 																			<!-- el id dado por el model del controlador con todo el mensaje llamado desde un jsp tag -->
<img alt="foto" src="${pageContext.request.contextPath}/recursos/images/imagen.png">	<!-- img es la etiqueta de imagenes, alt es el texto que va a aparecer en caso de no cargarse la imagen, en source primero va ese jsp tag para que se situe en la carpeta raiz de los jsp que es webapp y despues se indica la ruta de la imagen a pegar -->

</body>
</html>