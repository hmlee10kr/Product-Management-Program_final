package 상품관리프로그램;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ProductDAO {
	String jdbcDriver = "com.mysql.jdbc.Driver";// 연결하는 드라이버 설정
	String jdbcUrl = "jdbc:mysql://localhost/javadb";// 내 컴퓨터가 host
	Connection conn;// 연결하는 역할

	PreparedStatement pstmt;// 명령어를 저장하기 위한 변수
	ResultSet rs;// 결과 값을 저장하기 위한 변수

	Vector<String> items = null;// 항목들 저장
	String sql;// sql로 전달

	public void connectDB() {// DB에 연결하기 위한 함수
		try {
			Class.forName(jdbcDriver);
			// 나의 sql로 연결
			conn = DriverManager.getConnection(jdbcUrl, "javabook", "9603");

		} catch (Exception e) {// 예외 검사
			e.printStackTrace();
		}
	}

	public void closeDB() {// DB 닫기
		try {
			pstmt.close();// 명령어 닫기
			conn.close();// 연결고리 닫기
			rs.close();// 결과값 저장하는 것 닫기
		} catch (SQLException e) {
			e.printStackTrace();// 예외 처리
		}
	}

	public ArrayList<product> getAll() {// 전체 반환
		connectDB();
		sql = "select * from product";// 품목들의 전체를 선택

		// 전체 검색 데이터를 전달하는 ArrayList
		ArrayList<product> datas = new ArrayList<product>();

		// 관리번호 콤보박스 데이터를 위한 벡터 초기화
		items = new Vector<String>();
		items.add("전체");

		try {
			pstmt = conn.prepareStatement(sql);// 명령어 저장
			rs = pstmt.executeQuery();// 결과값 저장

			while (rs.next()) {// rs.next()->한 행을 가져온다는 뜻
				// 각 값들을 저장
				product p = new product();
				p.setPrcode(rs.getInt("prcode"));
				p.setPrname(rs.getString("prname"));
				p.setPrice(rs.getInt("price"));
				p.setManufacture(rs.getString("manufacture"));
				datas.add(p);
				items.add(String.valueOf(rs.getInt("prcode")));
			}
			rs.close();// 닫기
		} catch (SQLException e) {// 예외 검출
			e.printStackTrace();
		}
		closeDB();// 닫기
		return datas;// 반환

	}

	public product getProduct(int prcode) {// 하나의 product 반환
		connectDB();// 연결
		sql = "select * from product where prcode = ?";// 어떤 prcode의 product를 선택할지
		product p = null;
		try {
			pstmt = conn.prepareStatement(sql);// 명령어 저장
			pstmt.setInt(1, prcode);
			rs = pstmt.executeQuery();// 결과 저장

			rs.next();// 전체 선택
			p = new product();// product 정보 가져오기
			p.setPrcode(rs.getInt("prcode"));
			p.setPrname(rs.getString("prname"));
			p.setPrice(rs.getInt("price"));
			p.setManufacture(rs.getString("manufacture"));
			rs.close();// 닫기
		} catch (Exception e) {// 예외 검출
			e.printStackTrace();
		}
		closeDB();// 닫기
		return p;// 반환
	}

	public boolean newProduct(product product) {// 새로운 product등록
		connectDB();
		sql = "insert into product(prname, price,manufacture) VALUES(?,?,?)";// 입력되는 값대로 insert
		int result = 0;
		try {
			// 값 저장 및 전달
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPrname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManufacture());
			pstmt.setInt(4, product.getPrecode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();// 예외 처리
		}
		closeDB();// 닫기
		if (result > 0)// 0보다 크다는 것은 바뀐 명령어가 있다는 뜻
			return true;
		else
			return false;// 0보다 작으면 없다
	}

	public boolean delProduct(int prcode) {// 삭제
		connectDB();
		sql = "delete from product where precode = ?";// 어떤 product를 삭제할지 전달
		boolean result = false;

		try {
			pstmt = conn.prepareStatement(sql);// 명령어 저장
			pstmt.setInt(1, prcode);
			if (pstmt.executeUpdate() > 0)// 업데이트된게 있다는 뜻
				result = true;
			else
				result = false;
		} catch (SQLException e) {
			e.printStackTrace();// 예외 처리
		}
		closeDB();// 닫기
		return result;// 반환
	}

	public boolean updateProduct(product product) {// 업데이트
		connectDB();// 연결
		// 어떤 product를 업데잍 할것인지 전달
		sql = "update product set prname = ?, price = ?, manufacture = ? where prcode = ?";
		int result = 0;// 결과값 초기화

		try {
			// 업데이트할 정보 전달
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPrname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManufacture());
			pstmt.setInt(4, product.getPrecode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();// 예외 처리
		}
		closeDB();
		if (result > 0)// 업데이트 한것이 있으면 0보다 큼
			return true;
		else// 업데이트 한 것이 없다
			return false;
	}

	public Vector<String> getItems() {// item 값들 반환
		return items;
	}

}
