<%-- 
    Document   : index
    Created on : Nov 6, 2020, 10:24:34 AM
    Author     : QuangPro99
--%>

<%@page import="entities.toy"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <style>
    .container {
	min-height: 100vh;
	width: 100%;
	display: flex;
	align-items: center;
	justify-content: center;
    }
    *{
	box-sizing: border-box;
        float: left;
        margin: 0 auto;
    }
    

    .outer {
        border-radius: 20px;
	position: relative;
	background: #fff;
	height: 410px;
	width: 306px;
	overflow: hidden;
	display: flex;
	align-items: center;
        box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
        margin: 30px;
    }

    .content {
	animation-delay: 0.3s;
	position: absolute;
	left: 20px;
	z-index: 3
	
    }

    h1 {
	color: #111;
    }

    p {
	width: 280px;
	font-size: 13px;
	line-height: 1.4;
	color: #aaa;
	margin: 20px 0;
	
    }

    .bg {
	display: inline-block;
	color: #fff;
	background: cornflowerblue;
	padding: 5px 10px;
	border-radius: 50px;
	font-size: .7em;
    }
    .button {
	width: fit-content;
	height: fit-content;
	margin-top: 10px;
	
	
	
    }

    .button a {
	display: inline-block;
	overflow: hidden;
	position: relative;
	font-size: 11px;
	color: #111;
	text-decoration: none;
	padding: 10px 15px;
	border: 1px solid #aaa;
	font-weight: bold;
	
	
    }
    img{
        width: 100px;
        height: 100px;
    }

    .button a:after{
	content: "";
	position: absolute;
	top: 0;
	right: -10px;
	width: 0%;
	background: #111;
	height: 100%;
	z-index: -1;
	transition: width 0.3s ease-in-out;
	transform: skew(-25deg);
	transform-origin: right;
    }

    .button a:hover:after {
	width: 150%;
	left: -10px;
	transform-origin: left;
	
    }

    .button a:hover {
	color: #fff;
	transition: all 0.5s ease;
    }


    .button a:nth-of-type(1) {
	border-radius: 50px 0 0 50px;
	border-right: none;
    }

    .button a:nth-of-type(2) {
	border-radius: 0px 50px 50px 0;
    }

    .cart-icon {
	padding-right: 8px;
	
    }
    

    </style>
</head>
<body>
    <!-- Header -->
  <section id="header">
    <div class="header container">
      <div class="nav-bar">
        <div class="brand">
          <a href="#hero"><h1><span>T</span>oy <span>S</span>tore</h1></a>
        </div>
        <!--Search-->
        <form method="post" action="Search">
            <div class="box">
                <input type="text" placeholder="Search here" name="pid" id="pid">
                <button type="submit" name="submit" value="Search"><i class="fas fa-search"></i></button>
            </div>
            
        </form>
        <div class="nav-list">
          <div class="hamburger"><div class="bar"></div></div>
          <ul>
            <li><a href="#hero" data-after="Home">Home</a></li>
            <li><a href="#services" data-after="Service">Services</a></li>
            <li><a href="#projects" data-after="Projects">Projects</a></li>
            <li><a href="#about" data-after="About">About</a></li>
            <li><a href="#contact" data-after="Contact">Contact</a></li>
          </ul>
        </div>
      </div>
    </div>
  </section>
  <!-- End Header -->
            <%
                int count = 0;
                String color = "#F9EBB3";
                if (request.getAttribute("piList") != null) {
                    //ArrayList<toy> al = request.getAttribute("piList");
                    ArrayList al = (ArrayList) request.getAttribute("piList");
                    System.out.println(al);
                    Iterator itr = al.iterator();
                    while (itr.hasNext()) {
 
                        if ((count % 2) == 0) {
                            color = "#eeffee";
                        }
                        count++;
                        ArrayList pList = (ArrayList) itr.next();
            %>

                <div class="outer">
                    <div class="content animated fadeInLeft">
                        <img src="img/<%=pList.get(6)%>">
			<h1><%=pList.get(1)%></h1>
			<p><%=pList.get(3)%></p>
			
			<div class="button">
                            <a href="#"><%=pList.get(2)%></a><a class="cart-btn" href="#"><i class="cart-icon ion-bag"></i>ADD TO CART</a>
			</div>
                    </div>
                </div> 

            <%
                    }
                }
                if (count == 0) {
            %>
            <tr>
                <td colspan=6 align="center"
                    style="background-color:#eeffee"><b>No Record Found..</b></td>
            </tr>
            <%            }
            %>

  </body>
</html>