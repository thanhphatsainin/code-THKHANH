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
        
        <script>  

    function dangnhap(){

        var pass1 = document.getElementById("password");
        var repass1 = document.getElementById("passwordRepeat");

        if(name1!=null){

            var ps = pass1.value;
            var rp = repass1.value;
            
            if (ps != rp){
                alert('Moi ban nhap dung lai mat khau');
            }
            else{
        		alert('DK thanh cong');
        	}
        }
    }
        
	</script>
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
						<form action="editPasswordAction" method="post">
							<div class="input-box">
								<i ></i>
								<input type="text" name="id" value = "${userUpdate.id}" readonly="true">
							</div>
							<div class="input-box">
								<i ></i>
								<input type="text" name="name" value = "${userUpdate.name}" readonly="true">
							</div
                                                        <div class="input-box">
								<i ></i>
								<input type="text" name="email" value = "${userUpdate.email}" readonly="true">
							</div>
							<div class="input-box">
								<i ></i>
								<input type="text" name="address" value = "${userUpdate.address}" readonly="true">
							</div>
							<div class="input-box">
								<i ></i>
								<input type="text" name="position" value = "${userUpdate.position}" readonly="true">
							</div>
                                                        <div class="input-box">
								<i ></i>
								<input type="text" name="username" value = "${userUpdate.username}" readonly="true">
							</div>
							<div class="input-box">
								<i ></i>
								<input type="password" name="password" placeholder="Nhập mật khẩu mới" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
     title="Must contain at least one  number and one uppercase and lowercase letter, and at least 8 or more characters">
							</div>
                                                        <div class="input-box">
								<i ></i>
								<input type="password" name="passwordRepeat" placeholder="Nhập lại mật khẩu mới" required pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}"
     title="Must contain at least one  number and one uppercase and lowercase letter, and at least 8 or more characters">
							</div>
							<div class="btn-box">
								<button type="submit" onclick="dangnhap()">
									Lưu
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
