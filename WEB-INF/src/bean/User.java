package bean;

public class User {

	// 変数
	// ユーザーID
	private int userid;
	// 氏名
	private String name;
	// ニックネーム
	private String nickname;
	// アドレス(ユーザー名)
	private String mail;
	// 住所
	private String address;
	// 電話番号
	private String phone_number;
	// パスワード
	private String password;
	// 登録日
	private String signup_date;
	// 更新日
	private String updatemypage_date;
	// 退会日
	private String signout_date;
	// 権限
	private String authority;



	// 引数なしコンストラクタ
	public User() {

		// 変数初期化
		this.userid = 0;
		this.name = null;
		this.nickname = null;
		this.mail = null;
		this.address = null;
		this.phone_number = null;
		this.password = null;
		this.signup_date = null;
		this.updatemypage_date = null;
		this.signout_date = null;
		this.authority = null;

	}

	// アクセサメソッド
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSignup_date() {
		return signup_date;
	}

	public void setSignup_date(String signup_date) {
		this.signup_date = signup_date;
	}

	public String getUpdatemypage_date() {
		return updatemypage_date;
	}

	public void setUpdatemypage_date(String updatemypage_date) {
		this.updatemypage_date = updatemypage_date;
	}

	public String getSignout_date() {
		return signout_date;
	}

	public void setSignout_date(String signout_date) {
		this.signout_date = signout_date;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
