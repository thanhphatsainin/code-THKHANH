<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<div class="header-top">
    <div class="container">
        <div class="top-info">
            <div class="float-left d-md-block d-sm-none d-none">
                <ul>
                    <li><i class="fas fa-map-marker-alt"></i>  30 Đường 2/9, Phường Bình Hiên, Quận Hải Châu, Đà Nẵng</li>
                </ul>
            </div>
            <div class="pull-right">
                <ul>
                    <li><a href="/view/client/login.jsp">Đăng nhập</a></li>
                    <li><a href="/view/client/signup.jsp">Đăng ký</a></li>
                </ul>
            </div>
        </div>
    </div>
</div>
<header class="header clearfix relative">
    <div class="header__header">
        <div class="container">
            <div class="row">
                <div class="menu-icon hidden-md hidden-lg">
                    <div class="menu-open menu-default-open">
                        <i class="fa fa-bars"></i>
                    </div>
                </div>
                <h1 class="logo col-md-2 col-sm-2 col-xs-6 col-xs-push-3 col-sm-push-0">

                    <a href="index.html" title="Mua Yến Sào">
                        <c:forEach items="${listLogo}" var="logo" >
                            <img src="/static/admin/images/${ logo.image}" class="img-responsive center-block" width="160" height="auto">
                        </c:forEach>

                    </a>
                </h1>
                <div class="col-xs-12 col-sm-6 col-md-6">
                    <div class="menu">
                        <nav class="menu-primary visible-lg visible-md">
                            <ul>
                                <li class="main-menu-item current-menu-item current_page_item menu-item-home"><a href="/listAll" class="">Trang chủ</a></li>
                                <li class="main-menu-item menu-item-has-children"><a href="/view/client/gioithieu.jsp">Giới thiệu</a></li>
                                <li class="main-menu-item menu-item-has-children"><a>Sản phẩm</a>
                                    <ul class="sub-menu">
                                        <li class="sub-menu-item"><a class="menu-link sub-menu-link">Trang phục</a></li>
                                        <li class="sub-menu-item"><a class="menu-link sub-menu-link">Giày dép</a></li>
                                        <li class="sub-menu-item"><a class="menu-link sub-menu-link">Túi ví</a></li>
                                        <li class="sub-menu-item"><a class="menu-link sub-menu-link">Phụ kiện</a></li>
                                    </ul>
                                </li>
                                <li class="main-menu-item menu-item-has-children"><a href="" class="">Bộ sưu tập</a>
                                    <ul class="sub-menu ">
                                        <li><a href="/view/client/danhmuc.jsp">Summer 2020</a></li>
                                        <li><a>A Pretty Comback</a></li>
                                    </ul>
                                </li>
                                <li class="main-menu-item menu-item-has-children"><a href="/listLienHe">Liên hệ</a></li>
                            </ul>
                        </nav>						
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="header__cart d-md-block d-lg-block d-none">
                        <a href="/view/client/giohang.jsp" title="Giỏ hàng ">
                            <i class="fa fa-cart-plus"></i>
                            <span class="total-cart">0</span>
                        </a>
                    </div>
                    <div class="header__search hidden-xs hidden-sm">
                        <a href="">
                            <i class="fa fa-search" aria-hidden="true"></i>
                        </a>

                        <form class="search-form" method="get" id="searchform" action="">
                            <div class="form-group">
                                <div class="input-group">
                                    <input class="form-control" type="text" value="Tìm kiếm" >
                                    <div class="input-group-btn">
                                        <button class="btn buttom-search" type="submit"></button>
                                    </div>
                                </div>
                            </div>
                        </form>						
                    </div>
                </div>
            </div>

        </div>
    </div>
</header>
