package main;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class GetPrice {

	public int price(String size_name, String menu_name) {
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
			
			if (size_name.contains("Tall")) {
				String sql = "SELECT tall_price FROM menu WHERE menu_name = ?";
				PreparedStatement pstmt = 
						conn.prepareStatement(sql);
				
				pstmt.setString(1, menu_name);
				
				ResultSet rs = pstmt.executeQuery();							
				while (rs.next()) {
					price = rs.getInt("tall_price");

				}
				
				rs.close();
				pstmt.close();
				conn.close();
			} else if (size_name.contains("Grande")) {
				String sql = "SELECT grande_price FROM menu WHERE menu_name = ?";
				PreparedStatement pstmt = 
						conn.prepareStatement(sql);
				
				pstmt.setString(1, menu_name);
				
				ResultSet rs = pstmt.executeQuery();							
				while (rs.next()) {
					price = rs.getInt("grande_price");

				}
				
				rs.close();
				pstmt.close();
				conn.close();
			} else if (size_name.contains("Venti")) {
				String sql = "SELECT venti_price FROM menu WHERE menu_name = ?";
				PreparedStatement pstmt = 
						conn.prepareStatement(sql);
				
				pstmt.setString(1, menu_name);
				
				ResultSet rs = pstmt.executeQuery();							
				while (rs.next()) {
					price = rs.getInt("venti_price");

				}
				
				rs.close();
				pstmt.close();
				conn.close();
			}			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
		return price;
	}
	
}
