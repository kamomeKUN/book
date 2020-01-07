package master;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Product;
import dao.ProductDAO;
import shopping.ProductAction;
import tool.Action;

public class UpdateProductAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 変数宣言
		String page = "product.jsp";
		// パラメーター値の取得
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		// 商品オブジェクトの生成、設定
		Product p = new Product();
		p.setId(id);
		p.setName(name);
		p.setPrice(price);
		// 商品更新DAOの生成、実行
		ProductDAO dao = new ProductDAO();
		int line = dao.update(p);
		if (line == 1) {
			// 更新成功の場合
			request.setAttribute("success", "更新しました");
		} else {
			// 更新失敗の場合
			request.setAttribute("error", "エラー：更新失敗しました");
		}
		// 商品再検索
		ProductAction act = new ProductAction();
		page = act.execute(request, response);

		return page;
	}

}
