package db.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import db.bean.User;
import db.dao.DAOException;
import db.dao.UserDAO;

public class UserDeleteExecBean implements IBean {

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
		
		boolean check = dao.delete(id);
		
		if (check == false) {
			throw new DAOException("削除に失敗しました");
		}

		List<User> list = dao.findAll();
		
		//リクエストスコープに記憶させる
		request.setAttribute("list", list);
		
		return "/db/user_list.jsp"; //表示するページを返す
	}

}
