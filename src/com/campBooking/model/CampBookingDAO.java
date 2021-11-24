package com.campBooking.model;


import java.util.List;
import java.util.Set;




public interface CampBookingDAO {
	
	public void add(CampBookingVO campBookingVO);
	public void update(CampBookingVO campBookingVO);
	public void delete(Integer campBookingId);
	public CampBookingVO findByPK(Integer campBookingId);
	public Set<CampBookingVO> findByCampId(Integer campId,java.sql.Date date);
	public List<CampBookingVO> getAll();
	

}
