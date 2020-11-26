<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Test Form</title>

    <style type="text/css">
        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
            text-align: left;
        }
        input[type=text], input[type=password], select {
            width: 200px;
        }
        input[type=radio] {
            display: inline-block;
            margin-left: 45px;
        }
        input[type=checkbox] {
            display: inline-block;
            margin-right: 190px;
        }

        button {
            padding: 10px;
            margin: 10px;
        }
    </style>

</head>
<body>
<div>
    <a href="/addtest">Add Test</a><br/>
    <a href="/listtest">List Test</a><br/>
    <a href="/updatetest">Update Test</a><br/>
    <a href="/testID/1">Get Test ID 1</a>
</div>

<div align="center">
    <h2>New Test</h2>
    <%--@elvariable id="test" type=""--%>
    <form:form action="/testID/1" method="get" modelAttribute="test">
        <table border="1" cellpadding="10">
            <tr>
                <th>ID</th>
                <th>Name</th>
            </tr>
                <tr>
                    <td>${test.ID}</td>
                    <td>${test.name}</td>
                </tr>
        </table>
    </form:form>
</div>
</body>
</html>
