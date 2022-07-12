package subscription;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//�̱��� ���� ����
public class JdbcConnectionUtil {
	private static JdbcConnectionUtil instance;
	
	
	private	String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "c##green";
	private String password = "green1234";
	
	private JdbcConnectionUtil() {
		
	}
	
	
	public static JdbcConnectionUtil getInstance() {
		synchronized(JdbcConnectionUtil.class) { //��Ƽ���������
		if(instance ==null) 
			instance = new JdbcConnectionUtil();
		}
		return instance;
	}
	
	public Connection getConnection() throws SQLException{
		return DriverManager.getConnection(url, user, password);
	}
	
	public void close(ResultSet rs) {
		if(rs!=null) {
			try {
				rs.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void close(Statement stmt) {
		if(stmt!=null) {
			try {
				stmt.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public void close(Connection con) {
		if(con!=null) {
			try {
				con.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
