package com.company.model;

import com.campTagDetail.model.CampTagDetailVO;

public class CompanyDAO {

	public static void main(String[] args) {
		void insert(CompanyVO companyVO );

		void update(CampTagDetailVO campTagDetailVO);
		
		void delete(Integer campTagId, Integer campId);

		CampTagDetailVO findByPrimaryKey(Integer campTagId, Integer campId);

	}

}
