package com.campArea.model;

import java.util.List;


public class CampAreaService {
private   CampAreaDAO   campareadao;
	
	public  CampAreaService() {
		campareadao= new   CampAreaDAOlmpl();
	}

	//新增營位
	public  void  addCampArea(Integer campTagId, String campTagName) {

		CampAreaVO  campareaVO = new  CampAreaVO(); 
		campareaVO.setCampTagId(campTagId);
		
		campareadao.add(campareaVO);
		

		 
	
	}
	
	//刪除營位
	public void deleteCampArea(Integer campArea) {
		campareadao.delete(campArea);
	}
	
	
	//更新營位
	public void  updateCampArea(Integer campArea) {
		 
		CampAreaVO  campAreaVO = new  CampAreaVO();
		 
		 campAreaVO.setCampArea(campArea);
	
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
	
	
	
	
	



	

}
	
	
	
	
	


