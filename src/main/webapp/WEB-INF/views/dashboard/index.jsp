<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping Cart</title>
</head>
<body>
	<h1>Dashboard ${user.name}</h1>
	
	<a href="dashboard/users">Usuarios<img src="${contextPath}/img/svg/add.svg" alt="Add" width="24" height="24"></a>
	<a href="dashboard/articles">Artículos<img src="${contextPath}/img/svg/add.svg" alt="Add" width="24" height="24"></a>
	<a href="dashboard/wallets">Billetera<img src="${contextPath}/img/svg/add.svg" alt="Add" width="24" height="24"></a>
	
	<a href="dashboard/signout">Sign Out <img src="${contextPath}/img/svg/add.svg" alt="Add" width="24" height="24"></a>

</body>
</html>