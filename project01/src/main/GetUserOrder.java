package main;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class GetUserOrder {

	public String order() {
		String order = null;
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
			
			String sql = "SELECT USER_ORDER FROM basket";

			PreparedStatement pstmt = 
						conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();							
			while (rs.next()) {
				order = rs.getString("user_order");

			}
			
			rs.close();
			pstmt.close();
			conn.close();				
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return order;
	}	
	
}
