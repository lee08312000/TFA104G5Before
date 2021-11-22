package camp.service;

import java.sql.Timestamp;
import java.util.List;

import camp.common.MallOrderDetailVO;
import camp.dao.MallOrderDetailDAO;
import camp.dao.impl.MallOrderDetailDAOImpl;

public class MallOrderDetailService{
	
	private MallOrderDetailDAO dao;
	
	public MallOrderDetailService() {
		dao = new MallOrderDetailDAOImpl();
	}

	public MallOrderDetailVO addMallOrderDetail(Integer mallOrderId, Integer productId, Integer productPurchaseQuantity,
			Integer productPurchasePrice) {
		
		MallOrderDetailVO mallOrderDetailVO = new MallOrderDetailVO();
		
		mallOrderDetailVO.setMallOrderId(mallOrderId);
		mallOrderDetailVO.setProductId(productId);
		mallOrderDetailVO.setProductPurchaseQuantity(productPurchaseQuantity);
		mallOrderDetailVO.setProductPurchasePrice(productPurchasePrice);
		dao.insert(mallOrderDetailVO);
		
		return mallOrderDetailVO;
	}

	public MallOrderDetailVO updateMallOrderDetail(Integer mallOrderDetailId, Integer mallOrderId, Integer productId,
			Integer productPurchaseQuantity, Integer productPurchasePrice, Integer productCommentStar,
			String productComment, Timestamp productCommentTime) {
		
		MallOrderDetailVO mallOrderDetailVO = new MallOrderDetailVO();
		
		mallOrderDetailVO.setMallOrderDetailId(mallOrderDetailId);
		mallOrderDetailVO.setMallOrderId(mallOrderId);
		mallOrderDetailVO.setProductId(productId);
		mallOrderDetailVO.setProductPurchaseQuantity(productPurchaseQuantity);
		mallOrderDetailVO.setProductPurchasePrice(productPurchasePrice);
		mallOrderDetailVO.setProductCommentStar(productCommentStar);
		mallOrderDetailVO.setProductComment(productComment);
		mallOrderDetailVO.setProductCommentTime(productCommentTime);
		dao.update(mallOrderDetailVO);
		
		return mallOrderDetailVO;
	}

	public void deleteMallOrderDetail(Integer mallOrderDetailId) {
		dao.delete(mallOrderDetailId);
	}

	public MallOrderDetailVO getOneMallOrderDetail(Integer mallOrderDetailId) {
		return dao.findByPrimaryKey(mallOrderDetailId);
	}

	public List<MallOrderDetailVO> getAll() {
		return dao.getAll();
	}

}
