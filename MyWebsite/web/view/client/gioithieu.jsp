<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<link rel="stylesheet" type="text/css" href="/static/admin/css/styless.css">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<script src="js/customerz.js"></script>
	<link rel="stylesheet" href="path/to/font-awesome/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
	
	<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.css">
	<link rel="stylesheet" href="https://unpkg.com/swiper/swiper-bundle.min.css">

	<script src="https://unpkg.com/swiper/swiper-bundle.js"></script>
	<script src="https://unpkg.com/swiper/swiper-bundle.min.js"></script>

	<link rel="stylesheet" type="text/css" href="js/animate.css">
	<script src="js/customerz.js"></script>
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
</head>
<body>
	<%@include file="/view/client/header.jsp"%>

	<section class="content-page">
		<img src="/static/admin/images/hotsales-1.jpg" class="img-fluid">
		<div class="demo">
			<div class="container">
				<div class="form-border-left">
					<div class="left-box">
						<label>01</label>
						<span>Về Evo Milana</span>
					</div>
				</div>
				<div class="demo-text-right">
					<div class="right-head-title">
						<small>Về chúng tôi</small>
						<h3>Nhiệm vụ, tầm nhìn và  giá trị thương hiệu.</h3>
					</div>
					<div class="text-content">
						<p>Được thành lập vào năm 2002 bởi một bộ đôi tín đồ thời trang, Evo Milana đã nhanh chóng trở thành một trong những công ty phân phối thời trang lớn nhất trong việc giới thiệu các thương hiệu thời trang cao cấp và sang trọng tại Việt Nam. Sau thành công ngoài mong đợi của cửa hàng đầu tiên, hiện Evo Milana đang là ngôi nhà chung của hơn 21 thương hiệu đình đám thế giới, thổi vào thị trường Việt Nam những giấc mơ thời trang bất tận.</p>
					</div>
				</div>
			</div>
		</div>
		<div class="section intro">
			<div class="container">
				<div class="general" >
					Giới thiệu chung
				</div>
			</div>
			<div class="intro-around">
				<div class=" around-text">
					<div class="content-brand" >
						<div class="brand-text ">
							<h3>Evo Milana</h3>
							<p>Được thành lập vào năm 2002 bởi một bộ đôi tín đồ thời trang, Evo Milana đã nhanh chóng trở thành một trong những công ty phân phối thời trang lớn nhất trong việc giới thiệu các thương hiệu thời trang cao cấp và sang trọng tại Việt Nam. Sau thành công ngoài mong đợi của cửa hàng đầu tiên, hiện Evo Milana đang là ngôi nhà chung của hơn 21 thương hiệu đình đám thế giới, thổi vào thị trường Việt Nam những giấc mơ thời trang bất tận.

							</p>
						</div>
					</div>
				</div>
				<div class="around-img" >
					<img src="/static/admin/images/img-gioithieu.jpg" class="img-fluid">
					<div class="border-solid"></div>
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
	<a id="back-to-top"><i class="fa fa-angle-up"></i></a>

</body>
</html>
