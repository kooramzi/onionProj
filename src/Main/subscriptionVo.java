package Main;

public class subscriptionVo {
	private String sid;
	private String category;
	private String title;
	
	
	public subscriptionVo() {
		
	}
	
	public subscriptionVo(String sid,String category,String title) {
		this.sid = sid;
		this.category = category;
		this.title = title;
		
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
}
