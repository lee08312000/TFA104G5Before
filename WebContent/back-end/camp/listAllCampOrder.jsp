<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.campOrder.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet" href="../css/colorbox.css" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script src="../js/jquery.colorbox.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	//到新增指令集Page
	$("#testBtn").click(function() {
		//var campOrderId = $("input#campOrderId").val();
		var campOrderId = 12;
		param = {
			data : {
				"action":"GETONECAMP",
				"campOrderId" : campOrderId
			},
			title : "新增指令集",
			href : '<c:url value="/camp/campOrder.do" />',
			innerHeight : 350,
			innerWidth : 650,
			opacity : 0.5,
			top : 100
		};
		$.colorbox(param);
	});
});
</script>

<title>order</title>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">
<link rel="stylesheet" href="..\css\campOrder.css">
</head>
<body>

	<header class="header-outer">
		<div class="header-inner responsive-wrapper">
			<div class="header-logo">
				<a style="display: inline-block; vertical-align: middle;"
					href="首頁URL"> <img src="..\images\camp_paradise_logo.png" />
				</a> <span style="display: inline-block; vertical-align: middle;">Camping
					Paradise</span>
			</div>
			<nav class="header-navigation">
				<a href="#">Home</a> <a href="#">線上商城</a> <a href="#"><img
					src="..\images\heart.png"></a> <a href="#">註冊</a> <a href="#">登入</a>
				<a href="#"> <i class="fas fa-user"></i></a>
				<button>Menu</button>
			</nav>
		</div>
	</header>

<div id="bodyCenter">
	<!-- --------main區域------- -->
	<h2>營地訂單查詢</h2>

	<div class="divSearchForm">
		<form class="searchForm" action="/action_page.php"
			style="margin: auto; max-width: 300px">
			<select class="selector">
				<option>全部</option>
				<option>依日期排序</option>
				<option>已處理</option>
				<option>處理中</option>
				<option>已取消</option>
			</select> <input type="text" placeholder="請輸入關鍵字" name="search2">
			<button type="submit">
				<i class="fa fa-search"></i>
			</button>
			<div style="clear: both;"></div>
		</form>
		
    <input type="button" value="open the box" id="testBtn"/>
    
	</div>
	<table>
		<thead>
			<tr>
				<th>日期</th>
				<th>訂單流水號</th>
				<th>付款人</th>
				<th>連絡電話</th>
				<th>訂單總金額</th>
				<th>訂單狀態</th>
				<th>評價</th>
				<th>編輯</th>


			</tr>
		</thead>


		<tbody>

			<tr>
				<!-- <td>第二列</td> -->
				<td>10/04</td>
				<td>02</td>
				<td>蔡桃貴</td>
				<td>0988565372</td>
				<td>$2000</td>
				<td>已處理</td>
				<td>5分</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/camp/camp.Select">
						<input type="submit" value="修改"> <input type="hidden"
							name="camp" value="${campVO.camp}"> <input type="hidden"
							name="action" value="getOne_For_Update">
					</FORM>
				</td>

			</tr>

			<tr>
				<!-- <td>第三列</td> -->
				<td>10/10</td>
				<td>03</td>
				<td>蔡桃貴</td>
				<td>0988565372</td>
				<td>$2000</td>
				<td>已處理</td>
				<td>5分</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/camp/camp.Select">
						<input type="submit" value="修改"> <input type="hidden"
							name="camp" value="${campVO.camp}"> <input type="hidden"
							name="action" value="getOne_For_Update">
					</FORM>
				</td>
			<tr>
				<!-- <td>第四列</td> -->
				<td>10/20</td>
				<td>04</td>
				<td>蔡桃貴</td>
				<td>0988565372</td>
				<td>$200</td>
				<td>已處理</td>
				<td>5分</td>

				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/camp/camp.Select">
						<input type="submit" value="修改"> <input type="hidden"
							name="camp" value="${campVO.camp}"> <input type="hidden"
							name="action" value="getOne_For_Update">
					</FORM>
				</td>

			</tr>

			<tr>
				<!-- <td>第五列</td> -->
				<td>10/20</td>
				<td>04</td>
				<td>蔡桃貴</td>
				<td>0988565372</td>
				<td>$200</td>
				<td>已處理</td>
				<td>5分</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/camp/camp.Select">
						<input type="submit" value="修改"> <input type="hidden"
							name="camp" value="${campVO.camp}"> <input type="hidden"
							name="action" value="getOne_For_Update">
					</FORM>
				</td>
			<tr>
				<!-- <td>第六列</td> -->
				<td>10/20</td>
				<td>04</td>
				<td>蔡桃貴</td>
				<td>0988565372</td>
				<td>$200</td>
				<td>已處理</td>
				<td>5分</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/camp/camp.Select">
						<input type="submit" value="修改"> <input type="hidden"
							name="camp" value="${campVO.camp}"> <input type="hidden"
							name="action" value="getOne_For_Update">
					</FORM>
				</td>
			<tr>
				<!-- <td>第七列</td> -->
				<td>10/20</td>
				<td>04</td>
				<td>蔡桃貴</td>
				<td>0988565372</td>
				<td>$200</td>
				<td>已處理</td>
				<td>5分</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/camp/camp.Select">
						<input type="submit" value="修改"> <input type="hidden"
							name="camp" value="${campVO.camp}"> <input type="hidden"
							name="action" value="getOne_For_Update">
					</FORM>
				</td>
			<tr>
				<!-- <td>第八列</td> -->
				<td>10/20</td>
				<td>04</td>
				<td>蔡桃貴</td>
				<td>0988565372</td>
				<td>$200</td>
				<td>已處理</td>
				<td>5分</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/camp/camp.Select">
						<input type="submit" value="修改"> <input type="hidden"
							name="camp" value="${campVO.camp}"> <input type="hidden"
							name="action" value="getOne_For_Update">
					</FORM>
				</td>
			<tr>
				<!-- <td>第九列</td> -->
				<td>10/20</td>
				<td>04</td>
				<td>蔡桃貴</td>
				<td>0988565372</td>
				<td>$200</td>
				<td>已處理</td>
				<td>5分</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/camp/camp.Select">
						<input type="submit" value="修改"> <input type="hidden"
							name="camp" value="${campVO.camp}"> <input type="hidden"
							name="action" value="getOne_For_Update">
					</FORM>
				</td>
			<tr>
				<!-- <td>第十列</td> -->
				<td>10/20</td>
				<td>04</td>
				<td>蔡桃貴</td>
				<td>0988565372</td>
				<td>$200</td>
				<td>已處理</td>
				<td>5分</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/camp/camp.Select">
						<input type="submit" value="修改"> <input type="hidden"
							name="camp" value="${campVO.camp}"> <input type="hidden"
							name="action" value="getOne_For_Update">
					</FORM>
				</td>
			<tr>
				<!-- <td>第十一列</td> -->
				<td>10/20</td>
				<td>04</td>
				<td>蔡桃貴</td>
				<td>0988565372</td>
				<td>$200</td>
				<td>已處理</td>
				<td>5分</td>
				<td>
					<FORM METHOD="post"
						ACTION="<%=request.getContextPath()%>/camp/camp.Select">
						<input type="submit" value="修改"> <input type="hidden"
							name="camp" value="${campVO.camp}"> <input type="hidden"
							name="action" value="getOne_For_Update">
					</FORM>
				</td>
		</tbody>
	</table>
	<div class="pagination">

		<a href="#">&laquo;</a> <a href="#">1</a> <a href="#" class="active">2</a>
		<a href="#">3</a> <a href="#">4</a> <a href="#">5</a> <a href="#">6</a>
		<a href="#">&raquo;</a>
	</div>
</div>
	<!-- ----------------aside區域------------------->
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
					<li><a href="" class="light"> <i class="fa fa-edit"></i> <strong>商品管理</strong>
							<small>Commodity </small>
					</a></li>
					<li><a href="" class="light"> <i class="fa fa-gift"></i> <strong>訂單管理</strong>
							<small>Order </small>
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
					<li><a href="" class="light"> <i class="fa fa-comment-alt"></i>
							<strong>我的評論</strong> <small>Comment</small>
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