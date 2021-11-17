package camp.dao;

import java.util.List;

import camp.common.MallOrderDetailVO;

public interface MallOrderDetailDAO {
	public void insert(MallOrderDetailVO mallOrderDetailVO);
    public void update(MallOrderDetailVO mallOrderDetailVO);
    public void delete(Integer mallOrderDetailId);
    public MallOrderDetailVO findByPrimaryKey(Integer mallOrderDetailId);
    public List<MallOrderDetailVO> getAll();
}
