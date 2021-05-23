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
</head>
<body>
	<%@include file="/view/client/header.jsp"%>
	<section class="page-contacts">
		<div class="container"> 
			<div class="row"> 
				<div class="col-xs-12 col-sm-12 col-md-12"> 
					<div class="leave-your-message"> 
						<div class="general-add">
							Evo Milana
						</div>
						<p>Được thành lập vào năm 2002 bởi một bộ đôi tín đồ thời trang, Evo Milana đã nhanh chóng trở thành một trong những công ty phân phối thời trang lớn nhất trong việc giới thiệu các thương hiệu thời trang cao cấp và sang trọng tại Việt Nam. Sau thành công ngoài mong đợi của cửa hàng đầu tiên, hiện Evo Milana đang là ngôi nhà chung của hơn 21 thương hiệu đình đám thế giới, thổi vào thị trường Việt Nam những giấc mơ thời trang bất tận.</p>
					</div>
				</div> 
			</div> 
		</div>

		<div class="map-add">
			<div class="general-add">
				Địa chỉ của chúng tôi
			</div>
			<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3787.318525813272!2d105.90008867007131!3d18.332747296861054!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x31384e3cc399f40f%3A0x7566b8d1a07a1a79!2zTmFtIEjDoCwgVHAuIEjDoCBUxKluaCwgSMOgIFTEqW5oLCBWaeG7h3QgTmFt!5e0!3m2!1svi!2s!4v1589594253513!5m2!1svi!2s" width="100%" height="450" frameborder="0" style="border:0;" allowfullscreen="" aria-hidden="false" tabindex="0"></iframe>
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
