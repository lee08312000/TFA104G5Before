package com.mallOrder.model;

import java.util.List;

import com.cart.model.CartVO;

public interface MallOrderDAO {
	public void insert(MallOrderVO mallOrderVO);
    public void update(MallOrderVO mallOrderVO);
    public void delete(Integer mallOrderId);
    public MallOrderVO findByPrimaryKey(Integer mallOrderId);
    public List<MallOrderVO> getAll();
    public Integer insert(MallOrderVO mallOrderVO, List<CartVO> buyList);
}
