package com.campArea.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.camp.model.CampVO;
import com.campArea.model.CampAreaService;
import com.campArea.model.CampAreaVO;
import com.campTagDetail.model.CampTagDetailVO;

public class CampAreaServlet extends HttpServlet {
	private CampAreaService campAreaService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		campAreaService = new CampAreaService();
		
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html; charset=UTF-8");
		PrintWriter out = res.getWriter();

		HttpSession session = req.getSession();
		String action = req.getParameter("action");
        //新增營位
		if ("INSERT".equals(action)) {

			CampAreaVO campareaVO = new CampAreaVO();

			List<String> errorMsgs = new ArrayList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/	
				String campId = req.getParameter("campId");
				campareaVO.setCampId(Integer.valueOf(campId));
				
				
				String campAreaName = req.getParameter("campAreaName");
				if (campAreaName == null || ( campAreaName.trim()).length() == 0) {
					errorMsgs.add("營位名稱:請勿空白");
				}else {
					campareaVO.setCampAreaName(campAreaName);
				}
							
				String  weekdayPrice = req.getParameter("weekdayPrice");			
				if (weekdayPrice == null || (weekdayPrice.trim()).length() == 0) {
					errorMsgs.add("平日價格:請勿空白");
				}else {
					campareaVO.setWeekdayPrice(Integer.valueOf(weekdayPrice));
				}
				
				String  holidayPrice = req.getParameter("holidayPrice");
				if (holidayPrice == null || (holidayPrice.trim()).length() == 0) {
					errorMsgs.add("價日價格:請勿空白");
				}else {
					campareaVO.setHolidayPrice(Integer.valueOf(holidayPrice));
				}
				

				String capitationMax = req.getParameter("capitationMax");
				if (capitationMax== null || (capitationMax.trim()).length() == 0) {
					errorMsgs.add("每帳加購人頭上限:請勿空白");
				}else {
					campareaVO.setCapitationMax(Integer.valueOf(capitationMax));
				}
				
				
				
				String 	perCapitationFee = req.getParameter("perCapitationFee");
				if (perCapitationFee== null || (perCapitationFee.trim()).length() == 0) {
					errorMsgs.add("加購人頭價格:請勿空白");
				}else {
					campareaVO.setPerCapitationFee(Integer.valueOf(perCapitationFee));
				}
				
				String 	campAreaMax = req.getParameter("campAreaMax");
				if (campAreaMax== null || (campAreaMax.trim()).length() == 0) {
					errorMsgs.add("帳數上限:請勿空白");
				}else {
					campareaVO.setCampAreaMax(Integer.valueOf(campAreaMax));
				}
				
			
	
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/camp/insertCampArea.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}
	
				/*************************** 2.新增營位後,查詢資料是否新增成功 *****************************************/
         	   CampAreaService campareaSvc = new CampAreaService();
			    campareaSvc.addCampArea(campareaVO);
			    
			    List<CampAreaVO> campAreaList = new ArrayList<CampAreaVO>();
				req.setAttribute("list", campAreaList);
				req.setAttribute("campId", campId);
				
				

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				String url = "/back-end/camp/selectCampAreaShelves.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交campShelves.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/camp/insertCampArea.jsp");
				failureView.forward(req, res);
			}
		}
		
		/*************************** 更新營位 *************************************/		
		 //更新營位
		if ("UPDATE".equals(action)) {

			CampAreaVO campareaVO = new CampAreaVO();

			List<String> errorMsgs = new ArrayList<String>();
			req.setAttribute("errorMsgs", errorMsgs);
			
			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/	
				String campId = req.getParameter("campId");
				campareaVO.setCampId(Integer.valueOf(campId));
				
				String campAreaId = req.getParameter("campAreaId");
				campareaVO.setCampAreaId(Integer.valueOf(campAreaId));
				
				
				String campAreaName = req.getParameter("campAreaName");
				if (campAreaName == null || ( campAreaName.trim()).length() == 0) {
					errorMsgs.add("營位名稱:請勿空白");
				}else {
					campareaVO.setCampAreaName(campAreaName);
				}
							
				String  weekdayPrice = req.getParameter("weekdayPrice");			
				if (weekdayPrice == null || (weekdayPrice.trim()).length() == 0) {
					errorMsgs.add("平日價格:請勿空白");
				}else {
					campareaVO.setWeekdayPrice(Integer.valueOf(weekdayPrice));
				}
				
				String  holidayPrice = req.getParameter("holidayPrice");
				if (holidayPrice == null || (holidayPrice.trim()).length() == 0) {
					errorMsgs.add("價日價格:請勿空白");
				}else {
					campareaVO.setHolidayPrice(Integer.valueOf(holidayPrice));
				}
				

				String capitationMax = req.getParameter("capitationMax");
				if (capitationMax== null || (capitationMax.trim()).length() == 0) {
					errorMsgs.add("每帳加購人頭上限:請勿空白");
				}else {
					campareaVO.setCapitationMax(Integer.valueOf(capitationMax));
				}
				
				
				
				String 	perCapitationFee = req.getParameter("perCapitationFee");
				if (perCapitationFee== null || (perCapitationFee.trim()).length() == 0) {
					errorMsgs.add("加購人頭價格:請勿空白");
				}else {
					campareaVO.setPerCapitationFee(Integer.valueOf(perCapitationFee));
				}
				
				String 	campAreaMax = req.getParameter("campAreaMax");
				if (campAreaMax== null || (campAreaMax.trim()).length() == 0) {
					errorMsgs.add("帳數上限:請勿空白");
				}else {
					campareaVO.setCampAreaMax(Integer.valueOf(campAreaMax));
				}
				
			
	
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/camp/updateCampArea.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}
	
				/*************************** 2.新增營位後,查詢資料是否新增成功 *****************************************/
         	   CampAreaService campareaSvc = new CampAreaService();
         	 
			    campareaSvc.updateCampArea(campareaVO);
			    
			    List<CampAreaVO> campAreaList = new ArrayList<CampAreaVO>();
				req.setAttribute("list", campAreaList);
				req.setAttribute("campId", campId);
				
				

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				String url = "/back-end/camp/selectCampAreaShelves.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交campShelves.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/camp/updateCampArea.jsp");
				failureView.forward(req, res);
			}
		}
        //舊資料帶入營位查詢畫面
		if (action.equals("UPDATEFINDBYKEY")) {
			String campStr = req.getParameter("campAreaId");		
			Integer campAreaId = Integer.valueOf(campStr);
			CampAreaVO cv = campAreaService.getOneCampArea(campAreaId);
						
			req.setAttribute("campAreaVO",  cv);
			String url = "/back-end/camp/updateCampArea.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}
		
		// 營位畫面-->直接查詢
        if (action.equals("SEARCHALL")) {
			String campAreaStr = req.getParameter("campId");
			List<CampAreaVO> cavList = new  ArrayList<CampAreaVO>();
			if (campAreaStr != null && campAreaStr != "") {
				cavList = campAreaService.camparealist(Integer.valueOf(campAreaStr));
			}
			
			req.setAttribute("campId", campAreaStr );
			req.setAttribute("list", cavList );
			String url = "/back-end/camp/selectCampAreaShelves.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}
        
     // 新增營位畫面
        if (action.equals("INSERTPAGE")) {
			String campId = req.getParameter("campId");
			
			req.setAttribute("campId", campId );
			String url = "/back-end/camp/insertCampArea.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}
      	
    	/*************************** 刪除營位 *************************************/
		
		//刪除營位上架
		if (action.equals("DELETE")) {
			String campAreaStr = req.getParameter("campAreaId");
			if (campAreaStr != null && campAreaStr != "") {
			campAreaService.deleteCampArea(Integer.valueOf(campAreaStr));
			}
			
			List<CampAreaVO> campAreaList = new ArrayList<CampAreaVO>();
			campAreaService.getAll();
			String campStr = req.getParameter("camp_Id");
			req.setAttribute("campId",campStr);		
			req.setAttribute("list", campAreaList);
	
			String url = "/back-end/camp/selectCampAreaShelves.jsp";
		    RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);

		}

	}
}



