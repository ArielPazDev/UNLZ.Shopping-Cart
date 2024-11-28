<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="${contextPath}/css/main.css" rel="stylesheet">
<title>Shopping Cart</title>
</head>
<body>
	<h1><a href="../wallets"><img src="${contextPath}/img/svg/back.svg" alt="Back" width="48" height="48"></a>Billetera (transferir)</h1>

	<form method="POST" action="transfer">
		<div>
			<label for="idUserReceptor">ID Cuenta (destino)</label>
			<input id="idUserReceptor" name="idUserReceptor" type="text" placeholder="Ingresa su Cuenta" required>
		</div>	
		<div>
			<label for="money">Dinero $</label>
			<input id="money" name="money" type="text" placeholder="Ingresa su Dinero" required>
		</div>

		<a href="../wallets" class="cancel-button">Cancelar</a>
		<button type="submit">Depositar</button>
	</form>
</body>
</html>