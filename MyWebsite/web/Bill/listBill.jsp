
<%@page import="Dao1.ProductDAO"%>
<%@page import="Dao1.CategoryDAO"%>
<%@page import="Model.Category"%>
<%@page import="Dao1.BillDAO"%>
<%@page import="Model.Bill"%>
<%@page import="Model.User"%>
<%@page import="Dao1.UserDAO"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Product"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
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
                                <div class="left__image"><img src="/static/admin/assets/profile.jpg" alt=""></div>
                                <p class="left__name">Hatsune Miku</p>
                            </div>
                            <ul class="left__menu">
                                <li class="left__menuItem">
                                    <a href="http://localhost:8080/listBill" class="left__title">
                                        <img src="/static/admin/assets/icon-dashboard.svg" alt="">Dashboard
                                    </a>
                                </li>
                                <li class="left__menuItem">
                                    <div class="left__title">
                                        <a href="http://localhost:8080/listProduct" class="left__title">
                                            <img src="/static/admin/assets/icon-tag.svg" alt="">Sản Phẩm
                                        </a>
                                    </div>
                                </li>
                                <li class="left__menuItem">
                                    <div class="left__title">
                                        <a href="http://localhost:8080/listCategory" class="left__title">
                                            <img src="/static/admin/assets/icon-edit.svg" alt="">Danh Mục SP
                                        </a>
                                    </div>
                                </li>

                                <li class="left__menuItem">
                                    <a href="http://localhost:8080/listUser" class="left__title">
                                        <img src="/static/admin/assets/icon-users.svg" alt="">Khách Hàng
                                    </a>
                                </li>
                                <li class="left__menuItem">
                                    <a href="http://localhost:8080/listBill" class="left__title">
                                        <img src="/static/admin/assets/icon-book.svg" alt="">Đơn Đặt Hàng
                                    </a>
                                </li>
                                <li class="left__menuItem">
                                    <a href="http://localhost:8080/listLogo" class="left__title">
                                        <img src="/static/admin/assets/icon-settings.svg" alt="">Logo
                                    </a>
                                </li>
                                <li class="left__menuItem">
                                    <a href="http://localhost:8080/listArticle" class="left__title">
                                        <img src="/static/admin/assets/icon-pencil.svg" alt="">Article
                                    </a>
                                </li>
                                <li class="left__menuItem">
                                    <a href="http://localhost:8080/listContact" class="left__title">
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
                            <div class="right__title">Bảng điều khiển</div>
                            <p class="right__desc">Bảng điều khiển</p>
                            <div class="right__cards">
                                <a class="right__card" href="http://localhost:8080/listProduct">
                                    <div class="right__cardTitle">Sản Phẩm</div>
                                    <div class="right__cardNumber">${listProduct.size()}</div>
                                    <div class="right__cardDesc">Xem Chi Tiết <img src="assets/arrow-right.svg" alt=""></div>
                                </a>
                                <a class="right__card" href="http://localhost:8080/listUser">
                                    <div class="right__cardTitle">Khách Hàng</div>
                                    <div class="right__cardNumber">${listUser.size()}</div>
                                    <div class="right__cardDesc">Xem Chi Tiết <img src="assets/arrow-right.svg" alt=""></div>
                                </a>
                                <a class="right__card" href="http://localhost:8080/listCategory">
                                    <div class="right__cardTitle">Danh Mục</div>
                                    <div class="right__cardNumber">${listCategory.size()}</div>
                                    <div class="right__cardDesc">Xem Chi Tiết <img src="assets/arrow-right.svg" alt=""></div>
                                </a>
                                <a class="right__card" href="http://localhost:8080/listBill">
                                    <div class="right__cardTitle">Đơn Hàng</div>
                                    <div class="right__cardNumber">${listBill.size()}</div>
                                    <div class="right__cardDesc">Xem Chi Tiết <img src="assets/arrow-right.svg" alt=""></div>
                                </a>
                            </div>
                            <div class="right__table">
                                <!--<p class="right__tableTitle">Đơn hàng mới</p>-->
                                <div class="right__tableWrapper">
                                    <h1><center>List Bill</center></h1>
                                    <!-- boder la vien co kich thuoc 1 px, style = "border-collapse la vien don khong phai vien doi"-->


                                    <table border = "1" style = "border-collapse: collapse;" width = "80%" align="center">
                                        <tr>
                                            <th>STT</th>
                                            <th>Code Bill</th>
                                            <th>Name Customer</th>
                                            <th>Email</th>
                                            <th>Address</th>
                                            <th>Name Product</th>
                                            <th>Image Product</th>
                                            <th>Price</th>
                                            <th>Amount</th>
                                            <th>Date Pay</th>
                                            <th>Total</th>
                                            <th>Status</th>
                                            <th colspan="2"><a href = "Bill/addBill.jsp">ADD NEW Product</a></th>
                                            <!-- colspan de tach doi cot colsapn="2"-->
                                        </tr>

                                        <c:forEach items="${listBill}" var="bill" >
                                            <tr>
                                                <td>${bill.id}</td>
                                                <td>${bill.code}</td>
                                                <td>${bill.user.getName()}</td>
                                                <td>${bill.user.getEmail()}</td>
                                                <td>${bill.user.getAddress()}</td>

                                                <%--<c:forEach items="${bill.order.cart.getListProCarts()}" var="procart" >--%>
                                                <!--<tr>-->
                                                <td>
                                                    <c:forEach items="${bill.order.cart.getListProCarts()}" var="procart" >
                                                        <div> ${procart.product.getName()}</div>
                                                    </c:forEach>
                                                </td>
                                                <td data-label="Hình ảnh" style="text-align: center;">

                                                    <c:forEach items="${bill.order.cart.getListProCarts()}" var="procart" >
                                                        <div><img style="width: 50px;height: 50px; border-radius: 100%; object-fit: cover;" src="/static/admin/assets/${procart.product.getImage()}" alt=""></div>
                                                        </c:forEach>
                                                </td>
                                                <td>
                                                    <c:forEach items="${bill.order.cart.getListProCarts()}" var="procart" >
                                                        <div> ${procart.product.getPrice()}</div>
                                                    </c:forEach>

                                                </td>
                                                <td>
                                                    <c:forEach items="${bill.order.cart.getListProCarts()}" var="procart" >
                                                        <div> ${procart.amount}</div>
                                                    </c:forEach>

                                                </td>
                                                <!--</tr>-->
                                                <%--</c:forEach>--%>

                                                <td>${bill.datePay}</td>
                                                <td>${bill.total}</td>
                                                <td>${bill.status}</td>
                                                <td><a href="editBill?billId=${product.id}">Edit</a></td>
                                                <td><a href="removeBill?billId=${product.id}">Remove</a></td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </div>
                                <!--<a href="" class="right__tableMore"><p>Xem tất cả các đơn đặt hàng</p> <img src="assets/arrow-right-black.svg" alt=""></a>-->
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <script src="/static/admin/js/main.js"></script>
    </body>
</html>
