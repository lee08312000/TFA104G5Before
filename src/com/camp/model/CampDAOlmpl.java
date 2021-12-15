package com.camp.model;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

public class CampDAOlmpl implements CampDAO {
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

	private static final String CLOUM_FOR_INSERT = "company_Id,camp_Status,camp_description,camp_Name,camp_Rule,camp_Pic_1,camp_Pic_2,camp_Pic_3,camp_Pic_4,camp_Pic_5,camp_Address,camp_Phone,certificate_Num,certificate_Pic,camp_Launched_Time,camp_Applied_Launch_Time,longitude,lattitude";
	private static final String CLOUM_FOR_ALL = "camp_Id," + CLOUM_FOR_INSERT;
	private static final String INSERT_STMT = "INSERT INTO camp (" + CLOUM_FOR_INSERT + ") "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT " + CLOUM_FOR_ALL + " FROM camp order by camp_Id";
	private static final String GET_ONE_STMT = "SELECT " +  CLOUM_FOR_ALL + " FROM camp where camp_Id = ?";
	private static final String CAMPLIST = "SELECT " + CLOUM_FOR_ALL
			+ " FROM camp where 1 = 1 and camp_launched_time  between ? and ? and camp_id like '%' ? '%'";
	private static final String DELETE = "DELETE FROM camp where camp_Id = ?";
	private static final String UPDATE = "UPDATE camp set company_Id=?,camp_Status=?,camp_description=?,camp_Name=?,camp_Rule=?,camp_Pic_1=?,camp_Pic_2=?,camp_Pic_3=?,camp_Pic_4=?,camp_Pic_5=?,camp_Address=?,camp_Phone=?,certificate_Num=?,certificate_Pic=?,camp_Launched_Time=?,camp_Applied_Launch_Time=?,longitude=?,lattitude=? where camp_Id = ?";

	@Override // 新增營地資料
	public void insert(CampVO campVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, campVO.getCompanyId());
			pstmt.setInt(2, campVO.getCampStatus());
			pstmt.setString(3, campVO.getCampName());
			pstmt.setString(4, campVO.getCampDiscription());
			pstmt.setString(5, campVO.getCampRule());
			if (campVO.getCampPic1() != null) {
				pstmt.setBlob(6, new SerialBlob(campVO.getCampPic1()));
			} else {
				pstmt.setNull(6, java.sql.Types.BLOB);
			}
			if (campVO.getCampPic2() != null) {
				pstmt.setBlob(7, new SerialBlob(campVO.getCampPic2()));
			} else {
				pstmt.setNull(7, java.sql.Types.BLOB);
			}
			if (campVO.getCampPic3() != null) {
				pstmt.setBlob(8, new SerialBlob(campVO.getCampPic3()));
			} else {
				pstmt.setNull(8, java.sql.Types.BLOB);
			}
			if (campVO.getCampPic4() != null) {
				pstmt.setBlob(9, new SerialBlob(campVO.getCampPic4()));
			} else {
				pstmt.setNull(9, java.sql.Types.BLOB);
			}
			if (campVO.getCampPic5() != null) {
				pstmt.setBlob(10, new SerialBlob(campVO.getCampPic5()));
			} else {
				pstmt.setNull(10, java.sql.Types.BLOB);
			}
			pstmt.setString(11, campVO.getCampAddress());
			pstmt.setString(12, campVO.getCampPhone());
			pstmt.setString(13, campVO.getCertificateNum());
			if (campVO.getCampPic1() != null) {
				pstmt.setBlob(14, new SerialBlob(campVO.getCertificatePic()));
			} else {
				pstmt.setNull(14, java.sql.Types.BLOB);
			}
			pstmt.setTimestamp(15, campVO.getCampLaunchedTime());
			pstmt.setTimestamp(16, campVO.getCampAppliedLaunchTime());
			pstmt.setDouble(17, campVO.getLongitude());
			pstmt.setDouble(18, campVO.getLattitude());

			pstmt.executeUpdate();

		} catch (SQLException se) {
			se.printStackTrace();
			throw new RuntimeException("A database error occured. " + se.getMessage());

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

	@Override // 更新營地資料
	public void update(CampVO campVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setInt(1, campVO.getCompanyId());
			pstmt.setInt(2, campVO.getCampStatus());
			pstmt.setString(3, campVO.getCampDiscription());
			pstmt.setString(4, campVO.getCampName());
			pstmt.setString(5, campVO.getCampRule());
			if (campVO.getCampPic1() != null) {
				pstmt.setBlob(6, new SerialBlob(campVO.getCampPic1()));
			} else {
				pstmt.setNull(6, java.sql.Types.BLOB);
			}
			if (campVO.getCampPic2() != null) {
				pstmt.setBlob(7, new SerialBlob(campVO.getCampPic2()));
			} else {
				pstmt.setNull(7, java.sql.Types.BLOB);
			}
			if (campVO.getCampPic1() != null) {
				pstmt.setBlob(8, new SerialBlob(campVO.getCampPic3()));
			} else {
				pstmt.setNull(8, java.sql.Types.BLOB);
			}
			if (campVO.getCampPic1() != null) {
				pstmt.setBlob(9, new SerialBlob(campVO.getCampPic4()));
			} else {
				pstmt.setNull(9, java.sql.Types.BLOB);
			}

			if (campVO.getCampPic5() != null) {
				pstmt.setBlob(10, new SerialBlob(campVO.getCampPic5()));
			} else {
				pstmt.setNull(10, java.sql.Types.BLOB);
			}
			pstmt.setString(11, campVO.getCampAddress());
			pstmt.setString(12, campVO.getCampPhone());
			pstmt.setString(13, campVO.getCertificateNum());
			if (campVO.getCertificatePic() != null) {
				pstmt.setBlob(14, new SerialBlob(campVO.getCertificatePic()));
			} else {
				pstmt.setNull(14, java.sql.Types.BLOB);
			}

			pstmt.setTimestamp(15, campVO.getCampLaunchedTime());
			pstmt.setTimestamp(16, campVO.getCampAppliedLaunchTime());
			pstmt.setDouble(17, campVO.getLongitude());
			pstmt.setDouble(18, campVO.getLattitude());
			pstmt.setInt(19, campVO.getCampId());
			pstmt.executeUpdate();

		} catch (Exception se) {
			se.printStackTrace();
			throw new RuntimeException("A database error occured. " + se.getMessage());

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

	@Override // 刪除營地資料
	public void delete(Integer campId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, campId);

			pstmt.executeUpdate();

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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

	@Override // 查詢單筆營地資料
	public CampVO findByPrimaryKey(Integer campId) {

		CampVO CampVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, campId);

			rs = pstmt.executeQuery();

			while (rs.next()) {

				CampVO = new CampVO();
				CampVO.setCampId(rs.getInt("camp_Id"));
				CampVO.setCampName(rs.getString("camp_name"));
				CampVO.setCompanyId(rs.getInt("company_Id"));
				CampVO.setCampStatus(rs.getInt("camp_Status"));
				CampVO.setCampPic1(checkBlob(rs.getBlob("camp_Pic_1")));
				CampVO.setCampPic2(checkBlob(rs.getBlob("camp_Pic_2")));
				CampVO.setCampPic3(checkBlob(rs.getBlob("camp_Pic_3")));
				CampVO.setCampPic4(checkBlob(rs.getBlob("camp_Pic_4")));
				CampVO.setCampPic5(checkBlob(rs.getBlob("camp_Pic_5")));
				CampVO.setCampAddress(rs.getString("camp_Address"));
				CampVO.setCampPhone(rs.getString("camp_Phone"));
				CampVO.setCertificateNum(rs.getString("certificate_Num"));
				CampVO.setCertificatePic(checkBlob(rs.getBlob("certificate_Pic")));
				CampVO.setCampLaunchedTime(rs.getTimestamp("camp_Launched_Time"));
				CampVO.setCampAppliedLaunchTime(rs.getTimestamp("camp_Applied_Launch_Time"));
				CampVO.setLongitude(rs.getDouble("longitude"));
				CampVO.setLattitude(rs.getDouble("lattitude"));
				CampVO.setCampDiscription(rs.getString("camp_description"));
				CampVO.setCampRule(rs.getString("camp_rule"));
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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
		return CampVO;
	}

	private byte[] checkBlob(Blob blob) throws SQLException {
		int campPic1length = blob == null ? 0 : (int) blob.length();
		byte[] b = null;
		if (blob != null) {
			try {
				b = blob.getBytes(1, campPic1length);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {

				blob.free();
			}
		}
		return b;

	}

	@Override // 查詢全部營位
	public List<CampVO> getAll() {
		List<CampVO> list = new ArrayList<CampVO>();
		CampVO campVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {

				campVO = new CampVO();
				campVO.setCampId(rs.getInt("camp_Id"));
				campVO.setCampName(rs.getString("camp_name"));
				campVO.setCompanyId(rs.getInt("company_Id"));
				campVO.setCampStatus(rs.getInt("camp_Status"));
				campVO.setCampPic1(checkBlob(rs.getBlob("camp_Pic_1")));
				campVO.setCampPic2(checkBlob(rs.getBlob("camp_Pic_2")));
				campVO.setCampPic3(checkBlob(rs.getBlob("camp_Pic_3")));
				campVO.setCampPic4(checkBlob(rs.getBlob("camp_Pic_4")));
				campVO.setCampPic5(checkBlob(rs.getBlob("camp_Pic_5")));
				campVO.setCampAddress(rs.getString("camp_Address"));
				campVO.setCampPhone(rs.getString("camp_Phone"));
				campVO.setCertificateNum(rs.getString("certificate_Num"));
				campVO.setCertificatePic(checkBlob(rs.getBlob("certificate_Pic")));
				campVO.setCampLaunchedTime(rs.getTimestamp("camp_Launched_Time"));
				campVO.setCampAppliedLaunchTime(rs.getTimestamp("camp_Applied_Launch_Time"));
				campVO.setLongitude(rs.getDouble("longitude"));
				campVO.setLattitude(rs.getDouble("lattitude"));
				list.add(campVO); // Store the row in the list
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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
		return list;
	}

	@Override // 依營位狀態查詢
	public List<CampVO> camplist(Integer campId, Date startime, Date endtime, String campIdsearch) {
		List<CampVO> camplist = new ArrayList<CampVO>();
		CampVO campVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);

			StringBuilder sb = new StringBuilder(CAMPLIST);

			// CAMPLIST+camp_status=字串相加
			if (campId != 3) {
				sb.append(" and camp_status = ?");
			}
			pstmt = con.prepareStatement(sb.toString());

			// 依日期區間查詢營地
			if (campId == 3) {
				pstmt.setDate(1, new java.sql.Date(startime.getTime()));
				pstmt.setDate(2, new java.sql.Date(endtime.getTime()));
				pstmt.setString(3, campIdsearch);

			} else {
				pstmt.setDate(1,new java.sql.Date(startime.getTime()));
				pstmt.setDate(2,new java.sql.Date(endtime.getTime()));
				pstmt.setString(3,campIdsearch);
				pstmt.setInt(4,campId);
			}

			rs = pstmt.executeQuery();

			while (rs.next()) {

				campVO = new CampVO();
				campVO.setCampId(rs.getInt("camp_Id"));
				campVO.setCompanyId(rs.getInt("company_Id"));
				campVO.setCampName(rs.getString("camp_name"));
				campVO.setCampStatus(rs.getInt("camp_Status"));
				campVO.setCampPic1(checkBlob(rs.getBlob("camp_Pic_1")));
				campVO.setCampPic2(checkBlob(rs.getBlob("camp_Pic_2")));
				campVO.setCampPic3(checkBlob(rs.getBlob("camp_Pic_3")));
				campVO.setCampPic4(checkBlob(rs.getBlob("camp_Pic_4")));
				campVO.setCampPic5(checkBlob(rs.getBlob("camp_Pic_5")));
				campVO.setCampAddress(rs.getString("camp_Address"));
				campVO.setCampPhone(rs.getString("camp_Phone"));
				campVO.setCertificateNum(rs.getString("certificate_Num"));
				campVO.setCertificatePic(checkBlob(rs.getBlob("certificate_Pic")));
				campVO.setCampLaunchedTime(rs.getTimestamp("camp_Launched_Time"));
				campVO.setCampAppliedLaunchTime(rs.getTimestamp("camp_Applied_Launch_Time"));
				campVO.setLongitude(rs.getDouble("longitude"));
				campVO.setLattitude(rs.getDouble("lattitude"));
				campVO.setCampRule(rs.getString("camp_rule"));
				campVO.setCampDiscription(rs.getString("camp_description"));

				camplist.add(campVO); // Store the row in the list
			}

		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. " + se.getMessage());

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
		return camplist;
	}

}
