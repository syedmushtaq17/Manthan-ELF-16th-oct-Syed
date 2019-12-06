<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%String msg = (String) request.getAttribute("msg");%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>

<body style="font-family: cursive;">

<a href="./search" style="margin-left: 1000px">Search Resume</a>
<form action="./uploadservlet" style="font-family: cursive; " method="post" enctype="multipart/form-data">
     <h2 style="margin-left: 500px"> Upload Resume</h2>
<input type="file" style="width:400px ; margin-left: 350px ; border-color: black ; background-color: white" name="fname" placeholder="Enter only Pdf or Docx"> &nbsp <input type="submit" style="font-family: cursive;box-shadow: 3px 3px; border-color:  black;" value="Upload">
</form>


	<%if(msg!=null && !msg.isEmpty()) { %>
	<fieldset style="margin-top: 270px; background-color: #7FFFD4; border-color: solid black">
		<p style="color: black; text-align: center;"><%=msg %></p>
		</fieldset>
	<%} %>
	


</body>
</html>
