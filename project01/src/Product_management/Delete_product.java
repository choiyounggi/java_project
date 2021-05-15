package Product_management;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Delete_product {

	// ��ǰ������ �����ϰ� ���� ��ǰ�� �����ϴ� Ŭ����
	public String Delete(String p_name) {
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
					conn.prepareStatement("DELETE FROM sus_01 WHERE product_name = ?");
	
			pstmt.setString(1, p_name);
			
			int row = pstmt.executeUpdate();
			
			System.out.printf("%d���� ������Ʈ �Ǿ����ϴ�.\n", row);
			System.out.println("��ǰ�� �����Ǿ����ϴ�.");
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();				
			
			// ��ǰ ������ �������� ��
			return "s";
		} catch (SQLException e) {			
			e.printStackTrace();
			System.out.println("��ǰ ������ �����߽��ϴ�.");
			// ��ǰ ������ �������� ��
			return "f";
		}
	}
	
}
