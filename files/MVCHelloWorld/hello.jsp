<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
<title>Maven + Spring MVC</title>

</head>
<body>
	<h1>${title}</h1>
	<p>
	 ${message}
	</p>
	<p>
		<c:if test!="${empty name}">
			Hello_${name}_end
		</c:if>

		<c:if test=="${empty name}">
			Welcome Welcome!
		</c:if>
    </p>
	<p>© peterservice.ru 2016</p>

</body>
</html>