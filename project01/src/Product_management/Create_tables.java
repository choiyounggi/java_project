package Product_management;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Create_tables {

	public Create_tables() {
		// sus_01 ���̺� ������ ���ÿ� sus_01���̺��� �⺻������ sus_02 ���̺� �������ִ� Ŭ���� (try, catch�� ���̺� ���� ���ο� ���� �޼��� ���)
		Properties props = new Properties();
		props.setProperty("dataSourceClassName", "oracle.jdbc.pool.OracleDataSource");
		props.setProperty("dataSource.url", "jdbc:oracle:thin:@localhost:1521/XEPDB1");
		props.setProperty("dataSource.user", "hr");
		props.setProperty("dataSource.password", "1234");		
		props.put("dataSource.logWriter", new PrintWriter(System.out));
		
		HikariConfig config = new HikariConfig(props);
		HikariDataSource ds = new HikariDataSource(config);
		
		try {
			// ���� �����Ǵ� ���̺��� �� (sus_02)
			Connection conn = ds.getConnection();
			
			
			PreparedStatement pstmt = 
					conn.prepareStatement("CREATE TABLE sus_01 (\r\n"
							+ "    product_name VARCHAR2(25)\r\n"
							+ "        CONSTRAINT product_name_pk PRIMARY KEY,\r\n"
							+ "    commodity_price NUMBER(6)\r\n"
							+ "        CONSTRAINT commodity_price_nn NOT NULL,\r\n"
							+ "    manufacturer VARCHAR2(25)\r\n"
							+ "        CONSTRAINT manufacturer_nn NOT NULL,\r\n"
							+ "    nutrition_information VARCHAR2(15)\r\n"
							+ "        CONSTRAINT nutinfo_nn NOT NULL,\r\n"
							+ "    product_image VARCHAR2(30)\r\n"
							+ "        CONSTRAINT product_image_nn NOT NULL\r\n"
							+ ")");
			
			int row = pstmt.executeUpdate();
			
			System.out.printf("%d���� ������Ʈ �Ǿ����ϴ�.\n", row);
			System.out.println("sus_01 ���̺� ���� �Ϸ�");
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();				
			
		} catch (SQLException e) {		
			// �̹� ������ ���̺��� ������ �� (sus_01)
			System.out.println("sus_01 ���̺� ����(���� x)");
		}
		
		try {
			// ���� �����Ǵ� ���̺��� �� (sus_02)
			Connection conn = ds.getConnection();
			
			
			PreparedStatement pstmt = 
					conn.prepareStatement("CREATE TABLE sus_02 AS SELECT * FROM sus_01");
			
			int row = pstmt.executeUpdate();
			
			System.out.printf("%d���� ������Ʈ �Ǿ����ϴ�.\n", row);
			System.out.println("sus_02 ���̺� ���� �Ϸ�");
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();				
			
		} catch (SQLException e) {
			// �̹� ������ ���̺��� ������ �� (sus_02)
			System.out.println("sus_02 ���̺� ����(���� x)");
		}
		
	}
}
