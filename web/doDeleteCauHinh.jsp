<%@page import="entity.Service"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,DAO.*,entity.*"%>
 
<%
    request.setCharacterEncoding("UTF-8");

    String id =(String)request.getParameter("id");

   
 
    ServiceDAO dao = new ServiceDAO();
    boolean deleteStatus = dao.deleteServiceById(id);
     
    if(deleteStatus){
        response.sendRedirect("gdcauhinh.jsp");
    } else {
        response.sendRedirect("error.jsp");
    }
    
%>