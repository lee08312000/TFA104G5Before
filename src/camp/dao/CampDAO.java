package camp.dao;

import java.util.List;

import camp.common.CampVO;

public interface CampDAO {

	void insert(CampVO empVO);

	void update(CampVO campVO);

	void delete(Integer campId);

	CampVO findByPrimaryKey(Integer campId);

	List<CampVO> getAll();

}
