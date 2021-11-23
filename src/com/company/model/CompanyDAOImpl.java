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
	public void add(CompanyVO company) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, company.getCompanyId());
			pstmt.setInt(2, company.getCompanyStatus());
			pstmt.setString(3, company.getHeadName());
			pstmt.setString(4, company.getCompanyName());
			pstmt.setString(5, company.getCompanyAccount());
			pstmt.setString(6, company.getCompanyPassword());
			pstmt.setString(7, company.getCompanyEmail());
			pstmt.setString(8, company.getCompanyTel());
			pstmt.setString(9, company.getCompanyBankAccount());
			pstmt.setString(10, company.getCompanyAddress());
			pstmt.setTimestamp(11, company.getCompanyRegisterTime());

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
	public void update(CompanyVO company) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, company.getCompanyStatus());
			pstmt.setString(2, company.getHeadName());
			pstmt.setString(3, company.getCompanyName());
			pstmt.setString(4, company.getCompanyAccount());
			pstmt.setString(5, company.getCompanyPassword());
			pstmt.setString(6, company.getCompanyEmail());
			pstmt.setString(7, company.getCompanyTel());
			pstmt.setString(8, company.getCompanyBankAccount());
			pstmt.setString(9, company.getCompanyAddress());
			pstmt.setTimestamp(10, company.getCompanyRegisterTime());
			pstmt.setInt(11, company.getCompanyId());

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
		CompanyVO company = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, companyId);
			rs = pstmt.executeQuery(); //select相關用這個

			while (rs.next()) {
				company = new CompanyVO(); //物件建立的動作，建立Employee Bean,準備包裝著從資料庫查詢出來的部門資料
				// emp.setEmpno(empno);設定後直接回傳值回去
				company.setCompanyId(rs.getInt("companyId"));
				company.setCompanyStatus(rs.getInt("companyStatus"));
				company.setHeadName(rs.getString("headName"));
				company.setCompanyName(rs.getString("companyName"));
				company.setCompanyAccount(rs.getString("companyAccount"));
				company.setCompanyPassword(rs.getString("companyPassword"));
				company.setCompanyEmail(rs.getString("companyEmail"));
				company.setCompanyTel(rs.getString("companyTel"));
				company.setCompanyBankAccount(rs.getString("companyBankAccount"));
				company.setCompanyAddress(rs.getString("companyAddress"));
				company.setCompanyRegisterTime(rs.getTimestamp("companyRegisterTime"));
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

		return company; //不要忘了這個 要替換成迴圈裡的部門物件
	}

	@Override
	public List<CompanyVO> getAll() {
		List<CompanyVO> companyList = new ArrayList<>();
		CompanyVO company = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				company = new CompanyVO();
				company.setCompanyId(rs.getInt("companyId"));
				company.setCompanyStatus(rs.getInt("companyStatus"));
				company.setHeadName(rs.getString("headName"));
				company.setCompanyName(rs.getString("companyName"));
				company.setCompanyAccount(rs.getString("companyAccount"));
				company.setCompanyPassword(rs.getString("companyPassword"));
				company.setCompanyEmail(rs.getString("companyEmail"));
				company.setCompanyTel(rs.getString("companyTel"));
				company.setCompanyBankAccount(rs.getString("companyBankAccount"));
				company.setCompanyAddress(rs.getString("companyAddress"));
				company.setCompanyRegisterTime(rs.getTimestamp("companyRegisterTime"));
				companyList.add(company);
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

