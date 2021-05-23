<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Single-post</title>
        <link rel="stylesheet" type="text/css" href="/static/admin/css/styless.css">
        <meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
        <script src="js/customerz.js"></script>
        <link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    </head>
    <body>
        <%@include file="/view/client/header.jsp"%>
        <section class="single-post">
            <div class="container">
                <div class="row">

                    <div class="single-left">
                        
                            <h1 class="title-head">${abc.name}</h1>
                            <div class="content-post">
                                <p>Nhìn chung, style đời thường của các sao nữ xứ Hàn không hề cầu kỳ, làm quá; họ thường lên đồ với những items cơ bản nhưng vẫn ra được những set trang phục được đánh giá cao ở vẻ sành điệu. Và vì lẽ đó, bạn sẽ không thể bỏ qua loạt gợi ý diện đồ giản đơn, dễ mặc và chắc chắn sẽ đẹp sau đây của các mỹ nhân Kbiz; tất cả sẽ giúp nâng style của bạn lên một tầm cao mới.</p>
                                <p><img src="/static/admin/images/${abc.image}" ></p>
                                <p>${abc.des}</p>
                            </div>
                       
                    </div>

                    <div class="single-right">
                        <div class="post-related">
                            <h2 class="h2-title">Top bài viết nổi bật</h2>
                            <c:forEach items="${li}" var = "li">
                            <div class="item-news-index" >
                                <div class="item-news-image">
                                    <a href="singleArchive?articleId=${li.id}" tabindex="-1"> 
                                        <img src="/static/admin/images/${li.image}" class="img-fluid">
                                    </a> 
                                </div>
                                <div class="item-news-content">
                                    <h4> 
                                        <a href="">${li.name}</a> 
                                    </h4>
                                </div>
                            </div>
                           </c:forEach>

                        </div>
                    </div>
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
