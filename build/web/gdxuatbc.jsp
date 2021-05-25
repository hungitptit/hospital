<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,DAO.*,entity.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Xuất báo cáo</title>
</head>
<body>
	<form method="post" action="gdtimnguoi.jsp">
		<label>Loại báo cáo</label><br>
		<input type="radio" name = "loaibc" value="Thong tin ca nhan" checked>Thông tin cá nhân<br>
		<input type="radio" name = "loaibc" value="Lich su su dung">Lịch sử sử dụng<br>
		<br>
		<label>Kiểu file xuất</label><br>
		<input type="radio" name = "filebc" value="word" checked>Word<br>
		<input type="radio" name = "filebc" value="xlsx" >Xlsx<br>
		<input type="radio" name = "filebc" value="pdf">Pdf<br><br>
		
		<input type="submit" value="Xác nhận" onclick="alert('Chưa xuất ra được ạ')">
	</form>

</body>
</html>