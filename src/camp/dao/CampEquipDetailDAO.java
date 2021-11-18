package camp.dao;



import java.util.List;
import java.util.Set;

import camp.common.CampEquipDetailVO;

public interface CampEquipDetailDAO {
	public void add(Set<CampEquipDetailVO> equipSet);
	public void delete(CampEquipDetailVO campEquipDetailVO);
	public CampEquipDetailVO findByPK(CampEquipDetailVO campEquipDetailVO); //尋找這個營地是否有這個標籤
	public Set<CampEquipDetailVO> findByCampId(Integer CampId);
	public Set<CampEquipDetailVO> findByCampEquipId(Integer campEquipId);
	public List<CampEquipDetailVO> getAll();
	
	

}
