<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Cadastro de Usuários</title>
</head>
<body>
   
	<div class="container-cadastrar">
		<h2>Cadastro de Usuários</h2>
		<form action="salvarUsuario" class="cadastrar" method="post" id="FormUser">
		
            <input type="text" readonly="readonly" id="id" name="id" value="${user.id }">
            <br>
			<input type="text" id="login" name="login" placeholder="Nome" value="${user.login }">
			<br> 
			<input type="password" id="senha" name="senha"placeholder="senha" value="${user.senha }"> 
			<br> 
			<input type="text" id="nome" name="nome"placeholder="nome" value="${user.nome }"> 
			<br>
			<input type="text" id="telefone" name="telefone"placeholder="telefone" value="${user.telefone }"> 
			<br>
			<input class="btn"type="submit" value="salvar"> 
            <br>
            <input class="btn"type="submit" value="cancelar" onclick="document.getBayElementID('FormUser').action='salvarUsuario?acao=reset'">
		</form>
	</div>
	
</body>
</html>