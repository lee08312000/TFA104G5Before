package camp.dao;

import java.util.List;

import camp.common.CampBookingVO;


public interface CampBookingDAO {
	
	public void add(CampBookingVO campBookingVO);
	public void update(CampBookingVO campBookingVO);
	public void delete(Integer campBookingId);
	public CampBookingVO findByPK(Integer campBookingId);
	public List<CampBookingVO> getAll();
	

}
