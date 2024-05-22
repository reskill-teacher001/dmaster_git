package la.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import la.bean.Item;

public class ItemDAO extends DAO {
	
	//全件検索メソッド
	public List<Item> findAll() throws DAOException {
		List<Item> list = new ArrayList<>();

		String sql = "SELECT code, name, price FROM item";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				int code = rs.getInt("code");       //codeの列のデータを取得
				String name = rs.getString("name"); //nameの列のデータを取得
				int price = rs.getInt("price");     //priceの列のデータを取得

				list.add(new Item(code, name, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの取得に失敗しました");
		}

		return list;
	}
	
	//全件検索メソッド（単価の高い順または低い順でソート）
	public List<Item> sortPrice(boolean ascending) throws DAOException {
		List<Item> list = new ArrayList<>();

		String sql = "SELECT code, name, price FROM item ORDER BY price ";
		
		sql += (ascending ? "ASC" : "DESC");

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				int code = rs.getInt("code");       //codeの列のデータを取得
				String name = rs.getString("name"); //nameの列のデータを取得
				int price = rs.getInt("price");     //priceの列のデータを取得

				list.add(new Item(code, name, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return list;
	}
	
	//複数件検索メソッド（指定した単価以下の商品を取得）
	public List<Item> findByPrice(int lePrice) throws DAOException {
		List<Item> list = new ArrayList<>();

		String sql = "SELECT code, name, price FROM item WHERE price <= ?";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, lePrice);

			//SQLを実行して結果を取得する
			ResultSet rs = ps.executeQuery();

			while (rs.next() == true) { //レコードがあったら
				//レコードの列のデータを取得する
				int code = rs.getInt("code");       //codeの列のデータを取得
				String name = rs.getString("name"); //nameの列のデータを取得
				int price = rs.getInt("price");     //priceの列のデータを取得

				list.add(new Item(code, name, price));
			}

		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return list;
	}

	
	//登録メソッド
	public int addItem(String name, int price) throws DAOException {
		int rows = 0;

		String sql = "INSERT INTO item(name, price) VALUES(?, ?)";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			//Connection con = DriverManager.getConnection(url, user, pass);
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, price);

			//SQLを実行して結果を取得する
			rows = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return rows;
	}
	
	//削除メソッド
	public int deleteByPrimaryKey(int key) throws DAOException {
		int rows = 0;

		String sql = "DELETE FROM item WHERE code = ?";

		try (
			//正常にDBに接続された時に利用できるリモコンcon
			//Connection con = DriverManager.getConnection(url, user, pass);
			Connection con = getConnect();
		) {
			//SQL文を実行する準備をする
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, key);

			//SQLを実行して結果を取得する
			rows = ps.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new DAOException("レコードの操作に失敗しました");
		}

		return rows;
	}

}
