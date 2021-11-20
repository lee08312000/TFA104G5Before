package camp.service;

import java.sql.Timestamp;
import java.util.List;

import camp.common.MallOrderVO;

public interface MallOrderService {
	public MallOrderVO addMallOrder(Integer companyId, Integer memberId, Integer mailOrderTotalAmount, String creditCardNum, String receiverName, String receiverPhone, String receiverAddress);
    public MallOrderVO updateMallOrder(Integer mallOrderId ,Integer companyId, Integer memberId, Integer mallOrderStatus, Integer mallOrderDeliveryStatus,Integer mailOrderTotalAmount, String creditCardNum, String receiverName, String receiverPhone, String receiverAddress, Timestamp mallOrderCompletedTime);
    public void deleteMallOrder(Integer mallOrderId);
    public MallOrderVO getOneMallOrder(Integer mallOrderId);
    public List<MallOrderVO> getAll();

}
