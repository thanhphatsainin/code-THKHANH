
<%@page import="Dao1.ContactDAO"%>
<%@page import="Dao1.DAO"%>
<%@page import="Model.Contact"%>
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
            new ContactDAO().deletecontact(Integer.parseInt(id));
            response.sendRedirect("listContact.jsp");          
        %>
    </body>
</html>
