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

public class CampDAOImpl implements CampDAO {
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
<<<<<<< HEAD:src/com/camp/model/CampDAOImpl.java

	// 查詢營地基本資料(動態調整排序條件1.營地上架時間2.熱門排行)兩隻表camp left join camp_order
	private static final String GET_ALL_STMT = "SELECT \r\n"
			+ "    camp.*, ifnull(ranktable.rank_num,9999) as rank_no\r\n" + "FROM\r\n" + "    camp\r\n"
			+ "        LEFT JOIN\r\n" + "    (SELECT \r\n"
			+ "        t.*, (@row_number:=@row_number + 1) AS rank_num\r\n" + "    FROM\r\n" + "        (SELECT \r\n"
			+ "        camp_id,\r\n" + "            (SUM(camp_comment_star) / COUNT(*)) AS 'avg_star',\r\n"
			+ "            COUNT(*) AS 'compl_ordernum'\r\n" + "    FROM\r\n" + "        campingParadise.camp_order\r\n"
			+ "    WHERE\r\n" + "        camp_order_completed_time IS NOT NULL\r\n" + "    GROUP BY camp_id\r\n"
			+ "    ORDER BY compl_ordernum DESC , avg_star DESC) AS t, (SELECT @row_number:=0) AS t2) ranktable USING (camp_id)\r\n"
			+ "order by";

	private static String GET_BY_KEYWORDS = "SELECT  *  FROM camp where camp_name like '%%' ";
	private static final String GET_ONE_STMT = "SELECT  *  FROM camp where camp_Id = ?";
=======
	private static final String GET_ALL_STMT = "SELECT " + CLOUM_FOR_ALL + " FROM camp order by camp_Id";
	private static final String GET_ONE_STMT = "SELECT " +  CLOUM_FOR_ALL + " FROM camp where camp_Id = ?";
	private static final String CAMPLIST = "SELECT " + CLOUM_FOR_ALL
			+ " FROM camp where 1 = 1 and camp_launched_time  between ? and ? and camp_id like '%' ? '%'";
>>>>>>> Alice:src/com/camp/model/CampDAOlmpl.java
	private static final String DELETE = "DELETE FROM camp where camp_Id = ?";
	private static final String UPDATE = "UPDATE camp set company_Id=?,camp_Status=?,camp_description=?,camp_Name=?,camp_Rule=?,camp_Pic_1=?,camp_Pic_2=?,camp_Pic_3=?,camp_Pic_4=?,camp_Pic_5=?,camp_Address=?,camp_Phone=?,certificate_Num=?,certificate_Pic=?,camp_Launched_Time=?,camp_Applied_Launch_Time=?,longitude=?,lattitude=? where camp_Id = ?";
	private static final String ALL_PAGE = "SELECT  * FROM camp where camp_status=? limit ?,?";

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
<<<<<<< HEAD:src/com/camp/model/CampDAOImpl.java
			pstmt.setBigDecimal(17, campVO.getLongitude());
			pstmt.setBigDecimal(18, campVO.getLattitude());
=======
			pstmt.setDouble(17, campVO.getLongitude());
			pstmt.setDouble(18, campVO.getLattitude());
>>>>>>> Alice:src/com/camp/model/CampDAOlmpl.java

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
			pstmt.setBigDecimal(17, campVO.getLongitude());
			pstmt.setBigDecimal(18, campVO.getLattitude());
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
				CampVO.setCampDiscription(rs.getString("camp_description"));
				CampVO.setCampName(rs.getString("camp_name"));
				CampVO.setCampRule(rs.getString("camp_rule"));
				CampVO.setCampPic1(checkBlob(rs.getBlob("camp_Pic_1")));
				CampVO.setCampPic2(checkBlob(rs.getBlob("camp_Pic_2")));
				CampVO.setCampPic3(checkBlob(rs.getBlob("camp_Pic_3")));
				CampVO.setCampPic4(checkBlob(rs.getBlob("camp_Pic_4")));
				CampVO.setCampPic5(checkBlob(rs.getBlob("camp_Pic_5")));
				CampVO.setCampAddress(rs.getString("camp_Address"));
				CampVO.setCampPhone(rs.getString("camp_Phone"));
<<<<<<< HEAD:src/com/camp/model/CampDAOImpl.java
				CampVO.setCertificateNum(rs.getString("certificate_num"));
				CampVO.setCertificatePic(checkBlob(rs.getBlob("certificate_pic")));
				CampVO.setCampLaunchedTime(rs.getTimestamp("camp_launched_time"));
				CampVO.setLongitude(rs.getBigDecimal("longitude"));
				CampVO.setLattitude(rs.getBigDecimal("lattitude"));
				CampVO.setCampAppliedLaunchTime(rs.getTimestamp("camp_applied_launch_time"));

=======
				CampVO.setCertificateNum(rs.getString("certificate_Num"));
				CampVO.setCertificatePic(checkBlob(rs.getBlob("certificate_Pic")));
				CampVO.setCampLaunchedTime(rs.getTimestamp("camp_Launched_Time"));
				CampVO.setCampAppliedLaunchTime(rs.getTimestamp("camp_Applied_Launch_Time"));
				CampVO.setLongitude(rs.getDouble("longitude"));
				CampVO.setLattitude(rs.getDouble("lattitude"));
				CampVO.setCampDiscription(rs.getString("camp_description"));
				CampVO.setCampRule(rs.getString("camp_rule"));
>>>>>>> Alice:src/com/camp/model/CampDAOlmpl.java
			}

		} catch (SQLException se) {
			se.printStackTrace();
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

<<<<<<< HEAD:src/com/camp/model/CampDAOImpl.java
	@Override
	public List<CampVO> getAll(Integer orderby) {
=======
	@Override // 查詢全部營位
	public List<CampVO> getAll() {
>>>>>>> Alice:src/com/camp/model/CampDAOlmpl.java
		List<CampVO> list = new ArrayList<CampVO>();
		CampVO campVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String order = null;
		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			switch (orderby) {
			case 0: // 營地流水號
				order = "camp_id";
				break;
			case 1: // 營地上架時間新->舊
				order = "camp_launched_time desc";
				break;
			case 2: // 營地上架時間舊->新
				order = "camp_launched_time asc";
				break;
			case 3: // 熱門排行
				order = "rank_no asc";
			default: // 營地流水號
				order = "camp_id";
			}

			pstmt = con.prepareStatement(GET_ALL_STMT + " " + order);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				campVO = new CampVO();
				campVO.setCampId(rs.getInt("camp_Id"));
				campVO.setCampName(rs.getString("camp_name"));
				campVO.setCompanyId(rs.getInt("company_Id"));
				campVO.setCampStatus(rs.getInt("camp_Status"));
				campVO.setCampDiscription(rs.getString("camp_description"));
				campVO.setCampName(rs.getString("camp_name"));
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
				campVO.setLongitude(rs.getBigDecimal("longitude"));
				campVO.setLattitude(rs.getBigDecimal("lattitude"));
				campVO.setCampAppliedLaunchTime(rs.getTimestamp("camp_applied_launch_time"));
				list.add(campVO);
			}

		} catch (SQLException se) {
			se.printStackTrace();
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

	@Override
	public List<CampVO> findByKeyWord(String words) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CampVO> list = new ArrayList<CampVO>();
		CampVO campVO = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			StringBuffer str = new StringBuffer(GET_BY_KEYWORDS);
			str = str.insert(44, words);
			pstmt = con.prepareStatement(str.toString());
			rs = pstmt.executeQuery();
			while (rs.next()) {

				campVO = new CampVO();
				campVO.setCampId(rs.getInt("camp_Id"));
				campVO.setCompanyId(rs.getInt("company_Id"));
				campVO.setCampStatus(rs.getInt("camp_Status"));
				campVO.setCampDiscription(rs.getString("camp_description"));
				campVO.setCampName(rs.getString("camp_name"));
				campVO.setCampRule(rs.getString("camp_rule"));
				campVO.setCampPic1(checkBlob(rs.getBlob("camp_Pic_1")));
				campVO.setCampPic2(checkBlob(rs.getBlob("camp_Pic_2")));
				campVO.setCampPic3(checkBlob(rs.getBlob("camp_Pic_3")));
				campVO.setCampPic4(checkBlob(rs.getBlob("camp_Pic_4")));
				campVO.setCampPic5(checkBlob(rs.getBlob("camp_Pic_5")));
				campVO.setCampAddress(rs.getString("camp_Address"));
				campVO.setCampPhone(rs.getString("camp_Phone"));
				campVO.setCertificateNum(rs.getString("certificate_num"));
				campVO.setCertificatePic(checkBlob(rs.getBlob("certificate_pic")));
				campVO.setCampLaunchedTime(rs.getTimestamp("camp_launched_time"));
				campVO.setLongitude(rs.getBigDecimal("longitude"));
				campVO.setLattitude(rs.getBigDecimal("lattitude"));
				campVO.setCampAppliedLaunchTime(rs.getTimestamp("camp_applied_launch_time"));
				list.add(campVO);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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

<<<<<<< HEAD
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
=======
	@Override
	public List<CampVO> getAllByPage(Integer offset, Integer rows,Integer status) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CampVO> list = new ArrayList<CampVO>();
		CampVO campVO = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(ALL_PAGE);
			System.out.println(ALL_PAGE);
			pstmt.setInt(1, status);
			pstmt.setInt(2, offset);
			pstmt.setInt(3, rows);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				campVO = new CampVO();
				campVO.setCampId(rs.getInt("camp_Id"));
				campVO.setCompanyId(rs.getInt("company_Id"));
				campVO.setCampStatus(rs.getInt("camp_Status"));
				campVO.setCampDiscription(rs.getString("camp_description"));
				campVO.setCampName(rs.getString("camp_name"));
>>>>>>> 7890843d354c84c1d315f9810be7b06ed74d70a2
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
<<<<<<< HEAD
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
=======
				campVO.setLongitude(rs.getBigDecimal("longitude"));
				campVO.setLattitude(rs.getBigDecimal("lattitude"));
				campVO.setCampAppliedLaunchTime(rs.getTimestamp("camp_applied_launch_time"));
				list.add(campVO);
			}
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException se) {
			se.printStackTrace();
>>>>>>> 7890843d354c84c1d315f9810be7b06ed74d70a2
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
<<<<<<< HEAD
		return camplist;
	}

=======
		return list;
	}
>>>>>>> 7890843d354c84c1d315f9810be7b06ed74d70a2
}
