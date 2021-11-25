<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.cart.model.CartVO"%>
<%@ page import="com.company.model.CompanyDAOImpl"%>


<!DOCTYPE html>
<html lang="zh-Hant">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>購物車step1</title>
<!-- header&footer CSS -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"
	integrity="sha384-DyZ88mC6Up2uqS4h/KRgHuoeGwBcD4Ng9SiP4dIRy0EXTlnuz47vAwmeGwVChigm"
	crossorigin="anonymous">

<!-- 我自己加的CSS -->
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/front_end/mall/css/shoppingCart.css">
</head>

<body>
	<!-- header-start -->
	<header class="header-outer" style="width: 100%;">
		<div class="header-inner responsive-wrapper">
			<div class="header-logo">
				<a style="display: inline-block; vertical-align: middle;"
					href="首頁URL"> <img
					src="<%=request.getContextPath()%>/front_end/mall/images/camp_paradise_logo.png" />
				</a> <span style="display: inline-block; vertical-align: middle;">Camping
					Paradise</span>
			</div>
			<nav class="header-navigation">
				<a href="#">Home</a> <a href="#">線上商城</a> <a href="#"><img
					src="<%=request.getContextPath()%>/front_end/mall/images/heart.png"></a>
				<a href="#"><i style="color: white; font-size: 23px;"
					class="fas fa-shopping-cart"></i></a> <a href="#">註冊</a> <a href="#">登入</a>
				<a href="#"> <i class="fas fa-user"></i></a>

				<!-- fas fa-user-circle
    
                fas fa-user-circle
                 -->
				<button>Menu</button>
			</nav>
		</div>
	</header>
	<!-- header-end -->
	<div style="text-align: center;">
		<h2>
			<span
				style="color: white; background-color: #dbb07c; border-radius: 20px; padding: 3px 10px;">1.確認商品</span>
			>> 2.資料填寫 >> 3.資料確認 >> 4.訂單成立
		</h2>
	</div>

	<div class="shopping-cart" style="padding: 50px 30px 50px 30px;">

		<%
			List<CartVO> buyList = new ArrayList<CartVO>();

			CartVO cartvo1 = new CartVO(1, 1, 1, "酷炫帳篷1", 1000, 1);
			CartVO cartvo2 = new CartVO(2, 2, 1, "酷炫帳篷2", 2000, 2);
			CartVO cartvo3 = new CartVO(2, 3, 1, "酷炫帳篷3", 3000, 4);

			buyList.add(cartvo1);
			buyList.add(cartvo2);
			buyList.add(cartvo3);

			session.setAttribute("buyList", buyList);
			if (session.getAttribute("buyList") != null) {

				List<CartVO> cart = (List<CartVO>) session.getAttribute("buyList");

				Set<Integer> companySet = new TreeSet<Integer>();
				for (CartVO c : cart) {
					companySet.add(c.getCompanyId());
				}

				request.setAttribute("companySet", companySet);
			}
		%>

		<jsp:useBean id="companyDAOImpl"
			class="com.company.model.CompanyDAOImpl"></jsp:useBean>

		<form action="<%=request.getContextPath()%>/Cart/CartServlet"
			method="post">

			<c:forEach var="oneOrder" items="${ companySet }">






				<!-- 一個訂單start -->
				<div class="oneOrder">
					<h1 style="margin-bottom: 10px;">${companyDAOImpl.findByPK(oneOrder).companyName}</h1>

					<div class="column-labels">
						<label class="product-image">Image</label> <label
							class="product-details">Product</label> <label
							class="product-price" style="color: black; font-weight: bold;">單價</label>
						<label class="product-quantity"
							style="color: black; font-weight: bold;">數量</label> <label
							class="product-removal" style="color: black; font-weight: bold;">移除</label>
						<label class="product-line-price"
							style="color: black; font-weight: bold;">總計</label>
					</div>

					<c:forEach var="oneProduct" items="${ buyList }">

						<c:if test="${oneOrder == oneProduct.companyId}">
							<!-- 一個商品項start -->
							<div class="product">
								<div class="product-image">
									<img
										src="<%=request.getContextPath()%>/product/PicServlet?productId=${oneProduct.productId}&pic=1">
								</div>
								<div class="product-details">
									<div style="width: 85%; font-weight: bold;"
										class="product-title">
										<a
											href="product_detail.html?productId=${oneProduct.productId}&productTypeId=${oneProduct.productTypeId}"
											style="text-decoration: none;">${oneProduct.productName}</a>
									</div>
									<p class="product-description"></p>
								</div>
								<div class="product-price">${oneProduct.productPrice}</div>
								<div class="product-quantity">
									<input type="number" name="productPurchaseQuantity"
										value="${oneProduct.productPurchaseQuantity}" min="1">
								</div>
								<div class="product-removal">
									<button class="remove-product">移除</button>
								</div>
								<div class="product-line-price">${oneProduct.productPurchaseQuantity * oneProduct.productPrice}</div>

								<input type="hidden" name="companyId"
									value="${oneProduct.companyId}"> <input type="hidden"
									name="productId" value="${oneProduct.productId}"> <input
									type="hidden" name="productTypeId"
									value="${oneProduct.productTypeId}"> <input
									type="hidden" name="productName"
									value="${oneProduct.productName}"> <input type="hidden"
									name="productPrice" value="${oneProduct.productPrice}">

							</div>
							<!-- 一個商品項end -->

						</c:if>

					</c:forEach>

					<div style="padding-bottom: 50px;" class="totals">
						<div class="totals-item">
							<label style="font-weight: bold; color: black;">訂單金額</label>
							<div class="totals-value">0</div>
						</div>
					</div>
				</div>
				<!-- 一個訂單end -->

			</c:forEach>

			<!-- 總金額 -->

			<div class="totals">
				<div class="totals-item totals-item-total">
					<label style="font-weight: bold; color: black;">訂單總金額</label>
					<div class="totals-value" id="cart-total">0</div>
				</div>
			</div>

			<%-- 錯誤表列 --%>
			<c:if test="${not empty errorMsgs}">
				<font style="color: red">請修正以下錯誤:</font>
				<ul>
					<c:forEach var="message" items="${errorMsgs}">
						<li style="color: red">${message}</li>
					</c:forEach>
				</ul>
			</c:if>


			<input type="hidden" name="action" value="update"> <input
				type="submit" class="checkout" value="下一步">
		</form>

	</div>


	<!-- footer-start -->
	<footer class="tm-footer text-center">
		<pre>服務專線：(02)2252-7966　　 客服時間：週一至週五9:00~18:00　　 客服信箱：camp@easycamp.com.tw</pre>
		<pre>Copyright &copy; 2021 Camping Paradise | Design: <a
				style="text-decoration: none;" rel="nofollow" href="#">TFA104第五組</a>
		</pre>
	</footer>
	<!-- footer-end -->

	<script
		src="<%=request.getContextPath()%>/front_end/mall/vendors_shoppingCart/jquery/jquery-3.6.0.min.js"></script>

	<script
		src="<%=request.getContextPath()%>/front_end/mall/js/shoppingCart.js"></script>
</body>

</html>