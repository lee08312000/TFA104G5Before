package com.camp.model;

import java.util.List;

public interface CampDAO {

	public void insert(CampVO campVO);

	public void update(CampVO campVO);

	public void delete(Integer campId);

	public CampVO findByPrimaryKey(Integer campId);

	public List<CampVO> findByKeyWord(String words);
	
	
	//參數是排列方式
	public List<CampVO> getAll(Integer orderby);
	
	

}
