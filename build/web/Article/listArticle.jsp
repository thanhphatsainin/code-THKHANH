

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Article"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Dashboard</title>
        <link rel="stylesheet" href="/static/admin/css/main.css">
    </head>


    <body>

        <div class="wrapper">
            <div class="container">
                <div class="dashboard">
                    <div class="left">
                        <span class="left__icon">
                            <span></span>
                            <span></span>
                            <span></span>
                        </span>
                        <div class="left__content">
                            <div class="left__logo">LOGO</div>
                            <div class="left__profile">
                                <div class="left__image">
                                    <%--<c:url value="/static/admin/assets/profile.jpg" var="bootstrap"></c:url>--%>
                                    <img src="/static/admin/assets/profile.jpg" />
                                    <!--<img src="assets/profile.jpg" alt="">-->
                                </div>


                                <p class="left__name">Hatsune Miku</p>
                            </div>
                            <ul class="left__menu">
                                <li class="left__menuItem">
                                    <a href="http://localhost:39639/listBill" class="left__title">
                                        <img src="/static/admin/assets/icon-dashboard.svg" alt="">Dashboard
                                    </a>
                                </li>
                                <li class="left__menuItem">
                                    <div class="left__title">
                                        <a href="http://localhost:39639/listProduct" class="left__title">
                                            <img src="/static/admin/assets/icon-tag.svg" alt="">Sản Phẩm
                                        </a>
                                    </div>
                                </li>
                                <li class="left__menuItem">
                                    <div class="left__title">
                                        <a href="http://localhost:39639/listCategory" class="left__title">
                                            <img src="/static/admin/assets/icon-edit.svg" alt="">Danh Mục SP
                                        </a>
                                    </div>
                                </li>

                                <li class="left__menuItem">
                                    <a href="http://localhost:39639/listUser" class="left__title">
                                        <img src="/static/admin/assets/icon-users.svg" alt="">Khách Hàng
                                    </a>
                                </li>
                                <li class="left__menuItem">
                                    <a href="http://localhost:39639/listBill" class="left__title">
                                        <img src="/static/admin/assets/icon-book.svg" alt="">Đơn Đặt Hàng
                                    </a>
                                </li>
                                <li class="left__menuItem">
                                    <a href="http://localhost:39639/listLogo" class="left__title">
                                        <img src="/static/admin/assets/icon-settings.svg" alt="">Logo
                                    </a>
                                </li>
                                <li class="left__menuItem">
                                    <a href="http://localhost:39639/listArticle" class="left__title">
                                        <img src="/static/admin/assets/icon-pencil.svg" alt="">Article
                                    </a>
                                </li>
                                <li class="left__menuItem">
                                    <a href="http://localhost:39639/listContact" class="left__title">
                                        <img src="/static/admin/assets/icon-book.svg" alt="">Contact
                                    </a>
                                </li>
                                <li class="left__menuItem">
                                    <a href="index.jsp" class="left__title"><img src="/static/admin/assets/icon-logout.svg" alt="">Đăng Xuất</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="right">
                        <div class="right__content">
                            <div class="right__table">
                                <!--<p class="right__tableTitle">Danh sách sản phẩm</p>-->
                                <div class="right__tableWrapper">
                                    <div class="left_user" name="name">${sessionScope.nameUser}</div>
                                    <h1><center>List Article</center></h1>
                                    <!-- boder la vien co kich thuoc 1 px, style = "border-collapse la vien don khong phai vien doi"-->


                                    <table border = "1" style = "border-collapse: collapse;" width = "80%" align="center">
                                        <tr>
                                            <th>ID</th>
                                            <th>NAME</th>
                                            <th>Image</th>
                                            <th>Description</th>
                                            <th colspan="2"><a href = "Article/addArticle.jsp">ADD NEW Article</a></th>
                                            <!-- colspan de tach doi cot colsapn="2"-->
                                        </tr>

                                        <c:forEach items="${listArticle}" var="article" >
                                            <tr>
                                                <td>${article.id}</td>
                                                <td>${article.name}</td>
                                                <td data-label="Hình ảnh" style="text-align: center;"><img style="width: 50px;height: 50px; border-radius: 100%; object-fit: cover;" src="/static/admin/assets/${article.image}" alt=""></td>
                                                <!--<td>${article.image}</td>-->
                                                <td>${article.des}</td>
                                                <td><a href="editArticle?articleId=${article.id}">Edit</a></td>
                                                <td><a href="removeArticle?articleId=${article.id}">Remove</a></td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="/static/admin/js/main.js"></script>

        <!--        <h1><center>List Article</center></h1>
                 boder la vien co kich thuoc 1 px, style = "border-collapse la vien don khong phai vien doi"
                
                
                <table border = "1" style = "border-collapse: collapse;" width = "80%" align="center">
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>Image</th>
                        <th>Description</th>
                        <th colspan="2"><a href = "Article/addArticle.jsp">ADD NEW Article</a></th>
                         colspan de tach doi cot colsapn="2"
                    </tr>
                    
        <c:forEach items="${listArticle}" var="article" >
            <tr>
                <td>${article.id}</td>
                <td>${article.name}</td>
                <td>${article.image}</td>
                <td>${article.des}</td>
                <td><a href="editArticle?articleId=${article.id}">Edit</a></td>
                <td><a href="removeArticle?articleId=${article.id}">Remove</a></td>
            </tr>
        </c:forEach>
    </table>-->
    </body>
</html>
