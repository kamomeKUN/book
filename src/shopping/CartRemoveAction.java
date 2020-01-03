package shopping;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import tool.Action;

public class CartRemoveAction extends Action {

	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 変数
		String page = "cart.jsp";

		HttpSession session = request.getSession();

		// パラメーター値の取得
		int id = Integer.parseInt(request.getParameter("id"));
		// カートの中身を取得
		ArrayList<Item> cart = (ArrayList<Item>) session.getAttribute("cart");
		// 削除対象を設定
		for (Item i : cart) {
			if (id == i.getProduct().getId()) {
				cart.remove(i);
				break;
			}
		}
		return page;
	}

}
