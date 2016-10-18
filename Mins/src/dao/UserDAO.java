package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import core.DBConnectionPool;
import vo.UserVO;

public class UserDAO {

	DBConnectionPool connPool;
	
	public void setDbConnectionPool(DBConnectionPool connPool) {
		this.connPool = connPool;
	}
  	/*	
	public void setConnection(Connection connection) {
		this.connection = connection;
	}*/
		
	public UserVO selectAdminVO() throws Exception{
		Connection connection = null;
		Statement stmt = null;
		ResultSet rs = null;
		UserVO adminVO = new UserVO();
		
		try {
			connection = connPool.getConnection();
			stmt = connection.createStatement();
			String sql = "SELECT user_email, user_phoneNum FROM Users WHERE user_grade = 0;";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				adminVO.setUserEmail(rs.getString("user_email"))
						.setUserPhoneNum(rs.getString("user_phoneNum"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try { if (rs != null) rs.close();}catch (Exception e) {}
			try { if (stmt != null) rs.close();}catch (Exception e) {}
		}
		
		return adminVO;
	}
	
}
