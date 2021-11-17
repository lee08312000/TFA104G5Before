package productReport.dao;

import java.util.List;

import productReport.common.ProductReportVO;

public interface ProductReportDAO {

	public void insert(ProductReportVO productReportVO);
	public void delete(Integer productReportId);
    public void update(ProductReportVO productReportVO);
    public ProductReportVO findByPrimaryKey(Integer productReportId);
    public List<ProductReportVO> getAll();
}
