package Main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import member.JdbcConnectionUtil;

public class subscriptionDAO {
	private JdbcConnectionUtil util;
	private Connection con = null;
	private PreparedStatement pstmt = null; // 쿼리문사용을위한
	private ResultSet rs = null; // 셀렉트문의 결과는 Resultset으로 옴
	String sql=null;
	
	public subscriptionDAO() {
		util = JdbcConnectionUtil.getInstance();
	}

	public Object[][] selectSub(subscriptionVo subVo) {
		
		List<subscriptionVo> result = new ArrayList<>();
		Object[][] sContents = null;

		try {
			con = util.getConnection();
			System.out.println("접속성공!");

//			sql = "SELECT a.title, a.fee, a.category "
//					+ "FROM subscription a, SPENDING b "
//					+ "WHERE a.sid=b.sid AND a.category=1";
			
			sql = "SELECT a.CATEGORY, a.TITLE, a.FEE FROM SUBSCRIPTION a, SPENDING b WHERE a.SID=b.SID AND a.CATEGORY=1";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				subVo = new subscriptionVo(rs.getString("category"), rs.getString("TITLE"), rs.getInt("FEE"));
				result.add(subVo);
			}

			sContents = new Object[result.size()][3];
			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 3; j++) {
					sContents[i][j] = result.get(i).getCategory();
					sContents[i][++j] = result.get(i).getTitle();
					sContents[i][++j] = result.get(i).getFee();
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
	         if (rs != null) {
		            rs = null;
		         }
		         if (pstmt != null) {
		            pstmt = null;
		         }
		         if (con != null) {
			            con = null;
			         }
		      }
		return sContents;

	}
	
	
	public Object[][] selectLiv(subscriptionVo subVo) {
	
		List<subscriptionVo> result = new ArrayList<>();
		Object[][] lContents = null;

		try {
			con = util.getConnection();
			System.out.println("접속성공!");

			sql = "SELECT a.CATEGORY, a.TITLE, a.FEE FROM SUBSCRIPTION a, SPENDING b WHERE a.SID=b.SID AND a.CATEGORY=2";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				subVo = new subscriptionVo(rs.getString("category"), rs.getString("TITLE"),
						rs.getInt("FEE"));
				result.add(subVo);
			}

			lContents = new Object[result.size()][3];
			for (int i = 0; i < result.size(); i++) {
				for (int j = 0; j < 3; j++) {
					lContents[i][j] = result.get(i).getCategory();
					lContents[i][++j] = result.get(i).getTitle();
					lContents[i][++j] = result.get(i).getFee();
				}
			}
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
	         if (rs != null) {
		            rs = null;
		         }
		         if (pstmt != null) {
		            pstmt = null;
		         }
		         if (con != null) {
			            con = null;
			         }
		      }
		return lContents;

	}
	
	
	public int totalFee(subscriptionVo subVo) {
	
		int totalFee = 0;
		
		try {
			con = util.getConnection();
			System.out.println("접속성공!");

			sql = "SELECT SUM(FEE) AS TOTALFEE FROM SPENDING";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			if(rs.next()) {
				
				subVo = new subscriptionVo(rs.getInt("TOTALFEE")); //FEE로 했더니 부적합한 열 이름
				totalFee+=subVo.getFee();
			}		
		
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
	         if (rs != null) {
		            rs = null;
		         }
		         if (pstmt != null) {
		            pstmt = null;
		         }
		         if (con != null) {
			            con = null;
			         }
		      }
		return totalFee;

	}
	
	
	
	public int cnt(subscriptionVo subVo) {
	
		int cnt = 0;
		
		try {
			con = util.getConnection();
			System.out.println("접속성공!");

			sql = "SELECT count(*) AS cnt FROM SPENDING";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(sql);
			
			if(rs.next()) {
				
				cnt=rs.getInt(1);
			}
		
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		} finally {
	         if (rs != null) {
		            rs = null;
		         }
		         if (pstmt != null) {
		            pstmt = null;
		         }
		         if (con != null) {
			            con = null;
			         }
		      }
		return cnt;

	}
}
