<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Crear centro escolar</title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath}/guardarCentro" >
	<table>
	<tr>
		<th>
		descripcion
		</th>
		<th>
		<input type="text" name="descripcion"/>
		</th>
	</tr>
	<tr>
		<th>
		municipio
		</th>
		<th>
		<select name="municipio">
			<c:forEach items="${municipio}" var = "i">
			<option value="${i.id }">${i.descripcion}</option>
			</c:forEach>
		</select>
		</th>
	</tr>
	
	</table>
	<input type="submit" value="Crear cuenta"/>
</form>
</body>
</html>