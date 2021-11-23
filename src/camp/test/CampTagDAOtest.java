package camp.test;

import com.campTag.model.CampTagDAOlmpl;

public class CampTagDAOtest {

	public static void main(String[] args) {

		CampTagDAOlmpl cad = new CampTagDAOlmpl();

		// 查全部資料
//		CampTagVO ctvo = cad.findByPrimaryKey(3);
//		System.out.println(ctvo.toString());

		// 新增
//		CampTagVO camptag = new CampTagVO();
//		camptag.setCampTagId(15);
//		camptag.setCampTagName("溪流");
//		cad.insert(camptag);
//		System.out.println("新增成功");

		// 修改
//		CampTagVO camptag1 = new CampTagVO();
//		camptag1.setCampTagId(15);
//		camptag1.setCampTagName("海邊");
//		cad.update(camptag1);
//		System.out.println("修改成功");

		// 刪除
		cad.delete(15);
		System.out.println("刪除成功");

	}

}
