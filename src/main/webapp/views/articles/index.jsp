<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath}/css/main.css" rel="stylesheet">
<title>Shopping Cart</title>
</head>
<body>
	<h1>Artículos</h1>

	<a href="articles/create">Cargar nuevo artículo <img src="${contextPath}/img/svg/add.svg" alt="Add" width="24" height="24"></a>

	<table class="cs-table">
		<caption>Listado de Artículos</caption>
		<thead>
			<tr>
				<th>Código</th>
				<th>Nombre</th>
				<th>Descripción</th>
				<th>Precio</th>
				<th>Stock</th>
				<th>Acción</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="article" items="${articles}">
				<tr>
					<td style="text-align: center; font-weight: bold">${article.idArticle}</td>
					<td style="text-align: left">${article.name}</td>
					<td style="text-align: left">${article.description}</td>
					<td style="text-align: right">${article.price}</td>
					<td style="text-align: right">${article.stock}</td>
					<td style="text-align: center">
						<a href="articles/update?id=${article.idArticle}" style="margin: 0 .5rem 0 0"><img src="${contextPath}/img/svg/edit.svg" alt="Edit" width="32" height="32"></a>
						<a href="articles/delete?id=${article.idArticle}"><img src="${contextPath}/img/svg/delete.svg" alt="Delete" width="32" height="32"></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>