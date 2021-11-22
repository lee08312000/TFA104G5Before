package camp.service;

import java.sql.Timestamp;
import java.util.List;

import camp.common.ProductVO;
import camp.dao.ProductDAO;
import camp.dao.impl.ProductDAOImpl;





public class ProductService {
	private ProductDAO dao;

	public ProductService() {
		dao = new ProductDAOImpl();
	}

	public ProductVO addProduct(Integer companyId, Integer productTypeId, Integer productStatus,
			String productName, Integer productPrice, String productBrand, Integer productInventory,
			String productDescription, String shoppingInformation, byte[] productPic1, byte[] productPic2,
			byte[] productPic3, Timestamp productLaunchedTime, Integer productCommentedAllnum,
			Integer productCommentAllstar, Integer productSellAllnum) {

		ProductVO ProductVO = new ProductVO();

		ProductVO.setCompanyId(companyId);
		ProductVO.setProductTypeId(productTypeId);
		ProductVO.setProductStatus(productStatus);
		ProductVO.setProductName(productName);
		ProductVO.setProductPrice(productPrice);
		ProductVO.setProductBrand(productBrand);
		ProductVO.setProductInventory(productInventory);
		ProductVO.setProductDescription(productDescription);
		ProductVO.setShoppingInformation(shoppingInformation);
		ProductVO.setProductPic1(productPic1);
		ProductVO.setProductPic2(productPic2);
		ProductVO.setProductPic3(productPic3);
		ProductVO.setProductLaunchedTime(productLaunchedTime);
		ProductVO.setProductCommentedAllnum(productCommentedAllnum);
		ProductVO.setProductCommentAllstar(productCommentAllstar);
		ProductVO.setProductSellAllnum(productSellAllnum);
		dao.insert(ProductVO);

		return ProductVO;
	}

	public ProductVO updateProduct(Integer productId, Integer companyId, Integer productTypeId, Integer productStatus,
			String productName, Integer productPrice, String productBrand, Integer productInventory,
			String productDescription, String shoppingInformation, byte[] productPic1, byte[] productPic2,
			byte[] productPic3, Timestamp productLaunchedTime, Integer productCommentedAllnum,
			Integer productCommentAllstar, Integer productSellAllnum) {

		ProductVO ProductVO = new ProductVO();
		
		ProductVO.setProductId(productId);
		ProductVO.setCompanyId(companyId);
		ProductVO.setProductTypeId(productTypeId);
		ProductVO.setProductStatus(productStatus);
		ProductVO.setProductName(productName);
		ProductVO.setProductPrice(productPrice);
		ProductVO.setProductBrand(productBrand);
		ProductVO.setProductInventory(productInventory);
		ProductVO.setProductDescription(productDescription);
		ProductVO.setShoppingInformation(shoppingInformation);
		ProductVO.setProductPic1(productPic1);
		ProductVO.setProductPic2(productPic2);
		ProductVO.setProductPic3(productPic3);
		ProductVO.setProductLaunchedTime(productLaunchedTime);
		ProductVO.setProductCommentedAllnum(productCommentedAllnum);
		ProductVO.setProductCommentAllstar(productCommentAllstar);
		ProductVO.setProductSellAllnum(productSellAllnum);
		dao.update(ProductVO);

		return ProductVO;
	}

	public void deleteProduct(Integer productId) {
		dao.delete(productId);
	}

	public ProductVO getOneProduct(Integer productId) {
		return dao.findByPrimaryKey(productId);
	}

	public List<ProductVO> getAllProduct() {
		return dao.getAll();
	}
}
