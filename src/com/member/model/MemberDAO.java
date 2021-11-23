package com.member.model;

import java.util.List;

public interface MemberDAO {
	void add(MemberVO member);
	void update(MemberVO member);
	void delete(int memberId);
	MemberVO findByPK(int memberId);
	List<MemberVO> getAll();
}
