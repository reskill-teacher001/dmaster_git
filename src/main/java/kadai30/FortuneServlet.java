package kadai30;

import java.io.IOException;
import java.util.Random;

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
		//文字化け対策
		request.setCharacterEncoding("UTF-8");
		
		int month = Integer.parseInt(request.getParameter("month"));
		
		String[] colors = {"赤", "黄", "白"};
		String[] items = {"タオル", "カバン", "腕時計"};
		
		Random rand = new Random();
		
		int colorNum = rand.nextInt(3);
		int itemNum = rand.nextInt(3);
		int rank = rand.nextInt(12) + 1;
		
		//FortuneBeanのインスタンスを生成
		FortuneBean bean = new FortuneBean(
				month, items[itemNum], colors[colorNum], rank);
		
		//リクエスト・スコープに記憶
		request.setAttribute("bean", bean);
		
		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher("/kadai30/fortune.jsp");
		rd.forward(request, response);
	}

}
