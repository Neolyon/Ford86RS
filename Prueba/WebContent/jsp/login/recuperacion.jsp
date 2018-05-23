<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../complementos/boot.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src = "/Prueba/js/login/loginscript.js"></script>
<link rel = "stylesheet" type="text/css" href = "/Prueba/css/recuperarform.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<dir class="centrar">
	<div class="main-login main-center">
		<form class="form-horizontal" method="post" action="#">

			<div class="form-group">
				<label for="pin" class="cols-sm-2 control-label">Recuperación
					de Información...</label>
				<div class="cols-sm-10">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="fa fa-envelope fa" aria-hidden="true"></i></span> <input
							type="password" class="form-control" name="nip" id="nip"
							placeholder="Escribe tu NIP" />
					</div>
					<small class="text-muted">Para recuperar tu información
						presiona "Recuperar"</small>
				</div>
			</div>

			<div class="form-group ">
				<button type="button"
					class="btn btn-primary btn-lg btn-block login-button" onclick="recuperacion();">Recuperar</button>
			</div>
			<div class="form-group">
				<a href="/Prueba/Index.jsp">Ir a Login</a>
			</div>
		</form>
	</div>
	</dir>
</body>
</html>