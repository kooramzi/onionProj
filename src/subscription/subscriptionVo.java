package subscription;

public class subscriptionVo {
	private int sid;
	private String category;
	private String title;
	
	public subscriptionVo(int sid,String category,String title) {
		this.sid = sid;
		this.category = category;
		this.title = title;
		
	}

	public int getSid() {
		return sid;
	}

	public String getCategory() {
		return category;
	}

	public String getTitle() {
		return title;
	}
}
