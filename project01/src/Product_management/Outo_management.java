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
		// sus_02의 상품명이 sus_01의 상품명과 같을 때는 갱신(update)을 다른 때에는 추가(insert)를 해주는 클래스 (상품정보 자동관리)
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
					// MERGE INTO 쿼리문을 활용하여, 상품이 sus_01에 있고, sus_02에 없을 떄 정보를 추가하는 기능과
					// 상품이 sus_01과 sus_02에 모두 존재할 때, 정보를 갱신하는 기능을 한번에 구현 
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
			
			System.out.printf("sus_02점포 상품정보 자동 업데이트 완료");

			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();			
			
		} catch (SQLException e) {			
			e.printStackTrace();
		}
	}
	
}
