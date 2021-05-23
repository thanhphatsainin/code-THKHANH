<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Product"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <title>archive-product</title>
        <link rel="stylesheet" type="text/css" href="/static/admin/css/styless.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
        <script src="js/customerz.js"></script>
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    </head>
    <body>
        <%@include file="/view/client/header.jsp"%>

        <section class="banner-slide">
            <img src="/static/admin/images/cat-banner-1.jpg" class="img-fluid">
        </section>
        <section class="archive-product">
            <div class="container">
                <h1 class="title-category">Tất cả sản phẩm</h1>
                <div class="mota-category">Cập nhật những xu hướng quốc tế nhanh nhất cho phái đẹp, thay đổi diện mạo của bạn một cách toàn diện. Một tủ quần áo từ Ted Baker, Oasis, Warehouse, Puma,... mà các cô nàng ao ước sẽ khiến bạn trở nên hoàn hảo.</div>
                <div class="all-product">
                    <c:forEach items="${result}" var="product" >
                    <div class="item" >
                        <div class="evo-product-block-item"> 
                            <div class="box-image"> 
                                <a href="/view/client/click?productId=${product.id}" class="evo-image-pro product-item-photo" title="">
                                    <img src="/static/admin/images/${product.image}" class="img-fluid">
                                </a> 
                                <div class="label_product"> 
                                     <span class="label_sale">${100-(product.priceInit/product.price)*100}%</span> 
                                </div> 
                            </div> 
                            <div class="product-item-details">
                                <div class="price-box">
                                    <span class="price">${product.priceInit}</span>
                                    <span class="old-price">${product.price}</span>
                                </div> 
                                <h3 class="product-item-name">
                                    <a href="/view/client/click?productId=${product.id}">${product.name}</a> 
                                </h3> 
                            </div> 
                        </div>
                    </div>
                    </c:forEach>
                </div>
            </div>

        </section>

        <section class="evo-newletter">
            <div class="container">
                <div class="txt-left">
                    <p>Nhận thông tin khuyến mãi mới nhất từ Evo Milana</p>
                </div>
                <div class="txt-mail">
                    <input type="text" placeholder="Nhập email">
                    <button type="submit">
                        Đăng ký
                    </button>
                </div>
            </div>

        </section>
        <%@include file="/view/client/footer.jsp"%>

    </body>
</html>