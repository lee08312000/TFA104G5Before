package camp.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.campArea.model.CampAreaDAOlmpl;
import com.campOrder.model.CampOrderDAOImpl;
import com.campOrder.model.CampOrderVO;
public class CampOrderDAOtest {

	public static void main(String[] args) throws ParseException {

		CampOrderDAOImpl cad = new CampOrderDAOImpl();

		// 查全部資料
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date startDate = sdf.parse("2021-10-22 00:00:00");
		Date endDate = sdf.parse("2021-11-02 00:00:00");
		List<CampOrderVO> caList = cad.findByParams(2,startDate,endDate  );
		for (CampOrderVO av : caList) {
			System.out.println(av.toString());
		}

		// 新增
//		CampAreaVO camparea = new CampAreaVO();
//		camparea.setCampId(1);
//		camparea.setCampAreaName("5區");
//		camparea.setCampAreaMax(5);
//		camparea.setWeekdayPrice(1000);
//		camparea.setHolidayPrice(1300);
//		camparea.setCapitationMax(2);
//		camparea.setPerCapitationFee(200);
//		cad.insert(camparea);
		System.out.println("新增成功");
		
		//修改
//		CampAreaVO camparea2 = new CampAreaVO();
//		camparea2.setCampId(1);
//		camparea2.setCampAreaName("4區");
//		camparea2.setCampAreaMax(6);
//		camparea2.setWeekdayPrice(2000);
//		camparea2.setHolidayPrice(1000);
//		camparea2.setCapitationMax(3);
//		camparea2.setPerCapitationFee(100);
//		camparea2.setCampAreaId(16);
//		cad.update(camparea2);
//		System.out.println("修改成功");

		//刪除
		//cad.delete(23);
		System.out.println("刪除成功");

	}
}

