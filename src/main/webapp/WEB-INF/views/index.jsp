<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.*" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>test connection</title>
    <link rel="stylesheet" href="/test/resources/css/style.css">
</head>
<body>

<table id="buttons">
    <tr>
        <th>
            <div>
                <form id="connection1" method="get" action="/test/oracle">
                    <button type="submit">Oracle</button>
                </form>
            </div>
        </th>
        <th>
            <div>
                <form id="connection2" method="get" action="/test/firebird">
                    <button type="submit">Firebird</button>
                </form>
            </div>
        </th>
    </tr>
</table>

<table id="result">
    <tr>
        <th>key</th>
        <th>value</th>
    </tr>
    <c:forEach items="${dataList}" var="data">
        <tr>
            <td>${data.key}</td>
            <td>${data.value}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>