package inout;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import tool.Action;

public class LogoutAction extends Action {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// 変数宣言
		HttpSession session = request.getSession();
		String page = "logout-out.jsp";
		// すでにログアウトされている場合はエラーメッセージを表示
		if (session.getAttribute("customer") == null) {
			request.setAttribute("message", "すでにログアウトされています。");
			page = "logout-in.jsp";
			return page;
		}
		// セッション属性から顧客エンティティを削除
		session.removeAttribute("customer");
		return page;
	}

}
