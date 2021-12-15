package com.campTagDetail.model;

import java.util.List;
<<<<<<< HEAD
import java.util.Set;

import com.campEquipDetail.model.CampEquipDetailVO;
=======
>>>>>>> Alice

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
	
<<<<<<< HEAD
	
	
	//查詢所有營地標籤明細(管理員)
	public List<CampTagDetailVO> getAllCampTagsDetail(){
		return  camptagdetaildao.getAll();
	}
	
	
	//查詢這個營地有哪些標籤
	public List<Integer> findCampTagsByCampId(Integer campId){
		return camptagdetaildao.findByCampId(campId);
		
		
	}
	
	
	//查詢符合條件的營地(多條件)
		public Set<CampTagDetailVO> findByMultireq(Set<Integer> camptagSet) {
			if(!camptagSet.isEmpty()) {
				return camptagdetaildao.findByMultireq(camptagSet);
			}else {
				return null;
			}

		}

	
	
	
	

	
	
	
}

=======
	public List<CampTagDetailVO> findByCampId(Integer campId) {
		return camptagdetaildao.findByCampId(campId);

	}
	
	
	public List<CampTagDetailVO> getAll() {
		return camptagdetaildao.getAll();

	}

	public void update(List<String> updateCampList, Integer campId) {
			camptagdetaildao.deleteByKey(campId);
			
			for(String s :updateCampList) {
				CampTagDetailVO campTagDetailVO = new CampTagDetailVO();
				campTagDetailVO.setCampId(campId);
				campTagDetailVO.setCampTagId(Integer.valueOf(s));
				camptagdetaildao.insert(campTagDetailVO);
			}
	
	}
}



>>>>>>> Alice
