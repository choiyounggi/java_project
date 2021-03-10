package main;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DeleteBasket {

	public DeleteBasket() {
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
					conn.prepareStatement("DROP TABLE basket PURGE");
			
			int row = pstmt.executeUpdate();
			
			System.out.printf("%d행이 업데이트 되었습니다.\n", row);
			System.out.println("테이블 삭제 완료");
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();				
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
}
