package Main;

public class subscriptionVo {
	private String sid;
	private String category;
	private String title;
	private int fee;

	public subscriptionVo() {

	}

	public subscriptionVo(String category, String title, int fee) {
		this.category = category;
		this.title = title;
		this.fee = fee;

	}
	
	public subscriptionVo(int fee) {
		this.fee = fee;

	}


	public String getSid() {
		return sid;
	}

	public String getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}

	public int getFee() {
		return fee;
	}
	

}
