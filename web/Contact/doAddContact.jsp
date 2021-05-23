

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Dao1.ContactDAO"%>
<%@page import="Dao1.DAO"%>
<%@page import="Model.Contact"%>
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
           Contact u  = new Contact();
//           u.setId(Integer.parseInt((request.getParameter("id"))));
           u.setAddress(request.getParameter("address"));
           u.setEmail(request.getParameter("email"));
           u.setSdt(request.getParameter("sdt"));
           u.setHottline(request.getParameter("hottline"));
           
           System.out.println(u.toString());
           
           new ContactDAO().addcontact(u);
            response.sendRedirect("listContact.jsp");   
           
       %>
       
    </body>
</html>
