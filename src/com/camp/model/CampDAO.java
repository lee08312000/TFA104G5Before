package com.camp.model;

import java.util.Date;
import java.util.List;

import com.campArea.model.CampAreaVO;

public interface CampDAO {

	public void insert(CampVO campVO);

	public void update(CampVO campVO);

	public void delete(Integer campId);

<<<<<<< HEAD
	public CampVO findByPrimaryKey(Integer campId);

	public List<CampVO> findByKeyWord(String words);
	
	
	//參數是排列方式
	public List<CampVO> getAll(Integer orderby);
	
	
=======
	CampVO findByPrimaryKey(Integer campId);
	
	List<CampVO> camplist(Integer campId, Date startime, Date endtime,String campIdsearchs);
	

	List<CampVO> getAll();
	

>>>>>>> Alice

}
