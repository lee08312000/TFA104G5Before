package com.campArea.model;

import java.util.List;

public interface CampAreaDAO {

	void insert(CampAreaVO campAreaVO);

	void update(CampAreaVO campAreaVO);

	void delete(Integer campAreaId);

	CampAreaVO findByPrimaryKey(Integer campAreaId);

	List<CampAreaVO> getAll();

}