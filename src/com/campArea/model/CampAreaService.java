package com.campArea.model;

import java.util.List;



public class CampAreaService {
private   CampAreaDAO   campareadao;
	
	public  CampAreaService() {
		campareadao= new   CampAreaDAOlmpl();
	}

	//新增營位
	public  void  addCampArea(CampAreaVO  campareaVO){

		campareadao.insert(campareaVO);
			
	}
	
	//刪除營位
	public void deleteCampArea(Integer campArea) {
		campareadao.delete(campArea);
	}
	
	
	//更新營位
	public void  updateCampArea(CampAreaVO campareaVO) {
		
		campareadao.update(campareaVO);
	
	}
		 

	
	//查詢某個營位
	public	CampAreaVO  getOneCampArea(Integer campArea) {
		return campareadao.findByPrimaryKey(campArea);
	}
	
	//依條件查詢營位狀態
	
	public  List<CampAreaVO>  camparealist(Integer campId){
		
		return campareadao.camparealist(campId);
		
	}

	//查詢全部營位
	public List<CampAreaVO> getAll() {
		return  campareadao.getAll();
	}
}
	
	
	

	
	
	
	
	


