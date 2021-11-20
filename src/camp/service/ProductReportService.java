package camp.service;

import java.util.List;

import camp.common.ProductReportVO;

public interface ProductReportService {
	
	public ProductReportVO addProductReport(Integer memberId, Integer productId, String reportReason);
	public ProductReportVO updateProductReport(Integer productReportId, Integer memberId, Integer productId, String reportReason, Integer reportStatus);
	public void deleteProductReport(Integer productReportId);
    public ProductReportVO getOneProductReport(Integer productReportId);
    public List<ProductReportVO> getAll();

}
