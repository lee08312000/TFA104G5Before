package com.campTagDetail.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.campTag.model.CampTagDAO;
import com.campTag.model.CampTagDAOlmpl;

public class CampTagDetailService {
	private CampTagDetailDAO camptagdetaildao;

	public CampTagDetailService() {
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
		camptagdetaildao.delete(campTagId, campId);
	}

	
	// 查詢營地標籤明細
	public CampTagDetailVO getCampTagDetail(Integer campTagId, Integer campId) {
		return camptagdetaildao.findByPrimaryKey(campTagId, campId);

	}

	
	// 查詢所有營地標籤明細(管理員)
	public List<CampTagDetailVO> getAllCampTagsDetail() {
		return camptagdetaildao.getAll();
	}

	
	// 查詢這個營地有哪些標籤
	public List<Integer> findCampTagsByCampId(Integer campId) {
		return camptagdetaildao.findByCampId(campId);
	}

	
	// 查詢這個營地有哪些標籤(標籤號碼轉中文)
	public List<String> findCampTagsByCampIdNames(Integer campId) {
		List<Integer> list = camptagdetaildao.findByCampId(campId);
		List<String> strlist = new ArrayList<String>();
		CampTagDAO camptagdao = new CampTagDAOlmpl();
		for (Integer camptagId : list) {
			String camptagName = camptagdao.findByPrimaryKey(camptagId).getCampTagName();
			strlist.add(camptagName);
		}
		return strlist;
	}

	
	// 查詢符合條件的營地(多條件)
	public Set<CampTagDetailVO> findByMultireq(Set<Integer> camptagSet) {
		if (!camptagSet.isEmpty()) {
			return camptagdetaildao.findByMultireq(camptagSet);
		} else {
			return null;
		}

	}

}
