package camp.dao;




import java.util.List;

import camp.common.CampOrderVO;

public interface CampOrderDAO {

	public void add(CampOrderVO campOrderVO);

	public void update(CampOrderVO campOrderVO);

	public void delete(Integer campOrderId);

	public CampOrderVO findByPK(Integer campOrderId);

	public List<CampOrderVO> getAll();

}
