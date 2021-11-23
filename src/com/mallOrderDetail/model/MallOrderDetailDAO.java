package com.mallOrderDetail.model;

import java.util.List;

public interface MallOrderDetailDAO {
	public void insert(MallOrderDetailVO mallOrderDetailVO);
    public void update(MallOrderDetailVO mallOrderDetailVO);
    public void delete(Integer mallOrderDetailId);
    public MallOrderDetailVO findByPrimaryKey(Integer mallOrderDetailId);
    public List<MallOrderDetailVO> getAll();
}
