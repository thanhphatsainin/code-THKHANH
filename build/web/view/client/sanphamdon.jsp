<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="Model.Product"%>
<%@page import="java.util.ArrayList"%>
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
						<img src="/static/admin/images/${aa.image}" class="img-fluid">
					</div>
					<div id="product-info">
						<div class="summary entry-summary">
							<h1 class="product_title entry-title">${aa.name}</h1>
							<p class="price">
								<del>
									<span class="woocommerce-Price-amount amount">
										<bdi>${aa.price}<span class="woocommerce-Price-currencySymbol">₫</span></bdi>
									</span>
								</del> 
								<ins>
									<span class="woocommerce-Price-amount amount">
										<bdi>${aa.priceInit}<span class="woocommerce-Price-currencySymbol">₫</span></bdi>
									</span>
								</ins>
							</p>
							<div class="woocommerce-product-details__short-description">
								${aa.desShort}
							</div>
							<div class="act-buy">
								<form class="cart" action="" method="post">
<!--									<button type="button" class="minus">-</button>
									<div class="quantity">
										<input type="number" id="quantity_5fb92e866aab6" class="input-text qty text" step="1" min="1" max="" name="quantity" value="1" title="SL" size="4" placeholder="" inputmode="numeric">
									</div>
									<button type="button" class="plus">+</button>-->
									<div class="buy-item">
										<button type="submit" name="add-to-cart" class="single_add_to_cart_button btn button alt"><a href="cartServlet?productId=${aa.id}">Thêm vào giỏ hàng</a></button>
<!--                                                                                <button type="submit" name="add-to-cart" class="single_add_to_cart_button btn button alt" id="buy_now_button"><a href="listCarts?productId=${aa.id}">
										Mua ngay</a>	</button>-->
									</div>

								</form>
							</div>

						</div>
					</div>
				</div>	
				<div class="row">
					<div id="tab-description">
						<h2>Mô tả</h2>
						${aa.desLong}
					</div>
				</div>
			</div>
		</section>



	<%@include file="/view/client/footer.jsp"%>

	</body>
	</html>
