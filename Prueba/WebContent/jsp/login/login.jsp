<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../complementos/boot.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<link rel = "stylesheet" type="text/css" href = "/Prueba/css/loginform.css">
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css" rel="stylesheet">
<title>Login</title>
</head>
<body>
<dir class = "center_div">
<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
            <h4>¡Bienvenido!</h4>
            <input type="text" id="userName" class="form-control input-sm chat-input" placeholder="usuario" />
            </br>
            <input type="text" id="userPassword" class="form-control input-sm chat-input" placeholder="contraseña" />
            </br>
            <div class="wrapper">
            <span class="group-btn">     
                <a href="/Prueba/jsp/principal/principal.jsp" class="btn btn-primary btn-md">Iniciar Sesión <i class="fa fa-sign-in"></i></a>
                <br><br><br>
                <a href="/Prueba/jsp/login/recuperacion.jsp" class="btn btn-success">Recuperar Información</a>
            </span>
            </div>
            </div>
        
        </div>
    </div>
</div>
</dir>
</body>
</html>