<%-- 
    Document   : remove
    Created on : Oct 24, 2020, 9:54:44 AM
    Author     : QuangPro99
--%>
<%@page import="Dao1.ArticleDAO"%>
<%@page import="Model.Article"%>
<%@page import="Dao1.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String id = request.getParameter("id");//truyen vao id goi tu the index sang remove.jsp
            new ArticleDAO().deletearticle(Integer.parseInt(id));
            response.sendRedirect("listArticle.jsp");          
        %>
    </body>
</html>
