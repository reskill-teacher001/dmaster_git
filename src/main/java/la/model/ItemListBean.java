package la.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import la.bean.Item;
import la.dao.DAOException;
import la.dao.ItemDAO;

public class ItemListBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//ItemDAOクラスのインスタンスを生成
		ItemDAO dao = new ItemDAO();
		
		List<Item> items = dao.findAll();
		
		request.setAttribute("items", items);
		
		return "/la/showItem2.jsp";
	}

}
