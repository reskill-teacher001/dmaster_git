package p01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SampleServlet01
 */
@WebServlet("/receive01")
public class ReceiveServlet01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReceiveServlet01() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		
		//送信データを取得
		String name = request.getParameter("NAMAE");
		String gender = request.getParameter("GENDER");
		String pref = request.getParameter("PREF");
		String[] fruits = request.getParameterValues("FRUITS");
		String query = request.getParameter("QUERY");
		
		//Webブラウザへのお知らせ情報の設定
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>データ受信</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>データ受信</h1>");
		out.println("<hr>");
		out.println("名前：" + name + "<br>");
		out.println("性別：" + gender + "<br>");
		out.println("都道府県：" + pref + "<br>");
		out.println("好きなフルーツ：");
		
		if (fruits == null) {
			out.println("フルーツが選択されていません");
		} else {
			for (String f : fruits) {
				out.println(f + ", ");
			}
		}
		
		out.println("<br>");
		
		out.println("お問い合わせ内容：<br>" + query.replace("\n", "<br>") + "<br>");

		out.println("</body>");
		out.println("</html>");
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
