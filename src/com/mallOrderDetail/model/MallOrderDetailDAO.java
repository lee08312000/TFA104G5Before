package com.mallOrderDetail.model;

import java.sql.Connection;
import java.util.List;

public interface MallOrderDetailDAO {
	public void insert(MallOrderDetailVO mallOrderDetailVO);
	public void insert(MallOrderDetailVO mallOrderDetailVO, Connection con);
    public void update(MallOrderDetailVO mallOrderDetailVO);
    public void delete(Integer mallOrderDetailId);
    public MallOrderDetailVO findByPrimaryKey(Integer mallOrderDetailId);
    public List<MallOrderDetailVO> getAll();
}
