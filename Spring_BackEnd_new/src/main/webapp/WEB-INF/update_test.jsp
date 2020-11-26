<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add Book Form</title>

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

<a href="/addtest">Add Test</a>
<a href="/listtest">List Test</a>
<a href="/updatetest">Update Test</a>

<div align="center">
    <h2>New Book</h2>
    <%--@elvariable id="test" type=""--%>
    <form:form action="updatetest/1" method="post" modelAttribute="test">
        <form:button>Update Test</form:button>
    </form:form>
</div>
</body>
</html>
