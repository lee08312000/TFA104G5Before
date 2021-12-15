package com.camp.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CampService {
	private CampDAO campdao;

	public CampService() {
		campdao = new CampDAOImpl();

	}

//新增營地
	public void insert(Integer companyId, Integer campStatus, String campName, String campRule, byte[] campPic1,
			byte[] campPic2, byte[] campPic3, byte[] campPic4, byte[] campPic5, String campAddress, String campPhone,
			String certificateNum, byte[] certificatePic, Timestamp campLaunchedTime, Timestamp campAppliedLaunchTime,
			BigDecimal longitude, BigDecimal lattitude) {

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
	public void update(Integer campId, Integer companyId, Integer campStatus, String campName, String campRule,
			byte[] campPic1, byte[] campPic2, byte[] campPic3, byte[] campPic4, byte[] campPic5, String campAddress,
			String campPhone, String certificateNum, byte[] certificatePic, Timestamp campLaunchedTime,
			Timestamp campAppliedLaunchTime, BigDecimal longitude, BigDecimal lattitude) {

		CampVO campvo = campdao.findByPrimaryKey(campId);
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
		if (campId != null) {
			return campdao.findByPrimaryKey(campId);

		} else {
			return null;
		}

	}

//查詢廠商底下的營地(廠商只能看自己營地)

	public Set<CampVO> findCampByCompanyId(Integer companyId) {
		List<CampVO> list = campdao.getAll(0);
		Set<CampVO> set = new HashSet<CampVO>();
		for (CampVO item : list) {
			if (item.getCompanyId() == companyId) {
				set.add(item);
			}
		}
		return set;
	}

//查詢已上架的全部營地

//	public List<CampVO> getAllCampByStatus(Integer status, Integer order) {
//		List<CampVO> newlist = new ArrayList<CampVO>();
//		List<CampVO> list = campdao.getAll(order);
//		for (CampVO obj : list) {
//
//			if (obj.getCampStatus() == status) {
//
//				newlist.add(obj);
//
//			}
//
//		}
//		return newlist;
//
//	}
	
	
//查詢全部營地(分頁模式)page=請求頁數;row=顯示筆數;status=營地狀態
	public List<CampVO> getAllCampBypage(Integer page,Integer rows,Integer status) {
		Integer offset=rows*page;
		return campdao.getAllByPage(offset,rows,status);

		
	}
	
	

//查詢全部營地
	public List<CampVO> getAllCamp(Integer order) {

		return campdao.getAll(order);
	}

//查詢關鍵字搜尋營地
	public List<CampVO> findCampByKeyWord(String words) {
		return campdao.findByKeyWord(words);
	}

}
