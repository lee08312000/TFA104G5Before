package com.cart.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cart.model.CartVO;
import com.mallOrder.model.MallOrderVO;

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
		List<CartVO> buyList = (List<CartVO>) session.getAttribute("buyList");
		String action = req.getParameter("action");

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

			req.setAttribute("receiverName", receiverName);
			req.setAttribute("receiverPhone", receiverPhone);
			req.setAttribute("receiverAddress", receiverAddress);
			req.setAttribute("creditCardNum", creditCardNum);
			req.setAttribute("securityCode", securityCode);
			req.setAttribute("effectiveDate", effectiveDate);
			
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
		
		
		if ("step3tostep2".equals(action)) {
			
			req.setAttribute("receiverName", req.getParameter("receiverName"));
			req.setAttribute("receiverPhone", req.getParameter("receiverPhone"));
			req.setAttribute("receiverAddress", req.getParameter("receiverAddress"));
			req.setAttribute("creditCardNum", req.getParameter("creditCardNum"));
			req.setAttribute("securityCode", req.getParameter("securityCode"));
			req.setAttribute("effectiveDate", req.getParameter("effectiveDate"));
			

			String url = "/front_end/mall/shoppingCart02.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
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
