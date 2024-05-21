package p01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SampleServlet01
 */
@WebServlet("/counter")
public class CounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CounterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//セッションオブジェクトを取得
		HttpSession session = request.getSession(true);
		
		//１０秒なにもしなければセッションオブジェクトを消滅
		session.setMaxInactiveInterval(10);
		
		Integer count = (Integer)session.getAttribute("COUNT");
		
		if (count == null) {
			count = 0;
		}
		
		count++;
		
//		if (count > 10) {
//			count = 0;
//		}
		
		session.setAttribute("COUNT", count);
		
		if (count >= 10) {
			//session.removeAttribute("COUNT");
			session.invalidate(); //セッションオブジェクトを消滅する
		}
		
		//Webブラウザへのお知らせ情報の設定
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>カウンター</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>カウンター</h1>");
		out.println("<hr>");
		out.println("カウント値" + count + "<br>");
		out.println("<a href='counter'>カウントアップ</a><br>");
		out.println("セッションID：" + session.getId() + "<br>");
		out.println("</body>");
		out.println("</html>");
	}

}
