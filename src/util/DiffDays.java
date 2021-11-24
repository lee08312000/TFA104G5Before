package util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
//取得兩個日期差，之間的集合(包含頭尾)
public class DiffDays {

	public static List<java.sql.Date> getDates(Date startDate, Date endDate) {
	    List<Date> datesInRange = new ArrayList<>();
	    Calendar calendar = new GregorianCalendar();
	    calendar.setTime(startDate);

	    Calendar endCalendar = new GregorianCalendar();
	    endCalendar.setTime(endDate);
	    endCalendar.add(Calendar.DATE ,+1);
	    while (calendar.before(endCalendar)) {
	       java.util.Date result = calendar.getTime();
	        java.sql.Date sqlresult=new java.sql.Date(result.getTime());
	        datesInRange.add(sqlresult);
	        calendar.add(Calendar.DATE, 1);
	    }
	    return datesInRange;
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		List list=DiffDays.getDates(java.sql.Date.valueOf("2021-11-23"), java.sql.Date.valueOf("2021-11-25"));
		System.out.println(list.toString());
	}
}
