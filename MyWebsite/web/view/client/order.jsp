<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Order</title>
	<link rel="stylesheet" type="text/css" href="/static/admin/css/styless.css">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<script src="js/customerz.js"></script>
	<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
	<%@include file="/view/client/header.jsp"%>
	
	<section class="main">
		<div class="container">
			<div id="wrap-inner">
				<div id="khach-hang">
					<h3>Thông tin khách hàng</h3>
					<p>
						<span class="info">Khách hàng: </span>
						Vietpro
					</p>
					<p>
						<span class="info">Email: </span>
						vietpro@gmail.com
					</p>
					<p>
						<span class="info">Điện thoại: </span>
						01234567988
					</p>
					<p>
						<span class="info">Địa chỉ: </span>
						Hà Nội
					</p>
				</div>						
				<div id="hoa-don">
					<h3>Hóa đơn mua hàng</h3>							
					<table class="shop_table shop_table_responsive cart woocommerce-cart-form__contents" cellspacing="0">
						<thead>
							<tr>
								<th class="product-remove">&nbsp;</th>
								<th class="product-thumbnail">&nbsp;</th>
								<th class="product-name">Sản phẩm</th>
								<th class="product-price">Giá</th>
								<th class="product-quantity">Số lượng</th>
								<th class="product-subtotal">Tạm tính</th>
							</tr>
						</thead>
						<tbody>
							<tr class="woocommerce-cart-form__cart-item cart_item">

								<td class="product-remove">
									<a href="" class="remove" aria-label="Xóa sản phẩm này">×</a>						
								</td>

								<td class="product-thumbnail">
									<a href="">
										<img width="100" height="100" src="/static/admin/images/sp1.jpg" class="img-fluid">
									</a>					
								</td>

								<td class="product-name" data-title="Sản phẩm">
									<a href="">Tổ Yến Thô Tiêu Chuẩn Cao Cấp 50gram</a>
								</td>

								<td class="product-price" data-title="Giá">
									<span class="woocommerce-Price-amount amount">
										<bdi>1,470,000<span class="woocommerce-Price-currencySymbol">₫</span></bdi>
									</span>						
								</td>

								<td class="product-quantity" data-title="Số lượng">
									<div class="quantity">
										1
									</div>
								</td>

								<td class="product-subtotal" data-title="Tạm tính">
									<span class="woocommerce-Price-amount amount">
										<bdi>1,470,000<span class="woocommerce-Price-currencySymbol">₫</span></bdi>
									</span>	
								</td>
							</tr>


							<tr class="coupon-sale">
								<td colspan="6" class="actions">

									<div class="coupon">
										<label for="coupon_code">Ưu đãi:</label> 
										<input type="text" name="coupon_code" class="input-text" id="coupon_code"> 
										<button type="submit" class="btn button" name="apply_coupon" value="Áp dụng">Áp dụng</button>
									</div>

									<button type="submit" class="btn button-update" name="update_cart" value="Cập nhật giỏ hàng">Cập nhật giỏ hàng</button>
									<input type="hidden" id="woocommerce-cart-nonce" ><input type="hidden" name="_wp_http_referer" value="/gio-hang/">				
								</td>
							</tr>
						</tbody>
					</table>
				</div>
				<div id="xac-nhan">
					<br>
					<p align="justify">
						<b>Quý khách đã đặt hàng thành công!</b><br />
						• Sản phẩm của Quý khách sẽ được chuyển đến Địa chỉ có trong phần Thông tin Khách hàng của chúng Tôi sau thời gian 2 đến 3 ngày, tính từ thời điểm này.<br />
						• Nhân viên giao hàng sẽ liên hệ với Quý khách qua Số Điện thoại trước khi giao hàng 24 tiếng.<br />
						<b><br />Cám ơn Quý khách đã sử dụng Sản phẩm của Cửa hàng chúng Tôi!</b>
					</p>
				</div>
			</div>	
		</div>
	</section>


<%@include file="/view/client/footer.jsp"%>

</body>
</html>
