        /* Set rates + misc */
        var taxRate = 0;
        var shippingRate = 0;
        var fadeTime = 0;


        /* Assign actions */
        $('.product-quantity input').change(function () {
//        	console.log("123");
            if ($(this).val().trim() <= 0 || $(this).val().trim() == "") {

                $(this).closest("div.product").find('.product-removal button').eq(0).click();
            }
            
            updateQuantity(this);
            let subtotal = 0;
            // console.log($(this).parent().parent().parent().find("div.totals-value").eq(0));
            let orederSmallMoney = $(this).closest("div.oneOrder").find("div.totals-value").eq(0);

            let line_prices = $(this).closest("div.oneOrder").find("div.product-line-price");
            line_prices.each(function (index, item) {
                subtotal = parseInt(subtotal) + parseInt($(item).text());
            });
            orederSmallMoney.text(subtotal);
        });

        $('.product-removal button').click(function () {
            removeItem(this);
        });


        /* Recalculate cart */
        function recalculateCart() {
            var subtotal = 0;

            /* Sum up row totals */
            $('.product').each(function () {
                subtotal += parseFloat($(this).children('.product-line-price').text());
            });

            /* Calculate totals */
            var total = subtotal;

            /* Update totals display */
            $('.totals-value').fadeOut(fadeTime, function () {
                // $('.totals-value').html(subtotal.toFixed(2));


                $('#cart-total').html(total);
                if (total == 0) {
                    $('.checkout').fadeOut(fadeTime);
                } else {
                    $('.checkout').fadeIn(fadeTime);
                }
                $('.totals-value').fadeIn(fadeTime);
            });

            cartIsEmpty();
        }


        /* Update quantity */
        function updateQuantity(quantityInput) {
            /* Calculate line price */
            var productRow = $(quantityInput).parent().parent();
            var price = productRow.children('.product-price').text();
            var quantity = $(quantityInput).val();
            var linePrice = price * quantity;

            /* Update line price display and recalc cart totals */
            productRow.children('.product-line-price').each(function () {
                $(this).fadeOut(fadeTime, function () {
                    $(this).text(linePrice);
                    recalculateCart();
                    $(this).fadeIn(fadeTime);
                });
            });
        }


        /* Remove item from cart */
        function removeItem(removeButton) {
            /* Remove row from DOM and recalc cart total */
            var productRow = $(removeButton).parent().parent();
            let removeMonry = productRow.find("div.product-line-price").text();
            let subtotal = 0;
            // console.log($(this).parent().parent().parent().find("div.totals-value").eq(0));
            let orederSmallMoney = $(removeButton).closest("div.oneOrder").find("div.totals-value").eq(0);
            let line_prices = $(removeButton).closest("div.oneOrder").find("div.product-line-price");
            line_prices.each(function (index, item) {
                subtotal = parseInt(subtotal) + parseInt($(item).text());
            });
            orederSmallMoney.text(subtotal - removeMonry);

            productRow.slideUp(fadeTime, function () {

                if ($(removeButton).closest("div.oneOrder").find("div.product").length == 1) {
                    let oneOrder = $(removeButton).closest("div.oneOrder");
                    oneOrder.remove();
                }
                productRow.remove();
                recalculateCart();
            });
        }

        // 一進來頁面的動作
        $("div.oneOrder").each(function (index, item) {

            let subtotal = 0;
            // console.log($(this).parent().parent().parent().find("div.totals-value").eq(0));
            let orederSmallMoney = $(this).find("div.totals-value").eq(0);

            let line_prices = $(this).find("div.product-line-price");
            line_prices.each(function (index, item) {
                subtotal = parseInt(subtotal) + parseInt($(item).text());
            });
            orederSmallMoney.text(subtotal);
        });


        recalculateCart();

        // 判斷購物車為空的話，加入文字
        function cartIsEmpty() {
            if ($("div.shopping-cart").find("div.oneOrder").length == 0) {
                $("div.shopping-cart").prepend("<h1 style='text-align: center;'>購物車是空的!!!</h1>");
            };
        };

        $("button#inputReceiverInfo").on("click", function(){


            let member = {
                "memberName": "蜥蜴男爵",
                "memberPhone": "0912345678",
                "memberAddress": "台北市南京東路緯育Java就業養成班"
            };

            $("input#receiverName").val(member.memberName);
            $("input#receiverPhone").val(member.memberPhone);
            $("input#receiverAddress").val(member.memberAddress);
        });