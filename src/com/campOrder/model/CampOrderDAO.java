package com.campOrder.model;

<<<<<<< HEAD
<<<<<<< HEAD
=======



import java.util.Date;
>>>>>>> Alice
=======
import java.sql.Connection;
>>>>>>> 7890843d354c84c1d315f9810be7b06ed74d70a2
import java.util.List;

import com.campAreaOrderDetail.model.CampAreaOrderDetailVO;


public interface CampOrderDAO {

	public void add(CampOrderVO campOrderVO, CampAreaOrderDetailVO...campAreaOrderDetailVO);

	public void update(CampOrderVO campOrderVO);

	public void delete(Integer campOrderId);

	public CampOrderVO findByPK(Integer campOrderId);

	
	//查詢訂單"多"排序條件，依據0=訂單流水號，1=訂單狀態，2=預計退房日，3=預計入住日，4=訂單評論時間
	public List<CampOrderVO> getAll(Integer...sortmethed);
	
	//尋找熱門營地，依據已1.完成訂單數量 2.平均星星數
	public List<Integer> findhotcamp();
	
	
	
	
	
	
	
	

	
	
	

	List<CampOrderVO> findByParams(int statusnum, Date startDate, Date endDate);

}
