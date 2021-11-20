package camp.test;

import java.util.List;

import camp.common.CampAreaVO;
import camp.common.CampTagVO;
import camp.common.CampVO;
import camp.common.FavoriteCampVO;
import camp.dao.impl.FavoriteCampDAOlmpl;

public class FavoriteCampDAOtest {

	public static void main(String[] args) {

		FavoriteCampDAOlmpl fcd = new FavoriteCampDAOlmpl();

		// 查全部資料
//		List<FavoriteCampVO> caList = fcd.getAll();
//		for (FavoriteCampVO av : caList) {
//			System.out.println(av.toString());
//				
//		//新增
//		FavoriteCampVO favoritecamp = new FavoriteCampVO();		
//		favoritecamp.setCampId(3);
//		favoritecamp.setMemberId(9);
//		fcd .insert(favoritecamp);	
//		System.out.println("新增成功");
			
		//修改
		FavoriteCampVO favoritecamp1 = new FavoriteCampVO();
		favoritecamp1.setCampId(4); 
		favoritecamp1.setMemberId(10);
		favoritecamp1.setFavoriteCampId(20);
		fcd.update(favoritecamp1);
//		System.out.println("修改成功");
					
		//刪除
		fcd.delete(19);
		System.out.println("刪除成功");
		
		}
	}


