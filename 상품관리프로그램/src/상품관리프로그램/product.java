package ��ǰ�������α׷�;

public class product {
	private int prcode;
	private String prname;
	private int price;
	private String manufacture;

	// precode ��ȣ�� ��ȯ
	public int getPrecode() {
		return prcode;
	}

	// precode ��ȣ ����
	public void setPrcode(int prcode) {
		this.prcode = prcode;
	}

	// prname �̸� ��ȯ
	public String getPrname() {
		return prname;
	}

	// prname ����
	public void setPrname(String prname) {
		this.prname = prname;
	}

	// ���� ��ȯ
	public int getPrice() {
		return price;
	}

	// ���� ����
	public void setPrice(int price) {
		this.price = price;
	}

	// ������ ��ȯ
	public String getManufacture() {
		return manufacture;
	}

	// ������ ����
	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}
}
