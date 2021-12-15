package com.campTagDetail.model;

import java.util.List;
<<<<<<< HEAD
import java.util.Set;

import com.campEquipDetail.model.CampEquipDetailVO;
=======
>>>>>>> Alice

public interface CampTagDetailDAO {

	public void insert(CampTagDetailVO campTagDetailVO);

	public void update(CampTagDetailVO campTagDetailVO);

<<<<<<< HEAD
	public CampTagDetailVO findByPrimaryKey(Integer campTagId, Integer campId);
=======
	void update(CampTagDetailVO campTagDetailVO);
	
	void delete(Integer campTagId, Integer campId);
>>>>>>> Alice

	public Set<CampTagDetailVO> findByMultireq(Set<Integer> camptagSet);//查詢符合條件的營地

<<<<<<< HEAD
	public List<Integer> findByCampId(Integer campId);
	
	public void delete(Integer campTagId, Integer campId);
	
	
	public List<CampTagDetailVO> getAll();
=======
	List<CampTagDetailVO> findByCampId(Integer campId);

	List<CampTagDetailVO> getAll();

	void deleteByKey(Integer campId);

>>>>>>> Alice

}
