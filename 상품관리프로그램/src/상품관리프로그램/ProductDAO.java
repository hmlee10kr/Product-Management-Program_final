package ��ǰ�������α׷�;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

public class ProductDAO {
	String jdbcDriver = "com.mysql.jdbc.Driver";// �����ϴ� ����̹� ����
	String jdbcUrl = "jdbc:mysql://localhost/javadb";// �� ��ǻ�Ͱ� host
	Connection conn;// �����ϴ� ����

	PreparedStatement pstmt;// ��ɾ �����ϱ� ���� ����
	ResultSet rs;// ��� ���� �����ϱ� ���� ����

	Vector<String> items = null;// �׸�� ����
	String sql;// sql�� ����

	public void connectDB() {// DB�� �����ϱ� ���� �Լ�
		try {
			Class.forName(jdbcDriver);
			// ���� sql�� ����
			conn = DriverManager.getConnection(jdbcUrl, "javabook", "9603");

		} catch (Exception e) {// ���� �˻�
			e.printStackTrace();
		}
	}

	public void closeDB() {// DB �ݱ�
		try {
			pstmt.close();// ��ɾ� �ݱ�
			conn.close();// ����� �ݱ�
			rs.close();// ����� �����ϴ� �� �ݱ�
		} catch (SQLException e) {
			e.printStackTrace();// ���� ó��
		}
	}

	public ArrayList<product> getAll() {// ��ü ��ȯ
		connectDB();
		sql = "select * from product";// ǰ����� ��ü�� ����

		// ��ü �˻� �����͸� �����ϴ� ArrayList
		ArrayList<product> datas = new ArrayList<product>();

		// ������ȣ �޺��ڽ� �����͸� ���� ���� �ʱ�ȭ
		items = new Vector<String>();
		items.add("��ü");

		try {
			pstmt = conn.prepareStatement(sql);// ��ɾ� ����
			rs = pstmt.executeQuery();// ����� ����

			while (rs.next()) {// rs.next()->�� ���� �����´ٴ� ��
				// �� ������ ����
				product p = new product();
				p.setPrcode(rs.getInt("prcode"));
				p.setPrname(rs.getString("prname"));
				p.setPrice(rs.getInt("price"));
				p.setManufacture(rs.getString("manufacture"));
				datas.add(p);
				items.add(String.valueOf(rs.getInt("prcode")));
			}
			rs.close();// �ݱ�
		} catch (SQLException e) {// ���� ����
			e.printStackTrace();
		}
		closeDB();// �ݱ�
		return datas;// ��ȯ

	}

	public product getProduct(int prcode) {// �ϳ��� product ��ȯ
		connectDB();// ����
		sql = "select * from product where prcode = ?";// � prcode�� product�� ��������
		product p = null;
		try {
			pstmt = conn.prepareStatement(sql);// ��ɾ� ����
			pstmt.setInt(1, prcode);
			rs = pstmt.executeQuery();// ��� ����

			rs.next();// ��ü ����
			p = new product();// product ���� ��������
			p.setPrcode(rs.getInt("prcode"));
			p.setPrname(rs.getString("prname"));
			p.setPrice(rs.getInt("price"));
			p.setManufacture(rs.getString("manufacture"));
			rs.close();// �ݱ�
		} catch (Exception e) {// ���� ����
			e.printStackTrace();
		}
		closeDB();// �ݱ�
		return p;// ��ȯ
	}

	public boolean newProduct(product product) {// ���ο� product���
		connectDB();
		sql = "insert into product(prname, price,manufacture) VALUES(?,?,?)";// �ԷµǴ� ����� insert
		int result = 0;
		try {
			// �� ���� �� ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPrname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManufacture());
			pstmt.setInt(4, product.getPrecode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();// ���� ó��
		}
		closeDB();// �ݱ�
		if (result > 0)// 0���� ũ�ٴ� ���� �ٲ� ��ɾ �ִٴ� ��
			return true;
		else
			return false;// 0���� ������ ����
	}

	public boolean delProduct(int prcode) {// ����
		connectDB();
		sql = "delete from product where precode = ?";// � product�� �������� ����
		boolean result = false;

		try {
			pstmt = conn.prepareStatement(sql);// ��ɾ� ����
			pstmt.setInt(1, prcode);
			if (pstmt.executeUpdate() > 0)// ������Ʈ�Ȱ� �ִٴ� ��
				result = true;
			else
				result = false;
		} catch (SQLException e) {
			e.printStackTrace();// ���� ó��
		}
		closeDB();// �ݱ�
		return result;// ��ȯ
	}

	public boolean updateProduct(product product) {// ������Ʈ
		connectDB();// ����
		// � product�� ������ �Ұ����� ����
		sql = "update product set prname = ?, price = ?, manufacture = ? where prcode = ?";
		int result = 0;// ����� �ʱ�ȭ

		try {
			// ������Ʈ�� ���� ����
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, product.getPrname());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getManufacture());
			pstmt.setInt(4, product.getPrecode());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();// ���� ó��
		}
		closeDB();
		if (result > 0)// ������Ʈ �Ѱ��� ������ 0���� ŭ
			return true;
		else// ������Ʈ �� ���� ����
			return false;
	}

	public Vector<String> getItems() {// item ���� ��ȯ
		return items;
	}

}
