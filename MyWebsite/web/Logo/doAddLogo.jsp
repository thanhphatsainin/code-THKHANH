

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="Dao1.LogoDAO"%>
<%@page import="Model.Logo"%>
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
           Logo u  = new Logo();
//           u.setId(Integer.parseInt((request.getParameter("id"))));
           u.setName(request.getParameter("name"));
           u.setImage(request.getParameter("image"));
           
           System.out.println(u.toString());
           
           new LogoDAO().addlogo(u);
            response.sendRedirect("listLogo.jsp");   
           
       %>
       
    </body>
</html>
