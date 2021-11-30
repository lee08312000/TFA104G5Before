package com.campArea.model;

import java.util.ArrayList;
import java.util.List;

public class CampAreaService {
	
	private CampAreaDAO campareadao;

	public CampAreaService() {
		campareadao = new CampAreaDAOImpl();
	}

//新增一個營位	
	public void addCampArea(Integer campId, String campAreaName, Integer campAreaMax, Integer weekdayPrice,
			Integer holidayPrice, Integer capitationMax, Integer perCapitationFee, byte[] campAreaPic) {
		CampAreaVO campAreaVO = new CampAreaVO();
		campAreaVO.setCampId(campId);
		campAreaVO.setCampAreaName(campAreaName);
		campAreaVO.setCampAreaMax(campAreaMax);
		campAreaVO.setWeekdayPrice(weekdayPrice);
		campAreaVO.setHolidayPrice(holidayPrice);
		campAreaVO.setCapitationMax(capitationMax);
		campAreaVO.setPerCapitationFee(perCapitationFee);
		campAreaVO.setCampAreaPic(campAreaPic);

		campareadao.add(campAreaVO);

	}

//更新營位資訊	
	public void updateCampArea(Integer campAreaId, Integer campId, String campAreaName, Integer campAreaMax,
			Integer weekdayPrice, Integer holidayPrice, Integer capitationMax, Integer perCapitationFee,
			byte[] campAreaPic) {

		CampAreaVO campAreaVO = campareadao.findByPrimaryKey(campAreaId);
		campAreaVO.setCampId(campId);
		campAreaVO.setCampAreaName(campAreaName);
		campAreaVO.setCampAreaMax(campAreaMax);
		campAreaVO.setWeekdayPrice(weekdayPrice);
		campAreaVO.setHolidayPrice(holidayPrice);
		campAreaVO.setCapitationMax(capitationMax);
		campAreaVO.setPerCapitationFee(perCapitationFee);
		campAreaVO.setCampAreaPic(campAreaPic);

		campareadao.update(campAreaVO);

	}

//刪除營位資料
	public void deleteCampArea(Integer campAreaId) {
		if (campAreaId != null) {
			campareadao.delete(campAreaId);
		}
	}

//查詢一個營位資訊
	public CampAreaVO findCampAreaByCampAreaId(Integer campAreaId) {
		if (campAreaId != null) {
			return campareadao.findByPrimaryKey(campAreaId);

		} else {
			return null;
		}

	}

	public List<CampAreaVO> getAllCampArea() {
		return campareadao.getAll();

	}

//查詢這個營地的所有營位資訊

	public List<CampAreaVO> findCampAreaByCampId(Integer campId) {
		if (campId != null) {
			List<CampAreaVO> alllist = campareadao.getAll();
			List<CampAreaVO> selelist = new ArrayList<CampAreaVO>();
			for (CampAreaVO ob : alllist) {
				if (ob.getCampId() == campId) {
					selelist.add(ob);
				}

			}

			return selelist;
		} else {
			return null;
		}

	}

}
