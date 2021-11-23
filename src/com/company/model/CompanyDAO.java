package com.company.model;

import java.util.List;

import com.company.model.CompanyVO;

public interface CompanyDAO {
	void add(CompanyVO company);
	void update(CompanyVO company);
	void delete(int companyId);
	CompanyVO findByPK(int companyId);
	List<CompanyVO> getAll();
}
