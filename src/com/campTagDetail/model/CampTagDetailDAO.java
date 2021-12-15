package com.campTagDetail.model;

import java.util.List;

public interface CampTagDetailDAO {

	void insert(CampTagDetailVO campTagDetailVO);

	void update(CampTagDetailVO campTagDetailVO);
	
	void delete(Integer campTagId, Integer campId);

	CampTagDetailVO findByPrimaryKey(Integer campTagId, Integer campId);

	List<CampTagDetailVO> findByCampId(Integer campId);

	List<CampTagDetailVO> getAll();

	void deleteByKey(Integer campId);


}
