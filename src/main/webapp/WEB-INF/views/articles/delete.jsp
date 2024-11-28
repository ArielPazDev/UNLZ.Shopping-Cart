<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<h1><a href="../articles"><img src="${contextPath}/img/svg/back.svg" alt="Back" width="48" height="48"></a>Artículo ${idArticle} (borrar)</h1>
	
	<form method="POST" action="delete">
		<input name="idArticle" type="hidden" value="${idArticle}">
		
		<a href="../articles" class="cancel-button">Cancelar</a>
		<button type="submit">Confirmar el borrado del artículo ${idArticle}</button>
	</form>
	
</body>
</html>