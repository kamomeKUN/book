package shopping;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import dao.ProductDAO;
import tool.Action;

public class ProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 変数宣言
		String page = "product.jsp";
		int price = 300;
		ArrayList<Product> list = new ArrayList<Product>();

		HttpSession session = request.getSession();
		// パラメータを取得
		String keyword = request.getParameter("keyword");
		if (keyword == null) keyword = "";

		String strPrice = request.getParameter("price");
		if (strPrice != null && strPrice != "") {
			price = Integer.parseInt(strPrice);
		}
		// 商品検索
		ProductDAO dao = new ProductDAO();
		list = dao.search(keyword, price);
		// セッションオブジェクトに設定
		session.setAttribute("list", list);
		return page;
	}

}
