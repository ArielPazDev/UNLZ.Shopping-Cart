<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<h1><a href="../users"><img src="${contextPath}/img/svg/back.svg" alt="Back" width="48" height="48"></a>Usuario (crear)</h1>

	<form method="POST" action="create">
		<div>
			<label for="name">Nombre</label>
			<input id="name" name="name" type="text" placeholder="Ingresa su Nombre" required>
		</div>
		<div>
			<label for="username">Usuario</label>
			<input id="username" name="username" type="text" placeholder="Ingresa su Usuario" required>
		</div>
		<div>
			<label for="password">Contraseña</label>
			<input id="password" name="password" type="password" placeholder="Ingresa su Contraseña" required>
		</div>
		<div>
			<label for="rol">Rol</label>
			<select id="rol" name="rol" placeholder="Ingresa su Rol" required>
				<option selected></option>
				<option value="Empleado">Empleado</option>
				<option value="Cliente">Cliente</option>
			</select>
		</div>

		<a href="../users" class="cancel-button">Cancelar</a>
		<button type="submit">Crear</button>
	</form>

</body>
</html>