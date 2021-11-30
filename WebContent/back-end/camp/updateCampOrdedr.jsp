<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>order</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">
<link rel="stylesheet" href="css\camCompany.css">
</head>
<body>
	<header class="header-outer">
		<div class="header-inner responsive-wrapper">
			<div class="header-logo">
				<a style="display: inline-block; vertical-align: middle;"
					href="首頁URL"> <img src="images\camp_paradise_logo.png" />
				</a> <span style="display: inline-block; vertical-align: middle;">Camping
					Paradise</span>
			</div>
			<nav class="header-navigation">
				<a href="#">Home</a> <a href="#">線上商城</a> <a href="#"><img
					src="images\heart.png"></a> <a href="#">註冊</a> <a href="#">登入</a>
				<a href="#"> <i class="fas fa-user"></i></a>
				<button>Menu</button>
			</nav>
		</div>
	</header>


	<!-- --------main區域------- -->
	<div class="divSearchForm">
		<form class="searchForm" action="/action_page.php"
			style="margin: auto; max-width: 300px">
			<input type="text" placeholder="Search.." name="search2">
			<button type="submit">
			<i class="fa fa-search"></i>
			</button>
			<div style="clear: both;"></div>
		</form>
	</div>
	<table id="table-1">
		<FORM METHOD="post" ACTION="camp.do" name="form1">
			<table>
			<tr>
				<th>日期</th>
				<th>訂單流水號</th>
				<th>付款人</th>
				<td><input type="TEXT" name="payer_name"  
			 	value="" /></td><td></td>
			 
				<th>連絡電話</th>
				<td><input type="String" name="payer_phone" 
			 	value="" /></td><td></td>
				
				<th>訂單總金額</th>
				<td><input type="String" name="camp_order_total_amount" 
			 	value="" /></td><td></td>			
				<th>訂單狀態 <select>
						<optgroup label="訂單狀態">
						</optgroup>
						<td><input type="String" name="camp_order_status" 
			 			value="" /></td><td></td>
				</select></th>
				
				<th>評價</th>
				<th colspan="1">編輯</th>
				<td><input type="Text" name="camp_comment" 
			 	    value="" /></td><td></td>
	         	<th></th>	        
			</tr>
		</thead>
			<br>
				<input type="hidden" name="action" value="insert">
				<input type="submit" value="送出新增"></FORM>
				
					
			<!--aside-->
			<aside class="aside">
				<div class="container">
					<nav>
						<ul class="mcd-menu">
							<li><a href="" class="light"> <i
									class="fa fa-campground"></i> <strong>營地管理</strong> <small>Camp
										Management</small>
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

			<footer class="tm-footer text-center">
				<pre>服務專線：(02)2252-7966　　 客服時間：週一至週五9:00~18:00　　 客服信箱：camp@easycamp.com.tw</pre>
				<pre>Copyright &copy; 2021 Camping Paradise | Design: <a
						style="text-decoration: none;" rel="nofollow" href="#">TFA104第五組</a>
				</pre>
			</footer>
</body>
</html>