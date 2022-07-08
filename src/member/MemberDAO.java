
/*https://siloam72761.tistory.com/entry/Java-DB-%ED%9A%8C%EC%9B%90%EA%B0%80%EC%9E%85-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EC%8B%9C%EC%8A%A4%ED%85%9C-%EB%A7%8C%EB%93%A4%EA%B8%B0*/

package member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MemberDAO {
//	DAO)�ڹ� ���α׷����� �����ͺ��̽� �۾��� �����ϴ� Ŭ����
//	�ڹ� ���α׷��� �ٸ� ����� �ϴ� Ŭ������ �����Ͽ� �۾�

	private JdbcConnectionUtil util;

	public MemberDAO() {
		util = JdbcConnectionUtil.getInstance();
	}

	// Insert
	public void insertMember(MemberVo vo) {
		Connection conn = null; // db����
		PreparedStatement pstmt = null; // ������ ����
		ResultSet rs = null; // �˻���� ���ڵ� ����
		String sql = null;

		try {

			conn = util.getConnection();
			System.out.println("���Ӽ���!");

			sql = "insert into member(id, password, name, phoneNumber)";
			sql += " values (?,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPassword());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPnum());
			pstmt.executeUpdate();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	public MemberVo selectMember(String string) {
		Connection conn = null; // db����
		PreparedStatement pstmt = null; // ������ ����
		ResultSet rs = null; // �˻���� ���ڵ� ����
		String sql = null;
		MemberVo result = null;

		try {
			conn = util.getConnection();
			System.out.println("���Ӽ���!");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, string);
			rs = pstmt.executeQuery();

			sql = "select * from member where ?";

			while (rs.next()) {
				result = new MemberVo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
