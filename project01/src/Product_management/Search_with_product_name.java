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
	public String info(String product_name) {
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
			String sql = "SELECT product_name, TO_CHAR(commodity_price,'9,999,999L') as \"commodity_price\", manufacturer, nutrition_information, product_image FROM sus_01 WHERE product_name = ?";

			PreparedStatement pstmt = 
						conn.prepareStatement(sql);
			
			pstmt.setString(1, product_name);
			
			ResultSet rs = pstmt.executeQuery();							
			while (rs.next()) {
				information = String.format("[��ǰ��]:        %s        [����]:%s          [������]:          %s          [��������]:          %s", rs.getString("product_name"), rs.getString("commodity_price"), rs.getString("manufacturer"), rs.getString("nutrition_information"));
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
