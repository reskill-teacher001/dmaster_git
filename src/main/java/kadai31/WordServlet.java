package kadai31;

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
 * Servlet implementation class FortuneServlet
 */
@WebServlet("/WordServlet")
public class WordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WordServlet() {
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
		String english = request.getParameter("english");
		String japanese = request.getParameter("japanese");
		
		WordBean bean = new WordBean(english, japanese);
		
		//セッションオブジェクトを取得
		HttpSession session = request.getSession(true);
		
		@SuppressWarnings("unchecked")
		List<WordBean> list = (List<WordBean>)session.getAttribute("list");
		
		if (list == null) {
			list = new ArrayList<>();
			session.setAttribute("list", list); //セッション・スコープに記憶
		}
		
		list.add(bean);
		
		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher("/kadai31/listword.jsp");
		rd.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		
		WordModel model = new WordModel();
		
		List<WordBean> list = model.execute(request);
		
		request.setAttribute("list", list);
		
		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher("/kadai31/listword.jsp");
		rd.forward(request, response);

	}
}
