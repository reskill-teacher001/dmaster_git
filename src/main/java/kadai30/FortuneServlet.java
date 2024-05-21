package kadai30;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FortuneServlet
 */
@WebServlet("/FortuneServlet")
public class FortuneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FortuneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//FortuneBeanのインスタンスを生成
		FortuneBean bean = new FortuneBean(9, "タオル", "白", 6);
		
		//リクエスト・スコープに記憶
		request.setAttribute("bean", bean);
		
		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher("/kadai30/fortune.jsp");
		rd.forward(request, response);
	}

}
