<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Usuarios Salvos</title>
</head>
<body>

<h1>Usuários Salvos</h1>
 <h3 style="color: red;">${msg}</h3>
  <div class="container-tabela">
   <table class="tabela">
              <tr>
                  <th>Id</th>
                  <th>Login</th>
                  <th>Nome</th>
                   <th>Telefone</th>
                  <th>Editar</th>
                  <th>Excluir</th> 
              </tr> 
        <c:forEach items="${usuarios }" var="user">
            
            <tr>
            <td style="width: 150px"><c:out value="${user.id }"></c:out></td>
              <td style="width: 150px"><c:out value="${user.login }"></c:out></td>
              <td><c:out value="${user.nome }"></c:out></td>
              <td><c:out value="${user.telefone }"></c:out></td>
              <td><button class="btn-editar"><a href="salvarUsuario?acao=editar&user=${user.login }">Editar</a></button></td>
              <td><button class="btn-excluir"><a href="salvarUsuario?acao=delete&user=${user.login }">Excluir</a></button></td>
            </tr>
        </c:forEach>
   </table>
   
  </div>

</body>
</html>