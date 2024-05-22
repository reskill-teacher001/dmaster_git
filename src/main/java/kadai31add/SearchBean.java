package kadai31add;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SearchBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) {
		List<WordBean> search = new ArrayList<>();
		
		//リクエスト・パラメータを取得
		String keyword = request.getParameter("keyword");
		
		//セッションオブジェクトを取得
		HttpSession session = request.getSession(false);
		
		if (session == null) {
			return "/kadai31add/error.js";
		}
		
		@SuppressWarnings("unchecked")
		List<WordBean> list = (List<WordBean>)session.getAttribute("list");
		
		if (list == null) {
			return "/kadai31add/error.jsp";
		}
		
		for (WordBean bean : list) {
			String english = bean.getEnglish();
			
			if (english.indexOf(keyword) != -1) {
				search.add(bean);
			}
		}
		
		request.setAttribute("list", search);
		
		return "/kadai31add/listword.jsp";
	}

}
