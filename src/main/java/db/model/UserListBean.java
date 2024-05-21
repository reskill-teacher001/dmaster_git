package db.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import db.bean.User;
import db.dao.DAOException;
import db.dao.UserDAO;

public class UserListBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//UserDAOのインスタンスを生成
		UserDAO dao = new UserDAO();
		
		List<User> list = dao.findAll();
		
		//リクエストスコープに記憶させる
		request.setAttribute("list", list);

		return "/db/user_list.jsp"; //表示するページを返す
	}

}
