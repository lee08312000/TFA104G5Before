package com.campOrder.controller;

import java.util.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.campOrder.model.CampOrderService;
import com.campOrder.model.CampOrderVO;

public class CampOrderServlet extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7466693753949857830L;
	
	private CampOrderService campOrderService ;

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();

		HttpSession session = req.getSession();
		String action = req.getParameter("action");
		
		
//		if (!action.equals("CHECKOUT")) {
//
//			// 刪除購物車中的書籍
//			if (action.equals("DELETE")) {
//				String del = req.getParameter("del");
//				int d = Integer.parseInt(del);
//				buylist.removeElementAt(d);
//			}
//			// 新增書籍至購物車中
//			else if (action.equals("ADD")) {
//				boolean match = false;
//
//				// 取得後來新增的書籍
//				BOOK abook = getBook(req);
//
//				// 新增第一本書籍至購物車時
//				if (buylist == null) {
//					buylist = new Vector<BOOK>();
//					buylist.add(abook);
//				} else {
//					for (int i = 0; i < buylist.size(); i++) {
//						BOOK book = buylist.get(i);
//
//						// 假若新增的書籍和購物車的書籍一樣時
//						if (book.getName().equals(abook.getName())) {
//							book.setQuantity(book.getQuantity()
//									+ abook.getQuantity());
//							buylist.setElementAt(book, i);
//							match = true;
//						} // end of if name matches
//					} // end of for
//
//					// 假若新增的書籍和購物車的書籍不一樣時
//					if (!match)
//						buylist.add(abook);
//				}
//			}
//
//			session.setAttribute("shoppingcart", buylist);
//			String url = "/EShop.jsp";
//			RequestDispatcher rd = req.getRequestDispatcher(url);
//			rd.forward(req, res);
//		}

		campOrderService = new CampOrderService();
		// 結帳，計算購物車書籍價錢總數
		if (action.equals("GETONECAMP")) {
			String campOrderIdStr = req.getParameter("campOrderId");
			CampOrderVO cov = new CampOrderVO();
			if(campOrderIdStr != null && campOrderIdStr!=""){
				cov = campOrderService.findByCampOrderId(Integer.valueOf(campOrderIdStr));
			} 
//			cov.setCampOrderId(123);
//			cov.setPayerName("小豬");
//			cov.setPayerPhone("123456");
			req.setAttribute("campOrderVO", cov);
			String url = "/back-end/camp/updateCampOrder.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}
		
		
	}


}
