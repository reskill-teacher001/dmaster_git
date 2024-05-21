package kadai10;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BbsServlet
 */
@WebServlet("/BbsServlet")
public class BbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private List<String> list;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BbsServlet() {
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
		String action = request.getParameter("action");
		
		String name = request.getParameter("NAME");
		String message = request.getParameter("MESSAGE");
		
		if (list == null) {
			list = new ArrayList<>();
		}
		
		if (action.equals("write")) {
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		
			list.add(now.format(f) + "　" + name + "：" + message);
		} else if (action.equals("remove")) {
			int number = Integer.parseInt(request.getParameter("num"));
			
			list.remove(number);
		}
		
		//Webブラウザへのお知らせ情報の設定
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>掲示板</title>");
		out.println("</head>");
		out.println("<body>");
		
		if (action.equals("write") || action.equals("remove")) {
			out.println("<form action=\"/cmaster/BbsServlet\" method=\"post\">");
			out.println("<input type=\"hidden\" name=\"action\" value=\"write\">");
			out.println("名前：<br>");
			out.println("<input type=\"text\" name=\"NAME\">");
			out.println("<br>");
			out.println("メッセージ：<br>");
			out.println("<textarea name=\"MESSAGE\" cols=\"30\" rows=\"5\"></textarea>");
			out.println("<br>");
			out.println("<input type=\"submit\" value=\"書き込み\">");
			out.println("</form>");
			out.println("<hr>");
		
			int num = 0;
		
			for (String msg : list) {
				out.println(msg + "[" + "<a href='/cmaster/BbsServlet?action=remove&num=" + num++ + "'>削除</a>" + "]" + "<br>");
				out.println("<hr>");
			}
		} else {
			out.println("操作エラー<br>");
			out.println("<a href='/cmaster/kadai10/bbs.html'>戻る</a><br>");
		}
		
		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
