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
		String min = request.getParameter("minPrice");
		String max = request.getParameter("maxPrice");
		
		//ItemDAOクラスのインスタンスを生成
		ItemDAO dao = new ItemDAO();
		
		List<Item> items = null;
		
		if (!min.equals("") && !max.equals("")) {
			items = dao.findByPriceBetween(Integer.parseInt(min), Integer.parseInt(max));
		} else if (!min.equals("") && max.equals("")) {
			items = dao.findByPrice(Integer.parseInt(min), false);
		} else if (min.equals("") && !max.equals("")) {
			items = dao.findByPrice(Integer.parseInt(max), true);
		}
		
		request.setAttribute("items", items);
		
		return "/la/showItem2.jsp";
	}

}
