package db.model;

import javax.servlet.http.HttpServletRequest;

import db.dao.DAOException;

public class UserUpdateBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {

		return "/"; //表示するページを返す
	}

}
