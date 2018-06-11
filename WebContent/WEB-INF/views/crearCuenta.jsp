<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
  <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <script>
  $( function() {
    $( "#datepicker" ).datepicker({ dateFormat: 'yy-mm-dd' });
  } );
  </script>
</head>
<body>
<form:form method="POST" modelAttribute="ob" action="${pageContext.request.contextPath}/guardarCuenta" >
	<table>
	<tr>
		<th>
		Nombre
		</th>
		<th>
		<form:input type="text" path="nombre"/>
		</th>
	</tr>
	<tr>
		<th>
		Apellido
		</th>
		<th>
		<form:input type="text" path="apellido"/>
		</th>
	</tr>
	<tr>
		<th>
		Fecha nacimiento
		</th>
		<th>
		<form:input type="text" path="fecha_nac" id="datepicker"/>
		</th>
	</tr>
	<tr>
		<th>
		Direccion
		</th>
		<th>
		<form:input type="text" path="direccion"/>
		</th>
	</tr>
	<tr>
		<th>
		Usuario
		</th>
		<th>
		<form:input type="text" path="usuario"/>
		</th>
	</tr>
	<tr>
		<th>
		Password
		</th>
		<th>
		<form:input type="text" path="password"/>
		</th>
	</tr>
	
	</table>
	<input type="submit" value="Crear cuenta"/>
</form:form>
</body>
</html>