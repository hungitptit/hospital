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
<body>
<div class="container">
 
 <br>
 
  <div class="panel-body">
  <h2 style="text-align: center"> Giao diện chính  </h2>
  
     <div style="text-align: center">
     <br>
       	<a type="button" class="btn btn-success" style="width: 300px"
        href="theodoids.jsp">Theo dõi danh sách</a></td>
        <br>
        <br>
        <a type="button" class="btn btn-success" style="width: 300px"
        href="gdtimnguoi.jsp">Xuất báo cáo</a></td>
     	<br>
     	<br>
        <a type="button" class="btn btn-success" style="width: 300px"
        href="gdxemtk">Cấu hình</a></td>
     
     </div>
     	
      
  </div>
 </div>


<div>
<!-- %@ include file="footer.jsp"%>  -->

</div>

</body>
<div class="footer">
    
    <h2>
        
        Tran Xuan Hung
    </h2>
</div>

</html>