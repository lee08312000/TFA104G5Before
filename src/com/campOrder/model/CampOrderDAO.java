package com.campOrder.model;




import java.util.Date;
import java.util.List;

public interface CampOrderDAO {

	public void add(CampOrderVO campOrderVO);

	public void update(CampOrderVO campOrderVO);

	public void delete(Integer campOrderId);

	public CampOrderVO findByPK(Integer campOrderId);

	public List<CampOrderVO> getAll();

	List<CampOrderVO> findByParams(int statusnum, Date startDate, Date endDate);

}
