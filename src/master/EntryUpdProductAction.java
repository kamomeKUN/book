package master;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Product;
import tool.Action;

public class EntryUpdProductAction extends Action {

	@SuppressWarnings("unchecked")
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 変数宣言
		String page = "updProduct.jsp";
		HttpSession session = request.getSession();
		// パラメーター値の取得
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			// セッションのリストから指定されたidの商品を検索する
			ArrayList<Product> list = (ArrayList<Product>) session.getAttribute("list");
			for(Product p : list) {
				if (id == p.getId()) {
					request.setAttribute("product", p);
				} else {
					request.setAttribute("error", "指定された商品は存在しません");
				}
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			request.setAttribute("error", "指定された商品は存在しません");
		}
		return page;
	}

}
