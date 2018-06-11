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

<title>Materias cursadas</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/AgregarMateriaCur">
<input type="text" name="id" value="${est.id }" style="visibility:hidden; width: 0px;"/>
<input type="submit" value="Agregar Materia cursada" /></form>
Nombre Estudiante: ${est.nombre } </br>
Apellido Estudiante: ${est.apellido} </br>
Id: ${est.id } </br>
<table id="myTable" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
<caption>Materias cursadas</caption>
      <thead>
<tr>
   <th>Acci&oacute;n</th>
   <th>Materia</th>
   <th>A&ntilde;o</th>
   <th>Periodo</th>
   <th>Nota</th>
   <th>Estado</th>
 </tr>
 </thead>
 <tbody>
 <c:forEach items="${ob}" var = "i">
  <tr>
   <td>
   	<form action="${pageContext.request.contextPath}/EditarMateriaCursada">
    	<input type=text name="id" value="${i.id }" style="visibility: hidden; width: 0px">
    	<input type="submit" value="Editar" />
	</form>
	</td>
   <td>${i.materia}</td>
   <td>${i.ano }</td>
   <td>${i.periodo }</td>
   <td>${i.nota }</td>
   <td>${i.estado }</td>
 </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>