package shopping;

import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Item;
import bean.Product;
import tool.Action;

public class CartAddAction extends Action{

	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 変数宣言
		String page = "cart.jsp";
		HttpSession session = request.getSession();
		// パラメーター値の取得
		int id = Integer.parseInt(request.getParameter("id"));
		// カートの取得・生成
		ArrayList<Item> cart = (ArrayList<Item>) session.getAttribute("cart");
		if (Objects.isNull(cart)) {
			cart = new ArrayList<Item>();
			session.setAttribute("cart", cart);
		}
		// 既にカートにある商品の追加処理
		for (Item i : cart) {
			if (i.getProduct().getId() == id) {
				i.setCount(i.getCount() + 1);
				return page;
			}
		}
		// 商品リストの取得
		ArrayList<Product> list = new ArrayList<Product>();
		list = (ArrayList<Product>) session.getAttribute("list");
		// まだカートにない商品の追加処理
		for (Product p : list) {
			if (p.getId() == id) {
				Item i = new Item();
				i.setProduct(p);
				i.setCount(1);
				cart.add(i);
			}
		}
		return page;
	}
}
