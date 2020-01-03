package shopping;

import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import dao.PurchaseDAO;
import tool.Action;

public class PurchaseAction extends Action {

	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 変数宣言
		String page = "purchase-out.jsp";

		HttpSession session = request.getSession();

		// パラメータ値を取得
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		// 入力値チェック
		if (name.isEmpty() || address.isEmpty()) {
			request.setAttribute("error", "お名前、住所を入力してください");
			page = "purchase-in.jsp";
			return page;
		}
		// 購入処理
		PurchaseDAO dao = new PurchaseDAO();
		ArrayList<Item> cart = (ArrayList<Item>) session.getAttribute("cart");
		if (Objects.isNull(cart) || !dao.insert(cart, name, address)) {
			page = "purchase-error-insert.jsp";
			return page;
		}
		// ショッピングカートの中身を削除
		session.removeAttribute("cart");
		return page;
	}
}
