<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<h1>Listado de Artículos</h1>

	<ul>
		<c:forEach var="article" items="${articles}">
			<li>${article.codeArticle}</li>
		</c:forEach>
	</ul>
</body>
</html>