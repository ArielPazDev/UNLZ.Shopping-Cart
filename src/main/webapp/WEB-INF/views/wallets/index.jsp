<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath}/css/main.css" rel="stylesheet">
<title>Shopping Cart</title>
</head>
<body>
	<h1><a href="../dashboard"><img src="${contextPath}/img/svg/back.svg" alt="Back" width="48" height="48"></a>Billetera (${user.name})</h1>

	<h2>Dinero disponible: $ ${user.money}</h2>

	<a href="wallets/deposit" style="margin: 0 .5rem 0 0">
		<img src="${contextPath}/img/svg/edit.svg" alt="Edit" width="32" height="32">
	</a>
	<a href="wallets/transfer">
		<img src="${contextPath}/img/svg/delete.svg" alt="Delete" width="32" height="32">
	</a>
</body>
</html>