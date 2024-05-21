package p01;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SampleServlet01
 */
@WebServlet("/pageA")
public class PageA extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageA() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションオブジェクトを取得
		HttpSession session = request.getSession(true);
		session.setAttribute("NAME", "山田太郎");
		
		//アプリケーションオブジェクトを取得
		ServletContext application = getServletContext();
		application.setAttribute("AGE", 23);
		
		request.setAttribute("COMPANY", "キヤノン");
		
		User user = new User("01", "山田太郎2", 24);
		request.setAttribute("USER", user);
	
		//リクエストの転送（フォワード処理）
		//リクエスト転送用のオブジェクトを取得する
		//RequestDispatcher rd = request.getRequestDispatcher("/pageB");
		//RequestDispatcher rd = request.getRequestDispatcher("/jsp/pageC.jsp");
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/pageD.jsp");
		
		//フォワード処理を実行（リクエスト転送処理の実行）
		rd.forward(request, response);
		
//		//Webブラウザへのお知らせ情報の設定
//		response.setContentType("text/html; charset=UTF-8");
//		
//		PrintWriter out = response.getWriter();
//		
//		out.println("<!DOCTYPE html>");
//		out.println("<html>");
//		out.println("<head>");
//		out.println("<title>ページA</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("<h1>ページA</h1>");
//		out.println("<hr>");
//		out.println("<a href='pageB'>ページBへ</a><br>");
//		out.println("</body>");
//		out.println("</html>");
	}

}
