package main;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class UpdatePoint {
	public UpdatePoint(int usedPoint, String id) {
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
			
			PreparedStatement pstmt = 
					conn.prepareStatement("UPDATE users SET membership_point = membership_point - ? WHERE user_name = ?");
			
			pstmt.setInt(1, usedPoint);
			pstmt.setString(2, id);
			
			int row = pstmt.executeUpdate();
			
			System.out.printf("포인트를 사용 완료");

			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
}
