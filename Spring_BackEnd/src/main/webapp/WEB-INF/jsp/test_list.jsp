<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Book List</title>
</head>
<body>

<a href="/">Go home</a>

<h1 align="center">My Test List</h1>
<br/>
<table border="1" cellpadding="10">
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    <c:forEach var="test" items="${testList}">
        <tr>
            <td>${test.ID}</td>
            <td>${test.testingName}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>