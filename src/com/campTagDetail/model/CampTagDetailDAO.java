package com.campTagDetail.model;

public interface CampTagDetailDAO {

	void insert(CampTagDetailVO campTagDetailVO);

	void update(CampTagDetailVO campTagDetailVO);
	
	void delete(Integer campTagId, Integer campId);

	CampTagDetailVO findByPrimaryKey(Integer campTagId, Integer campId);


}
