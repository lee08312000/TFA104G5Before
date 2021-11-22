package camp.service;

import java.util.List;

import camp.common.FavoriteProdoctVO;
import camp.dao.FavoriteProdoctDAO;
import camp.dao.impl.FavoriteProdoctDAOImpl;



public class FavoriteProdoctService {
	private FavoriteProdoctDAO dao;

	public FavoriteProdoctService() {
		dao = new FavoriteProdoctDAOImpl();
	}
	
	public FavoriteProdoctVO addFavoriteProdoct(Integer memberId, Integer productId) {

		FavoriteProdoctVO FavoriteProdoctVO = new FavoriteProdoctVO();

		FavoriteProdoctVO.setMemberId(memberId);
		FavoriteProdoctVO.setProductId(productId);
		
		dao.insert(FavoriteProdoctVO);

		return FavoriteProdoctVO;
	}

	public FavoriteProdoctVO updateFavoriteProdoct(Integer favoriteProductId, Integer memberId, Integer productId) {

		FavoriteProdoctVO FavoriteProdoctVO = new FavoriteProdoctVO();
		
		FavoriteProdoctVO.setFavoriteProductId(favoriteProductId);
		FavoriteProdoctVO.setMemberId(memberId);
		FavoriteProdoctVO.setProductId(productId);
		dao.update(FavoriteProdoctVO);
		
		return FavoriteProdoctVO;
	}

	public void deleteFavoriteProdoct(Integer favoriteProductId) {
		dao.delete(favoriteProductId);
	}

	public FavoriteProdoctVO getOneFavoriteProdoct(Integer favoriteProductId) {
		return dao.findByPrimaryKey(favoriteProductId);
	}

	public List<FavoriteProdoctVO> getAllFavoriteProdoct() {
		return dao.getAll();
	}
}
