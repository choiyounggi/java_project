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

	// ��ǰ������ �˻����� �� �˻� ���� �������� Ŭ����
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
				information = String.format("[��ǰ��]:        %s", rs.getString("product_name"));
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
			
			// TO_CHAR�� �̿��� ������ �׳� ���ڷ� ���ִ� ��ǰ������ �ѱ������� õ���� , �߰��� ���ݵڿ� �������� ���̰� ���
			String sql = "SELECT TO_CHAR(commodity_price,'9,999,999L') as \"commodity_price\" FROM sus_01 WHERE product_name = ?";

			PreparedStatement pstmt = 
						conn.prepareStatement(sql);
			
			pstmt.setString(1, product_name);
			
			ResultSet rs = pstmt.executeQuery();							
			while (rs.next()) {
				information = String.format("[����]:%s", rs.getString("commodity_price"));
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
				information = String.format("[������]:          %s", rs.getString("manufacturer"));
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
			
			// TO_CHAR�� �̿��� ������ �׳� ���ڷ� ���ִ� ��ǰ������ �ѱ������� õ���� , �߰��� ���ݵڿ� �������� ���̰� ���
			String sql = "SELECT nutrition_information FROM sus_01 WHERE product_name = ?";

			PreparedStatement pstmt = 
						conn.prepareStatement(sql);
			
			pstmt.setString(1, product_name);
			
			ResultSet rs = pstmt.executeQuery();							
			while (rs.next()) {
				information = String.format("[��������]:          %s", rs.getString("nutrition_information"));
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
