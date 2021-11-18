package camp.dao.impl;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import camp.common.CampEquipDetailVO;
import camp.dao.CampEquipDetailDAO;
import util.Util;

public class CampEquipDetailDAOImpl implements CampEquipDetailDAO {
	private static final String INSERT_STMT = "INSERT INTO  camp_equip_detail( camp_equip_id,camp_id) VALUES (?,?)";
	private static final String DELETE_STMT = "DELETE FROM camp_equip_detail WHERE camp_equip_id= ? and camp_id=?";
	private static final String FIND_BY_PK = "SELECT * FROM camp_equip_detail WHERE camp_equip_id= ? and camp_id=?";
	private static final String FIND_BY_CampId = "SELECT * FROM camp_equip_detail WHERE  camp_id=?";
	private static final String FIND_BY_CampEquipIdId = "SELECT * FROM camp_equip_detail WHERE  camp_equip_id=?";
	private static final String GET_ALL = "SELECT * FROM camp_equip_detail ORDER BY camp_id";

	static {
		try {
			Class.forName(Util.DRIVER);
		} catch (ClassNotFoundException ce) {
			ce.printStackTrace();
		}
	}

	@Override
	public void add(Set<CampEquipDetailVO> equipSet) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			for (CampEquipDetailVO item : equipSet) {
				pstmt = con.prepareStatement(INSERT_STMT);
				pstmt.setInt(1, item.getCampEquipId());
				pstmt.setInt(2, item.getCampId());
				int suc_row = pstmt.executeUpdate();
				System.out.println("成功更新" + suc_row + "筆");
			}
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
	public void delete(CampEquipDetailVO campEquipDetailVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(DELETE_STMT);
			pstmt.setInt(1, campEquipDetailVO.getCampEquipId());
			pstmt.setInt(2, campEquipDetailVO.getCampId());
			int suc_row = pstmt.executeUpdate();
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
	public CampEquipDetailVO findByPK(CampEquipDetailVO campEquipDetailVO) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CampEquipDetailVO campEquipDetailVOfind=null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);	
			pstmt = con.prepareStatement(FIND_BY_PK);
			pstmt.setInt(1, campEquipDetailVO.getCampEquipId());
			pstmt.setInt(2, campEquipDetailVO.getCampId());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				campEquipDetailVOfind = new CampEquipDetailVO();
				campEquipDetailVOfind.setCampEquipId(rs.getInt(1));
				campEquipDetailVOfind.setCampId(rs.getInt(2));
			}
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
		return campEquipDetailVOfind;
	}
		
	@Override
	public Set<CampEquipDetailVO> findByCampEquipId(Integer campEquipId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Set<CampEquipDetailVO> set = new LinkedHashSet<CampEquipDetailVO>();
		CampEquipDetailVO campEquipDetailVO = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_CampEquipIdId);
			pstmt.setInt(1, campEquipId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				campEquipDetailVO = new CampEquipDetailVO();
				campEquipDetailVO.setCampEquipId(rs.getInt(1));
				campEquipDetailVO.setCampId(rs.getInt(2));
				set.add(campEquipDetailVO);
			}
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
		return set;
	}
		
		

	
	@Override
	public Set<CampEquipDetailVO> findByCampId(Integer campId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Set<CampEquipDetailVO> set = new LinkedHashSet<CampEquipDetailVO>();
		CampEquipDetailVO campEquipDetailVO = null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(FIND_BY_CampId);
			pstmt.setInt(1, campId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				campEquipDetailVO = new CampEquipDetailVO();
				campEquipDetailVO.setCampEquipId(rs.getInt(1));
				campEquipDetailVO.setCampId(rs.getInt(2));
				set.add(campEquipDetailVO);
			}
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
		return set;
	}

	@Override
	public List<CampEquipDetailVO> getAll() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CampEquipDetailVO> list = new ArrayList<CampEquipDetailVO>();
		CampEquipDetailVO campEquipDetailVO=null;
		try {
			con = DriverManager.getConnection(Util.URL, Util.USER, Util.PASSWORD);
			pstmt = con.prepareStatement(GET_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				campEquipDetailVO = new CampEquipDetailVO();
				campEquipDetailVO.setCampEquipId(rs.getInt(1));
				campEquipDetailVO.setCampId(rs.getInt(2));
				list.add(campEquipDetailVO);
			}

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
		return list;
	}

	

	

}
