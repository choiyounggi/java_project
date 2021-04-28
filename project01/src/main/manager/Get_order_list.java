package main.manager;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Get_order_list {

	public String order_list() {
		String result = "";
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
			
			String sql = "SELECT * FROM order_list";

			PreparedStatement pstmt = 
						conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();	
			while (rs.next()) {
				result += (String.format("[%s]\n주문날짜 : %s\n주문총액: %d\n[주문내역]\n%s\n\n", rs.getString("user_name"), rs.getString("order_date"), rs.getInt("payment"), rs.getString("user_order")));	
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
