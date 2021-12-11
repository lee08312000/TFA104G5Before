<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="com.campArea.model.*"%>
<!DOCTYPE html>
<%@ page import="java.util.*"%>



<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>CampCerticatenum</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/back-end/css/insertCampCertificatenum.css">
</head>
<body>
	<!-- --------head區域------- -->
	<header class="header-outer">
		<div class="header-inner responsive-wrapper">
			<div class="header-logo">
				<a style="display: inline-block; vertical-align: middle;"
					href="首頁URL"> <img
					src="<%=request.getContextPath()%>/back-end/images/camp_paradise_logo.png" />
				</a> <span style="display: inline-block; vertical-align: middle;">Camping
					Paradise</span>
			</div>
			<nav class="header-navigation">
				<a href="#">Home</a> <a href="#">線上商城</a> <a href="#"><img
					src="<%=request.getContextPath()%>/back-end/images/heart.png"></a>
				<a href="#">註冊</a> <a href="#">登入</a> <a href="#"> <i
					class="fas fa-user"></i></a>
				<button>Menu</button>
			</nav>
		</div>
	</header>

	<!-- --------main區域------- -->

	<h1>營地上架審核</h1>
	<h2>${errorMsgs}</h2>
	<form method="post"
		ACTION="<%=request.getContextPath()%>/camp/shelves.do">
		<table class="camp_table">
		
		    <tr>
       			<td><label>廠商流水號:</label></td>
			    <td>${company_id}</td>
			</tr>
	
			<tr>
				<td><label>廠商名稱:</label></td>				
				<td>${company_name}</td>
			</tr>

			<tr>
				<td><label>負責人姓名:</label></td>
				<td><input type="text" id="head_name" name="head_name"></td>
			</tr>
			
			<tr>
				<td><label>廠商電話:</label></td>
				<td><input type="text" id="company_tel"name="company_tel"></td>
			</tr>
			

			<tr>
				<td><label>營地名稱:</label></td>
				<td><input type="text" id="camp_nme"name="comp_name"></td>
			</tr>
			
			<tr>
				<td><label>廠商地址:</label></td>
				<td>${company_address}</td>
			</tr>
		

			<tr>
				<td><label>認證字號:</label></td>
				<td><input type="text" id="certificate_num"name="certificate_num"></td>
			</tr>

			<tr>
				<td><label>證書圖片:</label></td>
				<td><div class="upload_certificate_pic">
						<input id="upload" type="file" accept="image/*"
							multiple="multiple">
						<button class="btn" style="margin-right: 10px">點擊上傳</button>
					</div>
					<div class="img-box">
						<!-- 存放預覽圖片 -->
					</div></td>
			</tr>

			<tr>

				<td colspan="2"><input type="hidden" name="action"
					value="INSERT" /> <input type="submit" value="確認新增"
					style="margin-left: 250px;"> <input type="submit"
					value="取消"></td>
			</tr>

		</table>
	</form>

	<div class="pagination">
		<a href="#">&laquo;</a> <a href="#">1</a> <a href="#" class="active">2</a>
		<a href="#">3</a><a href="#">&raquo;</a>
	</div>















	<!-- --------aside區域------- -->
	<div id="sidebar">
		<aside class="aside">
			<div class="container">
				<nav>
					<ul class="mcd-menu">
						<li><a href="" class="light"> <i class="fa fa-campground"></i>
								<strong>營地管理</strong> <small>Camp Management</small>
						</a>
							<ul>
								<li><a href="#"><i class="fas fa-cannabis"></i>我的營地</a></li>
								<li><a href="#"><i class="fas fa-cannabis"></i>營地上下架</a></li>
								<li><a href="#"><i class="fas fa-cannabis"></i>審核狀況</a></li>
							</ul></li>
						<li><a href="" class="light"> <i class="fa fa-edit"></i>
								<strong>商品管理</strong> <small>Commodity </small>
						</a></li>
						<li><a href="" class="light"> <i class="fa fa-gift"></i>
								<strong>訂單管理</strong> <small>Order </small>
						</a>
							<ul>
								<li><a href="#"><i class="fas fa-cannabis"></i>日程表管理</a></li>
								<li><a href="#"><i class="fas fa-cannabis"></i>營地訂單管理</a></li>
								<li><a href="#"><i class="fas fa-cannabis"></i>商城訂單管理</a></li>
							</ul></li>
						<li><a href="" class="light"> <i
								class="fas fa-calendar-week"></i> <strong>廠商資料</strong> <small>Vendor
									Information</small>
						</a>
							<ul>
								<li><a href="#"><i class="fas fa-cannabis"></i>基本資料瀏覽,修改</a></li>
								<li><a href="#"><i class="fas fa-cannabis"></i>更改密碼</a></li>
							</ul></li>
						<li><a href="" class="light"> <i
								class="fa fa-comment-alt"></i> <strong>我的評論</strong> <small>Comment</small>
						</a>
							<ul>
								<li><a href="#"><i class="fas fa-cannabis"></i>營地評價</a></li>
								<li><a href="#"><i class="fas fa-cannabis"></i>商品評價</a></li>
							</ul></li>
					</ul>
				</nav>
			</div>
		</aside>
	</div>



	<footer class="tm-footer text-center">
		<pre>服務專線：(02)2252-7966　　 客服時間：週一至週五9:00~18:00　　 客服信箱：camp@easycamp.com.tw</pre>
		<pre>Copyright &copy; 2021 Camping Paradise | Design: <a
				style="text-decoration: none;" rel="nofollow" href="#">TFA104第五組</a>
				</pre>
	</footer>
</body>
</html>

















