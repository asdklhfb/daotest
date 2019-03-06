package commons;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class Db {
	
	// 멤버 변수
	static String url = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	static String user = "scott";
	static String pwd = "Tiger07#";
	static Connection c = null;
	static Statement s = null;
	
	// 정적 초기화 블럭
	static {
		/* 1. jdbc 로딩 */
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("1. jdbc 로딩 예외 : " + e.getMessage());
		}
	}
	
	// DML을 전달받아 실행시키는 메서드
	public static int executeUpdate(String sql) {
		// db연결
		getConnection();
		
		// sql 실행
		try {
			s = c.createStatement();
			s.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			// close
			closeConnection();
		}
		return 0;
	}
	
	// 쿼리를 전달받아 결과를 listMap으로 리턴
	public static ArrayList<HashMap<String, String>> selectListMap(String sql){
		// db 연결
		getConnection();
		
		/* 3.2. SELECT SQL실행 */
		ResultSet rs = null;
		try {
			s = c.createStatement();
			rs = s.executeQuery(sql);			
			} catch (SQLException e) {
			System.out.println("3. SQL실행 예외 : " + e.getMessage());
		}
			
		// ResultSet을 ArrayList화
		ArrayList<HashMap<String, String>> list = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> map = null;
			
		try {
			while(rs.next()) {
				map = new HashMap<String, String>();
				// 열의 갯수 가져오기
				ResultSetMetaData rm = rs.getMetaData();
				int c_count = rm.getColumnCount();
				for(int i = 1; i <= c_count; i++) {
					map.put(rm.getColumnName(i), rs.getString(i));	
				}
				
				list.add(map);
			}
		} catch (SQLException e) {
			System.out.println("5. ResultSet을 ArrayList화 예외 : " + e.getMessage());			
		}
		// close
		closeConnection();		
		//return 값
		return list;	
	}
		
	// 연결 메서드
	static void getConnection() {
		/* 2. DB연결 */
		try {
			c = DriverManager.getConnection(url, user, pwd);
		} catch (SQLException e) {
			System.out.println("2. 연결 예외 : " + e.getMessage());
		}
	}
		
	// 연결 종료 메서드
	static void closeConnection() {
		/* 4. DB접속 마무리 */
		if(!Objects.isNull(s)) {
			try {
				s.close();
			} catch (SQLException e) {
				System.out.println("DB접속 마무리 예외 : " + e.getMessage());			
			}
		}
	}
}
