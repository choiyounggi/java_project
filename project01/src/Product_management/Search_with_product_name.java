package Product_management;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Search_with_product_name {

	// 상품명으로 검색했을 때 검색 값을 리턴해줄 클래스
	public String product_name(String product_name) {
		String information = "";
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

			String sql = "SELECT product_name FROM sus_01 WHERE product_name = ?";

			PreparedStatement pstmt = 
						conn.prepareStatement(sql);
			
			pstmt.setString(1, product_name);
			
			ResultSet rs = pstmt.executeQuery();							
			while (rs.next()) {
				information = String.format("[상품명]:        %s", rs.getString("product_name"));
			}
			
			rs.close();
			pstmt.close();
			conn.close();				
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return information;

	}
	
	public String commodity_price(String product_name) {
		String information = "";
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
			
			// TO_CHAR를 이용해 기존에 그냥 숫자로 들어가있던 상품가격을 한국식으로 천단위 , 추가와 가격뒤에 원단위를 붙이게 출력
			String sql = "SELECT TO_CHAR(commodity_price,'9,999,999L') as \"commodity_price\" FROM sus_01 WHERE product_name = ?";

			PreparedStatement pstmt = 
						conn.prepareStatement(sql);
			
			pstmt.setString(1, product_name);
			
			ResultSet rs = pstmt.executeQuery();							
			while (rs.next()) {
				information = String.format("[가격]:%s", rs.getString("commodity_price"));
			}
			
			rs.close();
			pstmt.close();
			conn.close();				
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return information;

	}
	
	public String manufacturer(String product_name) {
		String information = "";
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
			
			String sql = "SELECT manufacturer FROM sus_01 WHERE product_name = ?";

			PreparedStatement pstmt = 
						conn.prepareStatement(sql);
			
			pstmt.setString(1, product_name);
			
			ResultSet rs = pstmt.executeQuery();							
			while (rs.next()) {
				information = String.format("[제조사]:          %s", rs.getString("manufacturer"));
			}
			
			rs.close();
			pstmt.close();
			conn.close();				
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return information;

	}
	
	public String nutrition_information(String product_name) {
		String information = "";
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
			
			// TO_CHAR를 이용해 기존에 그냥 숫자로 들어가있던 상품가격을 한국식으로 천단위 , 추가와 가격뒤에 원단위를 붙이게 출력
			String sql = "SELECT nutrition_information FROM sus_01 WHERE product_name = ?";

			PreparedStatement pstmt = 
						conn.prepareStatement(sql);
			
			pstmt.setString(1, product_name);
			
			ResultSet rs = pstmt.executeQuery();							
			while (rs.next()) {
				information = String.format("[영양정보]:          %s", rs.getString("nutrition_information"));
			}
			
			rs.close();
			pstmt.close();
			conn.close();				
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		return information;

	}
	
}
