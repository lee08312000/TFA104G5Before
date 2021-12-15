package com.campArea.model;

import java.util.List;

public interface CampAreaDAO {
	public void add(CampAreaVO campAreaVO);
	

	public void update(CampAreaVO campAreaVO);

	public void delete(Integer campAreaId);

<<<<<<< HEAD
	public CampAreaVO findByPrimaryKey(Integer campAreaId);

	public List<CampAreaVO> getAll();
=======
	void delete(Integer campAreaId);
	

	CampAreaVO findByPrimaryKey(Integer campAreaId);
	
	List<CampAreaVO> camparealist(Integer campId);

	List<CampAreaVO> getAll();
>>>>>>> Alice

	
}
