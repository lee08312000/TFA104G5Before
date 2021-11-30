package com.campTagDetail.model;



public class CampTagDetailService {
	private CampTagDetailDAO  camptagdetaildao;

	public  CampTagDetailService() {
		 camptagdetaildao = new CampTagDetailDAOlmpl();
	}

	// 新增營地標籤明細
	public void insertCampTagDetail(Integer campTagId, Integer campId) {
		

		CampTagDetailVO camptagdetailvo = new CampTagDetailVO();

		camptagdetailvo.setCampTagId(campTagId);
		camptagdetailvo.setCampId(campId);

		camptagdetaildao.insert(camptagdetailvo);

	}



	// 刪除營地標籤明細
	public void deleteCampTagDetail(Integer campTagId, Integer campId) {
		camptagdetaildao.delete(campTagId,campId);
	}

	


	// 查詢營地標籤明細
	public CampTagDetailVO getCampTagDetail(Integer campTagId, Integer campId) {
		return camptagdetaildao.findByPrimaryKey(campTagId,campId);

	}
}

