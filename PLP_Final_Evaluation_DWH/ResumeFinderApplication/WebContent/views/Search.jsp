<%@page import="com.manthan.exam.resumeinfobean.ResumeInfoBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%ArrayList<ResumeInfoBean> al=(ArrayList)request.getAttribute("al"); %>
<%String msg = (String) request.getAttribute("msg");%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 <style>
   
        
        tr:nth-child(odds) {
            background: #f2f2f2;
        }
        
         .table {
            width: 90%;
            border: 2px solid black;
            margin-top: 3%;
            margin-left: 5%;
        }
       
        
        th,
        td {
            border-right: 2px solid black;
        }
    </style>
</head>
<body style="font-family: cursive;">
<a href="./upload" style="margin-left: 1000px">Upload Resume </a>
<form action="./searchservlet" style="font-family: cursive;" method="post">
     <h2 style="margin-left: 500px"> Search Resume</h2>
<input type="text" style="width:400px ; margin-left: 350px ; border-color:  black" name="search"> &nbsp <input type="submit" style="font-family: cursive;box-shadow: 3px 3px;border-color:  black;" value="Search">
</form>

   <%if(msg!=null && !msg.isEmpty()) { %>
	<fieldset style="margin-top: 270px; background-color: #7FFFD4; border-color: solid black">
		<p style="color: black; text-align: center;"><%=msg %></p>
		</fieldset>
	<%} %>

	<%if(al!=null && !al.isEmpty()){ %>
	<div class="table">
				<table style="border-collapse: collapse; width:100%" >
					<thead>
						<tr style="background: #ccc;">
							<th>File Name</th>
							<th>Name</th>
							<th>Email</th>
							<th>Download Link</th>
						</tr>
					</thead>
					<tbody>
					<%for(ResumeInfoBean resumeInfoBean:al){ %>
						<tr>
							<td> <%= resumeInfoBean.getFilename() %> </td>
							<td>  <%= resumeInfoBean.getName() %> </td>
							<td>  <%= resumeInfoBean.getEmail() %></td>
							<td  align="center">
							<a href="./downloadservlet?filename=<%= resumeInfoBean.getFilename() %>"> 
							 <img src="${pageContext.request.contextPath}/image/download1.png"  alt="download" />
						    </a>
							 </td>
						</tr>
          	</tbody>
					<%} %>
					
					</table>
		</div>
				<%} %>		
	
	
</body>
</html>