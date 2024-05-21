package kadai21;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class BbsServlet
 */
@WebServlet("/BbsServlet2")
public class BbsServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbsServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		
		//送信データを取得
		String name = request.getParameter("NAME");
		String message = request.getParameter("MESSAGE");
		
		HttpSession session = request.getSession(true);
		
		@SuppressWarnings("unchecked")
		List<String> list = (List<String>)session.getAttribute("list");
		
		if (list == null) {
			list = new ArrayList<>();
			session.setAttribute("list", list);
		}
		
		list.add(name + "：" + message);
		//session.setAttribute("list", list);
	
		RequestDispatcher rd = request.getRequestDispatcher("/ShowServlet");
		rd.forward(request, response);
		
//		//Webブラウザへのお知らせ情報の設定
//		response.setContentType("text/html; charset=UTF-8");
//		
//		PrintWriter out = response.getWriter();
//		
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>掲示板</title>");
//		out.println("</head>");
//		out.println("<body>");
//		
//		out.println("<form action=\"/cmaster/BbsServlet2\" method=\"post\">");
//		out.println("名前：<br>");
//		out.println("<input type=\"text\" name=\"NAME\">");
//		out.println("<br>");
//		out.println("メッセージ：<br>");
//		out.println("<textarea name=\"MESSAGE\" cols=\"30\" rows=\"5\"></textarea>");
//		out.println("<br>");
//		out.println("<input type=\"submit\" value=\"書き込み\">");
//		out.println("</form>");
//		out.println("<hr>");
//	
//		for (String msg : list) {
//			out.println(msg);
//			out.println("<hr>");
//		}
//		
//		out.println("</body>");
//		out.println("</html>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
