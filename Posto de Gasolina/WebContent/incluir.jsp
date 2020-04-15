<%@      taglib prefix="resp" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastrar Aluno</title>
</head>
<body>

 <form action=" ${pageContext.request.contextPath}/incluir.aluno" method="get">

<table style="width:50%" border = "1px" align ="center">
  <tr>
      <td colspan="2"  align ="center" ><h3>Cadastrar Aluno</h3></td>   
  </tr>
  <tr>
    <th>C.A.:</th>
    <td><input type="text" name="ca"></td>     
  </tr>
  <tr>
    <th>Nome.:</th>
    <td><input type="text" name="nome"></td>   
  </tr>
  <tr>
    <th>E-mail.:</th>
    <td><input type="text" name="email"></td>   
  </tr>
  <tr>
    <th>Data de Nascimento.:</th>
    <td><input type="text" name="dt_nasc"></td>   
  </tr>  <tr>
    <th>Endereço.:</th>
    <td><input type="text" name="endereco"></td>    
  </tr>
  <tr>
      <td colspan="2"  align ="center" ><input type="submit" name="Enviar" value="Enviar"></td>   
  </tr>
</table>
</form>
<center><resp:out value="${menssagem}" /></center>
</body>
</html>