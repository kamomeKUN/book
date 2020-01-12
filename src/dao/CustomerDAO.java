package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import bean.Customer;

public class CustomerDAO extends DAO {

	public Customer search(String login, String password) throws Exception {
		// 変数宣言
		Customer customer = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet res = null;
		String sql = "SELECT * FROM customer where login = ? and password = ?;";
		// DB接続
		con = getConnection();
		// 検索
		st = con.prepareStatement(sql);
		st.setString(1, login);
		st.setString(2, password);
		res = st.executeQuery();
		// 検索結果取得
		while (res.next()) {
			customer = new Customer();
			customer.setId(res.getInt("id"));
			customer.setLogin(res.getString("login"));
			customer.setPassword(res.getString("password"));
			customer.setAdminFlag(res.getString("adminFlag"));
		}
		// close処理
		st.close();
		con.close();
		return customer;
	}
}
