package shopping;

import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import tool.Action;

public class PreviewAction extends Action {

	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 変数宣言
		String page = "purchase-in.jsp";

		HttpSession session = request.getSession();
		// 未ログインの場合
		if (session.getAttribute("customer") == null) {
			page = "preview-error-login.jsp";
			return page;
		}
		// カートに商品がない場合
		ArrayList<Product> cart = (ArrayList<Product>) session.getAttribute("cart");
		if (Objects.isNull(cart) || cart.size() == 0) {
			page = "preview-error-cart.jsp";
			return page;
		}
		// パラメーター値の取得
		return page;
	}
}
