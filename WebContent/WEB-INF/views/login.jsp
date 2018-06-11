<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/verificar" method="post">
	<table>
		<tr>
			<th>
			Usuario:
			</th>
			<th>
			<input type="text" name="user"/>
			</th>
		</tr>
		<tr>
			<th>
			Contrase&nacute;a:
			</th>
			<th>
			<input type="password" name="pass"/>
			</th>
		</tr>
	</table>
	<input type="submit" value="Entrar" />
</form>

<c:if test = "${mensaje == 1}">
   <p style="color: red;">Se termino el tiempo habil de la sesion<p>
</c:if>

<form method="post"  action="${pageContext.request.contextPath}/crear_cuenta">
	<input type="submit" value="Crear cuenta"/>
</form>
</body>
</html>