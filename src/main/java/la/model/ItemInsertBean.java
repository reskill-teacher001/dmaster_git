package la.model;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import la.bean.Item;
import la.dao.DAOException;
import la.dao.ItemDAO;

public class ItemInsertBean implements IBean {

	@Override
	public String execute(HttpServletRequest request) throws DAOException {
		//リクエストパラメータを取得
		String name = request.getParameter("name");
		int price = Integer.parseInt(request.getParameter("price"));
		
		//ItemDAOクラスのインスタンスを生成
		ItemDAO dao = new ItemDAO();
		
		int rows = dao.addItem(name, price);
		
		if (rows != 1) {
			throw new DAOException("登録に失敗しました。");
		}
		
		List<Item> items = dao.findAll();
		
		request.setAttribute("items", items);
		
		return "/la/showItem2.jsp";
	}

}
