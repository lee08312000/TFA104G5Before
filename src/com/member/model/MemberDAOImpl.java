package com.member.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import util.Util;

public class MemberDAOImpl implements MemberDAO {
	private static final String INSERT_STMT = "INSERT INTO company(member_id, member_account_status, member_name, member_account, member_password, memberEmail, memberAddress, memberPhone, memberPic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE member SET memberAccountStatus = ?, memberName = ?, memberAccount = ?, memberPassword = ?, memberEmail = ?, memberAddress = ?, memberPhone = ?, memberPic = ?";
	private static final String DELETE_STMT = "DELETE FROM member WHERE memberId = ?";
	private static final String FIND_BY_PK = "SELECT * FROM member WHERE memberId = ?";
	private static final String GET_ALL = "SELECT * FROM member";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(MemberVO member) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, member.getMemberId());
			pstmt.setInt(2, member.getMemberAccountStatus());
			pstmt.setString(3, member.getMemberName());
			pstmt.setString(4, member.getMemberAccount());
			pstmt.setString(5, member.getMemberPassword());
			pstmt.setString(6, member.getMemberEmail());
			pstmt.setString(7, member.getMemberAddress());
			pstmt.setString(8, member.getMemberPhone());
			pstmt.setBytes(9, member.getMemberPic());


			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(MemberVO member) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, member.getMemberAccountStatus());
			pstmt.setString(2, member.getMemberName());
			pstmt.setString(3, member.getMemberAccount());
			pstmt.setString(4, member.getMemberPassword());
			pstmt.setString(5, member.getMemberEmail());
			pstmt.setString(6, member.getMemberAddress());
			pstmt.setString(7, member.getMemberPhone());
			pstmt.setBytes(8, member.getMemberPic());
			pstmt.setInt(9, member.getMemberId());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(int memberId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, memberId);
			
			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public MemberVO findByPK(int memberId) { //回傳一個員工的物件
		MemberVO member = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery(); //select相關用這個

			while (rs.next()) {
				member = new MemberVO(); //物件建立的動作，建立Employee Bean,準備包裝著從資料庫查詢出來的部門資料
				// emp.setEmpno(empno);設定後直接回傳值回去
				member.setMemberId(rs.getInt("memberId"));
				member.setMemberAccountStatus(rs.getInt("memberAccountStatus"));
				member.setMemberName(rs.getString("memberName"));
				member.setMemberAccount(rs.getString("memberAccount"));
				member.setMemberPassword(rs.getString("memberPassword"));
				member.setMemberEmail(rs.getString("memberEmail"));
				member.setMemberAddress(rs.getString("memberAddress"));
				member.setMemberPhone(rs.getString("memberPhone"));
				member.setMemberPic(rs.getBytes("memberPic"));

			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return member; //不要忘了這個 要替換成迴圈裡的部門物件
	}

	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> memberList = new ArrayList<>();
		MemberVO  member = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				member = new MemberVO();
				member.setMemberId(rs.getInt(1));
				member.setMemberAccountStatus(rs.getInt(2));
				member.setMemberName(rs.getString(3));
				member.setMemberAccount(rs.getString(4));
				member.setMemberPassword(rs.getString(5));
				member.setMemberEmail(rs.getString(6));
				member.setMemberAddress(rs.getString(7));
				member.setMemberPhone(rs.getString(8));
				member.setMemberPic(rs.getBytes(9));
				memberList.add(member);
				
			}

		} catch (SQLException se) {
			se.printStackTrace();
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return memberList;
	}

}
