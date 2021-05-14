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

	// 상품명으로 검색했을 때 검색 값을 리턴해줄 클래스
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
			
			// TO_CHAR를 이용해 기존에 그냥 숫자로 들어가있던 상품가격을 한국식으로 천단위 , 추가와 가격뒤에 원단위를 붙이게 출력
			String sql = "SELECT product_name, TO_CHAR(commodity_price,'9,999,999L') as \"commodity_price\", manufacturer, nutrition_information, product_image FROM sus_01 WHERE product_name = ?";

			PreparedStatement pstmt = 
						conn.prepareStatement(sql);
			
			pstmt.setString(1, product_name);
			
			ResultSet rs = pstmt.executeQuery();							
			while (rs.next()) {
				information = String.format("[상품명]:        %s        [가격]:%s          [제조사]:          %s          [영양정보]:          %s", rs.getString("product_name"), rs.getString("commodity_price"), rs.getString("manufacturer"), rs.getString("nutrition_information"));
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
