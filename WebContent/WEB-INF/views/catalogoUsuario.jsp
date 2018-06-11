<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
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

<title>${titulo }</title>
</head>
<body>
<button>
${boton} ${titulo}
</button>

<table id="myTable" class="tablesorter" border="0" cellpadding="0" cellspacing="1">
<caption>${titulo}</caption>
      <thead>
<tr>
   <th>Acci&oacute;n</th>
   <th>C&oacute;digo</th>
   <th>Usuario</th>
   <th>Estado</th>
 </tr>
 </thead>
 <tbody>
 <c:forEach items="${ob}" var = "i">
  <tr>
   <td>
   	<form action="${pageContext.request.contextPath}/${editar}">
    	<input type=text name="id" value="${i.id }" style="visibility: hidden; width: 0px">
    	<input type="submit" value="Editar" />
	</form>
	</td>
   <td>${i.id }</td>
   <td>${i.usuario }</td>
   <td>
   	 <c:choose>
         <c:when test = "${i.estado == 0}">
            Inactivo
         </c:when>
         
         <c:when test = "${i.estado == 1}">
            Activo
         </c:when>
      </c:choose>
   
   </td>
 </tr>
</c:forEach>
</tbody>
</table>
</body>
</html>