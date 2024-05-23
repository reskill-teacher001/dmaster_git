package la.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import la.bean.Item;
import la.dao.DAOException;
import la.dao.ItemDAO;

public class ItemSearchStep3Bean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//リクエストパラメータを取得
		String name = request.getParameter("name");
		
		String min = request.getParameter("minPrice");
		String max = request.getParameter("maxPrice");
		
		//Step4
		HttpSession session = request.getSession(true);
		
		session.setAttribute("name", name);
		session.setAttribute("minPrice", min);
		session.setAttribute("maxPrice", max);
		
		String data = "";
		
//		data += !name.equals("") ? "&name=" + name : "";
//		data += !min.equals("") ? "&min=" + min : "";
//		data += !max.equals("") ? "&max=" + max : "";
		data += "&name=" + name;
		data += "&minPrice=" + min;
		data += "&maxPrice=" + max;

		session.setAttribute("data", data);
		
		//ItemDAOクラスのインスタンスを生成
		ItemDAO dao = new ItemDAO();
		
		List<Item> items = null;
		
		if (name.equals("") && min.equals("") && max.equals("")) {
			items = dao.findAll();
		} else if (!name.equals("") && min.equals("") && max.equals("")) {
			items = dao.findByName(name);
		} else if (!min.equals("") && !max.equals("")) {
			items = dao.findByNameAndPriceBetween(name, Integer.parseInt(min), Integer.parseInt(max));
		} else if (!min.equals("") && max.equals("")) {
			items = dao.findByNameAndPrice(name, Integer.parseInt(min), false);
		} else if (min.equals("") && !max.equals("")) {
			items = dao.findByNameAndPrice(name, Integer.parseInt(max), true);
		}
		
		request.setAttribute("items", items);
		
		return "/la/showItem2.jsp";
	}

}
