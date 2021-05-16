<%@page import="entity.Person"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,DAO.*,entity.*"%>
 
<%
    request.setCharacterEncoding("UTF-8");

    String name =(String)request.getParameter("name");
    //System.out.print(name);
    //String password = (String)request.getParameter("password");
    List<Person> listPerson= new ArrayList<Person>();
   
 
    PersonDAO dao = new PersonDAO();
    listPerson = dao.searchByName(name);
     
    session.setAttribute("listPerson", listPerson);
    response.sendRedirect("person.jsp?timkiem=true");
    
%>