package com.company.model;

<<<<<<< HEAD
import java.util.List;

import com.company.model.CompanyVO;

public interface CompanyDAO {
	void add(CompanyVO companyVO);
	void update(CompanyVO companyVO);
	void delete(int companyId);
	CompanyVO findByPK(int companyId);
	List<CompanyVO> getAll();
=======
import com.campTagDetail.model.CampTagDetailVO;

public interface CompanyDAO {

	
		void insert(CompanyVO companyVO );

		void update(CampTagDetailVO campTagDetailVO);
		
		void delete(Integer campTagId, Integer campId);

		CampTagDetailVO findByPrimaryKey(Integer campTagId, Integer campId);

	

>>>>>>> Alice
}
