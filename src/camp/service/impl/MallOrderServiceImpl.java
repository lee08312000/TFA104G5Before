package camp.service.impl;

import java.sql.Timestamp;
import java.util.List;

import camp.common.MallOrderVO;
import camp.dao.MallOrderDAO;
import camp.dao.impl.MallOrderDAOImpl;
import camp.service.MallOrderService;

public class MallOrderServiceImpl implements MallOrderService{
	
	private MallOrderDAO dao;
	
	public MallOrderServiceImpl() {
		dao = new MallOrderDAOImpl();
	}

	@Override
	public MallOrderVO addMallOrder(Integer companyId, Integer memberId, Integer mailOrderTotalAmount,
			String creditCardNum, String receiverName, String receiverPhone, String receiverAddress) {
		
		MallOrderVO mallOrderVO = new MallOrderVO();
		
		mallOrderVO.setCompanyId(companyId);
		mallOrderVO.setMemberId(memberId);
		mallOrderVO.setMailOrderTotalAmount(mailOrderTotalAmount);
		mallOrderVO.setCreditCardNum(creditCardNum);
		mallOrderVO.setReceiverName(receiverName);
		mallOrderVO.setReceiverPhone(receiverPhone);
		mallOrderVO.setReceiverAddress(receiverAddress);
		dao.insert(mallOrderVO);
		
		return mallOrderVO;
	}

	@Override
	public MallOrderVO updateMallOrder(Integer mallOrderId, Integer companyId, Integer memberId,
			Integer mallOrderStatus, Integer mallOrderDeliveryStatus, Integer mailOrderTotalAmount,
			String creditCardNum, String receiverName, String receiverPhone, String receiverAddress,
			Timestamp mallOrderCompletedTime) {
		
		MallOrderVO mallOrderVO = new MallOrderVO();
		
		mallOrderVO.setCompanyId(companyId);
		mallOrderVO.setMemberId(memberId);
		mallOrderVO.setMallOrderStatus(mallOrderStatus);
		mallOrderVO.setMallOrderDeliveryStatus(mallOrderDeliveryStatus);
		mallOrderVO.setMailOrderTotalAmount(mailOrderTotalAmount);
		mallOrderVO.setCreditCardNum(creditCardNum);
		mallOrderVO.setReceiverName(receiverName);
		mallOrderVO.setReceiverPhone(receiverPhone);
		mallOrderVO.setReceiverAddress(receiverAddress);
		mallOrderVO.setMallOrderCompletedTime(mallOrderCompletedTime);
		mallOrderVO.setMallOrderId(mallOrderId);
		dao.update(mallOrderVO);
		
		return mallOrderVO;
	}

	@Override
	public void deleteMallOrder(Integer mallOrderId) {
		dao.delete(mallOrderId);
	}

	@Override
	public MallOrderVO getOneMallOrder(Integer mallOrderId) {
		return dao.findByPrimaryKey(mallOrderId);
	}

	@Override
	public List<MallOrderVO> getAll() {
		return dao.getAll();
	}

}
