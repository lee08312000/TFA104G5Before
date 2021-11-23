package com.campBooking.model;

import java.util.List;


public interface CampBookingDAO {
	
	public void add(CampBookingVO campBookingVO);
	public void update(CampBookingVO campBookingVO);
	public void delete(Integer campBookingId);
	public CampBookingVO findByPK(Integer campBookingId);
	public List<CampBookingVO> getAll();
	

}
