package com.campBooking.model;


import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;



public class CampBookingService {

	private CampBookingDAO bookdao;

	CampBookingService() {
		bookdao = new CampBookingDAOImpl();
	}

//新增公休日某個日期(廠商)	確認要新增的公休日是否有人訂位，否則新增成功

	public Boolean update(Integer campId, Date date) {
		if (campId != null && date != null) {
			Set<CampBookingVO> set = bookdao.findByCampId(campId, date);
			Iterator it = set.iterator();
			while (it.hasNext()) {
				CampBookingVO booking = (CampBookingVO) it.next();
				if (booking.getBookedCampAreaNum() - booking.getBookingCampAreaMax() <= 0) {
					System.out.println("此日期已有人預約，請確認訂單");
					return false;
				}
			}
			while (it.hasNext()) {
				CampBookingVO booking = (CampBookingVO) it.next();
				booking.setClosedStatus('1'); //char值要轉型
				bookdao.update(booking);
			}
			System.out.println("新增公休日成功");
			return true;
		}
		System.out.println("輸入正確參數");
		return false;
	}

//查詢否個營地某一天某一個日期某一個營位的空位狀態
	public CampBookingVO findByPK(Integer campBookingId) {
		if(campBookingId!=null) {
			 CampBookingVO	campBookingVO=bookdao.findByPK(campBookingId);	
			return campBookingVO;
		}
		return null;
	}
	
	
//拿取全部空位的資訊
	public List<CampBookingVO> getAll() {
		return bookdao.getAll();
	}

}
