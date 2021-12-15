package com.campOrder.model;

<<<<<<< HEAD
=======



import java.util.Date;
>>>>>>> Alice
import java.util.List;

import com.campAreaOrderDetail.model.CampAreaOrderDetailVO;

public interface CampOrderDAO {

	public void add(CampOrderVO campOrderVO, CampAreaOrderDetailVO...campAreaOrderDetailVO);

	public void update(CampOrderVO campOrderVO);

	public void delete(Integer campOrderId);

	public CampOrderVO findByPK(Integer campOrderId);

	public List<CampOrderVO> getAll();
	
	//尋找熱門營地，依據已1.完成訂單數量 2.平均星星數
	public List<Integer> findhotcamp();
	
	
	
	
	
	
	
	

	
	
	

	List<CampOrderVO> findByParams(int statusnum, Date startDate, Date endDate);

}
