$(function () {


    // 加入我的最愛及購物車
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

    

    // 商品排序
    $("select.orderBy").on("change", function () {
      console.log($(this).val());
    });

  });

  // ------------------$(function)之外---------------------------------
  // 點擊商品分類變色，從資料庫撈出此分類的資料
  $(document).on("click", "div.filters > ul > li", function () {
      $("div.filters > ul > li").removeClass("active");
      $(this).addClass("active");
      history.replaceState(null, "page2", "products_list.html");
    });
  
  
  
  // 從資料庫調出商品分類
  var productTypeList = [
    {
      "productTypeId": 1,
      "productTypeName": "帳篷"
    },
    {
      "productTypeId": 2,
      "productTypeName": "衣服"
    }
  ];

  $.each(productTypeList, function (index, item) {

    let product_type = `<li data-productTypeId="${item.productTypeId}">${item.productTypeName}</li>`;

    $("div.filters > ul").append(product_type);
  });


  // 從網址抓參數
  var searchValue = (new URL(location.href)).searchParams.get('search');
 
  var productTypeIdValue = (new URL(location.href)).searchParams.get('productTypeId');

  if (searchValue != null && searchValue != "") {

    $("div.filters li.active").removeClass("active");
    // 利用searchValue 去資料庫搜尋商品名稱
    useSearchBar(searchValue);


  } else if (productTypeIdValue != null && productTypeIdValue != "") {
    $("div.filters > ul li").each(function (index, item) {
      if($(item).attr("data-productTypeId") == productTypeIdValue) {
        $(item).click();
      }
    });


  } else {
    // 從資料庫查熱門商品並列出
    var hotProducts = {
      "productId": 1,
      "productTypeId": 1,
      "productPic1": "assets_546/images/tent01.jpg",
      "productName": "酷炫帳篷-L",
      "productPrice": 2000,
      "productCommentstarAvg": 4,
      "heart": 1
    };


    for (var i = 0; i < 6; i++) {
      let product_item =
        `<div class="col-lg-4 col-md-6 all">
          <div data-productId="${hotProducts.productId}" data-productTypeId="${hotProducts.productTypeId}" class="product-item">
              <a href="product_detail.html?productId=${hotProducts.productId}&productTypeId=${hotProducts.productTypeId}"><img src="${hotProducts.productPic1}" alt="${hotProducts.productName}"></a>
              <div class="down-content">
                <a href="product_detail.html?productId=${hotProducts.productId}&productTypeId=${hotProducts.productTypeId}" title="${hotProducts.productName}">
                  <h4 style="overflow : hidden; text-overflow :ellipsis; white-space: nowrap; width: 75%">
                    ${hotProducts.productName}
                  </h4>
                </a>
                <h6>NT${hotProducts.productPrice}</h6>
                <p></p>
                <ul class="stars">
                  <li><i class="fa fa-star" ${hotProducts.productCommentstarAvg >= 1 ? "" : "style='display:none'"}></i></li>
                  <li><i class="fa fa-star" ${hotProducts.productCommentstarAvg >= 2 ? "" : "style='display:none'"}></i></li>
                  <li><i class="fa fa-star" ${hotProducts.productCommentstarAvg >= 3 ? "" : "style='display:none'"}></i></li>
                  <li><i class="fa fa-star" ${hotProducts.productCommentstarAvg >= 4 ? "" : "style='display:none'"}></i></li>
                  <li><i class="fa fa-star" ${hotProducts.productCommentstarAvg >= 5 ? "" : "style='display:none'"}></i></li>
                </ul>
                <span><img class = "icon ${hotProducts.heart == 1 ? "" : "-off"}" style="position: relative; bottom: 6px;" src="images/heart.png"><i class="far fa-heart addFavoriteProduct ${hotProducts.heart == 0 ? "" : "-off"}" style="color: gray; font-size: 25px;"></i>&nbsp;&nbsp;<i class="fas fa-cart-plus addShoppingCart" style="color: gray; font-size: 25px;"></i></span>
              </div>
            </div>
                </div>`;

      $("div.row.grid").append(product_item);
    }

  }







  // 此方法為去資料庫搜尋商品名稱
  function useSearchBar(productName) {

  }