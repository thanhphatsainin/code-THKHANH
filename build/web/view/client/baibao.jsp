<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>archive-post</title>
	<link rel="stylesheet" type="text/css" href="/static/admin/css/styless.css">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<script src="js/customerz.js"></script>
	<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
	<%@include file="/view/client/header.jsp"%>
	<section class="archive-post">
		<div class="container">
			<h1 class="title-category">Tất cả Tin tức</h1>
			<div class="all-post">
                            <c:forEach items="${listArticle}" var="a">
				<div class="item-news-index"> 
					<div class="item-news-image"> 
						<a href="singleArchive?articleId=${a.id}">
							<img src="/static/admin/images/${a.image}" class="img-fluid">
						</a> 
					</div> 
					<div class="item-news-content">
						<h4> 
							<a href="" >Diện quần cạp chun đâu chỉ thoải mái mà còn rất “ăn chơi”, hay nữa là bạn có thể mua online không cần thử</a> 
						</h4> 
						<div class="zone-content">
							Mùa Hạ đã gần kề và như một thói quen, các chị em sẽ rục rịch update cho tủ đồ Hè những items mới toanh để phong các...
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