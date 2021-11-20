package camp.test;

import java.util.List;

import camp.common.ProductVO;
import camp.dao.ProductDAO;
import camp.dao.impl.ProductDAOImpl;

public class ProductDAOImplTest {

	public static void main(String[] args) {

		ProductDAO dao = new ProductDAOImpl();
		List<ProductVO> list = dao.getSomeProducts(0, 0, 0, 0);
		
		for (ProductVO ap : list) {
			System.out.print(ap.getProductId() + ",");
			System.out.print(ap.getCompanyId() + ",");
			System.out.print(ap.getProductTypeId() + ",");
			System.out.print(ap.getProductStatus() + ",");
			System.out.print(ap.getProductName() + ",");
			System.out.print(ap.getProductPrice() + ",");
			System.out.print(ap.getProductBrand() + ",");
			System.out.print(ap.getProductInventory() + ",");
			System.out.print(ap.getProductDescription() + ",");
			System.out.print(ap.getShoppingInformation() + ",");
			System.out.print(ap.getProductPic1() + ",");
			System.out.print(ap.getProductPic2() + ",");
			System.out.print(ap.getProductPic3() + ",");
			System.out.print(ap.getProductLaunchedTime() + ",");
			System.out.print(ap.getProductCommentedAllnum() + ",");
			System.out.print(ap.getProductCommentAllstar() + ",");			
			System.out.print(ap.getProductSellAllnum());
			System.out.println();
			System.out.println("=============================================");
		}
	}

}
