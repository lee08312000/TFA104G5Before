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
	
	
<<<<<<< HEAD
=======
	CampVO findByPrimaryKey(Integer campId);
	
	List<CampVO> camplist(Integer campId, Date startime, Date endtime,String campIdsearchs);
	

	List<CampVO> getAll();
	

>>>>>>> Alice
=======
	//查詢全部營地(分頁模式) offset =略過筆數; rows=顯示筆數   
		public List<CampVO> getAllByPage(Integer offset,Integer rows,Integer status);
	
	
>>>>>>> 7890843d354c84c1d315f9810be7b06ed74d70a2

}
