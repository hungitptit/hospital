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
        <%
            String id = request.getParameter("id");
            Service sv = new Service();
            ServiceDAO dao = new ServiceDAO();
            sv = dao.getServiceById(id);
            request.setAttribute("cauhinh", sv);

        %>
        <div class="container" style="margin-bottom: 100px">
            <br>
            <div class="panel-body">
                <form method="post" action="CauHinhControl">
                    <table class="table">
                        <tbody>
                            <tr>
                                <th scope="row">Mã dịch vụ</th>
                                <td>
                                    <input type="text" name="id" readonly  value="<%=sv.getId()%>"/>
                                </td>

                            </tr>
                            <tr>
                                <th scope="row">Tên dịch vụ</th>
                                <td>
                                    <input type="text" name="name" readonly value="<%=sv.getName()%>"/>
                                </td>

                            </tr>
                            <tr>
                                <th scope="row">Chiết khấu</th>
                                <td colspan="2">
                                    <input type="number" id="ratio" step="0.0001" name="ratio" value="<%=sv.getRatio()%>"/>
                                </td>
                            </tr>
                            <tr>
                                <th scope="row">Loại dịch vụ</th>
                                <td colspan="2">
                                    <input type="text" name="type" readonly value="<%=sv.getServiceType().getName()%>"/>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div style="text-align: center">
                        <button id="submit" type="submit" class="btn btn-danger">Lưu</button>

                    </div>

                </form>
            </div>
        </div>
    </body>
    <div class="footer">

        <h2>

            Nguyen Quoc Hung

        </h2>
    </div>

</html>