package camp.dao.impl;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import camp.common.CampTagDetailVO;
import camp.dao.CampTagDetailDAO;

public class CampTagDetailDAOlmpl implements CampTagDetailDAO {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/campingParadise?serverTimezone=Asia/Taipei";
	String userid = "David";
	String passwd = "123456";
	
//	private static DataSource ds = null;
//	static {
//		try {
//			Context ctx = new InitialContext();
//			ds = (DataSource) ctx.lookup("java:comp/env/jdbc/TestDB2");
//		} catch (NamingException e) {
//			e.printStackTrace();
//		}
//	}

	private static final String CLOUM_FOR_INSERT = "camp_Id,camp_Tag_Id";
	private static final String INSERT_STMT = "INSERT INTO camp_tag_detail ("
			+ CLOUM_FOR_INSERT + ") " + "VALUES (?, ?)";
	private static final String GET_ONE_STMT = "SELECT " + CLOUM_FOR_INSERT
			+ " FROM camp_tag_detail where camp_Tag_Id = ? and camp_Id=?";
	private static final String DELETE = "DELETE FROM camp_tag_detail where  camp_Id=? and camp_Tag_Id = ? ";
	private static final String UPDATE = "UPDATE camp_tag_detail set camp_Tag_Id=?,camp_Id=? where camp_Tag_Id = ? and camp_Id=?";

	@Override
	public void insert(CampTagDetailVO campTagDetailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setInt(1, campTagDetailVO.getCampId());
			pstmt.setInt(2, campTagDetailVO.getCampTagId());
			pstmt.executeUpdate();

		
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
	public void update(CampTagDetailVO campTagDetailVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, campTagDetailVO.getCampTagIdNew());
			pstmt.setInt(2, campTagDetailVO.getCampIdNew());
			pstmt.setInt(3, campTagDetailVO.getCampTagId());
			pstmt.setInt(4, campTagDetailVO.getCampId());
			pstmt.executeUpdate();

		
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
	public void delete(Integer campTagId,Integer campId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, campTagId);
			pstmt.setInt(2, campId);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
	
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
	public CampTagDetailVO findByPrimaryKey(Integer campTagId,Integer campId) {

		CampTagDetailVO campTagDetailVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, campTagId);
			pstmt.setInt(2, campId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				
				campTagDetailVO = new CampTagDetailVO();
				campTagDetailVO.setCampId(rs.getInt("camp_Id"));
				campTagDetailVO.setCampTagId(rs.getInt("camp_Tag_Id"));
			}

			
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
		return campTagDetailVO;
	}

	private byte[] checkBlob(Blob blob) throws SQLException {
		int campPic1length = blob == null ? 0 : (int) blob.length();
		blob.free();
		return blob.getBytes(1, campPic1length);

	}
}