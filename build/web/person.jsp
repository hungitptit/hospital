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
  <form action="doSearchPerson.jsp" method="get">
  <input type="text" name="name" id="name"  /></td>
  <input class= "btn-success btn-md" type="submit" value="Tìm kiếm" />
  </form>
 </div>
 <br>
 <div class="panel panel-primary">
  <div class="panel-heading">
   <h3>Danh sách bệnh nhân</h3>
  </div>

     <%  List<Person> listPerson = new ArrayList<Person>();
                    if(request.getParameter("timkiem") !=null && request.getParameter("timkiem").equalsIgnoreCase("true")){
  			 listPerson = (ArrayList<Person>)session.getAttribute("listPerson");
                        request.setAttribute("listPerson", listPerson);
  		}else{
  			PersonDAO dao = new PersonDAO();
  			
                    listPerson = dao.getListPerson();
                    request.setAttribute("listPerson", listPerson);
            
                }
        %>
       
  
  <div class="panel-body">
   <table class="table table-bordered" id="table">
    <thead>
     <tr>
      <th width="10%">ID</th>
      <th width="30%">Họ và tên</th>
      <th width="30%">Số điện thoại</th>
      <th width="20%">Địa chỉ</th>
      
      <th width="20%"></th>
     </tr>
    </thead>
    <tbody>
       
     <% 
 
for(Person hos: listPerson){
%>
         
      <tr>
      
       <td><%=hos.getPerson_id()%></td>
       <td><%=hos.getName()%></td>
       <td><%=hos.getPhoneNumber()%></td>
       <td><%=hos.getAddress()%></td>
       
       <td>
       <a type="button" class="btn btn-primary"
        href="dsMuaBaoHiem.jsp?id=<%=hos.getPerson_id()%>&mode=person">Chi tiết</a></td>
      </tr>
    <%} %>
    </tbody>
   </table>
  </div>
 </div>
 
<div>
  <form name="timkiem" action="person.jsp" method="get">
  
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