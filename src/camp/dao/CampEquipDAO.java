package camp.dao;



import java.util.List;

import camp.common.CampEquipVO;

public interface CampEquipDAO {
	
		void add(CampEquipVO campEquipVO);
		void update(CampEquipVO campEquipVO);//名稱改正之類的
		void delete(Integer  campEquipId);
		CampEquipVO findByPK(Integer  campEquipId);
		List<CampEquipVO> getAll();
	
	
	

}
