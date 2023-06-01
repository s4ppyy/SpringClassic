<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
<title>2View Many emp</title>

</head>
<body>
<h1>Я вижу ${employeeSFor.size()} employeeS</h1>
    <table border="1">
        <thead>
            <tr>
                <th>id</th>
                <th>фамилия</th>
                <th>Дата приема</th>
            </tr>
        </thead>
        <tbody>
                <c:forEach items="${employeeSFor}" var="employee">
                 <tr>
                     <td>   <c:out value="${employee.getId()}"/></td>
                     <td>   <c:out value="${employee.getStrName()}"/></td>
                     <td>   <c:out value="${employee.getDtWork()}"/></td>
                  </tr>
                </c:forEach>
        </tbody>
        </table>
</body>
</html>