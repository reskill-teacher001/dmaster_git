package db.model;

import javax.servlet.http.HttpServletRequest;

import db.bean.User;
import db.dao.DAOException;
import db.dao.UserDAO;

public class UserUpdateBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//リクエスト・パラメータを取得
		String id = request.getParameter("id");
		
		//UserDAOのインスタンスを生成
		UserDAO dao = new UserDAO();
		
		User user = dao.findById(id);
		
		if (user == null) {
			throw new DAOException("指定したIDのユーザが見つかりません");
		}
		
		request.setAttribute("user", user);

		return "/db/user_update.jsp"; //表示するページを返す
	}

}
