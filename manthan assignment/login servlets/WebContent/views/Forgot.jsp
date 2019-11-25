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
		<legend>Create password</legend>
		<form action="./forgottestservlet" method="post">
			<table>
				<tr>
					<td>Username</td>
					<td>:</td>
					<td><input type="text" name="username" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				
				<tr>
					<td> Confirm Password</td>
					<td>:</td>
					<td><input type="password" name="cpassword" required></td>
				</tr>
				<td colspan="3"><br /> <input type="submit" value="Submit"></td>
				
			
			</table>
		</form>


	</fieldset>


</body>
</html>