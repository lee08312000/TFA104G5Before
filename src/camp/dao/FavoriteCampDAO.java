package camp.dao;

import java.util.List;

import camp.common.FavoriteCampVO;

public interface FavoriteCampDAO {

	void insert(FavoriteCampVO favoriteCampVO);

	void update(FavoriteCampVO favoriteCampVO);

	void delete(Integer favoriteCampId);

	FavoriteCampVO findByPrimaryKey(Integer favoriteCampId);

	List<FavoriteCampVO> getAll();

}
