package la.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import la.bean.Item;
import la.dao.DAOException;
import la.dao.ItemDAO;

public class ItemDeleteBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//リクエストパラメータを取得
		int code = Integer.parseInt(request.getParameter("code"));
		
		//ItemDAOクラスのインスタンスを生成
		ItemDAO dao = new ItemDAO();
		
		int rows = dao.deleteByPrimaryKey(code);
		
		if (rows != 1) {
			throw new DAOException("削除に失敗しました。");
		}
		
		List<Item> items = dao.findAll();
		
		request.setAttribute("items", items);
		
		return "/la/showItem2.jsp";
	}

}
