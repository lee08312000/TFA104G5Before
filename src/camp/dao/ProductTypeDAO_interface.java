package camp.dao;

import java.util.List;

import camp.common.ProductTypeVO;

public interface ProductTypeDAO_interface {

	public void insert(ProductTypeVO ProductTypeVO);
    public void update(ProductTypeVO ProductTypeVO);
    public void delete(Integer productTypeId);
    public ProductTypeVO findByPrimaryKey(Integer productTypeId);
    public List<ProductTypeVO> getAll();
}
