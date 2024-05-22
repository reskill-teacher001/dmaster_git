package kadai31add;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) {
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
		
		return "/kadai31add/listword.jsp";
	}

}
