<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath}/css/main.css" rel="stylesheet">
<title>Shopping Cart</title>
</head>
<body>
	<h1>Usuarios</h1>

	<a href="users/create">Cargar nuevo usuario <img src="${contextPath}/img/svg/add.svg" alt="Add" width="24" height="24"></a>

	<table class="cs-table">
		<caption>Listado de Usuarios</caption>
		<thead>
			<tr>
				<th>ID</th>
				<th>Nombre</th>
				<th>Usuario</th>
				<th>Contraseña</th>
				<th>Rol</th>
				<th>Dinero</th>
				<th>Acción</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td style="text-align: center; font-weight: bold">${user.idUser}</td>
					<td style="text-align: left">${user.name}</td>
					<td style="text-align: left">${user.username}</td>
					<td style="text-align: center">************</td>
					<td style="text-align: center">${user.rol}</td>
					<td style="text-align: right"><fmt:formatNumber value="${user.money}" type="number" maxFractionDigits="2" minFractionDigits="2" /></td>
					<td style="text-align: center">
						<a href="users/update?id=${user.idUser}" style="margin: 0 .5rem 0 0"><img src="${contextPath}/img/svg/edit.svg" alt="Edit" width="32" height="32"></a>
						<a href="users/delete?id=${user.idUser}"><img src="${contextPath}/img/svg/delete.svg" alt="Delete" width="32" height="32"></a>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>