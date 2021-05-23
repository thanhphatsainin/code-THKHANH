<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Product"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Evo</title>
        <link rel="stylesheet" type="text/css" href="/static/admin/css/styless.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
        <script src="js/customerz.js"></script>
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    </head>
    <body>
        <%@include file="/view/client/header.jsp"%>
        <section class="slider">
            <div class="wraper">
                <div class="slide">
                    <div class="slide_1 ra">
                        <img src="/static/admin/images/slider_1.jpg" class="img-fluid">
                    </div>
                    <div class="slide_2">
                        <img src="/static/admin/images/slider_1.jpg" class="img-fluid">
                    </div>
                    <div class="slide_3">
                        <img src="/static/admin/images/slider_1.jpg" class="img-fluid">
                    </div>
                </div>
                <div class="nut">
                    <ul>
                        <li></li>
                        <li></li>
                        <li></li>
                    </ul>
                </div>
            </div>
        </section>
        <section class="awe-section-2"> 
            <div class="section_search_feature"> 
                <div class="container"> 
                    <div class="section-2-all"> 
                        <div class="item-policy"> 
                            <a href="tel:0123456789" title="Hotline Hỗ Trợ"> 
                                <img src="/static/admin/images/feature_search_image_1.png" class="img-fluid">
                                <div class="item-policy-content"> 
                                    <h5>Hotline Hỗ Trợ</h5> 
                                    <span class="sub-text">+84 (0123) 456-7890</span>
                                </div> 
                            </a> 
                        </div> 
                        <div class="item-policy"> 
                            <a href="#" title="Miễn phí vận chuyển">
                                <img src="/static/admin/images/feature_search_image_2.png" class="img-fluid">
                                <div class="item-policy-content"> 
                                    <h5>Miễn phí vận chuyển</h5> 
                                    <span class="sub-text">Cho đơn hàng từ 500K</span> 
                                </div>
                            </a>
                        </div>
                        <div class="item-policy"> 
                            <a href="#" title="Miễn phí đổi trả">
                                <img src="/static/admin/images/feature_search_image_3.png" class="img-fluid">
                                <div class="item-policy-content">
                                    <h5>Miễn phí đổi trả</h5>
                                    <span class="sub-text">Trong vòng 30 ngày</span>
                                </div> 
                            </a> 
                        </div> 
                        <div class="item-policy">
                            <a href="#" title="Thanh toán bảo mật"> 
                                <img src="/static/admin/images/feature_search_image_4.png" class="img-fluid">
                                <div class="item-policy-content"> 
                                    <h5>Thanh toán bảo mật</h5> 
                                    <span class="sub-text">Chúng tôi chấp nhận các loại thẻ</span> 
                                </div> 
                            </a> 
                        </div>
                    </div> 
                </div> 
            </div> 
        </section>
        <section class="awe-section-3"> 
            <div class="section_three_banner"> 
                <div class="container"> 
                    <div class="row"> 
                        <div class="col-md-12 text-center"> 
                            <div class="sport-title"> 
                                <h3>Danh mục nổi bật</h3> 
                                <p>Evo Milana cung cấp những mẫu thiết kế thanh lịch, hiện đại được cập nhật liên tục hàng tuần.</p> 
                            </div> 
                        </div> 
                    </div> 


                    <div class="row"> 
                        <div class="fix-banner-margin"> 
                            <div class="item-shop-cate">
                                <a href="#" title="Shop Nữ"> 
                                    <img src="/static/admin/images/feature_banner_image_1.jpg" class="img-fluid">
                                    <span class="item-shop-cate-title">Shop Nữ</span> 
                                </a>
                            </div> 
                        </div> 
                        <div class="fix-banner-margin-small"> 
                            <div class="item-shop-cate big"> 
                                <a href="#" title="Shop Nam">
                                    <img src="/static/admin/images/feature_banner_image_2.jpg" class="img-fluid">
                                    <span class="item-shop-cate-title">Shop Nam</span> 
                                </a> 
                            </div>
                        </div> 
                        <div class=" fix-banner-margin-small"> 
                            <div class="item-shop-cate two-small"> 
                                <a href="#" title="Phụ Kiện"> 
                                    <img src="/static/admin/images/feature_banner_image_3.jpg" class="img-fluid">
                                    <span class="item-shop-cate-title">Phụ Kiện</span>
                                </a> 
                            </div> 
                            <div class="item-shop-cate two-small"> 
                                <a href="#" title="Khuyến mãi"> 
                                    <img src="/static/admin/images/feature_banner_image_4.jpg" class="img-fluid">
                                    <span class="item-shop-cate-title">Khuyến mãi</span> 
                                </a> 
                            </div>
                        </div> 
                    </div> 
                </div> 
            </div> 
        </section>



        <section class="awe-section-5"> 
            <div class="section_feature_collection_single"> 
                <div class="container"> 
                    <div class="row"> 
                        <div class="section_feature_collection_single_item">
                            <div class="fix-image">
                                <a class="single-col-img" href="" title="Color Of Spring"> 
                                    <img src="/static/admin/images/evo_collection_feature_img_1.jpg" class="img-fluid">
                                </a> 
                            </div> 
                            <div class="feature-collection-content"> 
                                <h3> 
                                    <a href="" title="Color Of Spring">Color Of Spring</a> 
                                </h3> 
                                <p> Nếu có thể được ví mùa xuân như một loại trái cây, tôi sẽ chọn trái cam vàng mọng nước, từ màu sắc, đến cái chạm vẻ ngoài, hay vị đọng lại: đều ngọt mát tự nhiên, đủ cho ta sự hứng khởi lạ kỳ. </p>
                                <a class="single-col-more" href="" title="Xem chi tiết">Xem chi tiết</a>
                            </div> 
                        </div> 
                        <div class="section_feature_collection_single_item">
                            <div class="feature-collection-content"> 
                                <h3> 
                                    <a href="" title="Color Of Spring">Color Of Spring</a> 
                                </h3> 
                                <p> Nếu có thể được ví mùa xuân như một loại trái cây, tôi sẽ chọn trái cam vàng mọng nước, từ màu sắc, đến cái chạm vẻ ngoài, hay vị đọng lại: đều ngọt mát tự nhiên, đủ cho ta sự hứng khởi lạ kỳ. </p>
                                <a class="single-col-more" href="" title="Xem chi tiết">Xem chi tiết</a>
                            </div> 
                            <div class="fix-image">
                                <a class="single-col-img" href="" title="Color Of Spring"> 
                                    <img src="/static/admin/images/evo_collection_feature_img_1.jpg" class="img-fluid">
                                </a> 
                            </div> 
                        </div> 
                    </div> 
                </div> 
            </div>
        </section>
        <section class="awe-section-6">
            <div class="container section_product_1 index-margin-top">
                <div class="row">
                    <div class="col-md-12">
                        <div class="sport-title">
                            <h3>
                                <a href="san-pham-moi" title="Hàng mới về">Hàng mới về</a>
                            </h3> 
                            <p>Danh sách sản phẩm thời trang mới nhất được cập nhật trong bộ sưu tập thời trang Evo Milana</p> 
                        </div> 
                    </div>
                </div>
                <div class="products-slide">
                    <c:forEach items="${listProduct}" var="product" >
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
        <section class="awe-section-12"> 
            <div class="container section_blogs"> 
                <div class="row">
                    <div class="col-md-12"> 
                        <div class="sport-title">
                            <h3>
                                <a href="http://localhost:39639/view/client/allArchive" title="Tin tức thời trang">Tin tức thời trang</a>
                            </h3> 
                            <p> Cập nhật xu hướng làm đẹp và thời trang nóng hổi nhất, đọc vị style của người nổi tiếng, tất cả những gì "hot hit" nhất về làm đẹp và thời trang mà bạn cần biết. </p>
                        </div>
                    </div> 
                </div>
                <div class="section_blogs_item_around">
                    <c:forEach items="${listArticle}" var="a">
                    <div class="section_blogs_item">
                        <div class="item-news-index" > 
                            <div class="item-news-image"> 
                                <a href="/view/client/singleArchive?articleId=${a.id}"> 
                                    <img src="/static/admin/images/${a.image}" class="img-fluid"> 
                                </a>
                            </div> 
                            <div class="item-news-content"> 
                                <h4> 
                                    <a href="/view/client/singleArchive?articleId=${a.id}" tabindex="-1">${a.name}</a> 
                                </h4> 
                                <div class="zone-content"> ${a.des}
                                </div> 
                            </div> 
                        </div>
                    </div>
                    </c:forEach>
                </div>
        </section>

        <section class="evo-newletter">
            <div class="container">
                <div class="txt-left">
                    <p>Nhận thông tin khuyến mãi mới nhất từ Evo Milana</p>
                </div>
                <div class="txt-mail">
                    <form method="post" action="sendMailtoCus">
                        <input type="text" name="mailCus" placeholder="Nhập email">
                        <button type="submit">
                            Đăng ký
                        </button>
                    </form>
                </div>
            </div>

        </section>
        <%@include file="/view/client/footer.jsp"%>

    </body>
</html>
