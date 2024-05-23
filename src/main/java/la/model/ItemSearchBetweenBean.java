package la.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import la.bean.Item;
import la.dao.DAOException;
import la.dao.ItemDAO;

public class ItemSearchBetweenBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//リクエストパラメータを取得
		int minPrice = Integer.parseInt(request.getParameter("minPrice"));
		int maxPrice = Integer.parseInt(request.getParameter("maxPrice"));
		
		//ItemDAOクラスのインスタンスを生成
		ItemDAO dao = new ItemDAO();
		
		List<Item> items = dao.findByPriceBetween(minPrice, maxPrice);
		
		request.setAttribute("items", items);
		
		return "/la/showItem2.jsp";
	}

}
