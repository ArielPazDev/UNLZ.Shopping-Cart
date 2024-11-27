<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<h1>Usuario ${user.name} (borrar)</h1>
	
	<form method="POST" action="delete">
		<input name="idUser" type="hidden" value="${user.idUser}">
		
		<a href="../users" class="cancel-button">Cancelar</a>
		<button type="submit">Confirmar el borrado del usuario ${user.name}</button>
	</form>
	
</body>
</html>