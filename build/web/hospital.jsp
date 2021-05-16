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
  <form action="doSearchHospital.jsp" method="get">
  <input type="text" name="name" id="name"  /></td>
  <input class= "btn-success btn-md" type="submit" value="Tìm kiếm" />
  </form>
 </div>
 <br>
 <div class="panel panel-primary">
  <div class="panel-heading">
   <h3>Danh sách bệnh viện</h3>
  </div>

     <%  List<Hospital> listHospital = new ArrayList<Hospital>();
                    if(request.getParameter("timkiem") !=null && request.getParameter("timkiem").equalsIgnoreCase("true")){
  			 listHospital = (ArrayList<Hospital>)session.getAttribute("listHospital");
                        request.setAttribute("listHospital", listHospital);
  		}else{
  			HospitalDAO dao = new HospitalDAO();
  			
                    listHospital = dao.getListHospital();
                    request.setAttribute("listHospital", listHospital);
            
                }
        %>
       
  
  <div class="panel-body">
   <table class="table table-bordered" id="table">
    <thead>
     <tr>
      <th width="10%">ID</th>
      <th width="30%">Tên bệnh viện</th>
      <th width="20%">Địa chỉ</th>
      
      <th width="20%"></th>
     </tr>
    </thead>
    <tbody>
       
     <% 
 
for(Hospital hos: listHospital){
%>
         
      <tr>
      
       <td><%=hos.getHospital_id()%></td>
       <td><%=hos.getName()%></td>
       
       <td><%=hos.getAddress()%></td>
       
       <td>
       <a type="button" class="btn btn-primary"
        href="dsMuaBaoHiem.jsp?id=<%=hos.getHospital_id()%>&mode=hospital">Chi tiết</a></td>
      </tr>
    <%} %>
    </tbody>
   </table>
  </div>
 </div>
 
<div>
  <form name="timkiem" action="hospital.jsp" method="get">
  
  <input class= "btn-success btn-md" type="submit" value="Tất cả danh sách" />
  </form>
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