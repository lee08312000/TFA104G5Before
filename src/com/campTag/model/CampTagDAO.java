package com.campTag.model;

public interface CampTagDAO {

	void insert(CampTagVO campTagVO);

	CampTagVO findByPrimaryKey(Integer campTagId);

	void delete(Integer campTagId);

	void update(CampTagVO campTagVO);

}
