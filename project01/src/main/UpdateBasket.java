package main;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class UpdateBasket {

	public UpdateBasket(String order, int total_price) {
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
					conn.prepareStatement("UPDATE basket SET user_order = ?, total_price = ?");
			
			if (getOrder() == null) {
				pstmt.setString(1, order);
			} else {
				pstmt.setString(1, getOrder() + order);
			}
			pstmt.setInt(2, getPrice() + total_price);
			
			int row = pstmt.executeUpdate();
			
			System.out.printf("%d행이 업데이트 되었습니다.\n", row);
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();				
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
	public String getOrder() {
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
			
			String sql = "SELECT user_order FROM basket";

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
	
	public int getPrice() {
		int price = 0;
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
			
			String sql = "SELECT total_price FROM basket";

			PreparedStatement pstmt = 
						conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();							
			while (rs.next()) {
				price = rs.getInt("total_price");

			}
			
			rs.close();
			pstmt.close();
			conn.close();				
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return price;
	}
	
}
