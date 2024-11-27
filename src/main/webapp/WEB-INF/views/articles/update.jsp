<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<h1>Artículo ${article.idArticle} (editar)</h1>

	<form method="POST" action="update">
		<input name="idArticle" type="hidden" value="${article.idArticle}">
		<div>
			<label for="name">Nombre</label>
			<input id="name" name="name" type="text" placeholder="Ingresa su Nombre" value="${article.name}" required>
		</div>

		<div>
			<label for="description">Descripción</label>
			<input id="description" name="description" type="text" placeholder="Ingresa su Descripción" value="${article.description}" required>
		</div>
		<div>
			<label for="price">Precio $</label>
			<input id="price" name="price" type="text" placeholder="Ingresa su Precio" value="${article.price}" required>
		</div>
		<div>
			<label for="stock">Stock</label>
			<input id="stock" name="stock" type="text" placeholder="Ingresa su Stock" value="${article.stock}" required>
		</div>

		<a href="../articles" class="cancel-button">Cancelar</a>
		<button type="submit">Guardar</button>
	</form>

</body>
</html>