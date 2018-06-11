<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Crear Expediente</title>
</head>
<body>

<table>
	<tr>
		<th>
			Nombre
		</th>
		<th>
			<input type="text" name= "nombre">
		</th>
	</tr>
	<tr>
		<th>
			Apellido
		</th>
		<th>
			<input type="text" name= "apellido">
		</th>
	</tr>
	<tr>
		<th>
			Carnet
		</th>
		<th>
			<input type="text" name= "carnet">
		</th>
	</tr>
	<tr>
		<th>
			Fecha nacimiento
		</th>
		<th>
			<input type="text" name= "fecha_nac">
		</th>
	</tr>
	<tr>
		<th>
			Pais
		</th>
		<th>
			<select name="pais">
			<c:forEach items="${pais}" var = "i">
  				<option>${i.descripcion}</option>
			</c:forEach>
			</select>
		</th>
	</tr>
	<tr>
		<th>
			Departamiento
		</th>
		<th>
			<select name="departamento">
			<c:forEach items="${departamento}" var = "i">
  				<option>${i.descripcion}</option>
			</c:forEach>
			</select>
		</th>
	</tr>
	<tr>
		<th>
			Municipio
		</th>
		<th>
			<select name="municipio">
			<c:forEach items="${municipio}" var = "i">
  				<option>${i.descripcion}</option>
			</c:forEach>
			</select>
		</th>
	</tr>
	</tr>
	<tr>
		<th>
			Direccion
		</th>
		<th>
			<input type="text" name= "direccion">
		</th>
	</tr>
	</tr>
	<tr>
		<th>
			Telefono
		</th>
		<th>
			<input type="number" name= "telefono">
		</th>
	</tr>
	</tr>
	<tr>
		<th>
			Celular
		</th>
		<th>
			<input type="number" name= "celular">
		</th>
	</tr>
	</tr>
	<tr>
		<th>
			Centro escolar
		</th>
		<th>
			<select name="centro_escolar">
			<c:forEach items="${centro_escolar}" var = "i">
  				<option>${i.descripcion}</option>
			</c:forEach>
			</select>
		</th>
	</tr>
	<tr>
		<th>
			Grado Cursado
		</th>
		<th>
			<input type="text" name= "grado_cursado">
		</th>
	</tr>
	<tr>
		<th>
			Nota ultimo grado
		</th>
		<th>
			<input type="text" name= "nota_grado">
		</th>
	</tr>
	<tr>
		<th>
			nombre_padre
		</th>
		<th>
			<input type="text" name= "nombre_padre">
		</th>
	</tr>
	<tr>
		<th>
			nombre_madre
		</th>
		<th>
			<input type="text" name= "nombre_madre">
		</th>
	</tr>
	<tr>
		<th>
			nombre_responsable
		</th>
		<th>
			<input type="text" name= "nombre_responsable">
		</th>
	</tr>
</table>
<form action="${pageContext.request.contextPath}/gExpediente">
	<input type="submit" value="Crear expediente">
</form>
</body>
</html>