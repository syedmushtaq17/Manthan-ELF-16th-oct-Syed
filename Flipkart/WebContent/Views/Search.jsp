

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*"%>
    <%@page import="com.manthan.flipkart.productinfobean.ProductInfo"%>
    
    <% ArrayList<ProductInfo> al= (ArrayList)request.getAttribute("al");%>
    <%String msg = (String) request.getAttribute("msg");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./searchservlet" 
 method="post">
     <h2 style="margin-left: 500px"> Search anything you want</h2>
<input type="text" style="width:400px ; margin-left: 350px ; border-color:  black" name="search"> &nbsp <input type="submit" style="font-family: cursive;box-shadow: 3px 3px;border-color:  black;" value="Search">
</form>
<%  if(msg!=null && !msg.isEmpty()) {%>
<%=msg %>
<% } %>

	<%if(al!=null && !al.isEmpty()){ %>
	<div class="table">
				<table style="border-collapse: collapse; width:100%" >
					<thead>
						<tr style="background: #ccc;">
							<th>Product Name</th>
							<th>Description</th>
							<th>Color</th>
							<th>Price</th>
							<th>NO of Units Left</th>
							<th>Buy IT </th>
						</tr>
					</thead>
					<tbody>
					<%for(ProductInfo pro:al){ %>
						<tr>
							<td> <%= pro.getProductname() %> </td>
							<td>  <%= pro.getDescription() %> </td>
							<td>  <%= pro.getProductcolor() %></td>
							<td>  <%= pro.getProductcost() %></td>
							<td><a href="./buyservlet"> buy
							<% request.setAttribute("productid", pro.getProductid()); %>
							</a></td>
						</tr>
          	</tbody>
					<%} %>
					
					</table>
		</div>
				<%} %>		
	

</body>
</html>