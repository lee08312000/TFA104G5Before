package com.camp.model;

<<<<<<< HEAD
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
=======
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.campArea.model.CampAreaDAOlmpl;
import com.campArea.model.CampAreaVO;
>>>>>>> Alice

public class CampService {
	private CampDAO campdao;

	public CampService() {
<<<<<<< HEAD
		campdao = new CampDAOImpl();

	}

//新增營地
	public void insert(Integer companyId, Integer campStatus, String campName, String campRule,
			byte[] campPic1, byte[] campPic2, byte[] campPic3, byte[] campPic4, byte[] campPic5, String campAddress,
			String campPhone, String certificateNum, byte[] certificatePic, Timestamp campLaunchedTime,
			Timestamp campAppliedLaunchTime, BigDecimal longitude, BigDecimal lattitude) {

		CampVO campvo = new CampVO();
	
		campvo.setCompanyId(companyId);
		campvo.setCampStatus(campStatus);
		campvo.setCampName(campName);
		campvo.setCampRule(campRule);
		campvo.setCampPic1(campPic1);
		campvo.setCampPic2(campPic2);
		campvo.setCampPic3(campPic3);
		campvo.setCampPic4(campPic4);
		campvo.setCampPic5(campPic5);
		campvo.setCampAddress(campAddress);
		campvo.setCampPhone(campPhone);
		campvo.setCertificateNum(certificateNum);
		campvo.setCertificatePic(certificatePic);
		campvo.setCampLaunchedTime(campLaunchedTime);
		campvo.setCampAppliedLaunchTime(campAppliedLaunchTime);
		campvo.setLongitude(longitude);
		campvo.setLattitude(lattitude);
		campdao.insert(campvo);

	}

//更新營地資料(不能更改的有1.營地上架時間，2.營地申請上架時間)
//刪除營地用狀態改變方式:下架
	public void update(Integer campId,Integer companyId, Integer campStatus, String campName, String campRule,
			byte[] campPic1, byte[] campPic2, byte[] campPic3, byte[] campPic4, byte[] campPic5, String campAddress,
			String campPhone, String certificateNum, byte[] certificatePic, Timestamp campLaunchedTime,
			Timestamp campAppliedLaunchTime, BigDecimal longitude, BigDecimal lattitude) {
		
		CampVO campvo=campdao.findByPrimaryKey(campId);
		campvo.setCompanyId(companyId);
		campvo.setCampStatus(campStatus);
		campvo.setCampName(campName);
		campvo.setCampRule(campRule);
		campvo.setCampPic1(campPic1);
		campvo.setCampPic2(campPic2);
		campvo.setCampPic3(campPic3);
		campvo.setCampPic4(campPic4);
		campvo.setCampPic5(campPic5);
		campvo.setCampAddress(campAddress);
		campvo.setCampPhone(campPhone);
		campvo.setCertificateNum(certificateNum);
		campvo.setCertificatePic(certificatePic);
		campvo.setLongitude(longitude);
		campvo.setLattitude(lattitude);
		campdao.update(campvo);

	
		
	}

	
	
//查詢營地資料
	public CampVO findCampByCampId(Integer campId) {
		if(campId!=null) {
			return campdao.findByPrimaryKey(campId);
						
		}else {
			return null;
		}
	
	}


//查詢廠商底下的營地(廠商只能看自己營地)
	
	public Set<CampVO> findCampByCompanyId(Integer companyId){
		List<CampVO> list=campdao.getAll(0);
		Set<CampVO> set=new HashSet<CampVO>();
		for(CampVO item:list) {	
			if(item.getCompanyId()==companyId) {
				set.add(item);
			}
		}
		return set;
	}
	
	


	
	
	
	
	
	
//查詢全部營地
	public List<CampVO> getAllCamp(Integer order){
		
		return campdao.getAll(order);	
	}
	
	
//查詢關鍵字搜尋營地
	public List<CampVO> findCampByKeyWord(String words){
		return campdao.findByKeyWord(words);	
	}

	
	
	
	
	
	
}
=======
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
	
	

>>>>>>> Alice
