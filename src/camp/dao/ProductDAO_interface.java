package camp.dao;

import java.util.List;

import camp.common.ProductVO;

public interface ProductDAO_interface {
	public void insert(ProductVO ProductVO);
    public void update(ProductVO ProductVO);
    public void delete(Integer productId);
    public ProductVO findByPrimaryKey(Integer productId);
    public List<ProductVO> getAll();
}
