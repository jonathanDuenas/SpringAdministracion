<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://mottie.github.io/tablesorter/css/theme.default.css" rel="stylesheet">
     
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script> 
    <script type="text/javascript" src="http://cdnjs.cloudflare.com/ajax/libs/jquery.tablesorter/2.9.1/jquery.tablesorter.min.js"></script>
     

<title>${titulo }</title>
</head>
<body>

<form method="post"  action="${pageContext.request.contextPath}/${boton }">
   <table>
    <tr>
   	<th>Id</th>
   	<th>
   	${item.id }
   	<input type="number" name="id" value="${item.id }" style="width:0px; height:0px;visibility: hidden"/>
   	</th>
   </tr>
   <tr>
   	<th>Descripcion</th>
   	<th>
   	<input type="text" name="descripcion" value="${item.descripcion }" />
   	</th>
   </tr>
   <tr>
   	<th>Estado</th>
   	<th>
   	<select name="estado">
   		<c:choose>
         <c:when test = "${item.estado == 0}">
            <option value=0 selected>Inactivo</option>
         </c:when>
         <c:when test = "${item.estado == 1}">
            <option value=0 >Inactivo</option>
         </c:when>
      </c:choose>
      <c:choose>
         <c:when test = "${item.estado == 0}">
            <option value=1>Activo</option>
         </c:when>
         <c:when test = "${item.estado == 1}">
            <option value=1 selected>Activo</option>
         </c:when>
      </c:choose>
   	</select>
   
   
   	</th>
   </tr>
   
   </table>
<button type="submit">Guardar</button>
		
</form>
	


</body>
</html>