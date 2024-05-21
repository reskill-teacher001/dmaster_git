package kadai30;

public class FortuneBean {
	//フィールド
	private int month; //誕生月
	private String item;     //ラッキーアイテム
	private String color;    //ラッキーカラー
	private int rank;     //ランク
	
	//コンストラクタ
	public FortuneBean() {
		
	}

	public FortuneBean(int month, String item, String color, int rank) {
		this.month = month;
		this.item = item;
		this.color = color;
		this.rank = rank;
	}

	//セッタ＆ゲッタ
	public int getMonth() {
		return month;
	}
	
	public void setMonth(int month) {
		this.month = month;
	}
	
	public String getItem() {
		return item;
	}
	
	public void setItem(String item) {
		this.item = item;
	}
	
	public String getColor() {
		return color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public int getRank() {
		return rank;
	}
	
	public void setRank(int rank) {
		this.rank = rank;
	}
	
}
