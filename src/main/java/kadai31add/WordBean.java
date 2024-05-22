package kadai31;

import java.io.Serializable;

public class WordBean implements Serializable {
	//フィールド
	private String english; //英語
	private String japanese; //日本語
	
	//コンストラクタ
	public WordBean() {

	}

	public WordBean(String english, String japanese) {
		this.english = english;
		this.japanese = japanese;
	}

	//セッタ＆ゲッタ
	public String getEnglish() {
		return english;
	}
	
	public void setEnglish(String english) {
		this.english = english;
	}
	
	public String getJapanese() {
		return japanese;
	}
	
	public void setJapanese(String japanese) {
		this.japanese = japanese;
	}
	
}
