package com.favoriteCamp.model;

import java.util.List;

public interface FavoriteCampDAO {

	void insert(FavoriteCampVO favoriteCampVO);

	void update(FavoriteCampVO favoriteCampVO);

	void delete(Integer favoriteCampId);

	FavoriteCampVO findByPrimaryKey(Integer favoriteCampId);

	List<FavoriteCampVO> getAll();

}
