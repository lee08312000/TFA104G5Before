package camp.service.impl;

import java.sql.Timestamp;
import java.util.List;

import camp.common.MallOrderDetailVO;
import camp.dao.MallOrderDetailDAO;
import camp.dao.impl.MallOrderDetailDAOImpl;
import camp.service.MallOrderDetailService;

public class MallOrderDetailServiceImpl implements MallOrderDetailService{
	
	private MallOrderDetailDAO dao;
	
	public MallOrderDetailServiceImpl() {
		dao = new MallOrderDetailDAOImpl();
	}

	@Override
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

	@Override
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

	@Override
	public void deleteMallOrderDetail(Integer mallOrderDetailId) {
		dao.delete(mallOrderDetailId);
	}

	@Override
	public MallOrderDetailVO getOneMallOrderDetail(Integer mallOrderDetailId) {
		return dao.findByPrimaryKey(mallOrderDetailId);
	}

	@Override
	public List<MallOrderDetailVO> getAll() {
		return dao.getAll();
	}

}
