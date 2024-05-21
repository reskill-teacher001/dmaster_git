package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KudoServlet
 */
@WebServlet("/kudo")
public class KudoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KudoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		
		//リクエスト・パラメータを取得
		String action = request.getParameter("action");
		
		String page = "/mvc/kikusui.jsp";
		
		Canon c = null;
		
		try {
			if (action.equals("tasu")) {
				c = new Tanaka();
			} else if (action.equals("hiku")) {
				c = new Kimura();
			} else if (action.equals("waru")) {
				c = new Endo();
			} else if (action.equals("kake")) {
				c = new Oku();
			}
			
			if (c != null) {
				page = c.calc(request);
			}
	} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		
		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
