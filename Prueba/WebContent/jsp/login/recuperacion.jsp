<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../complementos/boot.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel = "stylesheet" type="text/css" href = "/Prueba/css/recuperarform.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
			<div class="row main">
				<div class="panel-heading">
	               <div class="panel-title text-center">
	               		<h1 class="title">Nombre Usuario</h1>
	               		<hr />
	               	</div>
	            </div> 
				<div class="main-login main-center">
					<form class="form-horizontal" method="post" action="#">
						
						<div class="form-group">
							<label for="pin" class="cols-sm-2 control-label">PIN</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i class="fa fa-envelope fa" aria-hidden="true"></i></span>
									<input type="password" class="form-control" name="pin" id="pin"  placeholder="Escribe tu PIN"/>
								</div>
								<small class="text-muted">Para recuperar tu información presiona 'Recuperar'</small>
							</div>
						</div>

						<div class="form-group ">
							<button type="button" class="btn btn-primary btn-lg btn-block login-button">Recuperar</button>
						</div>
						<div class="form-group">
				            <a href="/Prueba/Index.jsp">Ir a Login</a>
				         </div>
					</form>
				</div>
			</div>
		</div>
</body>
</html>