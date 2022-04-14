<%@ page import="ru.gb.model.Product" %>
<%@ page import="java.util.List" %>



<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product</title>
 </head>
 <body>
<h1>Product</h1>
<hr>
<ul>
<%
for (Product value :  ((List<Product>) request.getAttribute("product")))  {
out.println("<li>" + "Id: " + value.getId() + " Title: " + value.getTitle() + " Cost: " + value.getCost() + "</li>");
 } %>
</ul>
 </body>
 </html>