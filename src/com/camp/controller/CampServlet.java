package com.camp.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;
import java.sql.Timestamp;

import javax.servlet.*;
import javax.servlet.http.*;

import com.camp.model.CampService;
import com.camp.model.CampVO;
import com.campArea.model.CampAreaService;
import com.campArea.model.CampAreaVO;

public class CampServlet extends HttpServlet {
	private CampAreaService campAreaService;
	/**
	 * 
	 */
	private static final long serialVersionUID = 8459587984407557206L;

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

		if ("INSERT".equals(action)) { 
			
			CampVO  campVO=new CampVO();//1.先宣告CampVO,預存傳入參數
		
			List<String> errorMsgs = new ArrayList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			try {
				/*************************** 1.接收請求參數 - 輸入格式的錯誤處理 **********************/
				String campanyId = req.getParameter("campany_id");
				campVO.setCompanyId(Integer.valueOf(campanyId));
				Timestamp ts=new Timestamp(new Date().getTime());
				campVO.setCampLaunchedTime(ts);
				campVO.setCampAppliedLaunchTime(ts);
				
				String campStatus = req.getParameter("camp_status");
				campVO.setCampStatus(Integer.valueOf(campStatus));
				String campName = req.getParameter("camp_name");//2.宣告campName變數,存camp_name參數
				if ( campName == null || ( campName.trim()).length() == 0) {
					errorMsgs.add("營地名稱:請勿空白");//3.判斷傳入參數是否為空值
				}else {
					campVO.setCampName(campName);//3.將campName參數存入campVO					
				}
				
				
				String campPhone = req.getParameter("camp_phone");
				if ( campPhone == null || ( campPhone.trim()).length() == 0) {
					errorMsgs.add("營地電話:請勿空白");
				}else {
					campVO.setCampPhone(campPhone);					
				}
				
				String longitude = req.getParameter("longitude");
				 double doubleLongitude = Double.parseDouble(longitude);
				if ( longitude == null || (longitude.trim()).length() == 0) {
					errorMsgs.add("緯度:請勿空白");
				}else {
					campVO.setLongitude(doubleLongitude);					
				}
				
				String lattitude = req.getParameter("lattitude");
				 double doubleLattitude = Double.parseDouble(lattitude);
				if ( lattitude == null || (lattitude.trim()).length() == 0) {
					errorMsgs.add("經度:請勿空白");
				}else {
					campVO.setLattitude(doubleLattitude);					
				}
				
				String campAddress= req.getParameter("campAddress");
				if ( campAddress == null || ( campAddress.trim()).length() == 0) {
					errorMsgs.add("地址:請勿空白");
				}else {
					campVO.setCampAddress(campAddress);					
				}
				
				String campDiscription= req.getParameter("campDiscription");
				if ( campDiscription == null || ( campDiscription.trim()).length() == 0) {
					errorMsgs.add("營地敘述:請勿空白");
				}else {
					campVO.setCampDiscription(campDiscription);					
				}
			
								
				String 	campRule= req.getParameter("campRule");
				if ( campRule == null || ( campRule.trim()).length() == 0) {
					errorMsgs.add("營地租借規則:請勿空白");
				}else {
					campVO.setCampRule(campRule);					
				}
			
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req.getRequestDispatcher("/back-end/camp/campShelves.jsp");
					failureView.forward(req, res);
					return;// 程式中斷
				}
				
				
				
				
				/*************************** 2.開始查詢資料 *****************************************/
				CampService campSvc = new CampService();
			    campSvc.insertCamp(campVO);
//				if (campAreaVO == null) {
//					errorMsgs.add("查無資料");
//				}

//				if (!errorMsgs.isEmpty()) {
//					RequestDispatcher failureView = req.getRequestDispatcher("/camp/campShelves.jsp");
//					failureView.forward(req, res);
//					return;// 程式中斷
//				}

				/*************************** 3.查詢完成,準備轉交(Send the Success view) *************/
				String url = "/back-end/camp/campShelves.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交campShelves.jsp
				successView.forward(req, res);

				/*************************** 其他可能的錯誤處理 *************************************/
			} catch (Exception e) {
				errorMsgs.add("無法取得資料:" + e.getMessage());
				RequestDispatcher failureView = req.getRequestDispatcher("/back-end/camp/campShelves.jsp");
				failureView.forward(req, res);
			}
		}
		
	 	/*************************** 查詢營地 *************************************/	
    	//查詢全部營地上架
    	
    	if (action.equals("SEARCHALL")) {
			String campstatues = req.getParameter("campstatues");
			String startDate = req.getParameter("startDate");
			String endDate = req.getParameter("endDate");
			String campAreaId = req.getParameter("campAreaId");
			
			
			CampAreaVO cav = new CampAreaVO();
			

			
		
		}
        	
    	
    	
    	

		// 查詢上架單筆營地
		if (action.equals("GETONECAMP")) {
			String campAreaStr = req.getParameter("campAreaId");
			CampAreaVO cav = new CampAreaVO();
			if (campAreaStr != null && campAreaStr != "") {
				cav = campAreaService.getOneCampArea(Integer.valueOf(campAreaStr));
			}
			req.setAttribute("campAreaStr", cav);
			String url = "/back-end/camp/campShelves.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);
		}
		
		//刪除營位上架
		if (action.equals("DELETE")) {
			String campAreaStr = req.getParameter("campAreaId");
			if (campAreaStr != null && campAreaStr != "") {
				campAreaService.deleteCampArea(Integer.valueOf(campAreaStr));
			}
			
			List<CampAreaVO> campAreaList = new ArrayList<CampAreaVO>();
			campAreaService.getAll();
			req.setAttribute("list", campAreaList);
			String url = "/back-end/camp/selectCamp.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(url);
			rd.forward(req, res);

		}

	}

}
