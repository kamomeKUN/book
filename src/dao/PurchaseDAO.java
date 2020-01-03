package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import bean.Item;
import bean.Product;

public class PurchaseDAO extends DAO {

	// 受注明細追加
	public boolean insert (ArrayList<Item> cart, String name, String address) throws Exception {
		// 変数宣言
		Connection con = null;
		PreparedStatement st = null;
		String sql = "insert into purchase values(null, ?, ?, ?, ?, ?, ?)";
		// DB接続
		con = getConnection();
		// 手動コミットに設定
		con.setAutoCommit(false);
		// 追加処理
		for (Item item : cart) {
			st = con.prepareStatement(sql);
			Product p = item.getProduct();
			st.setInt(1, p.getId());
			st.setString(2, p.getName());
			st.setInt(3, p.getPrice());
			st.setInt(4, item.getCount());
			st.setString(5, name);
			st.setString(6, address);
			int line = st.executeUpdate();
			st.close();

			// 追加処理チェック
			if (line != 1) {
				con.rollback();
				con.setAutoCommit(true);
				con.close();
				return false;
			}
		}
		con.commit();
		con.setAutoCommit(true);
		con.close();
		return true;
	}
}
