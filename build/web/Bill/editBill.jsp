<%-- 
    Document   : editBill
    Created on : Dec 3, 2020, 9:18:55 PM
    Author     : DELL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ListUser</title>
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
                                    <a href="" class="left__title"><img src="/static/admin/assets/icon-logout.svg" alt="">Đăng Xuất</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="right">
                        <div class="right__content">
                            <div class="right__table">
                                <div class="right__tableWrapper">
                                    <form method="POST" action="editBillAction">

                                        <h1 align="center">Edit Bill</h1>
                                        <table>
                                            <tr>
                                                <td>ID: </td>
                                                <td><input type="text" name="id" value = "${billUpdate.id}" readonly="true"></td>
                                            </tr>

                                            <tr>
                                                <td>IDUser: </td>
                                                <td><input type="text" name="userId" value = "${billUpdate.user.getId()}" readonly="true"></td>
                                            </tr>

                                            <tr>
                                                <td>IdOrder </td>
                                                <td><input type="text" name="orderId" value = "${billUpdate.order.getId()}" readonly="true"></td>
                                            </tr>

                                            <tr>
                                                <td>Code </td>
                                                <td><input type="text" name="code" value = "${billUpdate.code}" readonly="true"></td>
                                            </tr>

                                            <tr>
                                                <td>Date Pay </td>
                                                <td><input type="text" name="datePay" value = "${billUpdate.datePay}" readonly="true"</td>
                                            </tr>

                                            <tr>
                                                <td>Status </td>
                                                <td><input type="text" name="status" value = "${billUpdate.status}" ></td>
                                            </tr>
                                        </table>

                                        <input align="center" type="submit" value="Edit">
                                        <input align="center" type="reset" value="RESET">

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="/static/admin/js/main.js"></script>
    </body>
</html>
