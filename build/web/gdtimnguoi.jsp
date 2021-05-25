<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,DAO.*,entity.*"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css"> 
table, th, td {  
    border: 1px solid black;
    border-collapse: collapse;
}
</style>
<meta charset="ISO-8859-1">
<title>Tìm kiếm</title>
</head>
<%
	String tenN = request.getParameter("timkiem");
	ArrayList<Person> listP = null;
	if(tenN != null){
//		session.setAttribute("tennguoi", tenN);
		listP = (new PersonDAO()).searchPerson(tenN);
		session.setAttribute("dsPerson", listP);
	}
%>
<body>
	<form name="timnguoi" method="get" action="gdtimnguoi.jsp" >
		<table>
			<tr>
				<td>Tên</td>
				<td><input type="text" name = "timkiem" <%if(tenN!= null){ %>
														value = "<%=tenN%>"<%} %>></td>
				<td><input type = "submit" value = "tim">
				</td>	
			</tr>										
		</table>
	</form>
	
	
	<%
		if(listP!= null){
	%>			
	<table name = "kqPerson" >
		<tr><th>TT</th>
		<th>Mã </th>
		<th>Tên </th>
		<th>SDT </th>
		<th>Ngày sinh</th>
		<th>Email</th>
		<th>CMT</th>
		<th>So thẻ bh</th>
		<th>Mua bh</th>
		<th>Dịa chỉ</th>
		</tr>
		<%
			for(int i = 0; i< listP.size(); i++){ 	
		%>
		<tr>
		<td><%= (i+1)%></td>
		<td><%= listP.get(i).getPerson_id()%></td>
		<td><a href="gdchitiet.jsp?index=<%=i%>">
		<%= listP.get(i).getName() %></a></td>
		<td><%= listP.get(i).getPhoneNumber() %></td>
		<td><%= listP.get(i).getDob() %></td>
		<td><%= listP.get(i).getEmail() %></td>
		<td><%= listP.get(i).getCmt()%></td>
		<td><%= listP.get(i).getSothebaohiem()%></td>
		<td><%= listP.get(i).getMuabaohiem()%></td>
		<td><%= listP.get(i).getAddress()%></td>
		</tr>
		<%} }%>			
	</table>
</body>
</html>