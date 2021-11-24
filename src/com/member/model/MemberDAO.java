package com.member.model;

import java.util.List;

public interface MemberDAO {
	void add(MemberVO memberVO);
	void update(MemberVO memberVO);
	void delete(int memberId);
	MemberVO findByPK(int memberId);
	List<MemberVO> getAll();
}
