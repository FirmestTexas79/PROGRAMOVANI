<%@ page import="java.io.PrintWriter" %>
<%@ page import="static java.lang.System.out" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Kalkul" %>
</h1>
<%
    String vysledek;

    try {

        String a = request.getParameter("a");
        String b = request.getParameter("b");

        int c1 = Integer.parseInt(a);
        int c2 = Integer.parseInt(b);

        vysledek = String.valueOf(c1 * c2);

    } catch(Exception e) {
        vysledek = "Špatný vstup";
    }

%>


<br/>
<a href="hello-servlet">Hello Servlet</a>
</body>
</html>