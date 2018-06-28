<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML>

<html>
<head>
<title>JSP Page</title>
</head>
<body>
	<h1>Hello World!</h1>


	<c:forEach items="${personas}" var="item">

		<p>
			Persona : <strong>${item}</strong>
		</p>

	</c:forEach>

	<br>
	<br>

	<c:forEach items="${bienes}" var="item">

		<p>
			Bien : <strong>${item}</strong>
		</p>

	</c:forEach>



</body>
</html>
