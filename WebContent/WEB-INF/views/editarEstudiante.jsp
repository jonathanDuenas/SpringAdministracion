<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Estudiante</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/UpdateEstudiante">
	<table>
	<tr>
		<th>Nombre</th>
		<th><input type="text" name="nombre" value="${ob.nombre }"/></th>
	</tr>
	<tr>
		<th>Apellido</th>
		<th><input type="text" name="apellido" value="${ob.apellido }"/></th>
	</tr>
	<tr>
		<th>direccion</th>
		<th><input type="text" name="direccion" value="${ob.direccion }"/></th>
	</tr>
	<tr>
		<th>telefono</th>
		<th><input type="number" name="telefono" value="${ob.telefono }"/></th>
	</tr>
	<tr>
		<th>celular</th>
		<th><input type="number" name="celular" value="${ob.celular }"/></th>
	</tr>
	<tr>
		<th>Ultimo grado cursado</th>
		<th><input type="number" name="grado_cursado" value="${ob.grado_cursado }"/></th>
	</tr>
	<tr>
		<th>Nota ultimo grado</th>
		<th><input type="number" name="nota_grado" value="${ob.nota_grado }"/></th>
	</tr>
	
	</table>
	<input type="text" name="id" value="${ob.id }" style="visibility: hidden; width: 0px"/>
	<input type="submit" value="Guardar cambios"/>
</form>


</body>
</html>