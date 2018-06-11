<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://mottie.github.io/tablesorter/css/theme.default.css" rel="stylesheet">
     
  
<script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> 
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>
     
    <script>
        $(function(){
          $("#myTable").tablesorter({widgets: ['zebra']});
        });
    </script>

<title>Expedientes</title>
</head>
<body>



<form action="${pageContext.request.contextPath}/CrearExpediente">
<input type="submit" value="Crear expediente" /></form>

<form action="${pageContext.request.contextPath}/BuscarExpediente">
Buscar: 
	<input type="text" name="busqueda" >
	
  <input type="radio" name="tipo" value="0" checked> Edad del estudiante 
  <input type="radio" name="tipo" value="1"> Nombre 	
  <input type="radio" name="tipo" value="2"> Apellido 	
  <input type="radio" name="tipo" value="3"> Departamento 	
  <input type="radio" name="tipo" value="4"> Municipio 
</form>
<table id="myTable" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
<caption>Expedientes</caption>
      <thead>
<tr>
   <th>Acci&oacute;n</th>
   <th>Nombre</th>
   <th>Apellido</th>
   <th>Materias </br>aprobadas</th>
   <th>Materias </br>reprobadas</th>
   <th>Promedio</th>
 </tr>
 </thead>
 <tbody>
 <c:forEach items="${ob}" var = "i">
  <tr>
   <td>
   	<form action="${pageContext.request.contextPath}/${boton}">
    	<input type=text name="id" value="${i.id }" style="visibility: hidden; width: 0px">
    	<input type="submit" value="Editar" />
	</form>
	</td>
   <td>${i.nombre }</td>
   <td>${i.apellido }</td>
   <td>${i.aprobadas }</td>
   <td>${i.reprobadas }</td>
   <td>${i.promedio }</td>
 </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>