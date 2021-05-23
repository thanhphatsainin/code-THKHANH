
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>ListCategory</title>
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
                                <!--<p class="right__tableTitle">Danh sách sản phẩm</p>-->
                                <div class="right__tableWrapper">
                                    <form method="POST" action="addContact">

                                        <h1 align="center">THÊM Contact</h1>
                                        <table>
                                            <!--                <tr>
                                                                <td>ID: </td>
                                                                <td><input type="text" name="id" placeholder="6"></td>
                                                            </tr>-->
                                            <tr>
                                                <td>Address: </td>
                                                <td><input type="text" name="address"></td>
                                            </tr>

                                            <tr>
                                                <td>Email: </td>
                                                <td><input type="text" name="email"></td>
                                            </tr>

                                            <tr>
                                                <td>Phone </td>
                                                <td><input type="text" name="sdt"></td>
                                            </tr>

                                            <tr>
                                                <td>Hottline </td>
                                                <td><input type="text" name="hottline"></td>
                                            </tr>


                                        </table>

                                        <input type="submit" value="ADD NEW Contact">
                                        <input type="reset" value="RESET">

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
