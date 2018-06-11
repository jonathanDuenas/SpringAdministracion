<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Coordinador</title>
</head>
<body>

<form method="POST" action="${pageContext.request.contextPath}/expedientes" >
	<input type="submit" value="Expedientes"/>
</form>

<form method="POST" action="${pageContext.request.contextPath}/materiasCursadas" >
	<input type="submit" value="Materias cursadas"/>
</form>


</body>
</html>