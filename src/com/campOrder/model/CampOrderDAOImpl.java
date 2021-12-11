package com.campOrder.model;



import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import util.Util;

public class CampOrderDAOImpl implements CampOrderDAO {
	private static final String INSERT_STMT = "INSERT INTO camp_order(camp_id, member_id, camp_order_status, camp_order_total_amount, camp_check_out_date, camp_check_in_date, credit_card_num,payer_name,payer_phone,camp_order_confirmed_time,camp_order_completed_time,camp_comment_star,camp_comment,camp_order_comment_time) VALUES (?, ?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?)";
	private static final String UPDATE_STMT = "UPDATE camp_order SET camp_id = ?, member_id = ?, camp_order_status = ?, camp_order_total_amount = ?, camp_check_out_date= ?, camp_check_in_date = ? ,credit_card_num= ? ,payer_name= ? ,payer_phone=?,camp_order_confirmed_time=?,camp_order_completed_time=?,camp_comment_star=?,camp_comment=?,camp_order_comment_time=? WHERE camp_order_id = ?";

	private static final String DELETE_ORDER = "DELETE FROM camp_order WHERE camp_order_id = ?";
	private static final String DELETE_ORDERDETAIL = "DELETE FROM camp_order_detail WHERE camp_order_id = ?";

	private static final String FIND_BY_PK = "SELECT * FROM camp_order WHERE camp_order_id= ?";
	private static final String GET_ALL = "SELECT * FROM camp_order";
	private static final String FIND_BY_PARAMS = "SELECT * FROM camp_order where  camp_order_confirmed_time >=? and camp_order_confirmed_time <= ? and camp_order_status=? ";
	private static final String FIND_BY_PARAMS_NO_STATUS = "SELECT * FROM camp_order where  camp_order_confirmed_time >=? and camp_order_confirmed_time <= ? ";
	
	private static DataSource ds = null;
	static {
		try {
			Context ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/David");
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException | NamingException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(CampOrderVO campOrderVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, campOrderVO.getCampId());
			pstmt.setInt(2, campOrderVO.getMemberId());
			pstmt.setInt(3, campOrderVO.getCampOrderStatus());
			pstmt.setInt(4, campOrderVO.getCampOrderTotalAmount());
			pstmt.setDate(5, campOrderVO.getCampCheckOutDate());
			pstmt.setDate(6, campOrderVO.getCampCheckInDate());
			pstmt.setString(7, campOrderVO.getCreditCardNum());
			pstmt.setString(8, campOrderVO.getPayerName());
			pstmt.setString(9, campOrderVO.getPayerPhone());
			pstmt.setTimestamp(10, campOrderVO.getCampOrderConfirmedTime());
			pstmt.setTimestamp(11, campOrderVO.getCampOrderCompletedTime());
			pstmt.setInt(12, campOrderVO.getCampCommentStar());
			pstmt.setString(13, campOrderVO.getCampComment());
			pstmt.setTimestamp(14, campOrderVO.getCampOrderCommentTime());
			pstmt.executeUpdate();

		} catch (Exception se) {
			se.printStackTrace();

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
	public void update(CampOrderVO campOrderVO) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(UPDATE_STMT);

			pstmt.setInt(1, campOrderVO.getMemberId());
			pstmt.setInt(2, campOrderVO.getCampOrderStatus());
			pstmt.setInt(3, campOrderVO.getCampOrderTotalAmount());
			pstmt.setDate(4, campOrderVO.getCampCheckOutDate());
			pstmt.setDate(5, campOrderVO.getCampCheckInDate());
			pstmt.setString(6, campOrderVO.getCreditCardNum());
			pstmt.setString(7, campOrderVO.getPayerName());
			pstmt.setString(8, campOrderVO.getPayerPhone());
			pstmt.setTimestamp(9, campOrderVO.getCampOrderConfirmedTime());
			pstmt.setTimestamp(10, campOrderVO.getCampOrderCompletedTime());
			pstmt.setInt(11, campOrderVO.getCampCommentStar());
			pstmt.setString(12, campOrderVO.getCampComment());
			pstmt.setTimestamp(13, campOrderVO.getCampOrderCommentTime());
			pstmt.setInt(14, campOrderVO.getCampId());

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
	public void delete(Integer campOrderId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			con = ds.getConnection();
			con.setAutoCommit(false);
			pstmt = con.prepareStatement(DELETE_ORDERDETAIL);
			pstmt.setInt(1, campOrderId);
			pstmt.executeUpdate();

			pstmt = con.prepareStatement(DELETE_ORDER);
			pstmt.setInt(1, campOrderId);
			pstmt.executeUpdate();
			con.commit();
			con.setAutoCommit(true);
		} catch (SQLException se) {
			try {
				con.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			se.printStackTrace();
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
	public CampOrderVO findByPK(Integer campOrderId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CampOrderVO campOrderVO = null;
		try {

			con = ds.getConnection();
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, campOrderId);
			rs = pstmt.executeQuery();
			campOrderVO = new CampOrderVO();
			while (rs.next()) {
				campOrderVO.setCampOrderId(rs.getInt(1));
				campOrderVO.setCampId(rs.getInt(2));
				campOrderVO.setMemberId(rs.getInt(3));
				campOrderVO.setCampOrderStatus(rs.getInt(4));
				campOrderVO.setCampOrderTotalAmount(rs.getInt(5));
				campOrderVO.setCampCheckOutDate(rs.getDate(6));
				campOrderVO.setCampCheckInDate(rs.getDate(7));
				campOrderVO.setCreditCardNum(rs.getString(8));
				campOrderVO.setPayerName(rs.getString(9));
				campOrderVO.setPayerPhone(rs.getString(10));
				campOrderVO.setCampOrderConfirmedTime(rs.getTimestamp(11));
				campOrderVO.setCampOrderCompletedTime(rs.getTimestamp(12));
				campOrderVO.setCampCommentStar(rs.getInt(13));
				campOrderVO.setCampComment(rs.getString(14));
				campOrderVO.setCampOrderCommentTime(rs.getTimestamp(15));
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

		return campOrderVO;
	}
	
	@Override
	public List<CampOrderVO> findByParams(int statusnum,Date startDate,Date endDate) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CampOrderVO> list = new ArrayList<>();
		try {
			con = ds.getConnection();
			String sql= FIND_BY_PARAMS;
			if (statusnum == -1) {
				sql = FIND_BY_PARAMS_NO_STATUS;
			}
			pstmt = con.prepareStatement(sql);
			java.sql.Date startSqlDate = new java.sql.Date(startDate.getTime());
			pstmt.setDate(1, startSqlDate);
			java.sql.Date endSqlDate = new java.sql.Date(endDate.getTime());
			pstmt.setDate(2, endSqlDate);
			if (statusnum != -1) {
			  pstmt.setInt(3, statusnum);
			}
			
			CampOrderVO campOrderVO = null;
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				campOrderVO = new CampOrderVO();
				campOrderVO.setCampOrderId(rs.getInt(1));
				campOrderVO.setCampId(rs.getInt(2));
				campOrderVO.setMemberId(rs.getInt(3));
				campOrderVO.setCampOrderStatus(rs.getInt(4));
				campOrderVO.setCampOrderTotalAmount(rs.getInt(5));
				campOrderVO.setCampCheckOutDate(rs.getDate(6));
				campOrderVO.setCampCheckInDate(rs.getDate(7));
				campOrderVO.setCreditCardNum(rs.getString(8));
				campOrderVO.setPayerName(rs.getString(9));
				campOrderVO.setPayerPhone(rs.getString(10));
				campOrderVO.setCampOrderConfirmedTime(rs.getTimestamp(11));
				campOrderVO.setCampOrderCompletedTime(rs.getTimestamp(12));
				campOrderVO.setCampCommentStar(rs.getInt(13));
				campOrderVO.setCampComment(rs.getString(14));
				campOrderVO.setCampOrderCommentTime(rs.getTimestamp(15));
				list.add(campOrderVO);
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

		return list;
	}

	@Override
	public List<CampOrderVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CampOrderVO campOrderVO = null;
		List<CampOrderVO> list = new ArrayList<>();
		try {
			con = ds.getConnection();
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				campOrderVO = new CampOrderVO();
				campOrderVO.setCampOrderId(rs.getInt(1));
				campOrderVO.setCampId(rs.getInt(2));
				campOrderVO.setMemberId(rs.getInt(3));
				campOrderVO.setCampOrderStatus(rs.getInt(4));
				campOrderVO.setCampOrderTotalAmount(rs.getInt(5));
				campOrderVO.setCampCheckOutDate(rs.getDate(6));
				campOrderVO.setCampCheckInDate(rs.getDate(7));
				campOrderVO.setCreditCardNum(rs.getString(8));
				campOrderVO.setPayerName(rs.getString(9));
				campOrderVO.setPayerPhone(rs.getString(10));
				campOrderVO.setCampOrderConfirmedTime(rs.getTimestamp(11));
				campOrderVO.setCampOrderCompletedTime(rs.getTimestamp(12));
				campOrderVO.setCampCommentStar(rs.getInt(13));
				campOrderVO.setCampComment(rs.getString(14));
				campOrderVO.setCampOrderCommentTime(rs.getTimestamp(15));
				list.add(campOrderVO);
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

		return list;
	}

}
