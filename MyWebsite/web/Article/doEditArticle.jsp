

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
        <%  request.setCharacterEncoding("UTF-8");
//           id vi ben add name cuxng la id nen can goi dung de bat su kien sang doAdd
           Article u  = new Article();
           u.setId(Integer.parseInt((request.getParameter("id"))));
           u.setName(request.getParameter("name"));
           u.setImage(request.getParameter("image"));
           u.setDes(request.getParameter("des"));

           /*
            u.setPhone(new Integer(request.getParameter("phone")));
            u.setIdCardNumber(new Integer(request.getParameter("idcardNumber")));
           */
           //Đặt debug ở đây để xem những giá trị ở bên trên như setId, setName các thứ

           new ArticleDAO().editarticle(u);
           response.sendRedirect("listArticle.jsp");
       %>
    </body>

</html>
