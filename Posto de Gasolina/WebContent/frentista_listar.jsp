<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista dos Frentistas</title>
</head>
<body>

	<h2>Lista dos Frentistas</h2>
	
	<table>
	 <tr>
		<th>Nome</th>
		<th>Salario</th>
		</tr>	
		
	    <tbody>
		<c:forEach items="${jspFrentistas}" var="frentista">
		
		<tr>
		<td><c:out value="${frentista.nomeFrentista}"/></td>
		
		<td><c:out value="${frentista.salarioFrentista}"/></td>
		
		</tr>
		</c:forEach>
			
	
		</tbody>
			
			
			
		
	
	</table>
	
</body>
</html>