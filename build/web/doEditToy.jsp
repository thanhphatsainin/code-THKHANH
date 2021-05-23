<%-- 
    Document   : doEditToy
    Created on : Oct 28, 2020, 8:11:38 AM
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
        <%
//           id vi ben add name cuxng la id nen can goi dung de bat su kien sang doAdd
           toy t  = new toy();
           t.setId(request.getParameter("id"));
           t.setName(request.getParameter("name"));
           t.setPrice(request.getParameter("price"));
           t.setDescription(request.getParameter("description"));
           t.setDos(request.getParameter("dos"));
           t.setAvg(Float.parseFloat(request.getParameter("avg")));
           t.setImage(request.getParameter("image"));
           
           /*
            u.setPhone(new Integer(request.getParameter("phone")));
            u.setIdCardNumber(new Integer(request.getParameter("idcardNumber")));
           */
           //Đặt debug ở đây để xem những giá trị ở bên trên như setId, setName các thứ
           
           
           if(new DAO().editToy(t)){
               response.sendRedirect("index_1.jsp");//quay tro lai trang chu saau khi da add
           }
           else{
               response.sendRedirect("error.jsp");
           }
       %>
    </body>
</html>
