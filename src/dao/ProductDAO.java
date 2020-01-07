package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import bean.Product;

public class ProductDAO extends DAO {

	// 商品検索
	public ArrayList<Product> search(String keyword, int price) throws Exception {
		// 変数宣言
		ArrayList<Product> list = new ArrayList<Product>();
		String listSql = "select * from product where name like ? "
				+ "and price <= ?";

		Connection con = getConnection();
		// SQL実行
		PreparedStatement st = con.prepareStatement(listSql);
		st.setString(1, "%" + keyword + "%");
		st.setInt(2, price);
		ResultSet res = st.executeQuery();
		// 検索結果を取得
		while (res.next()) {
			Product p = new Product();
			p.setId(res.getInt("id"));
			p.setName(res.getString("name"));
			p.setPrice(res.getInt("price"));
			list.add(p);
		}
		// Close処理
		st.close();
		con.close();

		return list;
	}

	// 商品登録
	public int insert(Product product) throws Exception {
		// 変数
		String insSql = "insert into product values(null, ? , ?)";
		int line = 0;

		Connection con = getConnection();
		// SQL実行
		PreparedStatement st = con.prepareStatement(insSql);
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		line = st.executeUpdate();
		// Close処理
		st.close();
		con.close();
		return line;
	}

	// 商品更新
	public int update(Product product) throws Exception {
		// 変数
		String updSql = "update product set name = ?, price = ? where id = ?";
		int line = 0;

		Connection con = getConnection();

		// SQL実行
		PreparedStatement st = con.prepareStatement(updSql);
		st.setString(1, product.getName());
		st.setInt(2, product.getPrice());
		st.setInt(3, product.getId());
		line = st.executeUpdate();
		// close処理
		st.close();
		con.close();

		return line;
	}
}
