package com.camp.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.campArea.model.CampAreaDAOlmpl;
import com.campArea.model.CampAreaVO;

public class CampService {
	private CampDAO campdao;

	public CampService() {
		campdao = new CampDAOlmpl();
	}

	// 新增營位
	public void  insertCamp(CampVO campVO) {
		
//		campVO.setCampId(campId);
//		campVO.setCompanyId(companyId);
//		campVO.setCampStatus(campStatus);   
//		campVO.setCampDiscription(campDiscription);
//		campVO.setCampName(campName);
//		campVO.setCampRule(campRule);
//		campVO.setCampPic1(campPic1);
//		campVO.setCampPic2(campPic2);
//		campVO.setCampPic3(campPic3);
//		campVO.setCampPic4(campPic4);
//		campVO.setCampPic5(campPic5);
//		campVO.setCampAddress(campAddress);
//		campVO.setCampPhone(campPhone);
//		campVO.setCertificateNum(certificateNum);
//		campVO.setCertificatePic(certificatePic);
//		campVO.setCampLaunchedTime(campLaunchedTime);
//		campVO.setCampAppliedLaunchTime (campAppliedLaunchTime);
//		campVO.setLongitude(longitude);
//		campVO.setLattitude(lattitude);
//		
		campdao. insert(campVO);

	};
	
	//刪除營地
	public void deleteCamp(Integer camp) {
		campdao.delete(camp);
	}
	
	//更新營地
	public void updateCamp(CampVO campVO) {
		
		campdao.update(campVO);
		
		
	};
	
	//查詢某個營地
	public	CampVO  getOneCamp(Integer camp) {
		return campdao.findByPrimaryKey(camp);
	}   
	
	
	
	//依營狀態查詢營地
	public  List<CampVO>  camplist(Integer campId,Date startime,Date endtime,String campIdsearch){		
		return campdao.camplist(campId,startime,endtime,campIdsearch);
		
	}
	
	
	//查詢全部營地
	public List<CampVO>   getAll() {
	
		return  campdao.getAll();

	}

	
	}
	
	

