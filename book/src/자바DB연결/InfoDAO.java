package 자바DB연결;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class InfoDAO {

	public InfoVO one(int rank) {
		ResultSet rs = null;
		InfoVO bag = null;
		try {
			// 1. 오라클 11g와 연결할 부품 설정
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");

			// 2. 오라클 11g에 연결(java -- oracle)
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공");

			String sql = "select * from hr.INFO_T where rank = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, rank);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");

			rs = ps.executeQuery();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (rs.next()) {
				System.out.println("검색결과 있음");
				int no = rs.getInt("NO");
				String title = rs.getString("TITLE");
				String img = rs.getString("IMG");
				int rank2 = rs.getInt("RANK");

				bag = new InfoVO();
				bag.setNo(no);
				bag.setTitle(title);
				bag.setImg(img);
				bag.setRank(rank2);

			} else {
				System.out.println("검색결과 없음");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bag;
	}

	public int insert(InfoVO bag) {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");

			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공");

			String sql = "insert into hr.INFO_T values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, bag.getNo());
			ps.setString(2, bag.getTitle());
			ps.setString(3, bag.getImg());
			ps.setString(4, bag.getInfo());
			ps.setString(5, bag.getContent());
			ps.setString(6, bag.getPublisher());
			ps.setString(7, bag.getWriter());
			ps.setString(8, bag.getGenre());
			ps.setInt(9, bag.getRank());
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");

			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (result == 1) {
				System.out.println("책 등록 완료");
			}
		} catch (Exception e) {
			// result = 0;
			// e.printStackTrace();
		}
		return result;
	}

	public int delete(int no) {
		int result = 0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("1. 오라클과 자바 연결할 부품 설정 성공");
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "system";
			String password = "oracle";
			Connection con = DriverManager.getConnection(url, user, password);
			System.out.println("2. 오라클 연결 성공");
			
			String sql = "delete from hr.INFO_T where no = ?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, no);
			System.out.println("3. SQL문 부품(객체)으로 만들어주기 성공");
			
			result = ps.executeUpdate();
			System.out.println("4. SQL문 오라클로 보내기 성공");
			if (result == 1) {
				System.out.println("책 삭제 완료");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//System.out.println(result);
		return result;
	}
	

}