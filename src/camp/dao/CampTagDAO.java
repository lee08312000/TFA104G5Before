package camp.dao;

import camp.common.CampTagVO;

public interface CampTagDAO {

	void insert(CampTagVO campTagVO);

	CampTagVO findByPrimaryKey(Integer campTagId);

	void delete(Integer campTagId);

	void update(CampTagVO campTagVO);

}
