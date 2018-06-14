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
<form action="Sesion?op=l" method = "post">
<div class = "centrarlogo"><img src="/Prueba/imagenes/fordrs86.png" class="img-rounded"></div>
<dir class = "centrar">
<div class="container">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
            <h4>�Bienvenid@!</h4>
            <input type="text" id="userName" name = "user" class="form-control input-sm chat-input" placeholder="usuario" required />
            </br>
            <input type="password" id="userPassword" name = "pass" class="form-control input-sm chat-input" placeholder="contrase�a" required/>
            </br>
            <div class="wrapper">
            <span class="group-btn">    
            	<!-- href="/Prueba/jsp/principal/principal.jsp" -->
                <input type="submit" class="btn btn-primary btn-md" value = "Iniciar Sesi�n "><i class="fa fa-sign-in"></i></a>
                <br><br><br>
                <a href="/Prueba/jsp/login/recuperacion.jsp" class="btn btn-success">Recuperar Informaci�n</a>
            </span>
            </div>
            </div>
        
        </div>
    </div>
</div>
</dir>
</form>
</body>
</html>