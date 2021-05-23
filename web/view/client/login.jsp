<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
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
                        <li class="active"> 
                            <a href="/view/client/login.jsp" title="Đăng nhập">Đăng nhập</a>
                        </li>

                        <li> 
                            <a href="/view/client/signup.jsp" title="Đăng ký">Đăng ký</a> 
                        </li> 
                    </ul>
                    <div class="evo-login">
                        <div class="login-form">

                            <form action="CheckLogin" method="post">
                                <div class="input-box">
                                    <i ></i>
                                    <input name="username" type="text" placeholder="Nhập email" required >
                                </div>
                                <div class="input-box">
                                    <i ></i>
                                    <input name="password" type="password" placeholder="Nhập mật khẩu" required >
                                </div>
                                <div class="btn-box">
                                    <button type="submit">
                                        Đăng nhập
                                    </button>
                                </div>



                                <%                                                        String se = (String) session.getAttribute("wrong");
                                    if (se != null) {
                                        out.print(se);
                                    }
                                    session.removeAttribute("wrong");
                                %>
                            </form>

                            <div class="btn-box">
                                <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
                                </fb:login-button>
                                <!--                                    <button type="submit" scope="public_profile,email" onlogin="checkLoginState();">
                                                                        Đăng nhập = face
                                                                    </button>-->
                            </div>

                            <div id="status">
                            </div>
                            <form action="signUpFaceBook" method="post">
                                <!--                                <div class="btn-box">
                                                                    <fb:login-button scope="public_profile,email" onlogin="checkLoginState();">
                                                                    </fb:login-button>
                                                                    <button type="submit" scope="public_profile,email" onlogin="checkLoginState();">
                                                                        Đăng nhập = face
                                                                    </button>
                                                                </div>-->
                                <div class="input-box">
                                    <i ></i>
                                    <input type="text" id="txtname" name="name" placeholder="Nhập Tên" style="display:none;">
                                    <input type="text" id="txtemail" name="email" placeholder="Nhập email" style="display:none;">

                                </div>
                                <div class="btn-box">
                                    <!--                                    <fb:login-button type="submit" scope="public_profile,email" onlogin="checkLoginState();">
                                                                        </fb:login-button>-->
                                    <button type="submit" >
                                        Tiếp tục
                                    </button>
                                </div>
                            </form>




                            <div class="wrong">
                                <a href="/view/client/forget.jsp">Quên mật khẩu !</a><br>
                            </div>

                        </div>
                    </div>
                </div>
            </div>

        </section>


        <%@include file="/view/client/footer.jsp"%>



        <script>
            // This is called with the results from from FB.getLoginStatus().
            function statusChangeCallback(response) {
                console.log('statusChangeCallback');
                console.log(response);
                // The response object is returned with a status field that lets the
                // app know the current login status of the person.
                // Full docs on the response object can be found in the documentation
                // for FB.getLoginStatus().
                if (response.status === 'connected') {
                    // Logged into your app and Facebook.
                    testAPI();
//                    myFunction();
                } else {
                    // The person is not logged into your app or we are unable to tell.
//                    document.getElementById('status').innerHTML = 'Please log ' +
//                            'into this app.';
                }
            }

            // This function is called when someone finishes with the Login
            // Button.  See the onlogin handler attached to it in the sample
            // code below.
            function checkLoginState() {
                FB.getLoginStatus(function (response) {
                    statusChangeCallback(response);
                });
            }

            window.fbAsyncInit = function () {
                FB.init({
                    appId: '377056780293601',
                    cookie: true, // enable cookies to allow the server to access 
                    // the session
                    xfbml: true, // parse social plugins on this page
                    version: 'v2.8' // use graph api version 2.8
                });

                // Now that we've initialized the JavaScript SDK, we call 
                // FB.getLoginStatus().  This function gets the state of the
                // person visiting this page and can return one of three states to
                // the callback you provide.  They can be:
                //
                // 1. Logged into your app ('connected')
                // 2. Logged into Facebook, but not your app ('not_authorized')
                // 3. Not logged into Facebook and can't tell if they are logged into
                //    your app or not.
                //
                // These three cases are handled in the callback function.

                FB.getLoginStatus(function (response) {
                    statusChangeCallback(response);
                });

            };

            // Load the SDK asynchronously
            (function (d, s, id) {
                var js, fjs = d.getElementsByTagName(s)[0];
                if (d.getElementById(id))
                    return;
                js = d.createElement(s);
                js.id = id;
                js.src = "https://connect.facebook.net/en_US/sdk.js";
                fjs.parentNode.insertBefore(js, fjs);
            }(document, 'script', 'facebook-jssdk'));

            // Here we run a very simple test of the Graph API after login is
            // successful.  See statusChangeCallback() for when this call is made.
            function testAPI() {
                console.log('Welcome!  Fetching your information.... ');
                FB.api('/me', {fields: ' name, email'}, function (response) {
                    console.log('Successful login for: ' + response.name);
                    document.getElementById('status').innerHTML =
                            'Tiếp tục với , ' + response.name + '!';
                    document.getElementById("txtname").value = response.name;
                    document.getElementById("txtemail").value = response.email;
                    //innerHTML

//                    alert(response.email);
                    var txt;
                    var person = prompt("Please enter your name:", response.name);
                    if (person == null || person == "") {
                        txt = "User cancelled the prompt.";
                    } else {
                        txt = "Hello " + person + "! How are you today?";
                    }
                    document.getElementById("demo").innerHTML = txt;
//                    var Confirm = new CustomConfirm();
                });
            }
            function myFunction() {
                var txt;
                var person = prompt("Please enter your name:", "Harry Potter");
                if (person == null || person == "") {
                    txt = "User cancelled the prompt.";
                } else {
                    txt = "Hello " + person + "! How are you today?";
                }
                document.getElementById("demo").innerHTML = txt;
            }
            function Warn() {
                alert("This is a warning message!");
                document.write("This is a warning message!");
            }
            onclick = "Warn();"

//            function CustomAlert() {
//                this.render = function (dialog) {
//                    var winW = window.innerWidth;
//                    var winH = window.innerHeight;
//                    var dialogoverlay = document.getElementById('dialogoverlay');
//                    var dialogbox = document.getElementById('dialogbox');
//                    dialogoverlay.style.display = "block";
//                    dialogoverlay.style.height = winH + "px";
//                    dialogbox.style.left = (winW / 2) - (550 * .5) + "px";
//                    dialogbox.style.top = "100px";
//                    dialogbox.style.display = "block";
////                    document.getElementById('dialogboxhead').innerHTML = "Acknowledge This Message";
////                    document.getElementById('dialogboxbody').innerHTML = dialog;
////                    document.getElementById('dialogboxfoot').innerHTML = '<button onclick="Alert.ok()">OK</button>';
//                }
//                this.ok = function () {
//                    document.getElementById('dialogbox').style.display = "none";
//                    document.getElementById('dialogoverlay').style.display = "none";
//                }
//            }
//            var Alert = new CustomAlert();
//            s
        </script>
    </body>
</html>
