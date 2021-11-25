package com.campTag.model;

import java.util.List;

public interface CampTagDAO {

	void add(CampTagVO campTagVO);

	CampTagVO findByPrimaryKey(Integer campTagId);

	void delete(Integer campTagId);

	void update(CampTagVO campTagVO);
	
	List<CampTagVO> getAll();
	
	List<CampTagVO> getAllTag();
	

}
