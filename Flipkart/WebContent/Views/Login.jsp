<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <% String msg= (String)request.getAttribute("msg"); %>
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
<fieldset>
		<legend>user login</legend>
		<form action="./logins" method="post">
			<table>
				<tr>
					<td>Email</td>
					<td>:</td>
					<td><input type="text" name="email" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<td colspan="3"><br /> <input type="submit" value="Submit"></td>
				
	

			</table>
		</form>


	</fieldset>
</body>
</html>