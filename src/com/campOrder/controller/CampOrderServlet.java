package com.campOrder.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

import javax.servlet.*;
import javax.servlet.http.*;

import com.campOrder.model.CampOrderService;
import com.campOrder.model.CampOrderVO;

public class CampOrderServlet extends HttpServlet {

	private CampOrderService campOrderService;

	/**
	 * 
	 */
	private static final long serialVersionUID = 7466693753949857830L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		campOrderService = new CampOrderService();
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		String action = req.getParameter("action");

		// 查詢單筆訂單
		if (action.equals("GETONECAMP")) {
			String campOrderIdStr = req.getParameter("campOrderId");
			CampOrderVO cov = new CampOrderVO();
			if (campOrderIdStr != null && campOrderIdStr != "") {
				cov = campOrderService.findByCampOrderId(Integer.valueOf(campOrderIdStr));
			}
			req.setAttribute("campOrderVO", cov);
			String url = "/back-end/camp/updateCampOrder.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);

		}

		// 查詢多筆訂單
		if (action.equals("SEARCHALL")) {
			int statusnum = req.getParameter("statusnum") == null ? -1 : Integer.valueOf(req.getParameter("statusnum"));
			String startDateStr = req.getParameter("startDate");
			String endDateStr = req.getParameter("endDate");

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date startDate = null;
			Date endDate = null;
			try {
				startDate = sdf.parse(startDateStr + " 00:00:00");
				endDate = sdf.parse(endDateStr + " 00:00:00");
			} catch (ParseException e) {
			}

			List<CampOrderVO> covList = campOrderService.findByParams(statusnum, startDate, endDate);
			req.setAttribute("list", covList);
			String url = "/back-end/camp/listAllCampOrder.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);

		}
		// 修改訂單
		if (action.equals("UPDATE")) {
			String campOrderId = req.getParameter("campOrderId");
			String memberId = req.getParameter("memberId");
			String payerName = req.getParameter("payerName");
			String payerPhone = req.getParameter("payerPhone");
			String campStatus= req.getParameter("campStatus");
				
			
//			List<CampOrderVO> covList = campOrderService.findByParams(statusnum, startDate, endDate);
//			req.setAttribute("list", covList);
//			String url = "/back-end/camp/listAllCampOrder.jsp";
//			RequestDispatcher rd = req.getRequestDispatcher(url);			rd.forward(req, res);

		}

	}

}
