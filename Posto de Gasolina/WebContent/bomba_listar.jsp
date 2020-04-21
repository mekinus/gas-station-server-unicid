<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"  %>
<%@ page import="br.edu.unicid.dao.BombaDAO"  %>
<%@ page import="br.unicid.posto.bean.Bomba"  %>
<% BombaDAO bombaDao = new BombaDAO();
List<Bomba> tempBombas = bombaDao.listar();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista das Bombas</title>
</head>
<body>

	<h2>Lista das Bombas</h2>
	
	<table>
	 <tr>
		<th>N�mero</th>
		<th>Quantidade de Combustivel</th>
		<th>Valor</th>
		</tr>	
		
	    <tbody>
		<c:forEach items="${jspBombas}" var="bomba">
		
		<tr>
		<td><c:out value="${bomba.getNumero()}"/></td>
		
		<td><c:out value="${bomba.quantidadeDeCombustivel}"/></td>
		
		<td><c:out value="${bomba.valor}"/></td>
		</tr>
		</c:forEach>
			
	
		</tbody>
			
			
			
		
	
	</table>
	
</body>
</html>