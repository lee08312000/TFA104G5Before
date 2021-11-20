package camp.service;

import java.sql.Timestamp;
import java.util.List;

import camp.common.MallOrderDetailVO;

public interface MallOrderDetailService {

	public MallOrderDetailVO addMallOrderDetail(Integer mallOrderId, Integer productId, Integer productPurchaseQuantity, Integer productPurchasePrice);
    public MallOrderDetailVO updateMallOrderDetail(Integer mallOrderDetailId, Integer mallOrderId, Integer productId,
			Integer productPurchaseQuantity, Integer productPurchasePrice, Integer productCommentStar,
			String productComment, Timestamp productCommentTime);
    public void deleteMallOrderDetail(Integer mallOrderDetailId);
    public MallOrderDetailVO getOneMallOrderDetail(Integer mallOrderDetailId);
    public List<MallOrderDetailVO> getAll();
}
