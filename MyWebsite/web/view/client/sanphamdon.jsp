<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Single-product</title>
	<link rel="stylesheet" type="text/css" href="/static/admin/css/styless.css">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<script src="js/customerz.js"></script>
	<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
	<%@include file="/view/client/header.jsp"%>
	<section class="single-product">
		<div class="container">
			<div class="wrap-inner">
				<div class="row">
					<div id="product-img">
						<img src="/static/admin/images/sp1.jpg" class="img-fluid">
					</div>
					<div id="product-info">
						<div class="summary entry-summary">
							<h1 class="product_title entry-title">Túi đeo chéo Croc Effect Mini Rectangular Crossbody</h1>
							<p class="price">
								<del>
									<span class="woocommerce-Price-amount amount">
										<bdi>1,550,000<span class="woocommerce-Price-currencySymbol">₫</span></bdi>
									</span>
								</del> 
								<ins>
									<span class="woocommerce-Price-amount amount">
										<bdi>1,470,000<span class="woocommerce-Price-currencySymbol">₫</span></bdi>
									</span>
								</ins>
							</p>
							<div class="woocommerce-product-details__short-description">
								Thành phần vải: 100% Cotton
								Phom dáng áo thun cổ tròn
								Tay ngắn
								Họa tiết in hình chú chó vui nhộn
								In chữ "Just For Fun" phía trước áo
								Chất vải mềm mịn
								Màu sắc dễ phối với nhiều trang phục, phụ kiện
								Xuất xứ thương hiệu: Hong Kong
							</div>
							<div class="act-buy">
								<form class="cart" action="" method="post">
									<button type="button" class="minus">-</button>
									<div class="quantity">
										<input type="number" id="quantity_5fb92e866aab6" class="input-text qty text" step="1" min="1" max="" name="quantity" value="1" title="SL" size="4" placeholder="" inputmode="numeric">
									</div>
									<button type="button" class="plus">+</button>
									<div class="buy-item">
										<button type="submit" name="add-to-cart" class="single_add_to_cart_button btn button alt">Thêm vào giỏ hàng</button>
                                                                                <button type="submit" name="add-to-cart" class="single_add_to_cart_button btn button alt" id="buy_now_button"><a href="/view/client/giohang.jsp">
										Mua ngay</a>	</button>
									</div>

								</form>
							</div>

						</div>
					</div>
				</div>	
				<div class="row">
					<div id="tab-description">
						<h2>Mô tả</h2>
						Được thành lập vào năm 2002 bởi một bộ đôi tín đồ thời trang, Evo Milana đã nhanh chóng trở thành một trong những công ty phân phối thời trang lớn nhất trong việc giới thiệu các thương hiệu thời trang cao cấp và sang trọng tại Việt Nam. Sau thành công ngoài mong đợi của cửa hàng đầu tiên, hiện Evo Milana đang là ngôi nhà chung của hơn 21 thương hiệu đình đám thế giới, thổi vào thị trường Việt Nam những giấc mơ thời trang bất tận.
					</div>
				</div>
			</div>
		</section>



	<%@include file="/view/client/footer.jsp"%>

	</body>
	</html>
