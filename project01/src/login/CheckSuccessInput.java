package login;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class CheckSuccessInput {

	public String check(String id, String pwd) {
		String result = null; 
		Properties props = new Properties();
		props.setProperty("dataSourceClassName", "oracle.jdbc.pool.OracleDataSource");
		props.setProperty("dataSource.url", "jdbc:oracle:thin:@localhost:1521/XEPDB1");
		props.setProperty("dataSource.user", "hr");
		props.setProperty("dataSource.password", "1234");		
		props.put("dataSource.logWriter", new PrintWriter(System.out));
		
		HikariConfig config = new HikariConfig(props);
		HikariDataSource ds = new HikariDataSource(config);
		
		try {
			Connection conn = ds.getConnection();
			
			String sql = "SELECT pwd FROM users WHERE user_name = ?";

			PreparedStatement pstmt = 
						conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			ResultSet rs = pstmt.executeQuery();							
			while (rs.next()) {
				if (rs.getString("pwd").equals(pwd)) {
					result = "success";
				} else {
					result = "fail";
				}

			}
			
			rs.close();
			pstmt.close();
			conn.close();				
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}

		return result;
		
	}
	
}
