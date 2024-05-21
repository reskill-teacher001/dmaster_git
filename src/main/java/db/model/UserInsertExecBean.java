package db.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import db.bean.User;
import db.dao.DAOException;
import db.dao.UserDAO;

public class UserInsertExecBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		try {
			//リクエスト・パラメータを取得
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			int age = Integer.parseInt(request.getParameter("age"));
			
			//UserDAOのインスタンスを生成
			UserDAO dao = new UserDAO();
			
			boolean check = dao.insert(id, name, age);
			
			if (check == false) {
				throw new DAOException("登録に失敗しました。");
			}
	
			List<User> list = dao.findAll();
			
			//リクエストスコープに記憶させる
			request.setAttribute("list", list);
			
			return "/db/user_list.jsp"; //表示するページを返す
		} catch (NumberFormatException e) {
			throw new DAOException("整数に変換できません。");
		}
	}

}
