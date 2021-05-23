<%-- 
    Document   : doAdd
    Created on : Oct 24, 2020, 9:53:34 AM
    Author     : QuangPro99
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Model.User"%>
<%@page import="Dao1.UserDAO"%>
<%@page import="Dao1.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JS</title>
    </head>
    <body>
       <%
//           id vi ben add name cuxng la id nen can goi dung de bat su kien sang doAdd
           User u  = new User();
//           u.setId(Integer.parseInt((request.getParameter("id"))));
           u.setName(request.getParameter("name"));
           u.setEmail(request.getParameter("email"));
           u.setAddress(request.getParameter("address"));
           u.setPosition(request.getParameter("position"));
           u.setUsername(request.getParameter("username"));
           u.setPassword(request.getParameter("password"));
           
           System.out.println(u.toString());
           
           new UserDAO().addUser(u);
            response.sendRedirect("listUser.jsp");   
           
       %>
       
    </body>
</html>
