package com.member.model;

import java.util.List;

public class MemberService {
	private MemberDAO dao;
	
	public MemberService() {
		dao = new MemberDAOImpl();
	}
	
	public MemberVO addMember(Integer memberId, Integer memberAccountStatus, String memberName, 
			String memberAccount, String memberPassword, String memberEmail, String memberAddress, 
			String memberPhone, byte[] memberPic) {
		
		MemberVO MemberVO = new MemberVO();
		
		MemberVO.setMemberId(memberId);
		MemberVO.setMemberAccountStatus(memberAccountStatus);
		MemberVO.setMemberName(memberName);
		MemberVO.setMemberAccount(memberAccount);
		MemberVO.setMemberPassword(memberPassword);
		MemberVO.setMemberEmail(memberEmail);
		MemberVO.setMemberAddress(memberAddress);
		MemberVO.setMemberPhone(memberPhone);
		MemberVO.setMemberPic(memberPic);
		
		return MemberVO;
	}	
	
	public MemberVO updateMember(Integer memberId, Integer memberAccountStatus, String memberName, 
			String memberAccount, String memberPassword, String memberEmail, String memberAddress, 
			String memberPhone, byte[] memberPic) {
		
		MemberVO MemberVO = new MemberVO();
		
		MemberVO.setMemberId(memberId);
		MemberVO.setMemberAccountStatus(memberAccountStatus);
		MemberVO.setMemberName(memberName);
		MemberVO.setMemberAccount(memberAccount);
		MemberVO.setMemberPassword(memberPassword);
		MemberVO.setMemberEmail(memberEmail);
		MemberVO.setMemberAddress(memberAddress);
		MemberVO.setMemberPhone(memberPhone);
		MemberVO.setMemberPic(memberPic);
		
		return MemberVO;
	}	
	
	public void deleteMember(Integer memberId) {
		dao.delete(memberId);
	}
	
	public MemberVO getOneMember(Integer memberId) {
		return dao.findByPK(memberId);
	}
	
	public List<MemberVO> getAllMember() {
		return dao.getAll();
	}
	
}
