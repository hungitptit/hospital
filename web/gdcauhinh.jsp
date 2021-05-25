<%@ include file="header.jsp"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"  import="DAO.*,entity.*"%>
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
        <%  List<Service> listService = new ArrayList<Service>();
            if (request.getParameter("timkiem") != null && request.getParameter("timkiem").equalsIgnoreCase("true")) {
                listService = (ArrayList<Service>) session.getAttribute("listService");
                request.setAttribute("listService", listService);
            } else {
                ServiceDAO dao = new ServiceDAO();

                listService = dao.getListService();
                request.setAttribute("listService", listService);

            }
        %>
        <div class="container">
            <h2 style="text-align: center"> Cấu hình  </h2>

            <br>

            <div class="panel-body">
                <table class="table table-bordered" id="table">
                    <thead>
                        <tr>
                            <th width="10%">ID</th>
                            <th width="30%">Tên dịch vụ</th>
                            <th width="20%">Chiết khấu</th>

                            <th width="20%">Loại dịch vụ</th>
                            <th width="20%">Thao tác</th>
                        </tr>
                    </thead>
                    <tbody>

                        <%
                            for (Service sv : listService) {
                        %>

                        <tr class="service">

                            <td><%=sv.getId()%></td>
                            <td><%=sv.getName()%></td>

                            <td><%=sv.getRatio()%></td>

                            <td><%=sv.getServiceType().getName()%></td>
                            <td><a type="button" class="btn btn-primary" id="<%=sv.getId()%>"
                                   href="chiTietCauHinh.jsp?id=<%=sv.getId()%>">Sửa</a>
                                <a type="button" class="btn btn-info"
                                   href="doDeleteCauHinh.jsp?id=<%=sv.getId()%>">Xóa</a></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>
        </div>


        <div>
            <!-- %@ include file="footer.jsp"%>  -->

        </div>

    </body>
    <div class="footer">

        <h2>

            Nguyen Quoc Hung
        </h2>
    </div>

</html>