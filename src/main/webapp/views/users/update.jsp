<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<h1>Usuarios (editar)</h1>

	<form method="POST" action="update">
		<input name="rol" type="hidden" value="${user.rol}">
		<div>
			<label for="idUser">ID</label>
			<input id="idUser" name="idUser" type="text" placeholder="Ingresa su ID" value="${user.idUser}" readonly>
		</div>
		<div>
			<label for="name">Nombre</label>
			<input id="name" name="name" type="text" placeholder="Ingresa su Nombre" value="${user.name}" required>
		</div>
		<div>
			<label for="username">Usuario</label>
			<input id="username" name="username" type="text" placeholder="Ingresa su Usuario" value="${user.username}" required>
		</div>
		<div>
			<label for="password">Contraseña</label>
			<input id="password" name="password" type="password" placeholder="Ingresa su Contraseña" value="${user.password}" required>
		</div>
		<div>
			<label for="money">Dinero</label>
			<input id="money" name="money" type="text" placeholder="Ingresa su Dinero" value="${user.money}" required>
		</div>
		<a href="../users" class="cancel-button">Cancelar</a>
		<button type="submit">Guardar</button>
	</form>

</body>
</html>