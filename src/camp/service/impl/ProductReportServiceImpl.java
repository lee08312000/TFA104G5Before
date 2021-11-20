package camp.service.impl;

import java.util.List;

import camp.common.ProductReportVO;
import camp.dao.ProductReportDAO;
import camp.dao.impl.ProductReportDAOImpl;
import camp.service.ProductReportService;

public class ProductReportServiceImpl implements ProductReportService{
	
	private ProductReportDAO dao;
	
	public ProductReportServiceImpl() {
		dao = new ProductReportDAOImpl();
	}

	@Override
	public ProductReportVO addProductReport(Integer memberId, Integer productId, String reportReason) {
		
		ProductReportVO productReportVO = new ProductReportVO();
		
		productReportVO.setMemberId(memberId);
		productReportVO.setProductId(productId);
		productReportVO.setReportReason(reportReason);
		
		dao.insert(productReportVO);
		return productReportVO;
	}

	@Override
	public ProductReportVO updateProductReport(Integer productReportId, Integer memberId, Integer productId,
			String reportReason, Integer reportStatus) {
		
		ProductReportVO productReportVO = new ProductReportVO();
		
		productReportVO.setMemberId(memberId);
		productReportVO.setProductId(productId);
		productReportVO.setReportReason(reportReason);
		productReportVO.setReportStatus(reportStatus);
		productReportVO.setProductReportId(productReportId);
		
		dao.update(productReportVO);
		return productReportVO;
	}

	@Override
	public void deleteProductReport(Integer productReportId) {
		dao.delete(productReportId);
	}

	@Override
	public ProductReportVO getOneProductReport(Integer productReportId) {
		return dao.findByPrimaryKey(productReportId);
	}

	@Override
	public List<ProductReportVO> getAll() {
		return dao.getAll();
	}

	

}
