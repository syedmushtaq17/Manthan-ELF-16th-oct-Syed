<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="java.util.*"%>
    <%@ page import="com.manthan.flipkart.orderinfo.OrderInfo" %>
     <% ArrayList<OrderInfo> al= (ArrayList)request.getAttribute("al");%>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%if(al!=null && !al.isEmpty()){ %>
	<div class="table">
				<table style="border-collapse: collapse; width:100%" >
					<thead>
						<tr style="background: #ccc;">
							<th>Product id</th>
							<th>Order id</th>
							<th>Price</th>
							
						</tr>
					</thead>
					<tbody>
					<%for(OrderInfo pro:al){ %>
						<tr>
							<td> <%= pro.getProductid() %> </td>
							<td>  <%= pro.getOrderid() %> </td>
							<td>  <%= pro.getPrice() %></td>
						
							
						</tr>
          	</tbody>
					<%} %>
					
					</table>
		</div>
				<%} %>		
	

</body>
</html>