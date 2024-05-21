package p01;

import java.io.IOException;
import java.io.PrintWriter;

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
@WebServlet("/pageB")
public class PageB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PageB() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションオブジェクトを取得
		HttpSession session = request.getSession(false);
		String name = (String)session.getAttribute("NAME");
		
		//アプリケーションオブジェクトを取得
		ServletContext application = getServletContext();
		Integer age = (Integer)application.getAttribute("AGE");
		
		String company = (String)request.getAttribute("COMPANY");
		
		//Webブラウザへのお知らせ情報の設定
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>ページB</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>ページB</h1>");
		out.println("<hr>");
		out.println("名前：" + name + "<br>");
		out.println("年齢：" + age + "<br>");
		out.println("会社：" + company + "<br>");
		out.println("</body>");
		out.println("</html>");
	}

}
