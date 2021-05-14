package Product_management;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class Outo_management {

	public Outo_management() {
		// sus_02�� ��ǰ���� sus_01�� ��ǰ��� ���� ���� ����(update)�� �ٸ� ������ �߰�(insert)�� ���ִ� Ŭ���� (��ǰ���� �ڵ�����)
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
					// MERGE INTO �������� Ȱ���Ͽ�, ��ǰ�� sus_01�� �ְ�, sus_02�� ���� �� ������ �߰��ϴ� ��ɰ�
					// ��ǰ�� sus_01�� sus_02�� ��� ������ ��, ������ �����ϴ� ����� �ѹ��� ���� 
					conn.prepareStatement("MERGE INTO sus_02 a\r\n"
							+ "    USING sus_01 b\r\n"
							+ "    ON (b.product_name = a.product_name)\r\n"
							+ "    WHEN MATCHED THEN\r\n"
							+ "        UPDATE SET\r\n"
							+ "            a.commodity_price = b.commodity_price,\r\n"
							+ "            a.manufacturer = b.manufacturer,\r\n"
							+ "            a.nutrition_information = b.nutrition_information,\r\n"
							+ "            a.product_image = b.product_image\r\n"
							+ "    WHEN NOT MATCHED THEN\r\n"
							+ "        INSERT (a.product_name, a.commodity_price, a.manufacturer, a.nutrition_information, a.product_image)\r\n"
							+ "            VALUES (b.product_name, b.commodity_price, b.manufacturer, b.nutrition_information, b.product_image)");
			
			int row = pstmt.executeUpdate();
			
			System.out.printf("sus_02���� ��ǰ���� �ڵ� ������Ʈ �Ϸ�");

			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
}
