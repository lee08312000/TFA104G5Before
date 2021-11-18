package camp.dao.impl;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import camp.common.CampBookingVO;
import camp.dao.CampBookingDAO;
import util.Util;

public class CampBookingDAOImpl implements CampBookingDAO {
	private static final String INSERT_STMT = "INSERT INTO  camp_booking (camp_id,camp_area_id,date,booking_camp_area_max,booked_camp_area_num,closed_status) VALUES (?,?,?,?,?,?)";
	private static final String UPDATE_STMT = "UPDATE camp_booking  SET camp_id=?,camp_area_id=?,date=?,booking_camp_area_max=?,booked_camp_area_num=?,closed_status=? WHERE camp_booking_id=?";
	private static final String DELETE_STMT = "DELETE FROM camp_booking WHERE camp_booking_id= ?";
	private static final String FIND_BY_PK = "SELECT * FROM camp_booking WHERE camp_booking_id=?";
	private static final String GET_ALL = "SELECT * FROM camp_area_order_detail";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(CampBookingVO campBookingVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(INSERT_STMT);
			pstmt.setInt(1, campBookingVO.getCampId());
			pstmt.setInt(2, campBookingVO.getCampAreaId());
			pstmt.setDate(3, campBookingVO.getDate());
			pstmt.setInt(4, campBookingVO.getBookingCampAreaMax());
			pstmt.setInt(5, campBookingVO.getBookedCampAreaNum());
			pstmt.setString(6, String.valueOf(campBookingVO.getClosedStatus()));

			int suc_row = pstmt.executeUpdate();
			System.out.println("成功更新" + suc_row + "筆");
		} catch (SQLException se) {
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
	public void update(CampBookingVO campBookingVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(UPDATE_STMT);
			pstmt.setInt(1, campBookingVO.getCampId());
			pstmt.setInt(2, campBookingVO.getCampAreaId());
			pstmt.setDate(3, campBookingVO.getDate());
			pstmt.setInt(4, campBookingVO.getBookingCampAreaMax());
			pstmt.setInt(5, campBookingVO.getBookedCampAreaNum());
			pstmt.setInt(6, campBookingVO.getClosedStatus());
			pstmt.setInt(7, campBookingVO.getCampBookingId());
			int suc_row = pstmt.executeUpdate();
			System.out.println("成功更新" + suc_row + "筆");
		} catch (SQLException se) {
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
	public void delete(Integer campBookingId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, campBookingId);
			int suc_row=pstmt.executeUpdate();
			System.out.println("成功刪除" + suc_row + "筆");
		} catch (SQLException se) {
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
	public CampBookingVO findByPK(Integer campBookingId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CampBookingVO campBookingVO = new CampBookingVO();
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, campBookingId);
			
			rs = pstmt.executeQuery();
			while (rs.next()) {
				campBookingVO.setCampBookingId(rs.getInt(1));
				campBookingVO.setCampId(rs.getInt(2));
				campBookingVO.setCampAreaId(rs.getInt(3));
				campBookingVO.setDate(rs.getDate(4));
				campBookingVO.setBookingCampAreaMax(rs.getInt(5));
				campBookingVO.setBookedCampAreaNum(rs.getInt(6));
				campBookingVO.setClosedStatus(rs.getString(7).charAt(0));
			}
		} catch (SQLException se) {
			se.printStackTrace();
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
		return campBookingVO;
	}

	@Override
	public List<CampBookingVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CampBookingVO> list = new ArrayList<CampBookingVO>();
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				CampBookingVO campBookingVO = new CampBookingVO();
				campBookingVO.setCampBookingId(rs.getInt(1));
				campBookingVO.setCampId(rs.getInt(2));
				campBookingVO.setCampAreaId(rs.getInt(3));
				campBookingVO.setDate(rs.getDate(4));
				campBookingVO.setBookingCampAreaMax(rs.getInt(5));
				campBookingVO.setBookedCampAreaNum(rs.getInt(6));
				campBookingVO.setClosedStatus(rs.getString(7).charAt(0));
				list.add(campBookingVO);
			}

		} catch (SQLException se) {
			se.printStackTrace();
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
