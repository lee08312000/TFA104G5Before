package com.admin.model;

import java.util.List;

public interface AdminDAO {
	// 此介面定義對資料庫的相關存取抽象方法
		void add(AdminVO admin);
		void update(AdminVO admin);
		void delete(int adminId);
		AdminVO findByPK(int adminId);
		List<AdminVO> getAll();
}
