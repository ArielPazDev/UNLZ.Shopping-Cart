<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<h1>Usuarios (borrar)</h1>
	
	<form method="POST" action="delete">
		<input name="idUser" type="hidden" value="${idUser}">
		
		<a href="../users" class="cancel-button">Cancelar</a>
		<button type="submit">Confirmar el borrado del usuario ID ${idUser}</button>
	</form>
	
</body>
</html>