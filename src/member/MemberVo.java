package member;

public class MemberVo {
//	VO) ���� �ٸ� Ÿ���� �����͸� �ٸ� Ŭ������ ������ �� ���
	
		private String id;
		private String pw;
		private String name;
//		private String birth;	
		private String pnum;
		
		
		public MemberVo() {}

	
	public MemberVo(String id, String pw, String name, String pnum) {
		this.id = id;
		this.pw = pw;
		this.name = name;
//		this.birth = birth;	
		this.pnum = pnum;
	}
	
	public String getId() {
		return id;
		
	}
	
	public String getPassword() {
		return pw;
		
	}
	public String getName() {
		return name;
		
	}
	
//	public String getBirth() {
//		return birth;
//		
//	}

	public String getPnum() {
		return pnum;
		
}


	public void setId(String id) {
		this.id = id;
	}


	public void getPassword(String pw) {
		this.pw = pw;
	}


	public void setName(String name) {
		this.name = name;
	}


//	public void setBirth(String birth) {
//		this.birth = birth;
//	}


	public void setPnum(String pnum) {
		this.pnum = pnum;
	}
	

}
