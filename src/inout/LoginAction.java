package inout;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Customer;
import dao.CustomerDAO;
import tool.Action;

public class LoginAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 変数宣言
		HttpSession session = request.getSession();
		String page = "login-out.jsp";
		Customer customer = null;
		// パラメーターの値を取得
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		// DAOを生成、商品登録
		CustomerDAO dao = new CustomerDAO();
		customer = dao.search(login, password);
		// ログイン可否判定
		// ログイン不可
		if (Objects.isNull(customer)) {
			page = "login-in.jsp";
			request.setAttribute("message", "ログインIDまたはパスワードが正しくありません。");
			return page;
		}
		// ログイン可
		// セッションオブジェクトに値を設定
		session.setAttribute("customer", customer);
		// 遷移画面を設定
		String adminFlag = customer.getAdminFlag();
		if (adminFlag.equals("01")) {
			page = "../master/product.jsp";
		}
		return page;
	}

}
