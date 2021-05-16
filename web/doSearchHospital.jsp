<%@page import="entity.Hospital"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,DAO.*,entity.*"%>
 
<%
    request.setCharacterEncoding("UTF-8");

    String name =(String)request.getParameter("name");
    //System.out.print(name);
    //String password = (String)request.getParameter("password");
    List<Hospital> listHospital= new ArrayList<Hospital>();
   
 
    HospitalDAO dao = new HospitalDAO();
    listHospital = dao.searchByName(name);
     
    session.setAttribute("listHospital", listHospital);
    response.sendRedirect("hospital.jsp?timkiem=true");
    
%>