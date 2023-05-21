<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>

<html>
<head>

</head>
<body>

	<h3>Benvenuto ${nomeUtente} ${cognomeUtente}</h3>
		<table style="border: 1px solid black">
    		<tr style="border: 1px solid black">
    			<th>NOME</th>
    			<th>CATEGORIA</th>
    			<th>PREZZO</th>
    		</tr>
    		<c:forEach items="${prodottoList}" var="unProdotto">
    			<tr style="border: 1px solid black">
    				<td>${unProdotto.nome}</td>
    				<td>${unProdotto.categoria}</td>
    				<td>${unProdotto.prezzo}</td>
    			</tr>
    		</c:forEach>
        </table>

</body>
</html>