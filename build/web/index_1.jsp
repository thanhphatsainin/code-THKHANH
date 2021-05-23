<%-- 
    Document   : index.jsp
    Created on : Oct 24, 2020, 8:07:14 AM
    Author     : QuangPro99
--%>

<%@page import="dao.DAO"%>
<%@page import="entities.toy"%>
<%--<%@page import="dao.DAO"%>--%>
<%@page import="entities.user"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin QuangPro99</title>
    </head>
    <body>
        <h1>List User</h1>
        <!-- boder la vien co kich thuoc 1 px, style = "border-collapse la vien don khong phai vien doi"-->
        <table border = "1" style = "border-collapse: collapse;" width = "80%" align="center">
            <tr>
                
                <th>ID</th>
                <th>NAME</th>
                <th>ADDRESS</th>
                <th>EMAIL</th>
                <th>PHONE</th>
                <th>ID CARD NUMBER</th>
                <th>DESCRIPTION</th>
                <th colspan="2"><a href = "add.jsp">ADD NEW USER</a></th>
                <!-- colspan de tach doi cot colsapn="2"-->
            </tr>
            
            
        <%//Nhung java vao trong html, vut ja va ben trong de tranh lap
            ArrayList<user> list = new DAO().getList();//co 1 danh sach toy
            int i= 1;//gan so thu tu
            for(user u : list){
                String urle = "edit.jsp?id="+u.getId();//edit theo id cua tung toy
                String urlr = "remove.jsp?id="+u.getId();
        %>
            <tr><!--doi voi dong STT-->
<!--                <td><%= i++ %></td>STT tu dong tang vi ban dau da gan =1-->
                <td><%= u.getId() %></td>
                <td><%= u.getName()%></td>
                <td><%= u.getAddress() %></td>
                <td><%= u.getEmail() %></td>
                <td><%= u.getPhone() %></td>
                <td><%= u.getIdCardNumber() %></td>
                <td><%= u.getDescription() %></td>
                <td><a href="<%= urle %>" >Edit</a></td><!--can tao duong dan tu add new Toy cho den file khac-->
                <td><a href="<%= urlr %>" >Remove</a></td><!-- urle link de edit, urlr link de remove-->
            </tr>
            <%}%>
        </table>
        
        <br>
        <table border = "1" style = "border-collapse: collapse;" width = "80%" align="center">
            <tr>
                <th>STT</th>
                <th>ID</th>
                <th>NAME</th>
                <th>PRICE</th>
                <th>DESCRIPTION</th>
                <th>DOS</th>
                <th>AVG</th>
                <th>IMAGE</th>
                <th colspan="2"><a href = "addToy.jsp">ADD NEW TOY</a></th>
                <!-- colspan de tach doi cot colsapn="2"-->
            </tr>
            
            
        <%//Nhung java vao trong html, vut ja va ben trong de tranh lap
            ArrayList<toy> list1 = new DAO().getList2();
            int k= 1;//gan so thu tu
            for(toy t : list1){
                String urle = "editToy.jsp?id="+t.getId();//edit theo id cua tung toy
                String urlr = "removeToy.jsp?id="+t.getId();
                
        %>
            <tr><!--doi voi dong STT-->
                <td><%= k++ %></td>
                <td><%= t.getId() %></td>
                <td><%= t.getName()%></td>
                <td><%= t.getPrice() %></td>
                <td><%= t.getDescription()%></td>
                <td><%= t.getDos()%></td>
                <td><%= t.getAvg()%></td>
                <td><%= t.getImage()%></td>
                <td><a href="<%= urle %>" >Edit</a></td><!--can tao duong dan tu add new Toy cho den file khac-->
                <td><a href="<%= urlr %>" >Remove</a></td><!-- urle link de edit, urlr link de remove-->
            </tr>

         <%}%>
        </table>
    </body>
</html>
