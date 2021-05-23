

<%@page import="Model.User"%>
<%@page import="Dao1.UserDAO"%>
<%@page import="Dao1.DAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%  request.setCharacterEncoding("UTF-8");
//           id vi ben add name cuxng la id nen can goi dung de bat su kien sang doAdd
           User u  = new User();
           u.setId(Integer.parseInt((request.getParameter("id"))));
           u.setName(request.getParameter("name"));
           u.setEmail(request.getParameter("email"));
           u.setAddress(request.getParameter("address"));
           u.setPosition(request.getParameter("position"));
           u.setUsername(request.getParameter("username"));
           u.setPassword(request.getParameter("password"));
           /*
            u.setPhone(new Integer(request.getParameter("phone")));
            u.setIdCardNumber(new Integer(request.getParameter("idcardNumber")));
           */
           //Đặt debug ở đây để xem những giá trị ở bên trên như setId, setName các thứ

           if(new UserDAO().editUser(u)){
               response.sendRedirect("listUser.jsp");;//quay tro lai trang chu saau khi da add
           }
           else{
               response.sendRedirect("error.jsp");
           }
                 

       %>
    </body>

</html>
