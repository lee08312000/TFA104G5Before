package com.camp.model;

import java.util.Date;
import java.util.List;

import com.campArea.model.CampAreaVO;

public interface CampDAO {

	void insert(CampVO empVO);

	void update(CampVO campVO);

	void delete(Integer campId);

	CampVO findByPrimaryKey(Integer campId);
	
	List<CampVO> camplist(Integer campId, Date startime, Date endtime,String campIdsearchs);
	

	List<CampVO> getAll();
	


}
