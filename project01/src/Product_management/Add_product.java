package Product_management;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Add_product {

	// 입력된 값으로 상품을 추가시키는 클래스 (상품명은 PK로 설정해놨기떄문에 중복될 가능성x)
	public String Add(String p_name, int c_price, String manufacturer, String n_info) {
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
					conn.prepareStatement("INSERT INTO sus_01 VALUES(?, ?, ?, ?, ?)");
	
			pstmt.setString(1, p_name);
			pstmt.setInt(2, c_price);
			pstmt.setString(3, manufacturer);
			pstmt.setString(4, n_info);
			pstmt.setString(5, p_name + ".jpg");
			
			
			int row = pstmt.executeUpdate();
			
			System.out.printf("%d행이 업데이트 되었습니다.\n", row);
			System.out.println("상품이 추가되었습니다.");
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();				
			
			// 상품 추가에 성공했을 떄
			return "s";
		} catch (SQLException e) {			
			e.printStackTrace();
			System.out.println("상품 추가에 실패했습니다.");
			// 상품 추가에 실패했을 때
			return "f";
		}
		
	}
	
}
