<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>la pagina de bienvenida</title>

<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/estilo.css"/>

</head>
<body>
<!-- <% response.sendRedirect("proyecto/lista"); %> --> <!-- esto es para redireccionar automaticamente sin pagina de bienvenida, aparentemente se puede usar por medio del scriplet cualquier objeto de cualquier clase, haciendolas pasar a todas las clases por publicas... -->

<h1>Esta es la pagina de bienvenida donde estaré haciendo modificaciones en breve</h1>

<a href="proyecto/lista">la lista del CRUD</a> <br>
  <!-- <a href="2doProyecto">proximamente algo.. todavia un error 404</a> -->

</body>
</html>