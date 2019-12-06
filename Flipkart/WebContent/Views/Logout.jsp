<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <% String msg= (String)request.getAttribute("msg"); %>
     <%@ page session="false" %>>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%  if(msg!=null && !msg.isEmpty()) {%>
<%=msg %>
<% } %>
<h2>Click On button to Logout</h2>
<form action="./login" method="get">

   <input type="submit" name="Logout" >
 
</form>
</body>
</html>