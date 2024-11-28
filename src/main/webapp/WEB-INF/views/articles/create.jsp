<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<h1><a href="../articles"><img src="${contextPath}/img/svg/back.svg" alt="Back" width="48" height="48"></a>Artículo (crear)</h1>

	<form method="POST" action="create">
		<div>
			<label for="idArticle">Código</label>
			<input id="idArticle" name="idArticle" type="text" placeholder="Ingresa su Código" required>
		</div>
		<div>
			<label for="name">Nombre</label>
			<input id="name" name="name" type="text" placeholder="Ingresa su Nombre" required>
		</div>

		<div>
			<label for="description">Descripción</label>
			<input id="description" name="description" type="text" placeholder="Ingresa su Descripción" required>
		</div>
		<div>
			<label for="price">Precio</label>
			<input id="price" name="price" type="text" placeholder="Ingresa su Precio" required>
		</div>
		<div>
			<label for="stock">Stock</label>
			<input id="stock" name="stock" type="text" placeholder="Ingresa su Stock" required>
		</div>

		<a href="../articles" class="cancel-button">Cancelar</a>
		<button type="submit">Crear</button>
	</form>

</body>
</html>