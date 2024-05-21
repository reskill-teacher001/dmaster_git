package db.model;

import javax.servlet.http.HttpServletRequest;

import db.dao.DAOException;

public class UserInsertBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {

		return "/db/user_insert.jsp"; //表示するページを返す
	}

}
