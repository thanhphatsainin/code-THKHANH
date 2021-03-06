<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cart</title>
        <link rel="stylesheet" type="text/css" href="/static/admin/css/styless.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
        <script src="js/customerz.js"></script>
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    </head>
    <body>
        <%@include file="/view/client/header.jsp"%>
        <section class="cart-main">
            <div class="container">
                <div id="wrap-inner">
                    <div id="list-cart">
                        <h3>Giỏ hàng</h3>
                        <form action="cong" method="post">
                            <table class="table table-bordered .table-responsive text-center">
                                <tr class="active">
                                    <td width="11.111%">Ảnh mô tả</td>
                                    <td width="22.222%">Tên sản phẩm</td>
                                    <td width="22.222%">Số lượng</td>
                                    <td width="16.6665%">Đơn giá</td>
                                    <td width="16.6665%">Thành tiền</td>
                                    <td width="11.112%">Xóa</td>
                                </tr>
                                
                                <c:forEach items="${listCart}" var = "listCart">
                                    
                                    <tr>
                                        <td><img class="img-responsive" src="/static/admin/images/${listCart.product.getImage()}"></td>
                                        <td>${listCart.product.getName()}</td>
                                        <td>
                                            <div class="form-group">
                                               
                                                <input class="form-control" type="number" name ="soluong" value="${listCart.amount}">
                                                 <input class="abcde" type="number" name ="procartId" value="${listCart.id}">
                                            </div>
                                        </td>
                                        <td><span class="price">${listCart.product.getPrice()} đ</span></td>
                                        <td><span class="price">${listCart.product.getPrice() * listCart.amount} đ</span></td>
                                        <td><a href="removeCart?productId=${listCart.product.getId()}">Xóa</a></td>
                                    </tr>
                                     
                                </c:forEach>
                            </table>
                            <div  id="total-price">
                                <div class="info-left">										
                                    Tổng thanh toán: <span class="total-price">${total}đ</span>

                                </div>
                                <div class="all-but">
                                    <a href="/view/client/allSanpham" class="my-btn btn">Mua tiếp</a>
                                    <!--<a type="submit" class="my-btn btn">Cập nhật</a>-->
                                    <input type="submit" class="my-btn btn" value="Cập nhật">
                                    <!--<a href="#" class="my-btn btn">Xóa giỏ hàng</a>-->
                                </div>
                            </div>
                        </form>             	                	
                    </div>


                </div>
                <div id="xac-nhan">
<!--                    <h3>Xác nhận mua hàng</h3>-->
                    <form>
<!--                        <div class="form-group">
                            <label for="email">Email address:</label>
                            <input required type="email" class="form-control" id="email" name="email">
                        </div>
                        <div class="form-group">
                            <label for="name">Họ và tên:</label>
                            <input required type="text" class="form-control" id="name" name="name">
                        </div>
                        <div class="form-group">
                            <label for="phone">Số điện thoại:</label>
                            <input required type="number" class="form-control" id="phone" name="phone">
                        </div>
                        <div class="form-group">
                            <label for="add">Địa chỉ:</label>
                            <input required type="text" class="form-control" id="add" name="add">
                        </div>-->
                        <div class="form-group text-right">
                            <button type="submit" class="btn btn-default"><a href="checkout">Thực hiện đơn hàng</a></button>
                        </div>
                    </form>
                </div>
            </div>
            <div class="cart-table">
                <div class=""></div>
            </div>
        </section>
        <%@include file="/view/client/footer.jsp"%>

    </body>
</html>
