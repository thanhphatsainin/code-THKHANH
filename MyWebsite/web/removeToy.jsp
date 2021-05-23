<%-- 
    Document   : removeToy
    Created on : Oct 27, 2020, 11:03:53 AM
    Author     : QuangPro99
--%>

<%@page import="dao.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");
            if(new DAO().remove2(id)){
                response.sendRedirect("index_1.jsp");
            }
            else{
                response.sendRedirect("error.jsp");
            }
        %>
    </body>
</html>
