<%-- 
    Document   : editToy
    Created on : Oct 27, 2020, 10:59:01 AM
    Author     : QuangPro99
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="dao.DAO"%>
<%@page import="entities.toy"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="doEditToy.jsp">
            
            <h1>Edit Toy</h1>
            <table>
            <%
            String id = request.getParameter("id");//dua vao id de nhan dien nho id vao trong database de chinh sua
            toy t = new DAO().getToyrById(id);
            %>
            <tr>
                <td>ID</td>
                <td><input type="text" name="id" value="<%= t.getId() %>"></td>
            </tr>
            <tr>
                <td>Name</td>
                <td><input type="text" name="name" value="<%= t.getName()%>"></td>
            </tr>
            
            <tr>
                <td>Price</td>
                <td><input type="text" name="price" value="<%= t.getPrice()%>"></td>
            </tr>
            
            <tr>
                <td>Description</td>
                <td><input type="text" name="description" value="<%= t.getDescription()%>"></td>
            </tr>
            
            <tr>
                <td>Dos</td>
                <td><input type="text" name="dos" value="<%= t.getDos()%>"></td>
            </tr>
            
            <tr>
                <td>Avg</td>
                <td><input type="text" name="avg" value="<%= t.getAvg()%>"></td>
            </tr>
            
            <tr>
                <td>Image</td>
                <td><input type="text" name="image" value="<%= t.getImage()%>"></td>
            </tr>
                
            </table>
            
            <input type="submit" value="Edit">
            <input type="reset" value="RESET">
            
        </form>
    </body>
</html>
