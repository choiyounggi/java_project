package main;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class CreateBasket {

	public CreateBasket(String id) {
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
					conn.prepareStatement("CREATE TABLE basket (\r\n"
							+ "    user_name VARCHAR2(40),\r\n"
							+ "    user_order VARCHAR2 (200),\r\n"
							+ "    total_price NUMBER (7)\r\n"
							+ ")");
			
			int row = pstmt.executeUpdate();
			
			System.out.printf("%d���� ������Ʈ �Ǿ����ϴ�.\n", row);
			System.out.println("���̺� ���� �Ϸ�");
			
			insert(id);
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();				
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}
	
	public void insert(String id) {
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
					conn.prepareStatement("INSERT INTO basket(user_name) VALUES(?)");
			
			pstmt.setString(1, id);
			
			int row = pstmt.executeUpdate();
			
			System.out.printf("%d���� ������Ʈ �Ǿ����ϴ�.\n", row);
			System.out.println("������ �߰� �Ϸ�");
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();				
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
}
