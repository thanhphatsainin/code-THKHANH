<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>Signup</title>
	<link rel="stylesheet" type="text/css" href="/static/admin/css/styless.css">
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1">
	<script src="js/customerz.js"></script>
	<link href="/your-path-to-fontawesome/css/fontawesome.css" rel="stylesheet">
	<link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
</head>
<body>
	<%@include file="/view/client/header.jsp"%>
	<section class="login-view">
		<div class="login-acount">
			<div class="banner-login">
				<div class="account_policy_title">Quyền lợi thành viên</div>
				<div class="account_policy_content">
					<p><i class="fa fa-check-circle-o" aria-hidden="true"></i>Mua hàng khắp thế giới cực dễ dàng, nhanh chóng</p> 
					<p><i class="fa fa-check-circle-o" aria-hidden="true"></i>Theo dõi chi tiết đơn hàng, địa chỉ thanh toán dễ dàng</p> 
					<p><i class="fa fa-check-circle-o" aria-hidden="true"></i>Nhận nhiều chương trình ưu đãi hấp dẫn từ chúng tôi</p>
				</div>
			</div>
			<div class="evo-acount">
				<ul class="auth-block__menu-list"> 
					<li > 
						<a href="/view/client/login.jsp" title="Đăng nhập">Đăng nhập</a>
					</li>
					<li class="active"> 
						<a href="/view/client/signup.jsp" title="Đăng ký">Đăng ký</a> 
					</li> 
				</ul>
				<div class="evo-login">
					<div class="login-form">
						<form action="" method="post">
							<div class="input-box">
								<i ></i>
								<input type="text" placeholder="Nhập Họ">
							</div>
							<div class="input-box">
								<i ></i>
								<input type="text" placeholder="Nhập Tên">
							</div>
							<div class="input-box">
								<i ></i>
								<input type="text" placeholder="Nhập Số điện thoại">
							</div>
							<div class="input-box">
								<i ></i>
								<input type="text" placeholder="Nhập email">
							</div>
							<div class="input-box">
								<i ></i>
								<input type="password" placeholder="Nhập mật khẩu">
							</div>
							<div class="btn-box">
								<button type="submit">
									Đăng Ký
								</button>
							</div>
						</form>						
					</div>
				</div>
			</div>
		</div>
		
	</section>

	
	<%@include file="/view/client/footer.jsp"%>

</body>
</html>
