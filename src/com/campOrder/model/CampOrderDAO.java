package com.campOrder.model;

import java.util.List;
import com.campAreaOrderDetail.model.CampAreaOrderDetailVO;

public interface CampOrderDAO {

	public void add(CampOrderVO campOrderVO, CampAreaOrderDetailVO...campAreaOrderDetailVO);

	public void update(CampOrderVO campOrderVO);

	public void delete(Integer campOrderId);

	public CampOrderVO findByPK(Integer campOrderId);

	public List<CampOrderVO> getAll();

}
