package signup;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class MemberRegistration {

	public MemberRegistration(String id, String pwd) {
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
					conn.prepareStatement("INSERT INTO users(user_name, pwd, membership_point, sign_up_date) VALUES(?, ?, 1000, sysdate)");
			
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			int row = pstmt.executeUpdate();
			
			System.out.printf("%s: 회원등록 완료\n", id);
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();				
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
		
	}
	
}
