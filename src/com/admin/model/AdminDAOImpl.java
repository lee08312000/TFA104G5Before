package com.admin.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import util.Util;

public class AdminDAOImpl implements AdminDAO {
	private static final String INSERT_STMT = "INSERT INTO admin(admin_account_status, admin_account, admin_password) VALUES (?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE admin SET admin_account_status = ?, admin_account = ?, admin_password = ? WHERE admin_id = ?";
	private static final String DELETE_STMT = "DELETE FROM admin WHERE admin_id = ?";
	private static final String FIND_BY_PK = "SELECT * FROM admin WHERE admin_id = ?";
	private static final String GET_ALL = "SELECT * FROM admin";
	
	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(AdminVO adminVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, adminVO.getAdminAccountStatus());
			pstmt.setString(2, adminVO.getAdminAccount());
			pstmt.setString(3, adminVO.getAdminPassword());

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
	public void update(AdminVO adminVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, adminVO.getAdminAccountStatus());
			pstmt.setString(2, adminVO.getAdminAccount());
			pstmt.setString(3, adminVO.getAdminPassword());
			pstmt.setInt(4, adminVO.getAdminId());

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
	public void delete(int adminId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, adminId);
			
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
	public AdminVO findByPK(int adminId) { //???????????????????????????
		AdminVO adminVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, adminId);
			rs = pstmt.executeQuery(); //select???????????????

			while (rs.next()) {
				adminVO = new AdminVO(); 
				// ??????????????????????????????Employee Bean,??????????????????????????????????????????????????????
				// emp.setEmpno(empno);??????????????????????????????
				adminVO.setAdminId(rs.getInt("admin_id"));
				adminVO.setAdminAccountStatus(rs.getInt("admin_account_status"));
				adminVO.setAdminAccount(rs.getString("admin_account"));
				adminVO.setAdminPassword(rs.getString("admin_password"));
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
		

		return adminVO; //?????????????????? ????????????????????????????????????
	}

	@Override
	public List<AdminVO> getAll() {
		List<AdminVO> adminList = new ArrayList<>();
		AdminVO adminVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				adminVO = new AdminVO();
				adminVO.setAdminId(rs.getInt("admin_id"));
				adminVO.setAdminAccountStatus(rs.getInt("admin_account_status"));
				adminVO.setAdminAccount(rs.getString("admin_account"));
				adminVO.setAdminPassword(rs.getString("admin_password"));
				adminList.add(adminVO);

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
		return adminList;
	}

//	public static void main(String[] args) {
//	
//	AdminDAOImpl dao = new AdminDAOImpl();
//	
//	// ??????
//	AdminVO adminVO01 = new AdminVO();
//	adminVO01.setAdminId(5);
//	adminVO01.setAdminAccountStatus(1);
//	adminVO01.setAdminAccount("David");
//	adminVO01.setAdminPassword("123456789");
//
//	dao.add(adminVO01);
//	
//	// ??????
//	AdminVO adminVO02 = new AdminVO();
//	adminVO02.setAdminAccountStatus(1);
//	adminVO02.setAdminAccount("Kevin");
//	adminVO02.setAdminPassword("987654321");
//	adminVO02.setAdminId(1);
//	
//	dao.update(adminVO02);
//	
//	//??????
//	dao.delete(3);
//	
//	//??????
//	AdminVO adminVO03 = dao.findByPK(4);
//	System.out.print(adminVO03.getAdminId() + ",");
//	System.out.print(adminVO03.getAdminAccountStatus() + ",");
//	System.out.print(adminVO03.getAdminAccount() + ",");
//	System.out.print(adminVO03.getAdminPassword());
//
//	
//	//????????????
//	List<AdminVO> list = dao.getAll();
//	
//	for (AdminVO test : list) {
//		System.out.print(test.getAdminId() + ",");
//		System.out.print(test.getAdminAccountStatus() + ",");
//		System.out.print(test.getAdminAccount() + ",");
//		System.out.print(test.getAdminPassword());
//		System.out.println();
//
//	}
//
//	}

}


