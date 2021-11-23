package com.camp.model;

import java.util.List;

public interface CampDAO {

	void insert(CampVO empVO);

	void update(CampVO campVO);

	void delete(Integer campId);

	CampVO findByPrimaryKey(Integer campId);

	List<CampVO> getAll();

}
