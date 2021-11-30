package camp.test;

import java.util.List;

import com.product.model.ProductDAO;
import com.product.model.ProductDAOImpl;
import com.product.model.ProductService;
import com.product.model.ProductVO;

public class ProductDAOImplTest {

	public static void main(String[] args) {

//		ProductDAO dao = new ProductDAOImpl();
//		List<ProductVO> list = dao.getProducts(0, 0, 1, 0, 10);
//		
//		for (ProductVO ap : list) {
//			System.out.print(ap.getProductId() + ",");
//			System.out.print(ap.getCompanyId() + ",");
//			System.out.print(ap.getProductTypeId() + ",");
//			System.out.print(ap.getProductStatus() + ",");
//			System.out.print(ap.getProductName() + ",");
//			System.out.print(ap.getProductPrice() + ",");
//			System.out.print(ap.getProductBrand() + ",");
//			System.out.print(ap.getProductInventory() + ",");
//			System.out.print(ap.getProductDescription() + ",");
//			System.out.print(ap.getShoppingInformation() + ",");
//			System.out.print(ap.getProductPic1() + ",");
//			System.out.print(ap.getProductPic2() + ",");
//			System.out.print(ap.getProductPic3() + ",");
//			System.out.print(ap.getProductLaunchedTime() + ",");
//			System.out.print(ap.getProductCommentedAllnum() + ",");
//			System.out.print(ap.getProductCommentAllstar() + ",");			
//			System.out.print(ap.getProductSellAllnum());
//			System.out.println();
//			System.out.println("=============================================");
//		}

		ProductService productSvc = new ProductService();
		List<ProductVO> list = productSvc.getProducts10Random3(2);

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
