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
	private static final String INSERT_STMT = "INSERT INTO company(member_id, member_account_status, member_name, member_account, member_password, member_email, member_address, member_phone, member_pic) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE member SET member_accountStatus = ?, member_name = ?, member_account = ?, member_password = ?, member_email = ?, member_address = ?, member_phone = ?, member_pic = ?";
	private static final String DELETE_STMT = "DELETE FROM member WHERE member_id = ?";
	private static final String FIND_BY_PK = "SELECT * FROM member WHERE member_id = ?";
	private static final String GET_ALL = "SELECT * FROM member";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, memberVO.getMemberId());
			pstmt.setInt(2, memberVO.getMemberAccountStatus());
			pstmt.setString(3, memberVO.getMemberName());
			pstmt.setString(4, memberVO.getMemberAccount());
			pstmt.setString(5, memberVO.getMemberPassword());
			pstmt.setString(6, memberVO.getMemberEmail());
			pstmt.setString(7, memberVO.getMemberAddress());
			pstmt.setString(8, memberVO.getMemberPhone());
			pstmt.setBytes(9, memberVO.getMemberPic());


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
	public void update(MemberVO memberVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, memberVO.getMemberAccountStatus());
			pstmt.setString(2, memberVO.getMemberName());
			pstmt.setString(3, memberVO.getMemberAccount());
			pstmt.setString(4, memberVO.getMemberPassword());
			pstmt.setString(5, memberVO.getMemberEmail());
			pstmt.setString(6, memberVO.getMemberAddress());
			pstmt.setString(7, memberVO.getMemberPhone());
			pstmt.setBytes(8, memberVO.getMemberPic());
			pstmt.setInt(9, memberVO.getMemberId());

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
		MemberVO memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, memberId);
			rs = pstmt.executeQuery(); //select相關用這個

			while (rs.next()) {
				memberVO = new MemberVO(); //物件建立的動作，建立Employee Bean,準備包裝著從資料庫查詢出來的部門資料
				// emp.setEmpno(empno);設定後直接回傳值回去
				memberVO.setMemberId(rs.getInt("member_id"));
				memberVO.setMemberAccountStatus(rs.getInt("member_account_status"));
				memberVO.setMemberName(rs.getString("member_name"));
				memberVO.setMemberAccount(rs.getString("member_account"));
				memberVO.setMemberPassword(rs.getString("member_password"));
				memberVO.setMemberEmail(rs.getString("member_email"));
				memberVO.setMemberAddress(rs.getString("member_address"));
				memberVO.setMemberPhone(rs.getString("member_phone"));
				memberVO.setMemberPic(rs.getBytes("member_pic"));

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

		return memberVO; //不要忘了這個 要替換成迴圈裡的部門物件
	}

	@Override
	public List<MemberVO> getAll() {
		List<MemberVO> memberList = new ArrayList<>();
		MemberVO  memberVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				memberVO = new MemberVO();
				memberVO.setMemberId(rs.getInt("member_id"));
				memberVO.setMemberAccountStatus(rs.getInt("member_account_status"));
				memberVO.setMemberName(rs.getString("member_name"));
				memberVO.setMemberAccount(rs.getString("member_account"));
				memberVO.setMemberPassword(rs.getString("member_password"));
				memberVO.setMemberEmail(rs.getString("member_email"));
				memberVO.setMemberAddress(rs.getString("member_address"));
				memberVO.setMemberPhone(rs.getString("member_phone"));
				memberVO.setMemberPic(rs.getBytes("member_pic"));
				memberList.add(memberVO);
				
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
	
	
	
	
//	public static void main(String[] args) {
//	
//	ProductReportVO productReportVO = new ProductReportVO();
//	ProductReportDAO dao = new ProductReportDAOImpl();
//	// insert 測試
//	
//	productReportVO.setMemberId(1);
//	productReportVO.setProductId(4);
//	productReportVO.setReportReason("太醜了!!!!");
//	
//	dao.insert(productReportVO);
	
	// delete 測試
//	dao.delete(2);
	
	// update 測試
//	productReportVO.setMemberId(2);
//	productReportVO.setProductId(2);
//	productReportVO.setReportReason("lol");
//	productReportVO.setReportStatus(1);
//	productReportVO.setProductReportId(3);
//	
//	dao.update(productReportVO);

	// findByPrimaryKey 測試
//	productReportVO = dao.findByPrimaryKey(4);
//	
//	System.out.println(productReportVO.getProductReportId());
//	System.out.println(productReportVO.getMemberId());
//	System.out.println(productReportVO.getProductId());
//	System.out.println(productReportVO.getReportTime());
//	System.out.println(productReportVO.getReportReason());
//	System.out.println(productReportVO.getReportStatus());
	
	// getAll 測試
//	List<ProductReportVO> list = dao.getAll();
//	
//	for (ProductReportVO p : list) {
//		System.out.println(p.getProductReportId());
//		System.out.println(p.getMemberId());
//		System.out.println(p.getProductId());
//		System.out.println(p.getReportTime());
//		System.out.println(p.getReportReason());
//		System.out.println(p.getReportStatus());
//		System.out.println("========================");
//	}
//	
//}

}
