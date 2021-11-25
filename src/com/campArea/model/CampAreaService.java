package com.campArea.model;

import java.util.List;


public class CampAreaService {
private   CampAreaDAO   campareadao;
	
	public  CampAreaService() {
		campareadao= new   CampAreaDAOlmpl();
	}

	//新增營位
	public  void  addCampArea(Integer campAreaId, Integer campId, String campAreaName,Integer campAreaMax,Integer weekdayPrice,
	     Integer holidayPrice,Integer capitationMax,Integer perCapitationFee,byte[]campAreaPic){

		CampAreaVO  campareaVO = new  CampAreaVO(); 
		campareaVO.setCampAreaId(campAreaId);
		campareaVO.setCampId(campId);
		campareaVO.setCampAreaName(campAreaName);
		campareaVO.setCampAreaMax(campAreaMax);
		campareaVO.setWeekdayPrice(weekdayPrice);
		campareaVO.setHolidayPrice(holidayPrice);
		campareaVO.setCapitationMax(capitationMax);
		campareaVO.setPerCapitationFee(perCapitationFee);
		campareaVO.setCampAreaPic(campAreaPic);
		
		campareadao.add(campareaVO);
			
	}
	
	//刪除營位
	public void deleteCampArea(Integer campArea) {
		campareadao.delete(campArea);
	}
	
	
	//更新營位
	public void  updateCampArea(Integer campAreaId, Integer campId, String campAreaName,Integer campAreaMax,Integer weekdayPrice,
		     Integer holidayPrice,Integer capitationMax,Integer perCapitationFee,byte[]campAreaPic) {
		 
		CampAreaVO campareaVO  = new  CampAreaVO();
		
		campareaVO.setCampAreaId(campAreaId);
		campareaVO.setCampId(campId);
		campareaVO.setCampAreaName(campAreaName);
		campareaVO.setCampAreaMax(campAreaMax);
		campareaVO.setWeekdayPrice(weekdayPrice);
		campareaVO.setHolidayPrice(holidayPrice);
		campareaVO.setCapitationMax(capitationMax);
		campareaVO.setPerCapitationFee(perCapitationFee);
		campareaVO.setCampAreaPic(campAreaPic);
		
		campareadao.update(campareaVO);
	
	}
		 

	
	//查詢某個營位
	public	CampAreaVO  getOneCampArea(Integer campArea) {
		return campareadao.findByPrimaryKey(campArea);
	}                                          
	
	//查詢全部營位
	public List<CampAreaVO> getAll() {
		return  campareadao.getAll();
	}
}
	
	
	

	
	
	
	
	


