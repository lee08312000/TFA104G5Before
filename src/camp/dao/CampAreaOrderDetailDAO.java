package camp.dao;

import java.util.List;

import camp.common.CampAreaOrderDetailVO;

public interface CampAreaOrderDetailDAO {
	public void add(CampAreaOrderDetailVO campAreaOrderDetailVO);
	public void update(CampAreaOrderDetailVO campAreaOrderDetailVO);
	public void delete(Integer campAreaOrderDetailId);
	public CampAreaOrderDetailVO findByPK( Integer campAreaOrderDetailId);
	public List<CampAreaOrderDetailVO> getAll();
	

}
