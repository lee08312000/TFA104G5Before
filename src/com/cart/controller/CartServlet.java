package com.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.model.CartVO;
import com.cart.model.ReceiverVO;
import com.mallOrder.model.MallOrderService;
import com.mallOrder.model.MallOrderVO;
import com.member.model.MemberVO;
import com.product.model.ProductService;
import com.product.model.ProductVO;

@WebServlet("/Cart/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartServlet() {
		super();
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
//		res.setContentType("text/html; charset=UTF-8"); 
//		PrintWriter out = res.getWriter();

		HttpSession session = req.getSession();
		MemberVO memberVO = (MemberVO) session.getAttribute("memberVO");
		List<CartVO> buyList = (List<CartVO>) session.getAttribute("buyList");
		String action = req.getParameter("action");
		
		// 從商城新增商品到購物車
		if ("add".equals(action)) {
			
			ProductService productSvc = new ProductService();
			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			Integer productId = Integer.parseInt(req.getParameter("productId").trim());
			Integer productPurchaseQuantity = Integer.parseInt(req.getParameter("productPurchaseQuantity").trim());
			/*************************** 2.開始修改資料 *****************************************/
			ProductVO productVO = productSvc.getOneProduct(productId);
			// 新的商品
			CartVO cartVO = new CartVO();
			cartVO.setCompanyId(productVO.getCompanyId());
			cartVO.setProductId(productId);
			cartVO.setProductTypeId(productVO.getProductTypeId());
			cartVO.setProductName(productVO.getProductName());
			cartVO.setProductPrice(productVO.getProductPrice());
			cartVO.setProductPurchaseQuantity(productPurchaseQuantity);
			
			if (buyList == null) {
				buyList = new ArrayList<CartVO>();
				buyList.add(cartVO);
			} else {
				for (int i = 0; i < buyList.size(); i++) {
					CartVO c = buyList.get(i);
					if (cartVO.getProductId().intValue() == c.getProductId().intValue()) {
						cartVO.setProductPurchaseQuantity(cartVO.getProductPurchaseQuantity() + c.getProductPurchaseQuantity());
						buyList.set(i, cartVO);
					} else {
						buyList.add(cartVO);
					}
				}
				
			}
			
			session.setAttribute("buyList", buyList);
		}

		// 更新購買清單

		if ("update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
			String[] productPurchaseQuantityArray = req.getParameterValues("productPurchaseQuantity");
			String[] productNameArray = req.getParameterValues("productName");

			for (int i = 0; i < productPurchaseQuantityArray.length; i++) {
				if ("".equals(productPurchaseQuantityArray[i])
						|| Integer.parseInt(productPurchaseQuantityArray[i]) <= 0) {
					errorMsgs.add(productNameArray[i] + " 請輸入正確數量");
				}
			}
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/mall/shoppingCart01.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始修改資料 *****************************************/

			buyList = getBuyList(req);

			/*************************** 3.修改完成,準備轉交(Send the Success view) *************/
			session.setAttribute("buyList", buyList);
			//
			ReceiverVO receiverVO = new ReceiverVO();
			receiverVO.setReceiverName(req.getParameter("receiverName"));
			receiverVO.setReceiverPhone(req.getParameter("receiverPhone"));
			receiverVO.setReceiverAddress(req.getParameter("receiverAddress"));
			receiverVO.setCreditCardNum(req.getParameter("creditCardNum"));
			receiverVO.setSecurityCode(req.getParameter("securityCode"));
			receiverVO.setEffectiveDate(req.getParameter("effectiveDate"));
			
			req.setAttribute("receiverVO", receiverVO);
			//
			String url = "/front_end/mall/shoppingCart02.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}

		// 購物車step2 輸入收件人資料

		if ("inputReceiverInfo".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String receiverName = req.getParameter("receiverName").trim();
			String receiverNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{1,10}$";
			if (receiverName == null || receiverName.trim().length() == 0) {
				errorMsgs.add("收件人姓名: 請勿空白");
			} else if (!receiverName.trim().matches(receiverNameReg)) {
				errorMsgs.add("收件人姓名: 只能是中、英文字母、數字和_，且長度必需在1到10之間");
			}

			String receiverPhone = req.getParameter("receiverPhone").trim();
			String receiverPhoneReg = "^[0][9]\\d{8}$";
			if (receiverPhone == null || receiverPhone.trim().length() == 0) {
				errorMsgs.add("收件人手機: 請勿空白");
			} else if (!receiverPhone.trim().matches(receiverPhoneReg)) {
				errorMsgs.add("收件人手機: 只能是正整數，長度為10，EX:0912345678");
			}

			String receiverAddress = req.getParameter("receiverAddress").trim();
			if (receiverAddress == null || receiverAddress.trim().length() == 0) {
				errorMsgs.add("收件人地址: 請勿空白");
			} else if (!(receiverPhone.trim().length() <= 80)) {
				errorMsgs.add("收件人地址: 長度不可超過80");
			}

			String creditCardNum = req.getParameter("creditCardNum").trim();
			String creditCardNumReg = "^\\d{16}$";
			if (creditCardNum == null || creditCardNum.trim().length() == 0) {
				errorMsgs.add("信用卡號: 請勿空白");
			} else if (!creditCardNum.trim().matches(creditCardNumReg)) {
				errorMsgs.add("信用卡號: 只能是正整數，長度為16");
			}

			String securityCode = req.getParameter("securityCode").trim();
			String securityCodeReg = "^\\d{3}$";
			if (securityCode == null || securityCode.trim().length() == 0) {
				errorMsgs.add("安全碼: 請勿空白");
			} else if (!securityCode.trim().matches(securityCodeReg)) {
				errorMsgs.add("安全碼: 只能是正整數，長度為3");
			}

			String effectiveDate = req.getParameter("effectiveDate").trim();
			String effectiveDateReg = "^[0-1][0-9]\\d{2}$";
			if (effectiveDate == null || effectiveDate.trim().length() == 0) {
				errorMsgs.add("有效日期: 請勿空白");
			} else if (!effectiveDate.trim().matches(effectiveDateReg)) {
				errorMsgs.add("有效日期: 只能是正整數，長度為4，格式為MMYY --> 2025年8月，EX:0825");
			}
			/*************************** 2.準備轉交(Send the Success view) *************/
			ReceiverVO receiverVO = new ReceiverVO();
			receiverVO.setReceiverName(receiverName);
			receiverVO.setReceiverPhone(receiverPhone);
			receiverVO.setReceiverAddress(receiverAddress);
			receiverVO.setCreditCardNum(creditCardNum);
			receiverVO.setSecurityCode(securityCode);
			receiverVO.setEffectiveDate(effectiveDate);
			
			req.setAttribute("receiverVO", receiverVO);
			

			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {

				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/mall/shoppingCart02.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			String url = "/front_end/mall/shoppingCart03.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}

		// step3tostep2
		if ("step3tostep2".equals(action)) {

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			/*************************** 2.準備轉交(Send the Success view) *************/
			
			ReceiverVO receiverVO = new ReceiverVO();
			receiverVO.setReceiverName(req.getParameter("receiverName"));
			receiverVO.setReceiverPhone(req.getParameter("receiverPhone"));
			receiverVO.setReceiverAddress(req.getParameter("receiverAddress"));
			receiverVO.setCreditCardNum(req.getParameter("creditCardNum"));
			receiverVO.setSecurityCode(req.getParameter("securityCode"));
			receiverVO.setEffectiveDate(req.getParameter("effectiveDate"));
			
			req.setAttribute("receiverVO", receiverVO);
			
			String url = "/front_end/mall/shoppingCart02.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}

		// 購物車結帳
		if ("checkout".equals(action)) {
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

			/*********************** 1.接收請求參數 - 輸入格式的錯誤處理 *************************/
			String receiverName = req.getParameter("receiverName");
			String receiverPhone = req.getParameter("receiverPhone");
			String receiverAddress = req.getParameter("receiverAddress");
			String creditCardNum = req.getParameter("creditCardNum");
			String securityCode = req.getParameter("securityCode");
			String effectiveDate = req.getParameter("effectiveDate");

			// 檢查庫存量及購買流程時廠商是否更動價格
			ProductService productSvc = new ProductService();
			for (int i = 0; i < buyList.size(); i++) {
				CartVO cartVO = buyList.get(i);
				ProductVO productVO = productSvc.getOneProduct(cartVO.getProductId());
				// 檢查庫存量
				Integer productInventory = productVO.getProductInventory();
				Integer productPurchaseQuantity = cartVO.getProductPurchaseQuantity();
				if ((productInventory.intValue() - productPurchaseQuantity.intValue()) < 0) {
					cartVO.setProductPurchaseQuantity(productInventory);
					if (cartVO.getProductPurchaseQuantity().intValue() == 0) {
						buyList.remove(i);
						i--;
					} else {				
						buyList.set(i, cartVO);
					}
					errorMsgs.add(cartVO.getProductName() + " 的庫存量為" + productInventory + "，請重新確認數量");
				}
				// 檢查購買流程時廠商是否更動價格
				Integer realPrice = productVO.getProductPrice();
				Integer cartPrice = cartVO.getProductPrice();
				if (cartPrice.intValue() != realPrice.intValue()) {
					cartVO.setProductPrice(realPrice);
					buyList.set(i, cartVO);
					errorMsgs.add(cartVO.getProductName() + " : 廠商在您 shopping 時更動了價格，請重新確認");
				}
				// 檢查購買流程時廠商是否下價商品
				if (productVO.getProductStatus().intValue() == 0) {
					buyList.remove(i);
					i--;
					errorMsgs.add(cartVO.getProductName() + " : 商品已下架，請重新確認");
				}
			}

			session.setAttribute("buyList", buyList);
			// Send the use back to the form, if there were errors
			if (!errorMsgs.isEmpty()) {
				
				ReceiverVO receiverVO = new ReceiverVO();
				receiverVO.setReceiverName(receiverName);
				receiverVO.setReceiverPhone(receiverPhone);
				receiverVO.setReceiverAddress(receiverAddress);
				receiverVO.setCreditCardNum(creditCardNum);
				receiverVO.setSecurityCode(securityCode);
				receiverVO.setEffectiveDate(effectiveDate);
				
				req.setAttribute("receiverVO", receiverVO);
				
				RequestDispatcher failureView = req.getRequestDispatcher("/front_end/mall/shoppingCart01.jsp");
				failureView.forward(req, res);
				return;// 程式中斷
			}

			/*************************** 2.開始新增資料 ***************************************/
			// 存放增加的訂單編號
			List<Integer> mallOrderIdList = new ArrayList<Integer>();
			// 創造companySet
			Set<Integer> companySet = new TreeSet<Integer>();
			for (CartVO c : buyList) {
				companySet.add(c.getCompanyId());
			}

			// 用set分別成立訂單
			for (Integer companyId : companySet) {
				// 存放增加的主鍵
				Integer mallOrderId = null;
				
				List<CartVO> newBuyList = new ArrayList<CartVO>();
				Integer mailOrderTotalAmount = 0;

				// 將此廠商的商品存到新的List
				for (int i = 0; i < buyList.size(); i++) {

					CartVO cartVO = buyList.get(i);
					if (companyId == cartVO.getCompanyId()) {
						newBuyList.add(cartVO);
					}
				}

				// 計算此訂單的總金額
				for (int i = 0; i < newBuyList.size(); i++) {
					CartVO cartVO = newBuyList.get(i);
					mailOrderTotalAmount += cartVO.getProductPrice() * cartVO.getProductPurchaseQuantity();
				}
				
				// 新增訂單主檔、訂單明細、修改商品庫存量及銷量
				MallOrderService mallOrderSvc = new MallOrderService();

				MallOrderVO mallOrderVO = new MallOrderVO();

				mallOrderVO.setCompanyId(companyId);
//				mallOrderVO.setMemberId(1);
				mallOrderVO.setMemberId(memberVO.getMemberId());
				mallOrderVO.setMailOrderTotalAmount(mailOrderTotalAmount);
				mallOrderVO.setCreditCardNum(creditCardNum);
				mallOrderVO.setReceiverName(receiverName);
				mallOrderVO.setReceiverPhone(receiverPhone);
				mallOrderVO.setReceiverAddress(receiverAddress);

				mallOrderId = mallOrderSvc.addMallOrderWithMallOrderDetail(mallOrderVO, newBuyList);
				mallOrderIdList.add(mallOrderId);
			}
			
			session.removeAttribute("buyList");

			
			/*************************** 3.準備轉交(Send the Success view) *************/
		}
	}

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	private List<CartVO> getBuyList(HttpServletRequest req) {

		List<CartVO> buyList = new ArrayList<CartVO>();

		String[] companyIdArray = req.getParameterValues("companyId");
		String[] productIdArray = req.getParameterValues("productId");
		String[] productTypeIdArray = req.getParameterValues("productTypeId");
		String[] productNameArray = req.getParameterValues("productName");
		String[] productPriceArray = req.getParameterValues("productPrice");
		String[] productPurchaseQuantityArray = req.getParameterValues("productPurchaseQuantity");

		for (int i = 0; i < companyIdArray.length; i++) {

			CartVO cartVO = new CartVO();

			Integer companyId = Integer.parseInt(companyIdArray[i]);
			Integer productId = Integer.parseInt(productIdArray[i]);
			Integer productTypeId = Integer.parseInt(productTypeIdArray[i]);
			String productName = productNameArray[i];
			Integer productPrice = Integer.parseInt(productPriceArray[i]);
			Integer productPurchaseQuantity = Integer.parseInt(productPurchaseQuantityArray[i]);

			cartVO.setCompanyId(companyId);
			cartVO.setProductId(productId);
			cartVO.setProductTypeId(productTypeId);
			cartVO.setProductName(productName);
			cartVO.setProductPrice(productPrice);
			cartVO.setProductPurchaseQuantity(productPurchaseQuantity);

			buyList.add(cartVO);
		}

		return buyList;
	}

}
