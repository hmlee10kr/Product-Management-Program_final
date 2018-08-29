package 상품관리프로그램;

public class product {
	private int prcode;
	private String prname;
	private int price;
	private String manufacture;

	// precode 번호를 반환
	public int getPrecode() {
		return prcode;
	}

	// precode 번호 설정
	public void setPrcode(int prcode) {
		this.prcode = prcode;
	}

	// prname 이름 반환
	public String getPrname() {
		return prname;
	}

	// prname 설정
	public void setPrname(String prname) {
		this.prname = prname;
	}

	// 가격 반환
	public int getPrice() {
		return price;
	}

	// 가격 설정
	public void setPrice(int price) {
		this.price = price;
	}

	// 제조사 반환
	public String getManufacture() {
		return manufacture;
	}

	// 제조사 설정
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
}
