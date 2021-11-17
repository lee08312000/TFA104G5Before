package camp.dao;

import java.util.List;

import camp.common.MallOrderVO;

public interface MallOrderDAO {
	public void insert(MallOrderVO mallOrderVO);
    public void update(MallOrderVO mallOrderVO);
    public void delete(Integer mallOrderId);
    public MallOrderVO findByPrimaryKey(Integer mallOrderId);
    public List<MallOrderVO> getAll();
}
