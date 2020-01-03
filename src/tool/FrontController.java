package tool;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns="*.action")
public class FrontController extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Page.header(out);
		request.setCharacterEncoding("UTF-8");

		try {
			// リクエストURLの取得・加工
			String path = request.getServletPath().substring(1);
			String name = path.replace(".a", "A").replace("/", ".");
			@SuppressWarnings("deprecation")
			// 指定されたアクションクラスのインスタンスを生成
			Action action = (Action)Class.forName(name).newInstance();
			String url = action.execute(request, response);
			request.getRequestDispatcher(url).forward(request, response);
		} catch (Exception e) {
			e.printStackTrace(out);
		}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}
