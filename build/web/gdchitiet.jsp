<%@page import="DAO.PersonDAO"%>
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

<title>Thông tin chi tiết</title>
</head>
<%
	String index = request.getParameter("index");
	Person pers = new Person();
	ArrayList<Bill> bill = new ArrayList<Bill>();
	if(index != null){
		pers = ((ArrayList<Person>)session.getAttribute("dsPerson")).get(Integer.parseInt(index));
		
		bill = (new PersonDAO()).getBill(pers.getPerson_id());
		if(bill == null){
			System.out.println("bill null");
		}
	}
//	String tk = request.getAttribute("tennguoi");
%>
<body>
	<h1>Thông tin bệnh nhân</h1>
	Ten: <%=pers.getName() %><br>
	Ma BH: <%=pers.getBhyt().getId() %><br>
	Ngay sinh: <%=pers.getDob() %><br>
	SDT: <%=pers.getPhoneNumber() %><br>
	Dia chi: <%=pers.getAddress() %><br>
	Lich su su dung: <br>
	
	<%if(bill!= null){%>
	<table>
		<tr>
			<th>Tên bệnh</th>
			<th>Bệnh viện</th>
			<th>Khoa</th>
			<th>Ngày nhập viện</th>
			<th>Ngày thanh toán</th>
			<th>Tổng số tiền</th>
		</tr>
		<%
			for(int i = 0; i<bill.size(); i++){
		%>
		<tr>
		<td><%=bill.get(i).getDisease().getName() %></td>
		<td><%=bill.get(i).getHospital().getName() %></td>
		<td><%=bill.get(i).getDisease().getKhoa() %></td>
		<td><%=bill.get(i).getDateOfAdmission() %></td>
		<td><%=bill.get(i).getDateOfDischarge() %></td>
		<td><%=bill.get(i).getAmount() %></td>
		</tr>
		<%} }%>
	</table>
  	<a type="button" class="btn btn-primary"
        href="gdtimnguoi.jsp">Quay lại</a></td>
	<a type="button" class="btn btn-primary"
        href="gdxuatbc.jsp">Xuất báo cáo</a></td>
<script >
function openPage(page){
	window.location="http://localhost:8080/Insurance/baocao/"+page;
}
</script>
</body>
</html>