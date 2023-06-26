package bean;

public class Sale {

	// 変数
	// 商品番号
	private int product_number;
	// 商品名
	private String product_name;
	// 種類
	private String kinds;
	// 価格
	private int price;
	// 個数
	private int quantity;
	// 備考
	private String remarks;
	// 地域
	private String region;
	// 画像
	private String image;
	// 出品日
	private String exhibition_date;
	// 更新日
	private String update_date;
	// 取引情報
	private String transaction;
	// 出品者ユーザーID
	private String exhibition_userid;
	// 購入者ユーザーID
	private String purchase_userid;
	// 購入日
	private String purchase_date;
	// 入金情報
	private String money_recieved;
	// 発送情報
	private String delivery;

	// 引数なしコンストラクタ
	public Sale() {
		//変数の初期化
		this.product_number=0;
		this.product_name=null;
		this.kinds=null;
		this.price=0;
		this.quantity=0;
		this.remarks=null;
		this.region=null;
		this.image=null;
		this.exhibition_date=null;
		this.update_date=null;
		this.transaction=null;
		this.exhibition_userid=null;
		this.purchase_userid=null;
		this.purchase_date=null;
		this.money_recieved=null;
		this.delivery=null;

	}

	public int getProduct_number() {
		return product_number;
	}

	public void setProduct_number(int product_number) {
		this.product_number = product_number;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getKinds() {
		return kinds;
	}

	public void setKinds(String kinds) {
		this.kinds = kinds;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getExhibition_date() {
		return exhibition_date;
	}

	public void setExhibition_date(String exhibition_date) {
		this.exhibition_date = exhibition_date;
	}

	public String getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(String update_date) {
		this.update_date = update_date;
	}

	public String getTransaction() {
		return transaction;
	}

	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	public String getExhibition_userid() {
		return exhibition_userid;
	}

	public void setExhibition_userid(String exhibition_userid) {
		this.exhibition_userid = exhibition_userid;
	}

	public String getPurchase_userid() {
		return purchase_userid;
	}

	public void setPurchase_userid(String purchase_userid) {
		this.purchase_userid = purchase_userid;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getMoney_recieved() {
		return money_recieved;
	}

	public void setMoney_recieved(String money_recieved) {
		this.money_recieved = money_recieved;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

}
