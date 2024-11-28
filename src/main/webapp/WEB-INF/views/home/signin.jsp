<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<h1>Iniciar sesión</h1>
	
	<form method="POST" action="signin">
		<div>
			<label for="username">Usuario</label>
			<input id="username" name="username" type="text" placeholder="Ingresa su Usuario" required>
		</div>
		<div>
			<label for="password">Contraseña</label>
			<input id="password" name="password" type="password" placeholder="Ingresa su Contraseña" required>
		</div>

		<a href="../home" class="cancel-button">Cancelar</a>
		<button type="submit">Iniciar sesión</button>
	</form>	

</body>
</html>