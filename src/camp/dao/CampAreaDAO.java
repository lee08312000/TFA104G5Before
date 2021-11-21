package camp.dao;

import java.util.List;

import camp.common.CampAreaVO;

public interface CampAreaDAO {

	void insert(CampAreaVO campAreaVO);

	void update(CampAreaVO campAreaVO);

	void delete(Integer campAreaId);

	CampAreaVO findByPrimaryKey(Integer campAreaId);

	List<CampAreaVO> getAll();

}
