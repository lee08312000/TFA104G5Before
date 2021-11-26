$(function () {
    // 右邊商品加入我的最愛及購物車
    $(document).on("click", "i.addRightFavoriteProduct", function () {
      // 檢查是否有登入
      //頁面導向
      // location.href = "https://www.google.com.tw";
      alert("right成功加入我的最愛");
    });
    $(document).on("click", "i.addRightShoppingCart", function () {
      // 檢查是否有登入
      //頁面導向
      // location.href = "https://www.google.com.tw";
      alert("right成功加入購物車");
    });

    // 相關商品加入我的最愛及購物車
    $(document).on("click", "i.addFavoriteProduct", function () {
      // 檢查是否有登入
      //頁面導向
      // location.href = "https://www.google.com.tw";
      alert("成功加入我的最愛");
    });

    $(document).on("click", "i.addShoppingCart", function () {
      // 檢查是否有登入
      //頁面導向
      // location.href = "https://www.google.com.tw";
      alert("成功加入購物車");

    });
  });

  ////////////////////////// 商品右半邊資訊 ////////////////////////////
  // 從URL取參數給api查詢
  var productIdValue = (new URL(location.href)).searchParams.get('productId');
  var productTypeIdValue = (new URL(location.href)).searchParams.get('productTypeId');
  console.log(productIdValue);
  console.log(productTypeIdValue);

  var product = {
    "productId": 1,
    "productTypeId": 2,
    "productTypeName": "衣服",
    "productBrand": "露營玩家",
    "productPic1": "assets_546/images/tent01.jpg",
    "productName": "酷炫帳篷-L",
    "productDescription": "是一個很酷的帳篷這是一個很酷的帳篷這是一個很酷的帳篷這是一個很酷的帳篷這是一個很酷的帳篷這是一個很酷的帳篷這是一個很酷的帳篷",
    "productCommentstarAvg": 4,
    "heart": 0,
    "productPic1": "assets_546/images/cloth01.jpg",
    "productPic2": "assets_546/images/tent01.jpg",
    "productPic3": "assets_546/images/cloth01.jpg",
    "productLaunchedTime": "2021-11-19",
    "productPrice": 5000,
    "productInventory": 39,
    "shoppingInformation": "快買就對了!!!"
  };
  // 商品名
  $("h4#productName").prepend(product.productName);
  // 愛心
  if (product.heart == 1) {
    $("div.right-content img#right-redHeart").removeClass("-off");
    $("div.right-content i#right-grayHeart").addClass("-off");
  }
  // 價格
  $("span#right-price").append(product.productPrice);
  // 星星數
  var rightStar =
    `<li><i class="fa fa-star" ${product.productCommentstarAvg >= 1 ? "" : "style='display:none'"}></i></li>
                  <li><i class="fa fa-star" ${product.productCommentstarAvg >= 2 ? "" : "style='display:none'"}></i></li>
                  <li><i class="fa fa-star" ${product.productCommentstarAvg >= 3 ? "" : "style='display:none'"}></i></li>
                  <li><i class="fa fa-star" ${product.productCommentstarAvg >= 4 ? "" : "style='display:none'"}></i></li>
                  <li><i class="fa fa-star" ${product.productCommentstarAvg >= 5 ? "" : "style='display:none'"}></i></li>`;
  $("ul#right-star").append(rightStar);
  // 商品描述
  $("p#right-productInfo").text(product.productDescription);
  // 庫存量
  $("span#right-inventory").append(product.productInventory);
  // 商品分類
  $("a#right-productTypeName").text(product.productTypeName);
  $("a#right-productTypeName").attr("href", `mall_products_list.html?productTypeId=${product.productTypeId}`);
  $("span#right-productBrand").text(product.productBrand);
  // 上架時間
  $("span#right-launchedTime").text(product.productLaunchedTime);


  // 主商品圖片
  var bigPic =
    `<li>
                <img style="height: 350px;" src="${product.productPic1}" />
              </li>
              <li>
                <img style="height: 350px;" src="${product.productPic2}" />
              </li>
              <li>
                <img style="height: 350px;" src="${product.productPic3}" />
              </li>`;
  var smallPic =
    `<li>
                <img style="width: 30%;" src="${product.productPic1}" />
              </li>
              <li>
                <img style="width: 30%;" src="${product.productPic2}" />
              </li>
              <li>
                <img style="width: 30%;" src="${product.productPic3}" />
              </li>`;

  $("ul#bigPic").append(bigPic);
  $("ul#smallPic").append(smallPic);

  // 商品購買須知
  $("p#shoppingInfo").text(product.shoppingInformation);

  // 相關商品推薦
  var typeProducts = {
    "productId": 1,
    "productTypeId": 1,
    "productPic1": "assets_546/images/tent01.jpg",
    "productName": "酷炫帳篷-L",
    "productPrice": 2000,
    "productCommentstarAvg": 4,
    "heart": 0
  };

  for (var i = 0; i < 8; i++) {
    let product_item =
      `<div data-productId="${typeProducts.productId}" data-productTypeId="${typeProducts.productTypeId}" class="product-item">
              <a href="mall_product_detail.html?productId=${typeProducts.productId}&productTypeId=${typeProducts.productTypeId}"><img src="${typeProducts.productPic1}" alt="${typeProducts.productName}"></a>
              <div class="down-content" style="position: relative; padding: 0 10px;">
                <a href="mall_product_detail.html?productId=${typeProducts.productId}&productTypeId=${typeProducts.productTypeId}" title="${typeProducts.productName}">
                  <h4 style="font-size: 16px; overflow : hidden; text-overflow :ellipsis; white-space: nowrap; width: 75%">
                    ${typeProducts.productName}
                  </h4>
                </a>
                <h6>NT${typeProducts.productPrice}</h6>
                <p></p>
                <ul class="stars">
                  <li><i class="fa fa-star" ${typeProducts.productCommentstarAvg >= 1 ? "" : "style='display:none'"}></i></li>
                  <li><i class="fa fa-star" ${typeProducts.productCommentstarAvg >= 2 ? "" : "style='display:none'"}></i></li>
                  <li><i class="fa fa-star" ${typeProducts.productCommentstarAvg >= 3 ? "" : "style='display:none'"}></i></li>
                  <li><i class="fa fa-star" ${typeProducts.productCommentstarAvg >= 4 ? "" : "style='display:none'"}></i></li>
                  <li><i class="fa fa-star" ${typeProducts.productCommentstarAvg >= 5 ? "" : "style='display:none'"}></i></li>
                </ul>
                <span style="position: absolute; right: 10px; bottom: 0px"><img class = "icon ${typeProducts.heart == 1 ? "" : "-off"}" style="position: absolute; right: 85%; bottom: -30px; width: 90%; height: auto;" src="images/heart.png"><i class="far fa-heart addFavoriteProduct ${typeProducts.heart == 0 ? "" : "-off"}" style="color: gray; font-size: 25px;"></i>&nbsp;&nbsp;<i class="fas fa-cart-plus addShoppingCart" style="color: gray; font-size: 25px;"></i></span>
              </div>
            </div>`;
    $("div#someProducts").append(product_item);
  }