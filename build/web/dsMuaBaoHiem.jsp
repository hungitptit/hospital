<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"  import="DAO.*,entity.*"%>
<%@ include file="header.jsp"%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
btn{
   width: 60px;
  }
  .th_btn{
  width:60px;
  }
  #th_password{
  width:60%;
  }
  body {
  display: flex;
  flex-direction: column;
  min-height: 100vh;
  padding-bottom: 70px;
}
	
</style>
<body >
<div class="container" style="margin-bottom: 100px">
 <div>
  
 </div>
 <br>
 <div class="panel panel-primary">
  <div class="panel-heading">
   <h3>Danh sách sử dụng bảo hiểm y tế</h3>
  </div>

     <% 
        String mode = request.getParameter("mode");
        int id = Integer.parseInt(request.getParameter("id"));
        List<tk> listtk = new ArrayList<tk>();
        tkDAO dao = new tkDAO();
        listtk = dao.getDsMuaBaoHiem(id, mode);
        request.setAttribute("listtk", listtk);
        %>
       
  
  <div class="panel-body">
   <table class="table table-bordered" id="table">
    <thead>
     <tr>
      <th width="5%">ID</th>
      <th width="20%">Họ và tên</th>
      <th width="10%">Ngày sinh</th>
      <th width="20%">Số CMT</th>
      <th width="20%">Số thẻ bảo hiểm</th>
      <th width="10%">Địa chỉ</th>
      
      <th width="20%">Khoa khám bệnh</th>
     </tr>
    </thead>
    <tbody>
       
     <% 
 
for(tk thongke: listtk){
%>
         
      <tr>
      
       <td><%=thongke.getIdPerson()%></td>
       <td><%=thongke.getName()%></td>
       <td><%=thongke.getDob()%></td>
       <td><%=thongke.getCmt()%></td>
       <td><%=thongke.getSothe()%></td>
       <td><%=thongke.getAddress()%></td>
       <td><%=thongke.getKhoa()%></td>
       
       
      </tr>
    <%} %>
    </tbody>
   </table>
  </div>
 </div>
 
<div>
  
 </div>
</div>

<div>
<!-- %@ include file="footer.jsp"%>  -->

</div>

</body>
<div class="footer">
    
    <h2>
        
        Trần Xuân Hưng
    </h2>
</div>

</html>