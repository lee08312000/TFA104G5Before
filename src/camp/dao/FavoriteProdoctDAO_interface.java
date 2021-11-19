package camp.dao;

import java.util.List;

import camp.common.FavoriteProdoctVO;



public interface FavoriteProdoctDAO_interface {
	
	 public void insert(FavoriteProdoctVO FavoriteProdoctVO);
     public void update(FavoriteProdoctVO FavoriteProdoctVO);
     public void delete(Integer favoriteProductId);
     public FavoriteProdoctVO findByPrimaryKey(Integer favoriteProductId);
     public List<FavoriteProdoctVO> getAll();
	
	
}
