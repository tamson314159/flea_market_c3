package bean;

public class Product {

	//商品番号を格納する変数
	private int product_id;

	//商品名を格納する変数
	private String product_name;

	//種類を格納する変数
	private String kinds;

	//価格を格納する変数
	private int price;

	//個数を格納する変数
	private int quantity;

	//備考を格納する変数
	private String remarks;

	//地域を格納する変数
	private String region;

	//出品日を格納する変数
	private String exhibition_date;

	//更新日を格納する変数
	private String update_date;

	//画像パスを格納する変数
	private String image;

	//取引状況を格納する変数
	private String transaction;

	//出品ユーザーIDを格納する変数
	private int user_id;

	//コンストラクタ
	public Product() {
		//変数の初期化
		this.product_id = 0;
		this.product_name = null;
		this.kinds = null;
		this.price = 0;
		this.quantity = 0;
		this.remarks = null;
		this.region = null;
		this.exhibition_date = null;
		this.update_date = null;
		this.image = null;
		this.transaction = null;
		this.user_id = 0;

	}

	//product_idのアクセサメソッド
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}

	//product_nameのアクセサメソッド
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	//kindsのアクセサメソッド
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}

	//priceのアクセサメソッド
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

	//quantityのアクセサメソッド
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	//remarksのアクセサメソッド
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	//regionのアクセサメソッド
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}

	//exhibition_dateのアクセサメソッド
	public String getExhibition_date() {
		return exhibition_date;
	}
	public void setExhibition_date(String exhibition_date) {
		this.exhibition_date = exhibition_date;
	}

	//update_dateのアクセサメソッド
	public String getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	//imageのアクセサメソッド
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}

	//transactionのアクセサメソッド
	public String getTransaction() {
		return transaction;
	}
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	//user_idのアクセサメソッド
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}


}
