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