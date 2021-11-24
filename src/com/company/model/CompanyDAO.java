package com.company.model;

import java.util.List;

import com.company.model.CompanyVO;

public interface CompanyDAO {
	void add(CompanyVO companyVO);
	void update(CompanyVO companyVO);
	void delete(int companyId);
	CompanyVO findByPK(int companyId);
	List<CompanyVO> getAll();
}
