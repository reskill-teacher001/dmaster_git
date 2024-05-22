package la.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import la.bean.Item;
import la.dao.DAOException;
import la.dao.ItemDAO;

public class ItemSortBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//リクエストパラメータを取得
		String key = request.getParameter("key");
		
		boolean ascending = key.equals("price_asc");
		
		//ItemDAOクラスのインスタンスを生成
		ItemDAO dao = new ItemDAO();
		
		List<Item> items = dao.sortPrice(ascending);
		
		request.setAttribute("items", items);
		
		return "/la/showItem2.jsp";
	}

}
