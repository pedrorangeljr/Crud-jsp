<jsp:useBean id="calcula" class="beans.BeanCursoJsp" type="beans.BeanCursoJsp" scope="page"></jsp:useBean>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<title>Login Usuário</title>
</head>
<body>
<br>
  <div class="container">
  
        <h1>Login Usuário</h1>
        
        <form action="LoginServlet" class="login" method="post">
            <input type="text" id="login" name="login" placeholder="Login">
            <br>
            <input type="password" id="senha" name="senha" placeholder="senha">
            <br>
            <input class="btn" type="submit" value="Logar">
        </form>
        
    </div>  
</body>
</html>