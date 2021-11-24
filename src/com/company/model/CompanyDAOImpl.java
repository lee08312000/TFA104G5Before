package com.company.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import util.Util;

public class CompanyDAOImpl implements CompanyDAO {
	private static final String INSERT_STMT = "INSERT INTO company(company_id, company_status, head_name, company_name, company_account, company_password, company_email, company_tel, company_bank_account, company_address, company_register_time) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STMT = "UPDATE company SET company_status = ?, head_name = ?, company_name = ?, company_account = ?, company_password = ?, company_email = ?, company_tel = ?, company_bank_account = ?, company_address = ?, company_register_time = ?, WHERE company_id = ?";
	private static final String DELETE_STMT = "DELETE FROM company WHERE company_id = ?";
	private static final String FIND_BY_PK = "SELECT * FROM company WHERE company_id = ?";
	private static final String GET_ALL = "SELECT * FROM company";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(CompanyVO companyVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, companyVO.getCompanyId());
			pstmt.setInt(2, companyVO.getCompanyStatus());
			pstmt.setString(3, companyVO.getHeadName());
			pstmt.setString(4, companyVO.getCompanyName());
			pstmt.setString(5, companyVO.getCompanyAccount());
			pstmt.setString(6, companyVO.getCompanyPassword());
			pstmt.setString(7, companyVO.getCompanyEmail());
			pstmt.setString(8, companyVO.getCompanyTel());
			pstmt.setString(9, companyVO.getCompanyBankAccount());
			pstmt.setString(10, companyVO.getCompanyAddress());
			pstmt.setTimestamp(11, companyVO.getCompanyRegisterTime());

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
	public void update(CompanyVO companyVO) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, companyVO.getCompanyStatus());
			pstmt.setString(2, companyVO.getHeadName());
			pstmt.setString(3, companyVO.getCompanyName());
			pstmt.setString(4, companyVO.getCompanyAccount());
			pstmt.setString(5, companyVO.getCompanyPassword());
			pstmt.setString(6, companyVO.getCompanyEmail());
			pstmt.setString(7, companyVO.getCompanyTel());
			pstmt.setString(8, companyVO.getCompanyBankAccount());
			pstmt.setString(9, companyVO.getCompanyAddress());
			pstmt.setTimestamp(10, companyVO.getCompanyRegisterTime());
			pstmt.setInt(11, companyVO.getCompanyId());

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
	public void delete(int companyId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);

			pstmt.setInt(1, companyId);
			
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
	public CompanyVO findByPK(int companyId) { //回傳一個員工的物件
		CompanyVO companyVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, companyId);
			rs = pstmt.executeQuery(); //select相關用這個

			while (rs.next()) {
				companyVO = new CompanyVO(); //物件建立的動作，建立Employee Bean,準備包裝著從資料庫查詢出來的部門資料
				// emp.setEmpno(empno);設定後直接回傳值回去
				companyVO.setCompanyId(rs.getInt("companyId"));
				companyVO.setCompanyStatus(rs.getInt("companyStatus"));
				companyVO.setHeadName(rs.getString("headName"));
				companyVO.setCompanyName(rs.getString("companyName"));
				companyVO.setCompanyAccount(rs.getString("companyAccount"));
				companyVO.setCompanyPassword(rs.getString("companyPassword"));
				companyVO.setCompanyEmail(rs.getString("companyEmail"));
				companyVO.setCompanyTel(rs.getString("companyTel"));
				companyVO.setCompanyBankAccount(rs.getString("companyBankAccount"));
				companyVO.setCompanyAddress(rs.getString("companyAddress"));
				companyVO.setCompanyRegisterTime(rs.getTimestamp("companyRegisterTime"));
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

		return companyVO; //不要忘了這個 要替換成迴圈裡的部門物件
	}

	@Override
	public List<CompanyVO> getAll() {
		List<CompanyVO> companyList = new ArrayList<>();
		CompanyVO companyVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				companyVO = new CompanyVO();
				companyVO.setCompanyId(rs.getInt("companyId"));
				companyVO.setCompanyStatus(rs.getInt("companyStatus"));
				companyVO.setHeadName(rs.getString("headName"));
				companyVO.setCompanyName(rs.getString("companyName"));
				companyVO.setCompanyAccount(rs.getString("companyAccount"));
				companyVO.setCompanyPassword(rs.getString("companyPassword"));
				companyVO.setCompanyEmail(rs.getString("companyEmail"));
				companyVO.setCompanyTel(rs.getString("companyTel"));
				companyVO.setCompanyBankAccount(rs.getString("companyBankAccount"));
				companyVO.setCompanyAddress(rs.getString("companyAddress"));
				companyVO.setCompanyRegisterTime(rs.getTimestamp("companyRegisterTime"));
				companyList.add(companyVO);
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
		return companyList;
	}

}

