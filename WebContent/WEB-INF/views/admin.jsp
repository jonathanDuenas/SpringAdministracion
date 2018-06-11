<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Administrador</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/centro_escolar">
    	<input type="submit" value="Centro escolar" />
	</form>
	<form action="${pageContext.request.contextPath}/departamentos">
    	<input type="submit" value="Departamentos" />
	</form>
	<form action="${pageContext.request.contextPath}/municipio">
    	<input type="submit" value="Municipio" />
	</form>
	<form action="${pageContext.request.contextPath}/materias">
    	<input type="submit" value="Materias" />
	</form>
	<form action="${pageContext.request.contextPath}/usuarios">
    	<input type="submit" value="Usuarios" />
	</form>
	</br>
	<form action="${pageContext.request.contextPath}/salir">
    	<input type="submit" value="Cerrar sesion" />
	</form>
</body>
</html>