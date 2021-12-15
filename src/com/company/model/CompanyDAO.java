package com.company.model;

import com.campTagDetail.model.CampTagDetailVO;

public interface CompanyDAO {

	
		void insert(CompanyVO companyVO );

		void update(CampTagDetailVO campTagDetailVO);
		
		void delete(Integer campTagId, Integer campId);

		CampTagDetailVO findByPrimaryKey(Integer campTagId, Integer campId);

	

}
