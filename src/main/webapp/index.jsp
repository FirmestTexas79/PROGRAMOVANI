<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Test" %>
</h1>
<%
    for(int i = 0; i <= 5; i++) { %>
<b>Cislo: </b> <%= 1%> <br>%>

<% } %>
<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>